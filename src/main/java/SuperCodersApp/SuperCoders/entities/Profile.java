package SuperCodersApp.SuperCoders.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;
    @Column(name="nickname", unique = true)
    private String nickname;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;
    @Column(name = "auth0Id", unique = true)
    private String outh0Id;
/*    @OneToOne(mappedBy = "profile", optional = true)
    @JsonBackReference
    private Employee employee;*/

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "profile")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    public Profile(){
    }

    public Profile(String name,String nickname, String email, String image, String phone, String outh0Id, Employee employee) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.outh0Id = outh0Id;
        this.employee = employee;
        this.role = Role.Operator;
    }

    public Profile(long id, String name, String nickname, String email, String image, String phone, String outh0Id,Employee employee) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.outh0Id = outh0Id;
        this.employee= employee;
        this.role = Role.Operator;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOuth0Id() {
        return outh0Id;
    }

    public void setOuth0Id(String outh0Id) {
        this.outh0Id = outh0Id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
