package Controllers;

import Models.Customer;
import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    Connector con = Connector.getInstance();

    private CustomerController() {
    }

    private static final CustomerController obj = new CustomerController();

    public static CustomerController getInstance() {
        return obj;
    }

    public void Save(Customer data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO customer(fname,lname,address,nic,email,phone) values ('" + data.getFname() + "','" + data.getLname() + "','" + data.getAddress() + "','" + data.getNic() + "','" + data.getEmail() + "','" + data.getPhone() + "') ");
    }

    public void Update(Customer data) throws Exception {
        con.getConnection();
        con.aud("UPDATE customer SET fname  = '" + data.getFname() + "',lname  = '" + data.getLname() + "',address  = '" + data.getAddress() + "',nic  = '" + data.getNic() + "',email  = '" + data.getEmail() + "',phone  = '" + data.getPhone() + "' WHERE customer_id = '" + data.getCustomer_id() + "'");
    }

    public void Delete(Customer data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM customer WHERE customer_id = '" + data.getCustomer_id() + "'");
    }

    public List<Customer> SearchAll() throws Exception {
        List<Customer> objList = new ArrayList<Customer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM customer");
        while (rset.next()) {
            Customer obj = new Customer();
            obj.setCustomer_id(rset.getInt(1));
            obj.setFname(rset.getString(2));
            obj.setLname(rset.getString(3));
            obj.setAddress(rset.getString(4));
            obj.setNic(rset.getString(5));
            obj.setEmail(rset.getString(6));
            obj.setPhone(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Customer> Search(Customer data) throws Exception {
        List<Customer> objList = new ArrayList<Customer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM customer WHERE customer_id = '" + data.getCustomer_id() + "'");
        while (rset.next()) {
            Customer obj = new Customer();
            obj.setCustomer_id(rset.getInt(1));
            obj.setFname(rset.getString(2));
            obj.setLname(rset.getString(3));
            obj.setAddress(rset.getString(4));
            obj.setNic(rset.getString(5));
            obj.setEmail(rset.getString(6));
            obj.setPhone(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
