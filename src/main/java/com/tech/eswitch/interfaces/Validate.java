package com.tech.eswitch.interfaces;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseConfirmation;
import com.tech.eswitch.dto.TransactionResponseValidation;
import org.springframework.stereotype.Service;

@Service
public interface Validate {
    TransactionResponseValidation validate(TransactionRequest transactionRequest);
}
