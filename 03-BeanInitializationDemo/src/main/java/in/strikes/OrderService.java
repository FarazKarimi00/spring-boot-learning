package in.strikes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class OrderService {
    private final PaymentService paymentService;
    public OrderService(PaymentService paymentService) {  // Proxy
        this.paymentService = paymentService;
//        System.out.println("OrderService created");
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }

    public void getOrderDetails() {
        System.out.println("Order details: abc...xyz");
    }
}
