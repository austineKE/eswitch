package com.tech.eswitch.repo;

import com.tech.eswitch.model.SendMoneyTransactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SendMoneyRepo extends CrudRepository<SendMoneyTransactions, Integer> {
}
