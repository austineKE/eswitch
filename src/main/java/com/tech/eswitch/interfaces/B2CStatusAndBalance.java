package com.tech.eswitch.interfaces;

import com.tech.eswitch.dto.TransactionStatusRequest;

public interface B2CStatusAndBalance {
   Object getAccountBalance();
   Object getTransactionStatus(TransactionStatusRequest statusRequest);
}
