package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        OrderService orderService1 = context.getBean(OrderService.class);

//        OrderService orderService2 = new OrderService(); // Creates a new OrderService object

        System.out.println(orderService == orderService1);
    }
}

