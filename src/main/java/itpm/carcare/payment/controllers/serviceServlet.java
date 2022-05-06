package itpm.carcare.payment.controllers;

import java.io.IOException;
import itpm.carcare.payment.models.Service;
import itpm.carcare.payment.models.ServiceDAO;
import itpm.carcare.payment.models.billDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class serviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceDAO serviceDAO;
	private billDAO billDAO;

	public serviceServlet() {
		serviceDAO = new ServiceDAO();
		billDAO = new billDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		// Open service.jsp [Service List page]
		case "/services":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: services called");

			proceedServices(request, response);
			break;

		// Search service
		case "/searchService":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: searchService called");

			serviceDAO.searchService(request.getParameter("searchText"));
			break;

		// back to Landing page
		case "/home":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: home called");

			proceedHome(request, response);
			break;

		// back to Services page
		case "/backToServices":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: backToServices called");

			proceedServices(request, response);
			break;

		// Insert bill item to the DB
		case "/toBill":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: toBill called");

			addTobill(request, response);
			break;

		// Delete bill item from the DB
		case "/deleteBillItem":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: deleteBillItem called");

			deleteBillItem(request, response);
			break;

		// Open insert-service-form.jsp [Insert services form]
		case "/new":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: new called");

			showInsertPage(request, response);
			break;

		// Insert new service to the DB
		case "/insert":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: insert called");

			getServiceDetails(request, response);
			break;
		case "/edit":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: edit called");

			break;
		case "/update":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: update called");

			break;
		case "/delete":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: delete called");

			break;

		default:
			break;
		}
	}

	// Proceed user to Services page
	private void proceedServices(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// log
		System.out.println("Proceeding to service.jsp");

		response.sendRedirect("service.jsp");
	}

	// Proceed user to landing page
	private void proceedHome(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// log
		System.out.println("Proceeding to billing_landing_page.jsp");

		response.sendRedirect("billing_landing_page.jsp");
	}

	// Proceed user to the insert services form
	private void showInsertPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// log
		System.out.println("Proceeding to insert-service-form.jsp");
		response.sendRedirect("insert-service-form.jsp");
	}

	// Delete bill item from the DB
	private void deleteBillItem(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("bill-item-id"));
		// log-User selected bill item id
		System.out.println("Selected bill item ID: " + id);

		billDAO.deleteBillItem(id);
		// log
		System.out.println("Redirecting to Landing page");

		response.sendRedirect("billing_landing_page.jsp");
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
		System.out.print("Selected ID by user: ");
		System.out.println(request.getParameter("service-id") + "\n");

		serviceDAO.addToBill(Integer.parseInt(request.getParameter("service-id")));

		response.sendRedirect("billing_landing_page.jsp");
	}

}
