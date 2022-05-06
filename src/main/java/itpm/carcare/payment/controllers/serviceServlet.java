package itpm.carcare.payment.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public serviceServlet() {
		serviceDAO = new ServiceDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
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
			System.out.print("\nGot the ADD to Bill Request\n");
			addTobill(request, response);
			break;
		default:
			break;
		}
	}

	// Navigate user to the services page
	private void navigateToServices(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("service.jsp");
		dispatcher.forward(request, response);
	}

	// Navigate user to the insert services form
	private void showInsertPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert-service-form.jsp");
		dispatcher.forward(request, response);
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("billing_landing_page.jsp");
		dispatcher.forward(request, response);
	}

}
