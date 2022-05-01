package itpm.carcare.payment.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itpm.carcare.DBConnect;

public class ServiceDAO {
	private static Connection con;
	private static Statement stmt;
	private PreparedStatement pst;
	private ResultSet rs = null;

	public List<Service> getAllServices() {

		List<Service> serviceList = new ArrayList<Service>();
		String RETRIEVE_SERVICE = "SELECT * FROM `carcare`.`service`;";

		try {

			con = DBConnect.getConnection();
			
			pst = con.prepareStatement(RETRIEVE_SERVICE);
			
			rs = pst.executeQuery();
			
			// Resultset validation
			if(rs!=null) {
				System.out.println("Services Retrieved");
			}
			else {
				System.err.println("Services Retrieving Failed!");
			}
			
			// Input ResultSet into ArrayList
			while(rs.next()) {
				// Create new object of Service class & insert data into it
				Service service = new Service();
				
				service.setServiceID(rs.getInt("service_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setDiscount(rs.getDouble("discount"));
				service.setDiscount(rs.getDouble("price"));
				
				// Add service object to ArrayList
				serviceList.add(service);
			}
			
			con.close();

		} catch (Exception e) {

			System.err.println("Retrieving Services failed!");
			System.err.println(e.getMessage());

		}

		return serviceList;
	}
}
