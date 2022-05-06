<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>New Service</title>

    <script
      src="https://kit.fontawesome.com/66bf06966e.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/SithumKavinda/css-cdn-itpm/insert-service-form.css" />
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
      <form action="#" method="post">
        <button type="submit">
          <i class="fa-solid fa-circle-chevron-left"></i>
        </button>
      </form>
    </div>

    <div class="service-main-container">
      <div class="form-header">
        <h1>Insert Service</h1>
      </div>
      <div id="center" class="form-body">
        <form action="insert" method="post">
          <div>
            <input
              id="text-input"
              type="text"
              name="serviceName"
              placeholder="Service Name"
            />
          </div>
          <div>
            <input
              id="text-input"
              type="text"
              name="discount"
              placeholder="Discount"
            />
          </div>
          <div>
            <input
              id="text-input"
              type="text"
              name="price"
              placeholder="Price"
            />
          </div>

          <button id="btn_rm" type="reset">Reset</button>

          <div id="center" class="submit-button-area">
            <button id="btn-nav" type="submit">Insert Service</button>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
