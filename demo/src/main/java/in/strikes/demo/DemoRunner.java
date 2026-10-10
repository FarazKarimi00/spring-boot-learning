package in.strikes.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner/*ApplicationRunner */ {

    private final PaymentGateway paymentGateway;

    @Autowired //(no need to write @Autowired if there is only one constructor)
    public DemoRunner(PaymentGateway paymentGateway) {  //(no need to write @Autowired)
        this.paymentGateway = paymentGateway;
    }

//    @Override   //AplicationRunner interface method
//    public void run(ApplicationArguments args) throws Exception {
//        paymentGateway.print();
//    }

    @Override // CommandLineRunner interface method
    public void run(String... args) throws Exception {
        paymentGateway.print();
    }
}
