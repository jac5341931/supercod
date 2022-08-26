package SuperCodersApp.SuperCoders.Entity;

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

    public Profile(){
    }

    public Profile(String id, String image, String phone) {
        this.id = id;
        this.image = image;
        this.phone = phone;
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

}
