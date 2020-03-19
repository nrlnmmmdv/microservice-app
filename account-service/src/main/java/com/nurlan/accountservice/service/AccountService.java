package com.nurlan.accountservice.service;

import com.nurlan.accountservice.entitiy.Account;
import com.nurlan.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tapilmadi!"));
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(Account account) {
        Assert.isNull(account.getId(), "Id cannot be null");
        return accountRepository.save(account);
    }

    public void delete(String id) {
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
