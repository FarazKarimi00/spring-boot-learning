package in.strikes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

// Here two different bean definition, so two different objects for each bean will be created
//    @Bean
//    public OrderService getOrder() {
//        return new OrderService();
//    }
//
//    @Bean
//    public OrderService getOrder2() {
//        return new OrderService();
//    }
}
