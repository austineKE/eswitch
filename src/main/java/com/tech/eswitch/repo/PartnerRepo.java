package com.tech.eswitch.repo;

import com.tech.eswitch.interfaces.PartnerRecords;
import com.tech.eswitch.model.EswitchPartners;
import com.tech.eswitch.model.SendMoneyTransactions;
import com.tech.eswitch.model.TransactionRequests;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartnerRepo extends CrudRepository<EswitchPartners, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM eswitch_partners ;")
    List<EswitchPartners> getAll();
}
