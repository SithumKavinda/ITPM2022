<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Service</title>

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
		<form action="insert" method="post">
			<div class="form-group">
				<input type="text" class="form-control" name="serviceName"
					aria-describedby="emailHelp" placeholder="Service Name">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="discount"
					aria-describedby="emailHelp" placeholder="Discount">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="price"
					aria-describedby="emailHelp" placeholder="Price">
			</div>

			<button type="submit" class="btn btn-primary">Insert Service</button>
		</form>
	</div>
</body>
</html>