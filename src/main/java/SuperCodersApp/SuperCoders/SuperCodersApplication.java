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

		Transaction aTransaction1 = new Transaction("Concept #1", 100.75f, anEmployee, aEnterprise);
		Transaction aTransaction2 = new Transaction("Concept #2", -50.30f, anEmployee, aEnterprise);
		Transaction aTransaction3 = new Transaction("Concept #3", -30.60f, anEmployee, aEnterprise);

		System.out.println(aTransaction1.getEmployeeName());
		System.out.println(aTransaction1.getEnterpriseName());


		System.out.println(aTransaction1.toString());

		System.out.println(aTransaction2.toString());

		System.out.println(aTransaction3.toString());


	}

}
