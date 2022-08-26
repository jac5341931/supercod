package SuperCodersApp.SuperCoders.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    private long id;
    @Column(name="concept")
    private String concept;
    @Column(name="amount")
    private float amount;
    @Column(name="employee")
    @ManyToOne
    private Employee employee;

    @Column(name="enterprise")
    @ManyToOne
    private Enterprise enterprise;
    @Column(name="createdAt")
    private LocalDate createdAt;

    public Transaction() {
    }
    public Transaction(String concept, float amount, Employee anEmployee, Enterprise aEnterprise) {
        this.concept = concept;
        this.amount = amount;
        this.employee = anEmployee;
        this.enterprise = aEnterprise;
        this.createdAt = LocalDate.now();
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getEmployeeName() {
        return this.employee.getName();
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    public String getEnterpriseName(){
        return this.enterprise.getName();
    }
    public String getCreatedAt() {
        return createdAt.toString();
    }

    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "concept='" + getConcept() + '\'' +
                ", amount=" + getAmount() +
                ", employee=" + employee.getName() +
                ", enterprise=" + enterprise.getName() +
                ", createdAt=" + getCreatedAt() +
                '}';
    }
}
