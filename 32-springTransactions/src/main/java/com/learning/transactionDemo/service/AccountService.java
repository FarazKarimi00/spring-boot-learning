package com.learning.transactionDemo.service;

import com.learning.transactionDemo.entity.Account;
import com.learning.transactionDemo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    public Account getAccountDetails(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("account not found"));
    }
}
