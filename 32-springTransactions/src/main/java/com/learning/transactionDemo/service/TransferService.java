package com.learning.transactionDemo.service;

import com.learning.transactionDemo.entity.Account;
import com.learning.transactionDemo.entity.TransferRecord;
import com.learning.transactionDemo.repository.AccountRepository;
import com.learning.transactionDemo.repository.TransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;


@Service
public class TransferService {
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository
    ) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        if(amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Enter positive amount");
        }
        if(fromAccountId == null || toAccountId == null) {
            throw new IllegalArgumentException("Account ID's cannot be null");
        }
        if(fromAccountId.equals(toAccountId)) {
            throw new IllegalArgumentException("Cannot transfer money to the same account");
        }
        Account fromAccount =
                accountRepository.findById(fromAccountId)
                .orElseThrow(()->new RuntimeException("User not found"));
        Account toAccount =
                accountRepository.findById(toAccountId)
                .orElseThrow(()->new RuntimeException("User not found"));
        fromAccount.debitAmount(amount);
//        accountRepository.saveAndFlush(fromAccount); (persistence context and dirty checking do it automatically, no need to do manually)
        toAccount.creditAccount(amount);
//        accountRepository.saveAndFlush(toAccount);

        transferRepository.save(new TransferRecord(
                fromAccountId, toAccountId, amount, LocalDate.now()
        ));

//        throw new RuntimeException("Simulated failure");
    }

    public TransferRecord getTransferRecord(Long id) {
        return transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found for id: " + id));
    }
}


