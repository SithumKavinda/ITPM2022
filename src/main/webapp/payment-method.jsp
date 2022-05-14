<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
double totalAmount = (double) request.getAttribute("total_amount");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Payment</title>

<!-- Regular CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/payment-options-style.css" />

<!-- Bootstrap v5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />

<!-- Font awesome -->
<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="payment-main-container">
		<div class="back-button-area">
			<form action="home" method="post">
				<button type="submit">
					<i class="fa-solid fa-circle-chevron-left"></i>
				</button>
			</form>
		</div>
		<div class="Payment-options-header">
			<h1>Payement Options</h1>
		</div>
		<div class="form-area">
			<form action="proceedPayment" method="post">
				<div class="total-amount-area">
					<div class="lable">Total Amount:</div>
					<div class="input">
						<input type="text" name="total_amount" id="total_amount" readonly
							value="<%=totalAmount%>" />
					</div>
				</div>
				<div class="payment-method-area">
					<p>Select Payment method:</p>
					<div class="cash-method">
						<input type="radio" name="payment-method" id="cash-option" vlaue="cash" checked />
						<label for="cash-option"> Cash Payment </label>
					</div>
					<div class="card-method">
						<input type="radio" name="payment-method" id="card-option" value="card" /> <label
							for="card-option"> Card Payment</label>
					</div>
				</div>
				<div class="proceed-button-area">
					<input id="btn-nav" type="submit" value="Proceed to Payment Page" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
