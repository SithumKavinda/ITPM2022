package itpm.carcare.payment.controllers;

import java.io.IOException;

import itpm.carcare.payment.models.BillDAO;
import itpm.carcare.payment.models.Service;
import itpm.carcare.payment.models.ServiceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class serviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceDAO serviceDAO;
	private BillDAO billDAO;

	public serviceServlet() {
		serviceDAO = new ServiceDAO();
		billDAO = new BillDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "home":
			RequestDispatcher dispatcher = request.getRequestDispatcher("service.jsp");
			dispatcher.forward(request, response);
			break;
		case "/services":
			navigateToServices(request, response);
			System.err.println("Servlet Activated");
			break;
		case "/new":
			showInsertPage(request, response);
			break;
		case "/insert":
			try {
				getServiceDetails(request, response);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
		case "/edit":

			break;
		case "/update":

			break;
		case "/delete":

			break;
		case "/toBill":
			System.out.println("\n===========================");
			System.out.println("Servlet: toBill called");
			addTobill(request, response);
			break;
		case "/deleteBillItem":
			System.out.println("\n===========================");
			System.out.println("Servlet: deleteBillItem called");
			deleteBillItem(request, response);
			break;
		default:
			break;
		}
	}

	// Delete bill table row
	private void deleteBillItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int billItemID = Integer.parseInt(request.getParameter("bill-delete-btn"));
		// log-user selected bill item ID
		System.out.println("Bill item ID: " + billItemID);

		// Redirect to the homepage
		response.sendRedirect("billing_landing_page.jsp");

		billDAO.deleteBillItem(billItemID);
	}

	// Navigate user to the services page
	private void navigateToServices(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("service.jsp");
	}

	// Navigate user to the insert services form
	private void showInsertPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("insert-service-form.jsp");
	}

	// Insert service from insert service form to Database
	private void getServiceDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = new Service();

		service.setServiceID(0);
		service.setServiceName(request.getParameter("serviceName"));
		service.setDiscount(Double.parseDouble(request.getParameter("discount")));
		service.setPrice(Double.parseDouble(request.getParameter("price")));

		response.sendRedirect("service.jsp");

		serviceDAO.addService(service);
	}

	// Insert service to the bill
	private void addTobill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Test
		System.err.print("Selected ID by user: ");
		System.out.println(request.getParameter("service-id") + "\n");

		// serviceDAO.getServiceByID(Integer.parseInt(request.getParameter("service-id")));

		serviceDAO.addToBill(Integer.parseInt(request.getParameter("service-id")));

		// Redirect to Landing Page
		response.sendRedirect("billing_landing_page.jsp");
	}

}
