package itpm.carcare.payment.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itpm.carcare.DBConnect;

public class BillDAO {

	private static Connection con;
	private static Statement stmt;
	private PreparedStatement pst;
	private ResultSet rs = null;

	// Check DB connection
	public void testConnection() {
		String sql = "SELECT * FROM person;";

		try {
			//Create connection
			con = DBConnect.getConnection();
			//Test connection
			if (con == null) {
				System.err.println("Error while connecting to the Database");
			}
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("person_name"));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.err.println(e.getMessage()+":\n");
		}
	}

	public List<BillItem> getServiceIDList(int currentUserID) {

		String sql = "SELECT serviceID FROM bill_service WHERE userID = ?";
		List<BillItem> serviceIDList = new ArrayList<BillItem>();

		try {
			con = DBConnect.getConnection();

			if (con == null) {
				System.out.println("Error while connecting to the Database");
			}

			pst = con.prepareStatement(sql);

			// Binding values
			pst.setInt(1, currentUserID);

			// Execute statement
			rs = pst.executeQuery();

			while (rs.next()) {
				int serviceID = rs.getInt("serviceID");
				BillItem billItem = new BillItem(currentUserID, serviceID);
				serviceIDList.add(billItem);
			}

			con.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return serviceIDList;
	}

//	<table>
//    <tr>
//        <th>SERVICE</th>
//        <th>DISCOUNT</th>
//        <th>TOTAL</th>
//    </tr>
//    <tr>
//        <td>-</td>
//        <td>-</td>
//        <td>-</td>
//    </tr>
//</table>
}
