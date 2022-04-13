package itpm.carcare.payment.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itpm.carcare.DBConnect;

public class billDataDAO {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// retrieve method
	public static List<billData> retrieveBillData(int billNo) {
		
		ArrayList<billData> billList = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select serviceName, discount, price from test_bill where billNo = '"+billNo+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String serviceName = rs.getString(2);
				double discount = rs.getDouble(3);
				double price = rs.getDouble(4);
				
				billData billItem = new billData(serviceName, discount, price);
				billList.add(billItem);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return billList;
		
	}
	
	
	// delete method
}
