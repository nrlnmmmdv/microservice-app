package com.nurlan.accountservice.service;

import com.nurlan.accountservice.dto.AccountDto;
import com.nurlan.accountservice.entitiy.Account;
import com.nurlan.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDto get(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tapilmadi!"));
        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(AccountDto accountDto) {
        Assert.isNull(accountDto.getId(), "Id cannot be null");
        Optional<Account> account = accountRepository.findById(accountDto.getId());
        Account accountToUpdate = account.map(it ->
        {
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            it.setBirthDate(accountDto.getBirthDate());
            return it;
        })
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper
                .map(accountRepository
                        .save(accountToUpdate), AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository
                .findById(id).orElseThrow(IllegalAccessError::new);
        accountRepository.delete(account);
    }

    public Slice<AccountDto> getAll(Pageable pageable) {
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return modelMapper.map(accounts, Slice.class);
    }
}
