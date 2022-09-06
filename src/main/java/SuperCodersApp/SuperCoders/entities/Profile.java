package SuperCodersApp.SuperCoders.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    private String id;
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;
    @Column(name = "createdAt", updatable = false)
    private LocalDate createdAt;
    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    protected Profile(){
    }

    public Profile(String id, String image, String phone) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
