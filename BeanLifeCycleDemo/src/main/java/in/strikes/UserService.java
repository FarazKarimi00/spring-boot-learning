package in.strikes;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component("userBean")
public class UserService implements BeanNameAware, ApplicationContextAware {

    public UserService() {
        System.out.println("UserService constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("Application context name is: " + applicationContext.getClass());
    }
}
