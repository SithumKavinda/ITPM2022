<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/items_page.css" />
</head>
<body>
	<div class="back-button">
		<form action="#" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="item-main-container">
		<div class="header">
			<h1>Item Details</h1>
		</div>
		<div class="add-item-button">
			<form action="#" method="post">
				<input id="btn-nav" type="submit" value="Add Item" />
			</form>
		</div>

		<div class="table-area">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="col-md-1 text-center" scope="col">Item Code</th>
						<th class="col-md-2 text-center" scope="col">Item Name</th>
						<th class="col-md-1 text-center" scope="col">Item Type</th>
						<th class="col-md-1 text-center" scope="col">Edit</th>
						<th class="col-md-1 text-center" scope="col">Remove</th>
					</tr>
				</thead>
				<tbody class="overflow-auto">

					<tr class="">
						<td class="col-md-1 text-center"></td>
						<td class="col-md-2 text-start"></td>
						<td class="col-md-1 text-center"></td>
						<td class="col-md-1 text-center">
							<button id="btn_item">EDIT</button>
						</td>
						<td class="col-md-1 text-center">
							<button id="btn_rm_item">REMOVE</button>
						</td>
					</tr>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>