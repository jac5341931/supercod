package SuperCodersApp.SuperCoders;

import SuperCodersApp.SuperCoders.Entity.Employee;
import SuperCodersApp.SuperCoders.Entity.Enterprise;
import SuperCodersApp.SuperCoders.Entity.Role;
import SuperCodersApp.SuperCoders.Entity.Transaction;
import SuperCodersApp.SuperCoders.Repository.EnterpriseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuperCodersApplication {

	private static final Logger log = LoggerFactory.getLogger(SuperCodersApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SuperCodersApplication.class, args);

		Enterprise aEnterprise = new Enterprise("MiEntidad", "CAlle 777", "3002326666", "8233584-3");
		Employee anEmployee = new Employee("Edward", "edwardrossiano@gmail.com");

		anEmployee.setEnterprise(aEnterprise);
		anEmployee.setRole(Role.Admin);

		System.out.println(aEnterprise.toString());
		System.out.println(anEmployee.toString());

		Transaction aTransaction1 = new Transaction("Concept #1", 100.75f, anEmployee, aEnterprise);
		Transaction aTransaction2 = new Transaction("Concept #2", -50.30f, anEmployee, aEnterprise);
		Transaction aTransaction3 = new Transaction("Concept #3", -30.60f, anEmployee, aEnterprise);

		System.out.println(aTransaction1.getEmployeeName());
		System.out.println(aTransaction1.getEnterpriseName());

		System.out.println(aTransaction1.toString());
		System.out.println(aTransaction2.toString());
		System.out.println(aTransaction3.toString());


	}

	@Bean
	public CommandLineRunner demo(EnterpriseRepository repository) {
		return (args) -> {
			// save a few customers
		/*	repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));*/

			// fetch all customers
			log.info("Enterprise found with findAll():");
			log.info("-------------------------------");
			for (Enterprise enterprise : repository.findAll()) {
				log.info(enterprise.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Enterprise enterprise = repository.findById(1L);
			log.info("Enterprise found with findById(1L):");
			log.info("--------------------------------");
			log.info(enterprise.toString());
			log.info("");

		/*	// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");

		*/
		};

	}
}
