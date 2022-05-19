package itpm.carcare.payment.controllers;

import java.io.IOException;
import itpm.carcare.payment.models.Service;
import itpm.carcare.payment.models.ServiceDAO;
import itpm.carcare.payment.models.billDAO;
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
		// Delete service from the DB
		case "/deleteService":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: delete called");

			deleteService(request, response);
			break;
		// Load service to the edit-service.jsp
		case "/loadService":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: loadService called");
			loadService(request, response);
			break;
		case "/editService":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: editService called");
			updateService(request, response);
			break;
		case "/generateBill":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: generateBill called");
			// Error
			getError(request, response);
			break;
		case "/paymentMethod":
			// log
			System.out.println("\n=========================");
			System.out.println("Servlet: paymentMethod called");
			openPaymentMethodPage(request, response);
			break;
		case "/proceedPayment":
			System.out.println("\n=========================");
			System.out.println("Servlet: proceedPayment called");

			String method = request.getParameter("payment-method");

			if (!method.equals("card")) {
				// log
				System.out.println("Cash Method selected");
				proceedToCashPayment(request, response);

			} else if (method.equals("card")) {
				// log
				System.out.println("Card Method selected");
				proceedToCardPayment(request, response);
			}

			break;
		case "/error":
			loadError(request, response);
			break;
		default:
			break;
		}
	}

	private void loadError(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rs = request.getRequestDispatcher("error-page.jsp");
		rs.forward(request, response);
	}

	private void proceedToCashPayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double totalAmount = billDAO.getBillTotal();
		request.setAttribute("total_amount", totalAmount);
		RequestDispatcher rs = request.getRequestDispatcher("cash-payment-page.jsp");
		rs.forward(request, response);
	}

	private void proceedToCardPayment(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rs = request.getRequestDispatcher("card-payment-page.jsp");
		rs.forward(request, response);

	}

	private void openPaymentMethodPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		double totalAmount = billDAO.getBillTotal();
		request.setAttribute("total_amount", totalAmount);
		RequestDispatcher rs = request.getRequestDispatcher("payment-method.jsp");
		rs.forward(request, response);
	}

	private void getError(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("Error-page.jsp");

	}

	// update service data
	private void updateService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int service_id = Integer.parseInt(request.getParameter("serviceIDEdit"));
		String service_name = request.getParameter("serviceNameEdit");
		double discount = Double.parseDouble(request.getParameter("discountEdit"));
		double price = Double.parseDouble(request.getParameter("priceEdit"));

		// log
		System.out.println("Assign current data to a model object");

		Service service = new Service(service_id, service_name, discount, price);

		// log
		System.out.println("Service: service ID = " + service.getServiceID() + " name = " + service.getServiceName()
				+ " Discount: " + service.getDiscount() + " Price: " + service.getPrice());

		serviceDAO.editService(service);

		// log
		System.out.println("Proceeding to service.jsp");

		response.sendRedirect("service.jsp");

	}

	// load service into form
	private void loadService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int service_id = Integer.parseInt(request.getParameter("service-id-edit"));
		// log
		System.out.println("Service ID: " + service_id);

		Service service = serviceDAO.getService(service_id);

		request.setAttribute("loadService", service);

		// log
		System.out.println("Proceeding to edit-service.jsp");

		// Proceed to edit-service.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit-service-form.jsp");
		rd.forward(request, response);
	}

	// Delete service
	private void deleteService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int service_id = Integer.parseInt(request.getParameter("service-ID-service-jsp"));

		// log
		System.out.println("Service ID: " + service_id);
		serviceDAO.deleteService(service_id);

		// log
		System.out.println("Proceeding to service.jsp");
		proceedServices(request, response);
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
