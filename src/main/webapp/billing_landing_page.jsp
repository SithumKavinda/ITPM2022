<%@page import="itpm.carcare.payment.models.billDAO"%>
<%@ page import="itpm.carcare.payment.models.Service"%>
<%@ page import="java.util.List"%>
<%@ page import="itpm.carcare.payment.models.ServiceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ServiceDAO serviceDAO = new ServiceDAO();
billDAO billDAO = new billDAO();
List<Service> billList = billDAO.getBillList();
List<Service> serviceList = serviceDAO.getAllServices();
%>

<!DOCTYPE html>
<html>
<head>
<title>Billing</title>

<!-- CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/billing_landing_page_updated.css" />

<!-- Fontawesome -->
<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1" />

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
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
				<div class="table-my">
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
							<%
							if (!billList.isEmpty()) {
								for (Service s : billList) {
									double total = 0;
									total += s.getPrice();
							%>

							<tr>
								<th align="center"><%=s.getServiceID()%></th>
								<td align="center"><%=s.getServiceName()%></td>
								<td align="center"><%=s.getDiscount()%></td>
								<td align="center"><%=s.getPrice()%></td>
								<td align="center">
									<form action="deleteBillItem" method="post">
										<input type="text" value="<%=s.getServiceID()%>"
											name="bill-item-id" style="display: none" />
										<button id="btn_rm" type="submit">Remove</button>
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
				<div class="bottom-container">
					<div class="Bill-Totals">
						<div class="text">TOTAL</div>
						<div class="total"><%=billDAO.getBillTotal()%></div>
					</div>
					<div class="Generate-bill-area">
						<form action="paymentMethod">
							<input id="btn-nav" type="submit" value="PAY" />
						</form>
					</div>
				</div>
			</div>

			<!-- Service List -->
			<div class="services-section">
				<!-- Search Bar -->

				<div class="service-list">
					<%
					if (!serviceList.isEmpty()) {
						for (Service s : serviceList) {
					%>
					<div>
						<form action="toBill" method="post">
							<button type="submit"><%=s.getServiceName()%></button>
							<input type="text" name="service-id"
								value="<%=s.getServiceID()%>" readonly="readonly"
								style="display: none" />
						</form>
					</div>

					<%
					}
					}
					%>
				</div>
			</div>
		</div>
		<div class="credit-section">Designed & Developed by Sithum
			Kavinda</div>
	</div>
	<div class="res-error">Invalid Display Resolution!</div>
</body>
</html>
</Service>
</Service>
