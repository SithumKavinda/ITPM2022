
package Controllers;

import Connector.Connector;
import Models.User;
import java.sql.ResultSet;

public class LoginController {

    Connector con = Connector.getInstance();
    User user = new User();

    private LoginController() {
    }

    private static final LoginController obj = new LoginController();

    public static LoginController getInstance() {
        return obj;
    }

    public User Login(String username, String password) throws Exception {

        con.getConnection();
        ResultSet rs = con.srh("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
        if (rs.next()) {

            user.setUser_id(rs.getInt(1));
            user.setName(rs.getString(2));
        } else {
            user.setUser_id(0);
        }

        return user;
    }
}

