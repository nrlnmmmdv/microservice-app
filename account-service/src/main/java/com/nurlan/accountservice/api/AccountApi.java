package com.nurlan.accountservice.api;

import com.nurlan.accountservice.dto.AccountDto;
import com.nurlan.accountservice.entitiy.Account;
import com.nurlan.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
/**
 *  localhost:8080/account
 * */
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.update(account));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(accountService.getAll(pageable));
    }
}