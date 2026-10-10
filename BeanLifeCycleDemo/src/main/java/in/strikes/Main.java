package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ConfigurableApplicationContext is child class of ApplicationContext with close() method
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

//        AppConfig config = context.getBean(AppConfig.class);
//        config.demo();

//        UserService userService = context.getBean(UserService.class);
//        userService.setBeanName("userBean2");

//        CartService cart = context.getBean(CartService.class);
//        System.out.println(cart.getValue(1));
//
//        context.close();
    }
}

