package SuperCodersApp.SuperCoders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperCodersApplication {

	public static void main(String[] args) {

		SpringApplication.run(SuperCodersApplication.class, args);

		Enterprise aEnterprise = new Enterprise("MiEntidad", "CAlle 777", "3002326666", "8233584-3");
		Employee anEmployee = new Employee("Edward", "edwardrossiano@gmail.com");

		anEmployee.setEnterprise(aEnterprise);
		anEmployee.setRole(Role.Admin);

		System.out.println(aEnterprise.toString());
		System.out.println(anEmployee.toString());
	}

}
