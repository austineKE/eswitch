package com.tech.eswitch.interfaces;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseValidation;

public interface Validate {
    TransactionResponseValidation validate(TransactionRequest transactionRequest);
}
