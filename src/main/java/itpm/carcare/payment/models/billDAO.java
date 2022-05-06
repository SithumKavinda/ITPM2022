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

	// Retrieve bill item list
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
				if (!billList.isEmpty()) {
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

	// Delete bill item
	public void deleteBillItem(int id) {
		// log
		System.out.println("/nBill item deleting...");

		String DELETEBILLITEMSQL = "DELETE FROM `carcare`.`bill` WHERE service_id=?;";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(DELETEBILLITEMSQL);
			pst.setInt(1, id);
			// log-SQL statement
			System.out.println(pst.toString());

			pst.execute();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	// Bill Total
	public double getBillTotal() {
		// log
		System.out.println("/nCalculating bill total");
		double total = 0;

		List<Service> serviceList = getBillList();

		if (!serviceList.isEmpty()) {
			for (Service service : serviceList) {
				total += service.getPrice();
				// log
				System.out.println("Total price: " + total);
			}
		}

		return total;
	}

	// Clear bill table data
	public void clearTable() {
		// log-Start
		System.out.println("\nClearing Bill Table");

		String CLEARTABLEQUERY = "TRUNCATE TABLE `carcare`.`bill`;";

		try {

			con = DBConnect.getConnection();
			pst = con.prepareStatement(CLEARTABLEQUERY);

			// log-Query
			System.out.println("Query " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
