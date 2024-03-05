package com.tech.eswitch.repo;

import com.tech.eswitch.model.TransactionRequests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionRequests, Integer> {

}
