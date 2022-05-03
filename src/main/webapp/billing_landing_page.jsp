
<%@ page import="itpm.carcare.payment.models.Service"%>
<%@ page import="java.util.List"%>
<%@ page import="itpm.carcare.payment.models.ServiceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
ServiceDAO serviceDAO = new ServiceDAO();
List<Service> serviceList = serviceDAO.getAllServices();
%>

<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1" />
<title>Billing</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/billing_landing_page.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script src="js/payment/sample.js"></script>
</head>
<body>
	<div class="main-container">
		<!-- Header Section -->
		<div class="header">
			<div class="topic">BILLING</div>
			<div class="add-services-container">
				<form action="services" method="post">
					<button id="btn" type="submit">Services</button>
				</form>
			</div>
		</div>

		<!-- Body Section -->
		<div class="body-section">
			<!-- Bill Table -->
			<div class="table-section">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Service ID</th>
							<th scope="col">Service Name</th>
							<th scope="col">Discount</th>
							<th scope="col">Price</th>
							<th scope="col">Remove</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">1</td>
							<td>Tyre & wheels grooming</td>
							<td align="center">10.00</td>
							<td align="center">3000.00</td>
							<td align="center">
								<button name="" id="btn_rm" onclick="">Remove</button>
							</td>
						</tr>

						<tr>
							<th align="center" colspan="4">TOTAL</th>
							<th align="center">3000.00</th>
						</tr>
					</tbody>
				</table>
			</div>

			<!-- Service List -->
			<div class="services-section">
				<!-- Search Bar -->
				<div class="search-bar">
					<navbar id="search-bar" class="navbar navbar-light bg-opacity-100">
					<form class="form-inline" method="get" action="search">
						<input class="form-control-sm" type="search"
							placeholder="Search Service" name="searchText" />
						<button id="btn-nav" class="btn btn-group-sm" type="submit">
							Search</button>
					</form>
					</navbar>
				</div>
				<div class="service-list">
					<% if (!serviceList.isEmpty()) { for (Service s : serviceList) { %>
					<button name="<%=s.getServiceID()%>">
						<%=s.getServiceName() %>
					</button>
					<% } } %>
					
				</div>
			</div>
		</div>
		<div class="credit-section">Designed & Developed by Sithum
			Kavinda</div>
	</div>
	<div class="res-error">Invalid Display Resolution!</div>
</body>
</html>
