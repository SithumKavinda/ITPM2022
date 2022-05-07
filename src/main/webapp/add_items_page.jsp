<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/add_item_page.css" />
</head>
<body>
	<div class="back-button">
		<form action="backToMainpage" method="post">
			<button type="submit">
				<i class="fa-solid fa-circle-chevron-left"></i>
			</button>
		</form>
	</div>

	<div class="item-main-container">
		<div class="form-header">
			<h1>Insert Item</h1>
		</div>
		<div id="center" class="form-body">
			<form action="insert" method="post">
				<div>
					<input id="text-input" type="text" name="iName"
						placeholder="Item Name" />
				</div>
				<div>
					<select name="iType" id="text-input">
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="mercedes">Mercedes</option>
						<option value="audi">Audi</option>
					</select>
				</div>

				<button id="btn_rm" type="reset">Reset</button>

				<div id="center" class="submit-button-area">
					<button id="btn-nav" type="submit">Insert Item</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>