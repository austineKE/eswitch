package com.tech.eswitch.interfaces;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.b2c.ValidationResult;

public interface Validate {
    ValidationResult validate(TransactionRequest transactionRequest);
}
