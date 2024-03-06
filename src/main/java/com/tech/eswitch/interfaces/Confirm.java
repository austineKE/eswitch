package com.tech.eswitch.interfaces;

import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseConfirmation;

public interface Confirm {
    TransactionResponseConfirmation confirm(TransactionRequest transactionRequest);
}
