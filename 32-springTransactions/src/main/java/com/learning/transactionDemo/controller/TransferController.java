package com.learning.transactionDemo.controller;

import com.learning.transactionDemo.entity.TransferRecord;
import com.learning.transactionDemo.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    private final TransferService transferService;
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferAmount(@RequestBody TransferRecord transferRecord) {
        transferService.transfer(
                transferRecord.getFromAccountId(),
                transferRecord.getToAccountId(),
                transferRecord.getAmount()
        );
        return ResponseEntity.ok("Transfer done");
    }

    @GetMapping("/get-transaction-details/{id}")
    public ResponseEntity<TransferRecord> getTransactionDetails(@PathVariable Long id) {
        TransferRecord record = transferService.getTransferRecord(id);
        return ResponseEntity.ok(record);
    }
}
