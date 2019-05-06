package ligai.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 03.11.2017
 * ligai.application.Application
 *
 * @author Ligai Vyacheslav
 * @version v0.1
 */
@SpringBootApplication
@ComponentScan("ligai")
@EnableJpaRepositories(basePackages = "ligai.repositories")
@EntityScan(basePackages = "ligai.models")
public class Application {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }
}


