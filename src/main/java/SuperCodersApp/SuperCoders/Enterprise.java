package SuperCodersApp.SuperCoders;
public class Enterprise {

    private String name;
    private String address;
    private String phone;
    private String NIT;

    public Enterprise(String name, String address, String phone, String NIT) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.NIT = NIT;
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

@Override
    public String toString() {
        return "Enterprise{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", NIT='" + NIT + '\'' +
                '}';
    }
}
