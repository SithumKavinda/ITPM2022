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
		case "/search":
			String searchKeyword = request.getParameter("searchText");
			System.out.println("Search Keyword: "+searchKeyword);
			
			List<Service> serviceList = new ArrayList<Service>();
			
			serviceList = serviceDAO.searchService(searchKeyword);
			
			if(!serviceList.isEmpty()) {
				for(Service s:serviceList) {
					System.out.println(s.getServiceName());
				}
			}
			
			request.setAttribute("SearchResult", serviceList);
			RequestDispatcher rd = request.getRequestDispatcher("billing_landing_page.css");
			rd.forward(request, response);
			break;
		case "/edit":

			break;
		case "/update":

			break;
		case "/delete":

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

}
