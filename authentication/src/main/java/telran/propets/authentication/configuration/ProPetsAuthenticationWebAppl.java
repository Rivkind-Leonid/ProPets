package telran.propets.authentication.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "telran.propets.authentication")
@SpringBootApplication
public class ProPetsAuthenticationWebAppl {
    public static void main(String[] args) {
        SpringApplication.run(ProPetsAuthenticationWebAppl.class, args);
    }
}
