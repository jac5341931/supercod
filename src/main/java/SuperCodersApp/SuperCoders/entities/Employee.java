package SuperCodersApp.SuperCoders.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Enterprise enterprise;

    @Column(name = "role")
    private Role role;

    protected Employee() {
    }
    public Employee(String name, String email, Enterprise enterprise) {
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.role = Role.Operator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

/*
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", enterprise=" + getEnterpriseName() +
                ", role=" + getRoleName() +
                '}';
    }*/
}
