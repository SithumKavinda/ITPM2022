package itpm.carcare.inventory.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import itpm.carcare.DBConnect;

public class InventoryItemDAO {

	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	// Retrieve function
	public List<InventoryItem> getInventoryList() {
		List<InventoryItem> inventoryList = new ArrayList<InventoryItem>();
		String GETINVENTORY_QUERY = "SELECT inventory_id, inventory_name, purchasedPrice, quantity FROM inventory;";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(GETINVENTORY_QUERY);

			// log
			System.out.println("SQL Statement: " + pst.toString());

			rs = pst.executeQuery();

			while (rs.next()) {
				InventoryItem inventoryItem = new InventoryItem();

				inventoryItem.setInventoryID(rs.getInt("inventory_id"));
				inventoryItem.setItemName(rs.getString("inventory_name"));
				inventoryItem.setPurchasedPrice(rs.getDouble("purchasedPrice"));
				inventoryItem.setQuantity(rs.getInt("quantity"));

				inventoryList.add(inventoryItem);
			}

			con.close();

		} catch (Exception e) {
			System.out.print("getInventoryList() => ");
			System.err.println(e.getMessage());
		}

		return inventoryList;
	}

	// Insert function
	public void insertInventoryItem(InventoryItem inventoryItem) {
		String INSERT_QUERY = "INSERT INTO inventory VALUES (?, ?, ?, ?);";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, inventoryItem.getInventoryID());
			pst.setString(2, inventoryItem.getItemName());
			pst.setDouble(3, inventoryItem.getPurchasedPrice());
			pst.setInt(4, inventoryItem.getQuantity());

			System.out.println("SQL Statement: " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.out.print("insertInventoryItem() => ");
			System.err.println(e.getMessage());
		}

	}

	// Delete function
	public void deleteInventoryItem(int inventoryItemID) {
		String DELETE_QUERY = "DELETE FROM `carcare`.`inventory` WHERE inventory_id = ?;";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(DELETE_QUERY);
			pst.setInt(1, inventoryItemID);
			// log
			System.out.println("SQL Statement: " + pst.toString());
			pst.execute();

			con.close();
		} catch (Exception e) {
			System.out.print("deleteInventoryItem() => ");
			System.err.println(e.getMessage());
		}
	}

	// Update function
	public void editInventoryItem(InventoryItem inventoryItem) {
		String EDIT_QUERY = "UPDATE `carcare`.`inventory` SET `inventory_name` = ?, `purchasedPrice` = ?, `quantity` = ? WHERE `inventory_id` = ?;";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(EDIT_QUERY);
			pst.setString(1, inventoryItem.getItemName());
			pst.setDouble(2, inventoryItem.getPurchasedPrice());
			pst.setInt(3, inventoryItem.getQuantity());
			pst.setInt(4, inventoryItem.getInventoryID());
			// Log
			System.out.println("SQL Statement: " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.out.print("editInventoryItem() => ");
			System.err.println(e.getMessage());
		}
	}

	// Get inventory item by inventory ID
	public InventoryItem getInventoryByID(int id) {
		InventoryItem inventoryItem = new InventoryItem();
		String GETBYID = "SELECT * FROM inventory where inventory_id=?;";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(GETBYID);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			rs.next();
			inventoryItem.setInventoryID(id);
			inventoryItem.setItemName(rs.getString("inventory_name"));
			inventoryItem.setPurchasedPrice(rs.getDouble("purchasedPrice"));
			inventoryItem.setQuantity(rs.getInt("quantity"));

			con.close();

		} catch (Exception e) {
			System.out.print("getInventoryByID() => ");
			System.err.println(e.getMessage());
		}

		return inventoryItem;
	}
}
