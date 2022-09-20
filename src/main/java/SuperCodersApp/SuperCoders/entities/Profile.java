package SuperCodersApp.SuperCoders.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="username", unique = true)
    private String username;
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;
    @Column(name = "createdAt", updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate createdAt;
    @Column(name = "updatedAt")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate updatedAt;

    @OneToOne //mapeada por los id de emprealdos
    private Employee employee;

    protected Profile(){
    }

    public Profile(long id, String username, String image, String phone, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.username = username;
        this.image = image;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt.now();
    }
}
