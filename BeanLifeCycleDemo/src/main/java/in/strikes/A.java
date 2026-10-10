package in.strikes;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;
    public A(B b) {
        this.b = b;
    }

    @PostConstruct
    public void setB() {
        b.setA(this);
    }
}
