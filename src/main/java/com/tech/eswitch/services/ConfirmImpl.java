package com.tech.eswitch.services;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseConfirmation;
import com.tech.eswitch.interfaces.Confirm;
import com.tech.eswitch.model.TransactionRequests;
import com.tech.eswitch.repo.TransactionRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfirmImpl implements Confirm {

    TransactionRepo transactionRepo;

    public ConfirmImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public TransactionResponseConfirmation confirm(TransactionRequest transactionRequest) {

        TransactionRequests transactionRequests = transactionRepo
                .findById(Integer.valueOf(transactionRequest.getThirdPartyTransID())).get();

        int amount = Integer.parseInt(transactionRequest.getTransAmount());
        int amountAwarded = (int) (0.9 * amount);
        transactionRequests.setAmountAwarded(String.valueOf(amountAwarded));
        transactionRequests.setProcessed(1);

        transactionRepo.save(transactionRequests);

        return new TransactionResponseConfirmation("0", "Success");
    }

}
