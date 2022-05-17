<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Card Payment</title>

    <!-- Regular CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/card-payment-page.css"
    />

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
  <body>
    <div class="card-payment-main-container">
      <div class="back-button-area">
        <form action="paymentMethod" method="post">
          <button type="submit">
            <i class="fa-solid fa-circle-chevron-left"></i>
          </button>
        </form>
      </div>
      <div class="card-Payment-header">
        <h1>Card Payment</h1>
      </div>

      <div class="card-payment-body">
        <form action="error" method="post" id="card-payment-form">
          <!-- Name of the card holder -->
          <div class="user-name">
            <input
              type="text"
              name="user-name"
              id="user-name"
              placeholder="Name of the Card Holder"
            />
          </div>
          <!-- Name error -->
          <div
            class="alert alert-danger p-1"
            role="alert"
            id="nameError"
            style="width: auto; font-size: 10pt"
          ></div>

          <!-- Card number -->
          <div class="card-number">
            <input
              type="number"
              name="card-number"
              id="card-number"
              placeholder="Card Number"
            />
          </div>
          <!-- Card number error -->
          <div
            class="alert alert-danger p-1"
            role="alert"
            id="numberError"
            style="width: auto; font-size: 10pt"
          ></div>

          <!-- Expiration -->
          <div class="expiration">
            <div class="lable">
              <p>Expiration details:</p>
            </div>

            <div class="month" id="align-center">
              <input id="month" type="number" placeholder="mm" />
            </div>
            <div class="year" id="align-center">
              <input id="year" type="number" placeholder="yyyy" />
            </div>
          </div>
          <!-- Expiration error -->
          <div
            class="alert alert-danger p-1"
            role="alert"
            id="expError"
            style="width: auto; font-size: 10pt"
          ></div>

          <!-- cvv number -->
          <div class="cvv">
            <input id="cvv" type="number" placeholder="cvv" />
            <p>
              * CSV code is on the back and is usually printed at the very far
              right of your signature line
            </p>
          </div>
          <!-- cvv error -->
          <div
            class="alert alert-danger p-1"
            role="alert"
            id="cvvError"
            style="width: auto; font-size: 10pt"
          ></div>

          <!-- submit button -->
          <div class="submit-button">
            <input id="btn" type="submit" value="Pay" />
          </div>
        </form>
      </div>
    </div>

    <!-- jQuery -->
    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>

    <script src="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/card-payment-page.js"></script>
  </body>
</html>
