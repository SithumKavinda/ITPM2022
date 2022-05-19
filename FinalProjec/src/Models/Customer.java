package Models;

public class Customer {

    private int customer_id;
    private String fname;
    private String lname;
    private String address;
    private String nic;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(int customer_id) {
        this.customer_id = customer_id;
    }

    public Customer(int customer_id, String fname, String lname, String address, String nic, String email, String phone) {
        this.customer_id = customer_id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.nic = nic;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
