package com.tech.eswitch.interfaces;

import com.tech.eswitch.dto.partner.Records;
import com.tech.eswitch.dto.partner.TransactionTotals;

import java.util.List;

public interface PartnerRecords {
    List<Records> getRecords(String accountId, String password, String date);

    List<Records> getAllRecords(String password, String date, Integer status);

    List<TransactionTotals> getTransactionTotals(String password, String date);
}
