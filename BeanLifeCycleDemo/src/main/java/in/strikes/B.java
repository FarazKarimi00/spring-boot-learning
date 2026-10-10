package in.strikes;

import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;
//    public B(A a) {
//        this.a = a;
//    }

    public void setA(A a) {
        this.a = a;
    }
}
