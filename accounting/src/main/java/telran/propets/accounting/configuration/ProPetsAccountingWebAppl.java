package telran.propets.accounting.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "telran.propets.accounting")
@SpringBootApplication
public class ProPetsAccountingWebAppl {
    public static void main(String[] args) {
        SpringApplication.run(ProPetsAccountingWebAppl.class, args);
    }
}
