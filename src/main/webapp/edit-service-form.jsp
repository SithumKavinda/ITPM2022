<%@page import="itpm.carcare.payment.models.Service"%> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> <%
Service service = (Service) request.getAttribute("loadService"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>New Service</title>

    <script
      src="https://kit.fontawesome.com/66bf06966e.js"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/insert-service-form-updated.css"
    />
    <!-- JavaScript Bundle with Popper -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <div class="back-button">
      <form action="backToServices" method="post">
        <button type="submit">
          <i class="fa-solid fa-circle-chevron-left"></i>
        </button>
      </form>
    </div>

    <div class="service-main-container">
      <div class="form-header">
        <h1>Edit Service</h1>
      </div>
      <div id="center" class="form-body">
        <form action="editService" method="post" name="insertForm" id="insertForm">
          <!-- Service Name -->
          <div>
            <input
              type="text"
              name="serviceIDEdit"
              id="serviceIDEdit"
              readonly
              style="display: none"
              value="<%=service.getServiceID()%>"
            />
            <input
              id="serviceName"
              type="text"
              name="serviceNameEdit"
              placeholder="Service Name"
              value="<%=service.getServiceName()%>"
            />
            <!-- Name error -->
            <div id="nameError" class="alert alert-danger p-1" role="alert">
              This is a danger alert—check it out!
            </div>
          </div>

          <!-- Discount -->
          <div>
            <input
              id="discount"
              type="number"
              name="discountEdit"
              placeholder="Discount"
              value="<%=service.getDiscount()%>"
            />
            <!-- Discount error -->
            <div id="discountError" class="alert alert-danger p-1" role="alert">
              This is a danger alert—check it out!
            </div>
          </div>

          <!-- Price -->
          <div>
            <input
              id="price"
              type="number"
              name="priceEdit"
              placeholder="Price"
              value="<%=service.getPrice()%>"
            />
            <!-- price error -->
            <div id="priceError" class="alert alert-danger p-1" role="alert">
              This is a danger alert—check it out!
            </div>
          </div>

          <button id="btn_rm" type="reset">Reset</button>

          <!-- Test -->

          <!-- Test -->

          <div id="center" class="submit-button-area">
            <input
              type="submit"
              value="Update Service"
              name="submitBtn"
              id="btn-nav"
            />
          </div>
        </form>
      </div>
    </div>

    <!-- jquery -->
    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>
    <script
      type="application/javascript"
      src="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/insert-service-form.js"
    ></script>
  </body>
</html>
