package CalendarioFinanceiro.Samantha;

import CalendarioFinanceiro.Samantha.mongoDb.repository.pacienteRepository;
import CalendarioFinanceiro.Samantha.paciente.paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableMongoRepositories
public class SamanthaApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SamanthaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
