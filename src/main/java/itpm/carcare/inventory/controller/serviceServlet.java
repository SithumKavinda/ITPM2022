package itpm.carcare.inventory.controller;

import java.io.IOException;

import itpm.carcare.inventory.models.InventoryItem;
import itpm.carcare.inventory.models.InventoryItemDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class serviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InventoryItemDAO inventoryItemDAO;

	public serviceServlet() {
		inventoryItemDAO = new InventoryItemDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/deleteInventory":
			System.out.println("Servlet: deleteInventory called");
			deleteInventory(request, response);
			break;
		case "/proceedToAddInventory":
			System.out.println("Servlet: proceedToAddInventory called");
			proceedToAddInventory(request, response);
			break;
		case "/proceedToItemDetails":
			System.out.println("Servlet: proceedToItemDetails called");
			proceedToItemDetails(request, response);
			break;
		case "/backToInventoryMain":
			System.out.println("Servlet: backToInventoryMain called");
			proceedToAddInventory(request, response);
			break;
		case "/insertInventory":
			insertInventory(request, response);
			break;
		case "/proceedToEdit":
			proceedToEdit(request, response);
			break;
		case "/updateRecord":
			updateInventory(request, response);
			break;
		default:
			break;
		}
	}

	private void updateInventory(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int inventoryID = Integer.parseInt(request.getParameter("item-id-insert"));
		String item_name = request.getParameter("item-name-insert");
		double purchase_price = Double.parseDouble(request.getParameter("purchased-price-insert"));
		int quantity = Integer.parseInt(request.getParameter("quantity-insert"));

		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setInventoryID(inventoryID);
		inventoryItem.setItemName(item_name);
		inventoryItem.setPurchasedPrice(purchase_price);
		inventoryItem.setQuantity(quantity);

		inventoryItemDAO.editInventoryItem(inventoryItem);

		// proceed to Inventory main page
		response.sendRedirect("inventory_main_page.jsp");
	}

	private void proceedToEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		InventoryItem inventoryItem = inventoryItemDAO
				.getInventoryByID(Integer.parseInt(request.getParameter("inventory-id-main")));

		request.setAttribute("InventoryItemToEdit", inventoryItem);

		RequestDispatcher rd = request.getRequestDispatcher("update_inventory_page.jsp");
		rd.forward(request, response);
	}

	private void insertInventory(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int inventoryID = 0;
		String item_name = request.getParameter("item-name-insert");
		double purchase_price = Double.parseDouble(request.getParameter("purchased-price-insert"));
		int quantity = Integer.parseInt(request.getParameter("quantity-insert"));

		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setInventoryID(inventoryID);
		inventoryItem.setItemName(item_name);
		inventoryItem.setPurchasedPrice(purchase_price);
		inventoryItem.setQuantity(quantity);

		inventoryItemDAO.insertInventoryItem(inventoryItem);

		response.sendRedirect("inventory_main_page.jsp");
	}

	private void proceedToItemDetails(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("items_page.jsp");

	}

	private void proceedToAddInventory(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("add_inventory_page.jsp");
	}

	private void deleteInventory(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int inventoryItemID = Integer.parseInt(request.getParameter("inventoryID-inventory"));
		// log
		System.out.println("Inventory ID: " + inventoryItemID);
		inventoryItemDAO.deleteInventoryItem(inventoryItemID);

		// Proceed to inventory_main_page.jsp
		response.sendRedirect("inventory_main_page.jsp");
	}
}
