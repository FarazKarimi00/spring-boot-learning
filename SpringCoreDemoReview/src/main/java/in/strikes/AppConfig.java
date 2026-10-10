package in.strikes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.strikes")
public class AppConfig {
    @Bean
    public UserService userServiceBean() {
        return new UserService();
    }
}
