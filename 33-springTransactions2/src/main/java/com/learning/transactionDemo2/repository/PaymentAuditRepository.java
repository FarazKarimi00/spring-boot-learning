package com.learning.transactionDemo2.repository;

import com.learning.transactionDemo2.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAuditRepository extends JpaRepository<PaymentAudit, Long> {
}
