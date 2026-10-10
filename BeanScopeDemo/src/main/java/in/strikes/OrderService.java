package in.strikes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")  // (By default, every class has singleton scope) Eager initialization
@Scope("prototype") // Lazy initialization
public class OrderService {

    public OrderService() {
        System.out.println("OrderService created");
    }

    public void placeOrder() {
        System.out.println("Order placed.");
    }
}
