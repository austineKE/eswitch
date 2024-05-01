package com.tech.eswitch.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.squareup.okhttp.*;
import com.tech.eswitch.configs.ScheduleConf;
import com.tech.eswitch.dto.send.SendError;
import com.tech.eswitch.dto.send.SendMoneyRequest;
import com.tech.eswitch.dto.send.SendSuccess;
import com.tech.eswitch.interfaces.SendMoney;
import com.tech.eswitch.model.TransactionRequests;
import com.tech.eswitch.repo.TransactionRepo;
import com.tech.eswitch.utils.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendMoneyImpl implements SendMoney {
    private TransactionRepo transactionRepo;
    private ScheduleConf scheduleConf;
    private TokenGenerator tokenGenerator;

    public SendMoneyImpl(TransactionRepo transactionRepo, ScheduleConf scheduleConf,TokenGenerator tokenGenerator) {
        this.transactionRepo = transactionRepo;
        this.scheduleConf = scheduleConf;
        this.tokenGenerator=tokenGenerator;
    }

    @Override
    public void sendMoney() {
        scheduleConf.setProceed(false);
        List<TransactionRequests> transactionRequests = transactionRepo
                .findTransactionToSend();
        for (TransactionRequests transaction : transactionRequests) {
            try {
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                SendMoneyRequest sendMoneyRequest = new SendMoneyRequest();
                sendMoneyRequest.setAmount(transaction.getAmountAwarded());
                sendMoneyRequest.setPartyB(transaction.getMsisdn());
                sendMoneyRequest.setOriginatorConversationID(transaction.getThirdPartyTransID());
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(sendMoneyRequest);
                RequestBody body = RequestBody.create(mediaType, json);
                Request request = new Request.Builder()
                        .url("https://sandbox.safaricom.co.ke/mpesa/b2c/v3/paymentrequest")
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", tokenGenerator.getToken())
                        .build();
                Response response = client.newCall(request).execute();
                //todo parse response
                String res = response.body().string();
                if (res.contains("errorCode")) {
                    ObjectMapper mapper = new ObjectMapper();
                    SendError sendError = mapper.readValue(res, SendError.class);
                    System.out.println(res);
//                    if (!sendError.getErrorMessage().contains("Invalid Access Token")) {
//                        transaction.setSendMoneySuccessful(0);
//                        transaction.setSendMoneyRetryCount(transaction.getSendMoneyRetryCount() + 1);
//                        transaction.setSendMoneyErrorCode(sendError.getErrorCode());
//                        transaction.setSendMoneyErrorMessage(sendError.getErrorMessage());
//                        transaction.setSendMoneyRequestId(sendError.getRequestId());
//                        transactionRepo.save(transaction);
//                    }
                } else if (res.contains("ConversationID")) {
                    ObjectMapper mapper = new ObjectMapper();
                    SendSuccess sendSuccess = mapper.readValue(res, SendSuccess.class);
                    transaction.setSendMoneySuccessful(1);
                    transaction.setSendMoneyRetryCount(0);
                    transaction.setSendMoneyRequestId(sendSuccess.getConversationID());
                    transactionRepo.save(transaction);
                } else {
                    System.out.println(res);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scheduleConf.setProceed(true);
    }
}
