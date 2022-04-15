<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<form action="test">
		<input type="text" placeholder="Enter ID" name="id">
		<input type="submit" value="Test" name="testButton">
	</form>
	
	<table border="1px solid black">
	
	<tr>
		<th>Service Name</th>
		<th>Discount</th>
		<th>Price</th>
	</tr>
	
	<c:forEach items="${billList}" var="bills">
	
		<tr>
			<td>
				<c:out value="bills.getServiceName()"/>
			</td>
			<td>
				<c:out value="bills.getDiscount()"></c:out>
			</td>
			<td>
				<c:out value="bills.getPrice()"></c:out>
			</td>
		</tr>
	
	</c:forEach>
	
	</table>

</body>
</html>