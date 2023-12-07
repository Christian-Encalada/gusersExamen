package ec.voto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ec.voto.api.repository")
@EntityScan(basePackages = "ec.voto.api.domain")
public class VotoApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(VotoApiApplication.class, args);
	}
}



