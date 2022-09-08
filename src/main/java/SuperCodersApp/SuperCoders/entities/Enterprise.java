package SuperCodersApp.SuperCoders.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "document", unique = true)
    private String NIT;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    @OneToMany(
            mappedBy = "id"/*,
            cascade = CascadeType.ALL,
            orphanRemoval = true*/
    )
    private List<Employee> users;


    protected Enterprise() {
    }
    public Enterprise(String name, String address, String phone, String NIT, List<Employee> users) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.NIT = NIT;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }

    /*@Override
    public String toString() {
        return "Enterprise{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", NIT='" + NIT + '\'' +
                '}';
    }*/
}
