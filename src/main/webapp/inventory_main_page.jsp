<%@page import="java.util.ArrayList"%>
<%@page import="itpm.carcare.inventory.models.InventoryItem"%>
<%@page import="java.util.List"%>
<%@page import="itpm.carcare.inventory.models.InventoryItemDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
InventoryItemDAO inventoryItemDAO = new InventoryItemDAO();
List<InventoryItem> inventoryList = (ArrayList) request.getAttribute("searchResult");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory</title>

<script src="https://kit.fontawesome.com/66bf06966e.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/inventory_main_page.css" />
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
	<div class="main-div">
		<!-- Header Section -->
		<div class="header_section">
			<h1>INVENTORY</h1>
		</div>

		<div class="body_section">
			<!-- Table Section -->
			<div class="table_section">
				<div class="search_section">
					<form action="searchInventory" method="post">
						<div class="search_box">
							<input type="text" id="searchService" placeholder="Search..."
								name="search-text">
						</div>
						<div class="search_button">
							<input type="submit" value="Search" id="searchButton">
						</div>
					</form>
				</div>
				<div class="table_area">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="col-md-1 text-center" scope="col">Inventory ID</th>
								<th class="col-md-2 text-center" scope="col">Item Name</th>
								<th class="col-md-2 text-center" scope="col">Purchased
									Price</th>
								<th class="col-md-1 text-center" scope="col">Quantity</th>
								<th class="col-md-1 text-center" scope="col">Edit</th>
								<th class="col-md-1 text-center" scope="col">Remove</th>
							</tr>
						</thead>
						<tbody class="overflow-auto">
							<%
							if (!inventoryList.isEmpty()) {
								for (InventoryItem i : inventoryList) {
							%>
							<tr class="">
								<td class="col-md-1 text-center"><%=i.getInventoryID()%></td>
								<td class="col-md-2 text-start"><%=i.getItemName()%></td>
								<td class="col-md-1 text-start"><%=i.getPurchasedPrice()%></td>
								<td class="col-md-1 text-center"><%=i.getQuantity()%></td>
								<td class="col-md-1 text-center">
									<form action="proceedToEdit" method="post">
										<input type="text" name="inventory-id-main"
											style="display: none;" readonly="readonly"
											value="<%=i.getInventoryID()%>">
										<button type="submit" id="btn_item">EDIT</button>
									</form>
								</td>
								<td class="col-md-1 text-center">
									<form action="deleteInventory" method="post">
										<input type="text" name="inventoryID-inventory"
											style="display: none;" readonly="readonly"
											value="<%=i.getInventoryID()%>">
										<button type="submit" id="btn_rm_item">REMOVE</button>
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
			</div>
			<div class="button_group_section">
				<div>
					<form action="addInventoryPage" method="post">
						<button type="submit">Add Inventory</button>
					</form>
				</div>

			</div>
		</div>
	</div>

</body>
</html>