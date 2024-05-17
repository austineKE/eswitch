package com.tech.eswitch.repo;

import com.tech.eswitch.dto.partner.TransactionTotals;
import com.tech.eswitch.model.TransactionRequests;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionRequests, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests where  transaction_completed=0 and processed=1 and send_money_successful=0 and send_money_retry_count<1  ORDER BY id asc limit 100;")
    List<TransactionRequests> findTransactionToSend();

    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests where  transid = ?;")
    TransactionRequests fetchById(String transId);

    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests where  send_money_request_id = ?;")
    TransactionRequests fetchByConversationId(String transId);

    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d') " +
            "= STR_TO_DATE(?, '%d/%m/%Y') and bill_ref_number in(" +
            "SELECT code FROM eswitch_partners where code =? and password=?);")
    List<TransactionRequests> fetchRecords(String date, String accountId, String password);


    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d') " +
            "= STR_TO_DATE(?, '%d/%m/%Y') and transaction_completed=1 and send_money_successful=1;")
    List<TransactionRequests> fetchCompletedRecords(String date);

    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d') " +
            "= STR_TO_DATE(?, '%d/%m/%Y') and transaction_reversed=1  ;")
    List<TransactionRequests> fetchRejectedRecords(String date);

    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d') " +
            "= STR_TO_DATE(?, '%d/%m/%Y') and transaction_completed=0 and send_money_successful=0 ")
    List<TransactionRequests> fetchPendingRecords(String date);

    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d') " +
            "= STR_TO_DATE(?, '%d/%m/%Y') ;")
    List<TransactionRequests> fetchAllRecords(String date);


    @Query(nativeQuery = true, value = "SELECT   * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d')\n" +
            "            = STR_TO_DATE(?, '%d/%m/%Y') and transaction_completed=1 and send_money_successful=1 ;")
    List<TransactionRequests> fetchSuccessfulTransactions(String date);

    @Query(nativeQuery = true, value = "SELECT   * FROM transaction_requests WHERE STR_TO_DATE(trans_time, '%Y%m%d')\n" +
            "            = STR_TO_DATE(?, '%d/%m/%Y') and transaction_completed=1 and send_money_successful=1 and bill_ref_number not in(\n" +
            "            SELECT code FROM eswitch_partners ) ;")
    List<TransactionRequests> fetchTotalsForCompany(String date);

}
