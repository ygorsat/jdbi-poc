package jdbi.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ygor.satiro
 * Classe main para execução da aplicação
 */

@SpringBootApplication
@ComponentScan(basePackages = "jdbi.poc")
public class JdbiPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbiPocApplication.class, args);
	}
}
