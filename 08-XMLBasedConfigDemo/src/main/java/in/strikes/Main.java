package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // Get bean by id/name
//        OrderService orderService = (OrderService) context.getBean("orderService");
//        orderService.placeOrder();

        // Get bean by type (throws NoUniqueBeanDefinitionException)
//        OrderService  orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

        // Get bean by id/name and type (best way)
//        OrderService orderService =
//                context.getBean("orderService", OrderService.class);

//        PaymentService paymentService =
//                context.getBean("paymentService", PaymentService.class);

//        paymentService.pay();
//        orderService.placeOrder();

        UserService user = context.getBean(UserService.class);
//        System.out.println(user.getUserNames());

        context.close();
    }
}



