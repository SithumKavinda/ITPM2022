<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Error Occured</title>

    <!-- Styles -->
    <link rel="stylesheet" href="style/payment/error-page.css" />
  </head>
  <body>
    <div class="main-container">
      <div class="error-header">
        <!-- Icon should be here -->
        <div class="icon"></div>
        <h1>Error Occured!</h1>
      </div>
      <div class="error-body">
        <div class="reason-area">
          <h2>Reason</h2>
        </div>
        <div class="stack-trace-area">
          <h2>Stack Trace</h2>
        </div>
      </div>
    </div>
    <div class="proceed-to-home">
      <form action="http://localhost:8051/categoryapi/webapi/categories" method="get">
      	<input type="submit" value="Get Table">
      </form>
    </div>
  </body>
</html>
