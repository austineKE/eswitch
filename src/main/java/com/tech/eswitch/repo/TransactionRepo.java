package com.tech.eswitch.repo;

import com.tech.eswitch.model.TransactionRequests;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionRequests, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM transaction_requests where  transaction_completed=0 and processed=1 and send_money_successful=0 and send_money_retry_count<3  ORDER BY id asc limit 100;")
    List<TransactionRequests> findTransactionToSend();
}
