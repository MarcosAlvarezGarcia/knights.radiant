package marcos.knights.radiant;

import marcos.knights.radiant.services.DataInsertionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KnightsRadiantApplication {

	public static void main(String[] args) {
		System.out.println("Hasieratzen/Starteando...");
		SpringApplication.run(KnightsRadiantApplication.class, args);
		System.out.println("*******************************************************************************************************************************************************************************************");
		System.out.println("*                                                                                                                                                      			                          *");
		System.out.println("*                                                                                                                                                      			       			          *");
		System.out.println("*                                                                                                                                                                           		      *");
		System.out.println("*                                                                                    WELCOME                                                                             		          *");
		System.out.println("*                                                                                    TO THE                                                                              		          *");
		System.out.println("*                                                                                KNIGHTS RADIANT!                                                                                         *");
		System.out.println("*                                                                                                                                                      			            		      *");
		System.out.println("*                                                                                                                                                                          			      *");
		System.out.println("*******************************************************************************************************************************************************************************************");

		System.out.println("Abra Postman en http://localhost:8080");
	}
	@Bean
	public CommandLineRunner init(DataInsertionService service) {
		return args -> {
			service.createSurges(10);
			service.createOrders(10);
		};
	}
}
