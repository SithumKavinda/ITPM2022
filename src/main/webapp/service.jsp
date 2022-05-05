<%@page import="itpm.carcare.payment.models.Service"%>
<%@page import="java.util.List"%>
<%@page import="itpm.carcare.payment.models.ServiceDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ServiceDAO serviceDAO = new ServiceDAO();
List<Service> serviceList = serviceDAO.getAllServices();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Services</title>
<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style/payment/main.css" />
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>
<body>
	<div class="service-main-container">

		<div class="add-service-button">
			<form action="new" method="post">
				<input type="submit" value="Add Service">
			</form>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="col-md-1" scope="col">Service ID</th>
					<th class="col-md-2" scope="col">Service Name</th>
					<th class="col-md-1" scope="col">Discount</th>
					<th class="col-md-1" scope="col">Price</th>
					<th class="col-md-1" scope="col">Edit</th>
					<th class="col-md-1" scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (!serviceList.isEmpty()) {
					for (Service s : serviceList) {
				%>
				<tr>
					<td class="col-md-1"><%=s.getServiceID()%></td>
					<td class="col-md-2"><%=s.getServiceName()%></td>
					<td class="col-md-1"><%=s.getDiscount()%></td>
					<td class="col-md-1"><%=s.getPrice()%></td>
					<td class="col-md-1">
						<button class="btn-warning">EDIT</button>
					</td>
					<td class="col-md-1">
						<button class="btn-danger">REMOVE</button>
					</td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
