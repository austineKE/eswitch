package com.tech.eswitch.services;

import com.tech.eswitch.interfaces.TimedOutTransactions;
import org.springframework.stereotype.Service;

@Service
public class TimedOutTransactionsImpl implements TimedOutTransactions {
    @Override
    public void addToQueue(Object request) {

    }
}
