public class Main {

    public static void main(String[] args) {
        Enterprise aEnterprise = new Enterprise("MiEntidad", "CAlle 777", "3002326666", "8233584-3");
        Employee anEmployee = new Employee("Edward", "edwardrossiano@gmail.com");

        anEmployee.setEnterprise(aEnterprise);
        anEmployee.setRole(Role.Operator);
        System.out.println(aEnterprise.toString1());
        System.out.println(anEmployee.toString1());
    }



}
