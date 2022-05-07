<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Items</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/update_items_page.css" />
</head>
<body>
	<div class="back-button">
		<form action="backToMainpage" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="inventory-main-container">
		<div class="form-header">
			<h1>Update Items</h1>
		</div>
		<div id="center" class="form-body">
			<form action="insert" method="post">
				<div>
					<input id="text-input" type="text" name="iName"
						placeholder="Item Name" />
				</div>
				<div>
					<input id="text-input" type="text" name="qty"
						placeholder="Quantity of item" />
				</div>

				<button id="btn_rm" type="reset">Reset</button>

				<div id="center" class="submit-button-area">
					<button id="btn-nav" type="submit">Update Items</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>