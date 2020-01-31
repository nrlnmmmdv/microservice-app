package com.nurlan.accountservice.repository;

import com.nurlan.accountservice.entitiy.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {

}
