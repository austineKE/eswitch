package com.tech.eswitch.services;

import com.tech.eswitch.interfaces.B2CStatusAndBalance;
import org.springframework.stereotype.Service;

@Service
public class B2CStatusAndBalanceImpl implements B2CStatusAndBalance {
    @Override
    public Object getAccountBalance() {
        //todo create the POST request here to hit Safaricom and get the account balance
        // In case you come up with any dto, have it b2c package

        return null;
    }

    @Override
    public Object getTransactionStatus() {
        //todo create the POST request here to hit Safaricom and get transaction status.
        // We will use this API to confirm failed transactions.
        // In case you come up with any dto, have it b2c package

        return null;
    }
}
