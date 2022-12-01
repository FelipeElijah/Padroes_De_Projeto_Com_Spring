package felipe.padroesDeProjeto.padroesdeprojetocomspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesDeProjetoComSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesDeProjetoComSpringApplication.class, args);
	}

}
