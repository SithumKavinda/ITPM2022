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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/services.css" />

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
	<div class="back-button">
		<form action="home" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="service-main-container">
		<div class="header">
			<h1>Services</h1>
		</div>
		<div class="add-service-button">
			<form action="new" method="post">
				<input id="btn-nav" type="submit" value="Add Service" />
			</form>
		</div>

		<div class="table-area">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="col-md-1 text-center" scope="col">Service ID</th>
						<th class="col-md-2 text-center" scope="col">Service Name</th>
						<th class="col-md-1 text-center" scope="col">Discount</th>
						<th class="col-md-1 text-center" scope="col">Price</th>
						<th class="col-md-1 text-center" scope="col">Edit</th>
						<th class="col-md-1 text-center" scope="col">Remove</th>
					</tr>
				</thead>
				<tbody class="overflow-auto">
					<%
					if (!serviceList.isEmpty()) {
						for (Service s : serviceList) {
					%>
					<tr class="">
						<td class="col-md-1 text-center"><%=s.getServiceID()%></td>
						<td class="col-md-2 text-start"><%=s.getServiceName()%></td>
						<td class="col-md-1 text-center"><%=s.getDiscount()%></td>
						<td class="col-md-1 text-center"><%=s.getPrice()%></td>

						<!-- Edit Button -->
						<td class="col-md-1 text-center">
							<form action="loadService" method="post">
								<input name="service-id-edit" type="text"
									value="<%=s.getServiceID()%>" style="display: none;">
								<button type="submit" id="btn_service">EDIT</button>
							</form>
						</td>

						<!-- Delete Button -->
						<td class="col-md-1 text-center">
							<form action="deleteService" method="post">
								<input name="service-ID-service-jsp" type="text"
									value="<%=s.getServiceID()%>" style="display: none;">
								<button type="submit" id="btn_rm_service">REMOVE</button>
							</form>
						</td>
					</tr>
					<%
					}
					}
					%>


				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
</Service>
