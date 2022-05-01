<%@page import="itpm.carcare.payment.models.Service"%> <%@page
import="java.util.List"%> <%@page
import="itpm.carcare.payment.models.ServiceDAO"%> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> <%
ServiceDAO serviceDAO = new ServiceDAO(); 
List<Service> serviceList = serviceDAO.getAllServices(); %>

  <!DOCTYPE html>
  <html>
    <head>
      <script
        src="https://kit.fontawesome.com/66bf06966e.js"
        crossorigin="anonymous"
      ></script>
      <meta charset="ISO-8859-1" />
      <title>Billing</title>
      <link rel="stylesheet" href="../../style/payment/main.css" />
    </head>
    <body>
      <div class="main-container">
        <!-- Header Section -->
        <div class="header">
          <div class="topic">BILLING</div>
          <div class="add-services-container">
            <a href="Service.jsp">Services</a>
          </div>
        </div>

        <!-- Body Section -->
        <div class="body-section">
          <form action="#" method="get">
            <div class="search-section">
              <div class="search-box">
                <input
                  type="text"
                  name="searchText"
                  placeholder="Search Services"
                />
              </div>
              <div class="search-button">
                <input type="submit" name="searchButton" value="Search" />
              </div>
            </div>
          </form>
          <div class="body-content">
            <div class="table-section">
              <table>
                <tr>
                  <th>SERVICE</th>
                  <th>DISCOUNT</th>
                  <th>TOTAL</th>
                </tr>
                <tr>
                  <td>-</td>
                  <td>-</td>
                  <td>-</td>
                </tr>
              </table>
            </div>
            <div class="services-section">
              <% if (!serviceList.isEmpty()) { for (Service s : serviceList) {
              %>
              <div><%= s.getServiceName()%></div>

              <% } } %>
            </div>
          </div>
        </div>
      </div>
    </body>
  </html>
</Service>
