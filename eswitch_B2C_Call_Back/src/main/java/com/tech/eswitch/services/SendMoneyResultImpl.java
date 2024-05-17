package com.tech.eswitch.services;

import com.tech.eswitch.dto.sendResult.ResultParameter;
import com.tech.eswitch.dto.sendResult.SendResult;
import com.tech.eswitch.interfaces.SendMoneyResult;
import com.tech.eswitch.model.SendMoneyTransactions;
import com.tech.eswitch.model.TransactionRequests;
import com.tech.eswitch.repo.SendMoneyRepo;
import com.tech.eswitch.repo.TransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class SendMoneyResultImpl implements SendMoneyResult {

    TransactionRepo transactionRepo;
    SendMoneyRepo sendMoneyRepo;

    public SendMoneyResultImpl(TransactionRepo transactionRepo, SendMoneyRepo sendMoneyRepo) {
        this.transactionRepo = transactionRepo;
        this.sendMoneyRepo = sendMoneyRepo;
    }

    @Override
    public void sendMoneyResult(SendResult sendResult) {
        try {
            Integer initialTransactionId = Integer.parseInt(sendResult.getResult()
                    .getOriginatorConversationID().split("_")[2]);
            TransactionRequests transactionRequests = transactionRepo
                    .findById(initialTransactionId).get();
            transactionRequests.setTransactionCompleted(1);
            transactionRepo.save(transactionRequests);

            SendMoneyTransactions sendMoneyTransactions = new SendMoneyTransactions();
            sendMoneyTransactions.setInitialTransactionId(initialTransactionId);
            sendMoneyTransactions.setConversationID(sendResult.getResult().getConversationID());
            sendMoneyTransactions.setOriginatorConversationID(sendResult.getResult().getOriginatorConversationID());
            sendMoneyTransactions.setResultDesc(sendResult.getResult().getResultDesc());
            sendMoneyTransactions.setResultCode(sendResult.getResult().getResultCode());
            sendMoneyTransactions.setResultType(sendResult.getResult().getResultType());
            sendMoneyTransactions.setTransactionID(sendResult.getResult().getTransactionID());

            if (sendResult.getResult().getResultParameters() != null) {
                for (ResultParameter resultParameter : sendResult.getResult().getResultParameters().getResultParameter()) {
                    if (resultParameter.getKey().equalsIgnoreCase("B2CChargesPaidAccountAvailableFunds")) {
                        sendMoneyTransactions.setChargesPaidAccountAvailableFunds(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("B2CRecipientIsRegisteredCustomer")) {
                        sendMoneyTransactions.setRecipientIsRegisteredCustomer(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("ReceiverPartyPublicName")) {
                        sendMoneyTransactions.setReceiverPartyPublicName(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("B2CWorkingAccountAvailableFunds")) {
                        sendMoneyTransactions.setWorkingAccountAvailableFunds(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("B2CUtilityAccountAvailableFunds")) {
                        sendMoneyTransactions.setUtilityAccountAvailableFunds(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("TransactionReceipt")) {
                        sendMoneyTransactions.setTransactionReceipt(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("TransactionCompletedDateTime")) {
                        sendMoneyTransactions.setTransactionCompletedDateTime(resultParameter.getValue().toString());
                    }
                    if (resultParameter.getKey().equalsIgnoreCase("TransactionAmount")) {
                        sendMoneyTransactions.setTransactionAmount(resultParameter.getValue().toString());
                    }
                }
            }

            if (sendResult.getResult().getReferenceData() != null) {
                sendMoneyTransactions.setQueueTimeoutURL(sendResult.getResult()
                        .getReferenceData().getReferenceItem().getValue());
            }
            sendMoneyRepo.save(sendMoneyTransactions);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
