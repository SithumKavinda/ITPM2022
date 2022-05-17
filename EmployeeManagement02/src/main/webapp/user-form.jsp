

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> Employee Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${user == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee Gender</label> <input type="text"
						value="<c:out value='${user.gender}' />" class="form-control"
						name="gender" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee DOB</label> <input type="text"
						value="<c:out value='${user.dob}' />" class="form-control"
						name="dob" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email" required="required" pattern="[^ @]*@[^ @]*">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Contact</label> <input type="text"
						value="<c:out value='${user.contact}' />" class="form-control"
						name="contact" required="required"  pattern="[0-9]{1}[0-9]{9}">
				</fieldset>

				<button type="submit" class="btn btn-success" onclick="myFunction();">Save</button>
				
				</form>
			</div>
		</div>
	</div>
	
	<script>


function myFunction() {
	<c:if test="${user != null}">
	alert("Employee detail updated successfully");
</c:if>
<c:if test="${user == null}">
	alert(" Employee detail inserted successfully ");
</c:if>
}
</script>
</body>
</html>