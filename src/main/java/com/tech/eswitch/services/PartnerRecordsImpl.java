package com.tech.eswitch.services;

import com.tech.eswitch.dto.partner.Records;
import com.tech.eswitch.dto.partner.TransactionTotals;
import com.tech.eswitch.interfaces.PartnerRecords;
import com.tech.eswitch.model.EswitchPartners;
import com.tech.eswitch.model.TransactionRequests;
import com.tech.eswitch.repo.PartnerRepo;
import com.tech.eswitch.repo.TransactionRepo;
import com.tech.eswitch.utils.PropertyReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PartnerRecordsImpl implements PartnerRecords {

    private TransactionRepo transactionRepo;
    private PartnerRepo partnerRepo;

    public PartnerRecordsImpl(TransactionRepo transactionRepo, PartnerRepo partnerRepo) {
        this.transactionRepo = transactionRepo;
        this.partnerRepo = partnerRepo;
    }

    @Override
    public List<Records> getRecords(String accountId, String password, String date) {
        List<TransactionRequests> transactionRequests = transactionRepo.fetchRecords(date, accountId, password);
        List<Records> records = new ArrayList<>();

        transactionRequests.forEach(record -> {
            Records records1 = new Records();
            records1.setAmountDeducted(String.valueOf(Double.parseDouble(record.getTransAmount())
                    - Double.parseDouble(record.getAmountAwarded())));
            records1.setBongaAmount(record.getTransAmount());
            records1.setCustomerAmount(record.getAmountAwarded());
            records1.setReceipt(record.getTransID());
            String status = "";
            if (record.getTransactionReversed() == 1) {
                status = "Reversed";
            } else if (record.getProcessed() == 1 && record.getSendMoneySuccessful() == 1) {
                status = "Success";
            } else {
                status = "Pending";
            }
            records1.setStatus(status);
            records.add(records1);
            records1 = null;
        });

        return records;
    }

    @Override
    public List<Records> getAllRecords(String password, String date, Integer status) {

        if(!PropertyReader.getProperty("eSwitch.send.money.password").equals(password)){
            return null;
        }

        List<TransactionRequests> transactionRequests = new ArrayList<>();

        if (status == -1) {
            transactionRequests = transactionRepo.fetchRejectedRecords(date);
        } else if (status == 0) {
            transactionRequests = transactionRepo.fetchCompletedRecords(date);
        } else if (status == 2) {
            transactionRequests = transactionRepo.fetchPendingRecords(date);
        } else {
            transactionRequests = transactionRepo.fetchAllRecords(date);
        }

        List<Records> records = new ArrayList<>();
        transactionRequests.forEach(record -> {
            Records records1 = new Records();
            records1.setAmountDeducted(String.valueOf(Double.parseDouble(record.getTransAmount())
                    - Double.parseDouble(record.getAmountAwarded())));
            records1.setBongaAmount(record.getTransAmount());
            records1.setCustomerAmount(record.getAmountAwarded());
            records1.setReceipt(record.getTransID());
            String s = "";
            if (record.getTransactionReversed() == 1) {
                s = "Reversed";
            } else if (record.getProcessed() == 1 && record.getSendMoneySuccessful() == 1) {
                s = "Success";
            } else {
                s = "Pending";
            }
            records1.setStatus(s);
            records.add(records1);
            records1 = null;
        });

        return records;
    }

    @Override
    public List<TransactionTotals> getTransactionTotals(String password, String date) {
        if(!PropertyReader.getProperty("eSwitch.send.money.password").equals(password)){
            return null;
        }
        List<TransactionRequests> transactionRequests = transactionRepo.fetchSuccessfulTransactions(date);
        List<EswitchPartners> partners = partnerRepo.getAll();
        List<TransactionTotals> transactionTotals = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        partners.forEach(x -> {
            TransactionTotals transactionTotals1 = new TransactionTotals();
            TransactionTotals finalTransactionTotals = transactionTotals1;
            transactionRequests.stream().filter(transactionRequests1 ->
                    transactionRequests1.getBillRefNumber().replaceAll("\\s", "").equalsIgnoreCase(x.getCode().replaceAll("\\s", "")))
                    .forEach(transactionRequests1 -> {
                        count.getAndIncrement();
                        finalTransactionTotals.setTotalTransactionsAmount(
                                finalTransactionTotals.getTotalTransactionsAmount()
                                        + Double.parseDouble(transactionRequests1.getCompanyAmount()));
                    });

            transactionTotals1.setCount(count.get());
            transactionTotals1.setPartnerCode(x.getCode().replaceAll("\\s", ""));
            transactionTotals.add(transactionTotals1);
            transactionTotals1 = null;
            count.set(0);
        });

        count.set(0);
        List<TransactionRequests> transactionRequests_ = transactionRepo.fetchTotalsForCompany(date);
        TransactionTotals transactionTotals1 = new TransactionTotals();
        TransactionTotals finalTransactionTotals = transactionTotals1;
        transactionRequests_.forEach(transactionRequests1 -> {
            count.getAndIncrement();
            finalTransactionTotals.setTotalTransactionsAmount(
                    finalTransactionTotals.getTotalTransactionsAmount()
                            + Double.parseDouble(transactionRequests1.getCompanyAmount()));
        });

        transactionTotals1.setCount(count.get());
        transactionTotals1.setPartnerCode("eswitch");
        transactionTotals.add(transactionTotals1);
        transactionTotals1 = null;
        count.set(0);
        return transactionTotals;
    }

}
