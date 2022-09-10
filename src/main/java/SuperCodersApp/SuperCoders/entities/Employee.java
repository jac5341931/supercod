package SuperCodersApp.SuperCoders.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
     @Column(name = "role")
     @Enumerated(EnumType.ORDINAL)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    protected Employee() {
    }
    public Employee(String name, String email, Profile profile,Enterprise enterprise) {
        this.name = name;
        this.email = email;
        this.profile = profile;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role roleName) {
        this.role = roleName;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
