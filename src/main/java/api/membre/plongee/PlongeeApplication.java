package api.membre.plongee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Marine
 */
@SpringBootApplication(scanBasePackages={
"api.membre.controller", "api.membre.domain","api.membre.repo","api.membre.service"})
@EnableAutoConfiguration
@ComponentScan(basePackages={"api.membre.controller","api.membre.service"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="api.membre.repo")
//@EntityScan(basePackages={"api.membre.domain"})
public class PlongeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlongeeApplication.class, args);
	}
}
