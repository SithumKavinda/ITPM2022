<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Inventory</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/add_inventory_page.css" />

</head>
<body>
	<div class="back-button">
		<form action="backToInventoryMain" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="inventory-main-container">
		<div class="form-header">
			<h1>Insert Inventory</h1>
		</div>
		<div id="center" class="form-body">
			<form action="insertInventory" method="post">
				<div>
					<input id="text-input" type="text" name="item-name-insert"
						placeholder="Item Name">
				</div>
				<div>
					<input id="text-input" type="text" name="purchased-price-insert"
						placeholder="Purchased price" />
				</div>
				<div>
					<input id="text-input" type="text" name="quantity-insert"
						placeholder="Quantity" />
				</div>

				<button id="btn_rm" type="reset">Reset</button>

				<div id="center" class="submit-button-area">
					<button id="btn-nav" type="submit">Insert Inventory</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>