package com.learning.transactionDemo.repository;

import com.learning.transactionDemo.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}
