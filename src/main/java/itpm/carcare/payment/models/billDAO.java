package itpm.carcare.payment.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import itpm.carcare.DBConnect;

public class billDAO {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	public List<Service> getBillList() {
		// log
		System.out.println("/nBill loading in the table has started");

		List<Service> billList = new ArrayList<Service>();
		String READBILLSQL = "SELECT * FROM carcare.bill;";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(READBILLSQL);
			// log
			System.out.println(pst.toString());

			rs = pst.executeQuery();

			// log
			System.out.print("ResultSet Status: ");
			if (rs != null) {
				System.out.println("ResultSet initiated with data");
			} else {
				System.err.println("No Data in ResultSet");
			}

			// Enter data to the ArrayList
			while (rs.next()) {
				Service service = new Service();
				
				service.setServiceID(rs.getInt("service_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setDiscount(rs.getDouble("discount"));
				service.setPrice(rs.getDouble("price"));
				
				billList.add(service);
				// bill
				System.out.print("Bill list status: ");
				if(!billList.isEmpty()) {
					System.out.println("Sucess");
				} else {
					System.err.println("Fail");
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return billList;
	}
}
