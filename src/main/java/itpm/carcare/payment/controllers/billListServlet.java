package itpm.carcare.payment.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import itpm.carcare.payment.models.billData;
import itpm.carcare.payment.models.billDataDAO;

public class billListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		List<billData> bill = billDataDAO.retrieveBillData(1);
		request.setAttribute("billDetails", bill);
		
		RequestDispatcher dis = request.getRequestDispatcher("billing_landing_page.jsp");
		dis.forward(request, response);
		
	}
}
