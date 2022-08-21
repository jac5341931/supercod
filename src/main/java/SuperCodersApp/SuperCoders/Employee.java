package SuperCodersApp.SuperCoders;
public class Employee {
/*    Es posible crear una nueva instancia de la clase
"Empleado"
    Es posible leer y modificar el nombre de un empleado
    Es posible leer y modificar el correo de un empleado
    Es posible leer y modificar la empresa a la que el
    empleado pertenece
    Es posible leer y modificar el rol del empleado
            (administrador, operativo)*/

    private String name;
    private String email;
    private Enterprise enterprise;
    private Role role;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.role = Role.Operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public String getEnterpriseName() {
        return enterprise.getName();
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleName(){
        return switch (this.role) {
            case Admin -> "Admin";
            case Operator -> "Operator";
        };
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", enterprise=" + getEnterpriseName() +
                ", role=" + getRoleName() +
                '}';
    }
}
