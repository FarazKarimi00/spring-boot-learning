package in.strikes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class PaymentService {

    private OrderService orderService;

    public PaymentService(OrderService orderService) {
        this.orderService = orderService;
//        System.out.println("Payment service created");
    }

    public void pay() {
        System.out.println("Payment Successful");
        orderService.getOrderDetails();
    }
}
