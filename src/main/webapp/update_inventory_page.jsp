<%@page import="itpm.carcare.inventory.models.InventoryItem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
InventoryItem inventoryItem = (InventoryItem) request.getAttribute("InventoryItemToEdit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Inventory</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/update_inventory_page.css" />
<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>
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
			<h1>Update Inventory</h1>
		</div>
		<div id="center" class="form-body">
			<form action="updateRecord" method="post">
				<div>
					<input id="text-input" type="text" name="item-id-insert"
						placeholder="Inventory ID" style="display: none;"
						value="<%=inventoryItem.getInventoryID()%>">
				</div>
				<div>
					<input id="text-input" type="text" name="item-name-insert"
						placeholder="Item Name" value="<%=inventoryItem.getItemName()%>">
				</div>
				<div>
					<input id="text-input" type="text" name="purchased-price-insert"
						placeholder="Purchased price"
						value="<%=inventoryItem.getPurchasedPrice()%>" />
				</div>
				<div>
					<input id="text-input" type="text" name="quantity-insert"
						placeholder="Quantity" value="<%=inventoryItem.getQuantity()%>" />
				</div>

				<button id="btn_rm" type="reset">Reset</button>

				<div id="center" class="submit-button-area">
					<button id="btn-nav" type="submit">Update Inventory</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>