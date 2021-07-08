package its.kennedy.gestione.magazzino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestioneMagazzinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneMagazzinoApplication.class, args);
	}

}
