package com.learning.transactionDemo.controller;

import com.learning.transactionDemo.entity.Account;
import com.learning.transactionDemo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created");
    }
    @GetMapping("/get-account-details/{id}")
    public ResponseEntity<Account> getAccountDetails(@PathVariable Long id) {
        Account account = accountService.getAccountDetails(id);
        return ResponseEntity.ok(account);
    }
}
