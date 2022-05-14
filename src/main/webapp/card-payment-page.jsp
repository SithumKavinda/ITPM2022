<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Card Payment</title>

<!-- Regular CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/card-payment-page-updated.css" />
<!-- https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/card-payment-page.css -->

<!-- Bootstrap v5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />

<!-- Font awesome -->
<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>

<script type="text/javascript">
	function defaultThings() {
		var error = document.getElementById("error");
		// initial styles
		error.style.width = "auto";
		error.style.height = "auto";
		error.style.fontSize = "10pt";
		error.style.display = "none";
		error.innerText = "";
	}

	function loadError() {
		var error = document.getElementById("error");
		//onload
		error.style.display = "flex";
		error.style.justifyContent = "center";
		error.style.alignItems = "center";
		error.style.padding = "2px 0 2px";
	}

	function validateUsername() {
		var username = document.getElementById("user-name");
		var error = document.getElementById("error");

		// test for blank
		if (username.value == null || username.value == "") {
			username.style.border = "2px solid red";
			error.innerText = "Username cannot be empty";
			loadError();
			username.focus();
			return false;
		} else {
			error.style.display = "none";
			username.style.border = "none";
		}
		return true;
	}

	function validateCardnumber() {
		var cardNumber = document.getElementById("card-number");
		var error = document.getElementById("error");
		if (cardNumber.value == null || cardNumber.value == "") {
			cardNumber.style.border = "2px solid red";
			error.innerText = "Card number cannot be empty";
			loadError();
			cardNumber.focus();
			return false;
		} else {
			error.style.display = "none";
			cardNumber.style.border = "none";
		}
		return true;
	}

	function cardnumberLength() {
		var cardNumber = document.getElementById("card-number");
		var error = document.getElementById("error");

		if (cardNumber.value.length < 16) {
			cardNumber.style.border = "2px solid red";
			error.innerText("Card number should contain 16 digits");
			loadError();
			cardNumber.focus();
			return false;
		} else {
			error.style.display = "none";
			cardNumber.style.border = "none";
		}
		return true;
	}

	function validateMonth() {
		var month = document.getElementById("month");
		var error = document.getElementById("error");

		if (month.value == null || month.value == "") {
			month.style.border = "2px solid red";
			error.innerText = "Month cannot be empty";
			loadError();
			month.focus();
			return false;
		} else {
			error.style.display = "none";
			month.style.border = "none";
		}
		return true;
	}

	function validateYear() {
		var year = document.getElementById("year");
		var error = document.getElementById("error");

		if (year.value == null || year.value == "") {
			year.style.border = "2px solid red";
			error.innerText = "Year cannot be empty";
			loadError();
			year.focus();
			return false;
		} else {
			error.style.display = "none";
			year.style.border = "none";
		}
		return true;
	}

	function validateCvv() {
		var cvv = document.getElementById("cvv");
		var error = document.getElementById("error");

		if (cvv.value == null || cvv.value == "") {
			cvv.style.border = "2px solid red";
			error.innerText = "cvv cannot be empty";
			loadError();
			cvv.focus();
			return false;
		} else {
			error.style.display = "none";
			cvv.style.border = "none";
		}
		return true;

		function validateSubmit() {
			var username = document.getElementById("user-name");

			var error = document.getElementById("error");

			if (username.value == null || username.value == "") {
				error.innerText = "Cannot Submit form";
				loadError();
				return false;
			} else {
				error.style.display = "none";
			}

			return true;
		}
	}
</script>
</head>
<body onload="defaultThings()">
	<div class="card-payment-main-container">
		<div class="back-button-area">
			<form action="paymentMethod" method="post">
				<button type="submit">
					<i class="fa-solid fa-circle-chevron-left"></i>
				</button>
			</form>
		</div>
		<div class="card-Payment-header">
			<h1>Card Payment</h1>
		</div>

		<div class="card-payment-body">
			<form action="error" method="post" onsubmit="return validateSubmit()">
				<div class="user-name">
					<input type="text" name="user-name" id="user-name"
						placeholder="Name of the Card Holder" oninput="validateUsername()" />
				</div>
				<div class="card-number">
					<input type="number" name="card-number" id="card-number"
						placeholder="Card Number" oninput="validateCardnumber()"
						onchange="cardnumberLength()" />
				</div>
				<div class="expiration">
					<div class="lable">
						<p>Expiration details:</p>
					</div>
					<div class="month" id="align-center">
						<input id="month" type="number" placeholder="mm"
							oninput="validateMonth()" />
					</div>
					<div class="year" id="align-center">
						<input id="year" type="number" placeholder="yyyy"
							oninput="validateYear()" />
					</div>
				</div>
				<div class="cvv">
					<input id="cvv" type="number" placeholder="cvv"
						oninput="validateCvv()" />
					<p>* CSV code is on the back and is usually printed at the very
						far right of your signature line</p>
				</div>
				<div class="submit-button">
					<input id="btn" type="submit" value="Pay" />
				</div>
				<div class="alert alert-danger" role="alert" id="error">This
					is a danger alert—check it out!</div>
			</form>
		</div>
	</div>
</body>
</html>
