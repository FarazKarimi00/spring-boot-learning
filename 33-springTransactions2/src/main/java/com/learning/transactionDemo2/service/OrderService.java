package com.learning.transactionDemo2.service;

import com.learning.transactionDemo2.entity.Order;
import com.learning.transactionDemo2.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentAuditService paymentAuditService;
    public OrderService(
            OrderRepository orderRepository,
            PaymentAuditService paymentAuditService
    ) {
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

//    @Transactional(
//            isolation = Isolation.READ_COMMITTED,
//            timeout = 30
//    )
//    @Transactional
    public void placeOrder(Order  order) {
        orderRepository.save(order);
        paymentAuditService.audit(order);
//        throw new RuntimeException("Simulated exception");
//        try {
//            paymentAuditService.audit(order);
//        } catch (Exception e) {
//
//        }
    }
}

