package com.tech.eswitch.services;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseConfirmation;
import com.tech.eswitch.interfaces.Confirm;
import com.tech.eswitch.model.TransactionRequests;
import com.tech.eswitch.repo.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfirmImpl implements Confirm {
    private Logger logger = LoggerFactory.getLogger(ConfirmImpl.class);
    TransactionRepo transactionRepo;

    public ConfirmImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public TransactionResponseConfirmation confirm(TransactionRequest transactionRequest) {

        try {
            TransactionRequests transactionRequests = transactionRepo
                    .fetchById(transactionRequest.getTransID());

            Double amount = Double.parseDouble(transactionRequest.getTransAmount());
            int amountAwarded = (int) Math.ceil(0.9 * amount);
            transactionRequests.setAmountAwarded(String.valueOf(amountAwarded));
            transactionRequests.setCompanyAmount(String.valueOf(amount - amountAwarded));
            transactionRequests.setProcessed(1);
            transactionRequests.setSendMoneyRetryCount(0);
            transactionRequests.setThirdPartyTransID("eSwitch_" + transactionRequests.getTransTime() + "_" + transactionRequests.getId());

            transactionRepo.save(transactionRequests);

            return new TransactionResponseConfirmation("0", "Success");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return new TransactionResponseConfirmation("10000", "Failed");
    }

}
