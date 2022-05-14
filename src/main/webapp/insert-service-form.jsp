<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- JS -->
<script>
	function defaultThings() {
		var nameErr = document.getElementById("nameError");
		var discountErr = document.getElementById("discountError");
		var priceErr = document.getElementById("priceError");

		nameErr.style.display = "none";
		discountErr.style.display = "none";
		priceErr.style.display = "none";
	}

	function showNameErr() {
		var nameErr = document.getElementById("nameError");
		nameErr.style.display = "flex";
	}

	function showDiscountErr() {
		var discountErr = document.getElementById("discountError");
		discountErr.style.display = "flex";
	}

	function showPriceErr() {
		var priceErr = document.getElementById("priceError");
		priceErr.style.display = "flex";
	}

	// Validations

	function validateName() {
		var serviceName = document.getElementById("text-input")
		var nameErr = document.getElementById("nameError")

		if (serviceName.value == '' || serviceName.value == null) {
			let errorText = "Name cannot leave empty"
			nameErr.innerText = errorText
			showNameErr()
			serviceName.style.border = "1px solid red"
		} else {
			nameErr.style.display = "none"
			serviceName.style.border = "none"
		}
	}

	function validateDiscount() {
		var discountErr = document.getElementById("discountError")
		var discount = document.forms['insertForm']['discount']

		if (discount.value == null || discount.value == '') {
			let errorText = 'Discount cannot leave empty'
			discountErr.innerText = errorText
			showDiscountErr()
			discount.style.border = '1px solid red'
		} else if (discount.value > 50) {
			let errorText = 'Discount cannot exceed 50%'
			discountErr.innerText = errorText
			showDiscountErr()
			discount.style.border = '1px solid red'
		} else {
			discountErr.style.display = "none"
			discount.style.border = "none"
		}
	}

	function validatePrice() {
		var priceErr = document.getElementById("priceError")
		var price = document.forms['insertForm']['price']

		if (price.value == '' || price.value == null) {
			let errorText = 'Price cannot leave empty'
			priceErr.innerText = errorText
			showPriceErr()
			price.style.border = '1px solid red'
		} else if (price.value < 0) {
			let errorText = 'Price should be greater than 0'
			priceErr.innerText = errorText
			showPriceErr()
			price.style.border = '1px solid red'
		} else {
			priceErr.style.display = 'none'
			price.style.border = 'none'
		}
	}

	function validateForm() {

		var serviceName = document.forms['insertForm']['serviceName'].value
		var discount = document.forms['insertForm']['discount'].value
		var price = document.forms['insertForm']['price'].value

		if (serviceName != null && serviceName != '' && discount != null
				&& discount != '' && price != null && price != '') {
			return true
		}

		return false
	}
</script>
<!-- Style -->
<style>
.alert {
	display: flex;
	justify-content: center;
	align-items: center;
	height: auto;
	font-size: 10pt;
	padding: 0;
}

/*Remove the arrows of number input*/
/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

/* Firefox */
input[type="number"] {
	-moz-appearance: textfield;
}

.alert {
	margin-top: 5px;
}
</style>
</head>
<body onload="defaultThings()">
	<div class="back-button">
		<form action="backToServices" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="service-main-container">
		<div class="form-header">
			<h1>Insert Service</h1>
		</div>
		<div id="center" class="form-body">
			<form action="insert" method="post" name="insertForm"
				onsubmit="return validateForm()">
				<!-- Service Name -->
				<div>
					<input id="text-input" type="text" name="serviceName"
						placeholder="Service Name" oninput="validateName()" />
					<!-- Name error -->
					<div id="nameError" class="alert alert-danger p-1" role="alert">
						This is a danger alert—check it out!</div>
				</div>

				<!-- Discount -->
				<div>
					<input id="text-input" type="number" name="discount"
						placeholder="Discount" oninput="validateDiscount()" />
					<!-- Discount error -->
					<div id="discountError" class="alert alert-danger p-1" role="alert">
						This is a danger alert—check it out!</div>
				</div>

				<!-- Price -->
				<div>
					<input id="text-input" type="number" name="price"
						placeholder="Price" oninput="validatePrice()" />
					<!-- price error -->
					<div id="priceError" class="alert alert-danger p-1" role="alert">
						This is a danger alert—check it out!</div>
				</div>

				<button id="btn_rm" type="reset">Reset</button>

				<div id="center" class="submit-button-area">
					<button id="btn-nav" type="submit" name="submitBtn">
						Insert Service</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
