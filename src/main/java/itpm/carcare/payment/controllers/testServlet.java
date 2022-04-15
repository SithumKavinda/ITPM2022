package itpm.carcare.payment.controllers;

import java.io.IOException;
import java.util.List;
import itpm.carcare.payment.models.bill;
import itpm.carcare.payment.models.billDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class testServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			List<bill> billList = billDAO.retrieveBillData(id);
			
			request.setAttribute("billList", billList);
			request.getRequestDispatcher("src/main/webapp/views/payment/test.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
