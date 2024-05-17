package com.tech.eswitch.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.squareup.okhttp.*;
import com.tech.eswitch.dto.AccountBalanceRequest;
import com.tech.eswitch.dto.TransactionStatusRequest;
import com.tech.eswitch.dto.send.SendError;
import com.tech.eswitch.interfaces.B2CStatusAndBalance;
import com.tech.eswitch.utils.PropertyReader;
import com.tech.eswitch.utils.TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class B2CStatusAndBalanceImpl implements B2CStatusAndBalance {

    private Logger logger=LoggerFactory.getLogger(B2CStatusAndBalanceImpl.class);
    private TokenGenerator tokenGenerator;

    public B2CStatusAndBalanceImpl(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public Object getAccountBalance() {
        //todo create the POST request here to hit Safaricom and get the account balance
        // In case you come up with any dto, have it b2c package
        // https://api.safaricom.co.ke/mpesa/accountbalance/v1/query
        try {
            logger.info("Begin calling safaricom for account balance");
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            AccountBalanceRequest balanceRequest=new AccountBalanceRequest();
            balanceRequest.setRemarks("Get Account Balance");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(balanceRequest);
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(PropertyReader.getProperty("eSwitch.account.balance"))
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
                return sendError;
            } else if (res.contains("ConversationID")) {
                // TODO: 5/5/2024 confirm what to do when the request is successful
            } else {
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object getTransactionStatus() {
        //todo create the POST request here to hit Safaricom and get transaction status.
        // We will use this API to confirm failed transactions.
        // In case you come up with any dto, have it b2c package
        // https://api.safaricom.co.ke/mpesa/transactionstatus/v1/query
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            TransactionStatusRequest statusRequest=new TransactionStatusRequest();
            statusRequest.setRemarks("Get transaction status");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(statusRequest);
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(PropertyReader.getProperty("eSwitch.transaction.status"))
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
                logger.info("Error occurred {}", res);
                return sendError;
            } else if (res.contains("ConversationID")) {
                // TODO: 5/5/2024 confirm what to do when the request is successful
            } else {
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
