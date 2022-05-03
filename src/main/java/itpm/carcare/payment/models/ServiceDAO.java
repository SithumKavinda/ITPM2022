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
	private PreparedStatement pst;
	private ResultSet rs = null;

	// Retrieve
	public List<Service> getAllServices() {

		List<Service> serviceList = new ArrayList<Service>();
		String RETRIEVE_SERVICE = "SELECT * FROM `carcare`.`service`;";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(RETRIEVE_SERVICE);

			rs = pst.executeQuery();

			// Resultset validation
			if (rs != null) {
				System.out.println("Services Retrieved");
			} else {
				System.err.println("Services Retrieving Failed!");
			}

			// Input ResultSet into ArrayList
			while (rs.next()) {
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

	// Insert
	public void addService(Service service) {
		String INSERTQUERY = "INSERT INTO `carcare`.`service` (`service_id`, `service_name`, `discount`, `price`) VALUES (0, ?, ?, ?);";
		boolean result = false;

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(INSERTQUERY);

			// Initiate parameters
			pst.setString(1, service.getServiceName());
			pst.setDouble(2, service.getDiscount());
			pst.setDouble(3, service.getPrice());

			// Execute query
			result = pst.execute();

			if (result) {
				System.out.println("Insert Successfull");
			} else {
				System.err.println("Inserting Failed");
			}

			con.close();

		} catch (Exception e) {
			System.err.println("Inserting Service failed!");
			System.err.println(e.getMessage());
		}
	}

	// Update
	public void editService(Service service) {
		String UPDATEQUERY = "UPDATE `carcare`.`service` SET `service_name` = ?, `discount` = ?, `price` = ? WHERE (`service_id` = ?);";
		boolean result = false;

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(UPDATEQUERY);

			pst.setString(1, service.getServiceName());
			pst.setDouble(2, service.getDiscount());
			pst.setDouble(3, service.getPrice());
			pst.setInt(4, service.getServiceID());

			result = pst.execute();

			if (result) {
				System.out.println("Update Successful");
			} else {
				System.err.println("Update failed");
			}

			con.close();
		} catch (Exception e) {
			System.err.println("Updating Service failed!");
			System.err.println(e.getMessage());
		}
	}

	// Delete
	public void deleteService(Service service) {
		String DELETEQUERY = "DELETE FROM `carcare`.`service` WHERE (`service_id` = ?);";
		boolean result = false;

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(DELETEQUERY);

			pst.setInt(1, service.getServiceID());

			result = pst.execute();

			if (result) {
				System.out.println("Delete Successful");
			} else {
				System.err.println("Delete Failed");
			}

			con.close();
		} catch (Exception e) {
			System.err.println("Deleting Service failed!");
			System.err.println(e.getMessage());
		}
	}

	// Search
	public List<Service> searchService(String serviceName) {
		List<Service> serviceList = new ArrayList<Service>();
		String SEARCHQUERY = "SELECT * FROM `carcare`.`service` where service_name LIKE ?;";

		try {
			con = DBConnect.getConnection();
			pst = con.prepareStatement(SEARCHQUERY);

			pst.setString(1, serviceName);
			
			System.err.println(pst.toString());
			
			rs = pst.executeQuery();

			while (rs.next()) {
				Service service = new Service();

				service.setServiceID(rs.getInt("service_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setDiscount(rs.getDouble("discount"));
				service.setDiscount(rs.getDouble("price"));

				serviceList.add(service);
			}

			con.close();
		} catch (Exception e) {
			System.err.println("There is no Service named " + serviceName);
		}

		return serviceList;
	}
}
