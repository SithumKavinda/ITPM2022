package itpm.carcare.payment.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import itpm.carcare.DBConnect;

public class ServiceDAO {
	private static Connection con;
	private PreparedStatement pst;
	private ResultSet rs = null;

	// Retrieve
	public List<Service> getAllServices() {
		// log
		System.out.println("\ngetAllServices() => Getting all Services...");

		List<Service> serviceList = new ArrayList<Service>();
		String RETRIEVE_SERVICE = "SELECT * FROM `carcare`.`service`;";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(RETRIEVE_SERVICE);
			// log
			System.out.println("SQL Query: " + pst.toString());

			rs = pst.executeQuery();

			// log
			System.out.print("ResultSet Status: ");

			if (rs != null) {
				System.out.println("ResultSet initiated with data");
			} else {
				System.err.println("ResultSet not initiated");
			}

			// Input ResultSet into ArrayList
			while (rs.next()) {
				// Create new object of Service class & insert data into it
				Service service = new Service();

				service.setServiceID(rs.getInt("service_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setDiscount(rs.getDouble("discount"));
				service.setPrice(rs.getDouble("price"));

				// Add service object to ArrayList
				serviceList.add(service);
			}

			con.close();

		} catch (Exception e) {
			System.out.print("getAllServices() => ");
			System.err.println("Retrieving Services failed");
			System.err.println(e.getMessage());

		}

		return serviceList;
	}

	// Insert
	public void addService(Service service) {
		// log
		System.out.println("\naddService() => Adding Service...");

		String INSERTQUERY = "INSERT INTO `carcare`.`service` (`service_id`, `service_name`, `discount`, `price`) VALUES (0, ?, ?, ?);";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(INSERTQUERY);

			// Initiate parameters
			pst.setString(1, service.getServiceName());
			pst.setDouble(2, service.getDiscount());
			pst.setDouble(3, service.getPrice());

			// log
			System.out.println("SQL Query: " + pst.toString());

			// Execute query
			pst.execute();

			con.close();

		} catch (Exception e) {
			System.out.print("addService() => ");
			System.err.println("Inserting Service failed");
			System.err.println(e.getMessage());
		}
	}

	// Update
	public void editService(Service service) {
		// log
		System.out.println("\neditService() => Editing Service...");

		String UPDATEQUERY = "UPDATE `carcare`.`service` SET `service_name` = ?, `discount` = ?, `price` = ? WHERE (`service_id` = ?);";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(UPDATEQUERY);

			pst.setString(1, service.getServiceName());
			pst.setDouble(2, service.getDiscount());
			pst.setDouble(3, service.getPrice());
			pst.setInt(4, service.getServiceID());

			// log
			System.out.println("SQL Query: " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.out.print("editService() => ");
			System.err.println("Updating Service failed");
			System.err.println(e.getMessage());
		}
	}

	// Delete
	public void deleteService(int service_id) {
		// log
		System.out.println("\ndeleteService() => Deleting Service...");

		String DELETEQUERY = "DELETE FROM `carcare`.`service` WHERE (`service_id` = ?);";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(DELETEQUERY);

			pst.setInt(1, service_id);

			// log
			System.out.println("SQL Query: " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.out.print("deleteService() => ");
			System.err.println("Deleting Service failed");
			System.err.println(e.getMessage());
		}
	}

	// Add bill item
	public void addToBill(int id) {
		// log
		System.out.println("\naddToBill() => Adding to Bill...");

		// Queries
		String SELECTQUERY = "SELECT * FROM `carcare`.`service` where service_id=?;";
		String INSERTQUERY = "INSERT INTO `carcare`.`bill` (`service_id`, `service_name`, `discount`, `price`) VALUES (?,?,?,?);";

		Service service = new Service();

		try {
			con = DBConnect.getConnection();
			// log
			System.out.println("Getting service by ID...");
			pst = con.prepareStatement(SELECTQUERY);

			pst.setInt(1, id);

			// log
			System.out.println("SQL Query: " + pst.toString());

			rs = pst.executeQuery();

			// log
			System.out.println("ResultSet Status: " + rs.toString());

			rs.next();

			service.setServiceID(rs.getInt("service_id"));
			service.setServiceName(rs.getString("service_name"));
			service.setDiscount(rs.getDouble("discount"));
			service.setPrice(rs.getDouble("price"));

			// log
			System.out.println("\nResultset Results: " + service.getServiceID() + " " + service.getServiceName() + " "
					+ service.getDiscount() + " " + service.getPrice());

			// Insert into DB
			System.out.println("\nInserting Data into Database...");

			pst = con.prepareStatement(INSERTQUERY);

			pst.setInt(1, service.getServiceID());
			pst.setString(2, service.getServiceName());
			pst.setDouble(3, service.getDiscount());
			pst.setDouble(4, service.getPrice());

			// log
			System.out.println("SQL Query: " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.out.print("addToBill() => ");
			System.err.println("Adding to Bill is Failed");
			System.err.println(e.getMessage());
		}
	}

	// Search service
	public List<Service> searchService(String searchQuery) {
		// log
		System.out.println("\nsearchService() => Searching services...");

		List<Service> searchedServices = new ArrayList<Service>();
		String SEARCHQUERY = "SELECT * FROM `carcare`.`service` where service_name=?";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(SEARCHQUERY);
			pst.setString(1, searchQuery);

			// log
			System.out.println("SQL Query: " + pst.toString());

			rs = pst.executeQuery();

			while (rs.next()) {
				Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"),
						rs.getDouble("discount"), rs.getDouble("price"));
				// log
				System.out.println(service.getServiceName());

				searchedServices.add(service);
			}

		} catch (Exception e) {
			System.out.println("searchService() => ");
			System.err.println(e.getMessage());
		}

		return searchedServices;
	}

	// get service by ID
	public Service getService(int service_id) {
		// log
		System.out.println("\ngetService() => Getting Service");

		Service service = new Service();
		String GETSERVICE = "select * from bill where service_id = ?;";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(GETSERVICE);
			pst.setInt(1, service_id);
			// log
			System.out.println("SQL Query: " + pst.toString());

			rs = pst.executeQuery();

			rs.next();

			service.setServiceID(rs.getInt("service_id"));
			service.setServiceName(rs.getString("service_name"));
			service.setDiscount(rs.getDouble("discount"));
			service.setPrice(rs.getDouble("price"));

			// log
			System.out.println("service => " + service.getServiceID() + " " + service.getServiceName() + " "
					+ service.getDiscount() + " " + service.getPrice());

		} catch (Exception e) {
			System.out.print("getService() => ");
			System.err.println("get service failed");
			System.err.println(e.getMessage());
		}

		return service;
	}
}
