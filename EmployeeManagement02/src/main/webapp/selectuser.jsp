<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*" %>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> Employee
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
			</ul>
			
			  <form id="form" method="post" action="selectuser.jsp">
				<input type="text" name="empid" class="form-control" id="empid" placeholder="Search..">
  			  	<button><i class="fa fa-search"></i></button>
			</form>
			
		</nav>
	</header>
	<br>

<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			
			<br>
			           <%
                Connection con;
                PreparedStatement pst;
                ResultSet rs;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/employeemanagement","root","Tharu#123");
                String empid = request.getParameter("empid");
                if (empid == null || empid.isEmpty())
                {
                  pst = con.prepareStatement("select * from employees");
                  rs = pst.executeQuery();
                  %>
                  	<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Email</th>
						<th>Contact</th>
	
					</tr>
				</thead>
				<tbody>
                  <%
                 while(rs.next())
                 {    
             
                     out.print("<TR>");
                     out.print("<TD>" + rs.getString("id") + "</TD>");
                     out.print("<TD>" + rs.getString("name") + "</TD>");
                     out.print("<TD>" + rs.getString("gender") + "</TD>");
                     out.print("<TD>" + rs.getString("dob") + "</TD>");
                     out.print("<TD>" + rs.getString("email") + "</TD>");
                     out.print("<TD>" + rs.getString("contact") + "</TD>");
                     out.print("</TR>");
                 }
                  %>
                  </tbody>

			</table>
                  <%
                }
               else {
                pst = con.prepareStatement("select * from employees where id =?");
                pst.setString(1, empid);
                rs = pst.executeQuery();
                %>
                  	<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Email</th>
						<th>Contact</th>
		
					</tr>
				</thead>
				<tbody>
                  <%
                 while(rs.next())
                 {    
             
                     out.print("<TR>");
                     out.print("<TD>" + rs.getString("id") + "</TD>");
                     out.print("<TD>" + rs.getString("name") + "</TD>");
                     out.print("<TD>" + rs.getString("gender") + "</TD>");
                     out.print("<TD>" + rs.getString("dob") + "</TD>");
                     out.print("<TD>" + rs.getString("email") + "</TD>");
                     out.print("<TD>" + rs.getString("contact") + "</TD>");
                     out.print("</TR>");
                 }
                  %>
                  </tbody>

			</table>
                  <%
                }
              %>   
		</div>
	</div>
</body>
</html>