
package Controllers;

import Models.User;
import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    Connector con = Connector.getInstance();

    //Singleton Design pattern is implemented 
    private UserController() {
    }

    private static final UserController obj = new UserController();

    public static UserController getInstance() {
        return obj;
    }

    
    //CRUD operations are implemented 
    public void Save(User data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO user(name,email,phone,username,password) values ('" + data.getName() + "','" + data.getEmail() + "','" + data.getPhone() + "','" + data.getUsername() + "','" + data.getPassword() + "') ");
    }

    public void Update(User data) throws Exception {
        con.getConnection();
        con.aud("UPDATE user SET name  = '" + data.getName() + "',email  = '" + data.getEmail() + "',phone  = '" + data.getPhone() + "',username  = '" + data.getUsername() + "',password  = '" + data.getPassword() + "' WHERE user_id = '" + data.getUser_id() + "'");
    }

    public void Delete(User data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM user WHERE user_id = '" + data.getUser_id() + "'");
    }

    public List<User> SearchAll() throws Exception {
        List<User> objList = new ArrayList<User>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user");
        while (rset.next()) {
            User obj = new User();
            obj.setUser_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setEmail(rset.getString(3));
            obj.setPhone(rset.getString(4));
            obj.setUsername(rset.getString(5));
            obj.setPassword(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<User> Search(User data) throws Exception {
        List<User> objList = new ArrayList<User>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user WHERE user_id = '" + data.getUser_id() + "'");
        while (rset.next()) {
            User obj = new User();
            obj.setUser_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setEmail(rset.getString(3));
            obj.setPhone(rset.getString(4));
            obj.setUsername(rset.getString(5));
            obj.setPassword(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}

