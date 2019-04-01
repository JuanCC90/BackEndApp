package BackEnd.backprueba1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringPrimeFacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrimeFacesApplication.class, args);
	}
}
