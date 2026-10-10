package in.strikes;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order = context.getBean(OrderService.class);// now bean is created if @Lazy
        order.placeOrder();
//        PaymentService paymentService = context.getBean(PaymentService.class); // For @Lazy
    }
}

