package in.strikes.model;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String MobileNo;

    public User(Integer id, String name, String email, String mobileNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        MobileNo = mobileNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }
}
