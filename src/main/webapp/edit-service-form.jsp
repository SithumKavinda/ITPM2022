<%@page import="itpm.carcare.payment.models.Service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Service service = (Service) request.getAttribute("loadService");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>New Service</title>

<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/insert-service-form.css" />
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
		<form action="backToServices" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="service-main-container">
		<div class="form-header">
			<h1>Edit Service</h1>
		</div>
		<div id="center" class="form-body">
			<form action="editService" method="post">
				<!-- Hidden Service ID -->
				<div style="display: none;">
					<input type="text" name="serviceIDEdit" style="display: none;"
						value="<%=service.getServiceID()%>" readonly="readonly" />
				</div>

				<div>
					<input id="text-input" type="text" name="serviceNameEdit"
						placeholder="Service Name" value="<%=service.getServiceName()%>" />
				</div>
				<div>
					<input id="text-input" type="text" name="discountEdit"
						placeholder="Discount" value="<%=service.getDiscount()%>" />
				</div>
				<div>
					<input id="text-input" type="text" name="priceEdit"
						placeholder="Price" value="<%=service.getPrice()%>" />
				</div>

				<div id="center" class="submit-button-area">
					<button id="btn-nav" type="submit">Update Service</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
