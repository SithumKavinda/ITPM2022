<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <% double totalAmount = (double)
request.getAttribute("total_amount"); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cash Payment</title>
    <!-- General Styles -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/cash-payment-page.css"
    />
    <!-- https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/cash-payment-page.css -->

    <!-- Bootstrap v5 CDN -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />

    <!-- Font awesome -->
    <script
      src="https://kit.fontawesome.com/66bf06966e.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body onload="defaultThings()">
    <div class="cash-payment-main-container">
      <div class="back-button-area">
        <form action="paymentMethod" method="post">
          <button type="submit">
            <i class="fa-solid fa-circle-chevron-left"></i>
          </button>
        </form>
      </div>
      <div class="cash-Payment-header">
        <h1>Cash Payment</h1>
      </div>

      <div class="cash-payment-body">
        <!-- form -->
        <form id="cashForm" action="error" name="cashForm" method="post">
          <!-- Display Total amount -->
          <div class="inline-lable-input">
            <div class="label">Total Amount:</div>
            <div class="total-amount">
              <input
                class="custom-input"
                id="total-amount"
                name="total-amount"
                type="text"
                value="<%=totalAmount%>"
                readonly
              />
            </div>
          </div>

          <!-- Enter paid amount -->
          <div class="inline-lable-input">
            <div class="label">Paid Amount:</div>
            <div class="paid-amount">
              <input
                class="custom-input"
                id="paidAmount"
                name="paidAmount"
                type="number"
                placeholder="Enter Paid Amount"
              />
            </div>
          </div>

          <!-- Show balance amount -->
          <div class="inline-lable-input">
            <div class="label">Balance:</div>
            <div class="balance-amount">
              <input
                class="custom-input"
                id="balance-amount"
                name="balance-amount"
                type="text"
                value="-"
                readonly
              />
            </div>
          </div>

          <!-- Proceed to Bill generation -->
          <div class="paid-amount-area">
            <input id="btn" name="submitBtn" type="submit" value="Pay" />
          </div>
        </form>
      </div>
      <div
        id="error"
        name="error"
        class="alert alert-danger text-center p-1"
        role="alert"
        style="width: auto; font-size: 12pt"
      >
        This is a danger alert—check it out!
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
      src="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/cash-payment.js"
    ></script>
  </body>
</html>
