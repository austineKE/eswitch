package com.tech.eswitch.services;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseValidation;
import com.tech.eswitch.interfaces.Validate;
import com.tech.eswitch.model.TransactionRequests;
import com.tech.eswitch.repo.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ValidationImpl implements Validate {
    private Logger logger = LoggerFactory.getLogger(ValidationImpl.class);
    TransactionRepo transactionRepo;

    public ValidationImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public TransactionResponseValidation validate(TransactionRequest transactionRequest) {
        try {
            logger.info(transactionRequest.getBusinessShortCode());
            TransactionRequests transactionRequests = new TransactionRequests();
            transactionRequests.setBillRefNumber(transactionRequest.getBillRefNumber());
            transactionRequests.setBusinessShortCode(transactionRequest.getBusinessShortCode());
            transactionRequests.setFirstName(transactionRequest.getFirstName());
            //transactionRequests.setInvoiceNumber(transactionRequest.getInvoiceNumber());
            //transactionRequests.setLastName(transactionRequest.getLastName());
            //transactionRequests.setMiddleName(transactionRequest.getMiddleName());
            String[] strings = transactionRequest.getInvoiceNumber().split("!");
            transactionRequests.setMsisdn(strings[2]);
            transactionRequests.setOrgAccountBalance(transactionRequest.getOrgAccountBalance());
            transactionRequests.setTransID(transactionRequest.getTransID());
            transactionRequests.setThirdPartyTransID(transactionRequest.getThirdPartyTransID());
            transactionRequests.setTransactionType(transactionRequest.getTransactionType());
            transactionRequests.setTransAmount(transactionRequest.getTransAmount());
            transactionRequests.setTransTime(transactionRequest.getTransTime());
            if (!transactionRequest.getFirstName().equalsIgnoreCase("Bonga Everywhere Services")) {
                transactionRequests.setProcessed(1);
                transactionRequests.setTransactionReversed(1);
                transactionRequests.setTransactionCompleted(1);
                transactionRequests.setAmountAwarded("0");
                transactionRepo.save(transactionRequests);
                return new TransactionResponseValidation("C2B00013", "Rejected");
            }
            transactionRequests.setProcessed(0);
            transactionRequests = transactionRepo.save(transactionRequests);
            return new TransactionResponseValidation("0", "Accepted", String.valueOf(transactionRequests.getId()));
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return new TransactionResponseValidation("C2B00013", "Rejected");
        }

}
