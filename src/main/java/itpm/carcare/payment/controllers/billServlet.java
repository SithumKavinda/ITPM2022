package itpm.carcare.payment.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itpm.carcare.payment.models.Service;

@WebServlet("/")
public class billServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public billServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/getBill":

			System.err.println("Bill loading Servlet Activated");
			break;
		case "/new":

			break;
		}

	}
}
