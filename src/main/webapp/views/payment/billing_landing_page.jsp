<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://kit.fontawesome.com/66bf06966e.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Billing</title>
<link rel="stylesheet" href="../../style/payment/main.css">
</head>
<body>
    <!-- Header Section -->
    <div class="header-section">
        <h1>BILLING</h1>
    </div>

    <div class="body-section">
        <!-- Table Section -->
        <div class="table-section">
            <div class="search-section">
                <form action="#">
                    <div class="search-box">
                        <input type="text" id="searchService">
                    </div>
                    <div class="search-button">
                        <input type="submit" value="Search" id="searchButton">
                    </div>
                </form>
            </div>
            <div class="data-section">
                <table>
                    <tr>
                        <th>SERVICE</th>
                        <th>DISCOUNT</th>
                        <th>PRICE</th>
                    </tr>
                    <div>
                        <tr>
                        <td>Engine Degreasing</td>
                        <td>10</td>
                        <td>12500.00</td>
                    </tr>
                    <tr>
                        <td>Vehicle Inspection</td>
                        <td>12</td>
                        <td>3500.00</td>
                    </tr>
                    <tr>
                        <td>Engine Tune-up</td>
                        <td>10</td>
                        <td>50000.00</td>
                    </tr>
                    <tr>
                        <td>Engine Tune-up</td>
                        <td>10</td>
                        <td>50000.00</td>
                    </tr>
                    </div>
                </table>
            </div>
            <div class="generate-invoice-section">
                <button type="menu">Generate Invoice</button>
            </div>
        </div>

        <!-- Services Section -->
        <div class="services-section">
            <div class="services-header">
                <div class="topic">
                    <h2>SERVICES</h2>
                </div>
                <div class="add-button">
                    <i class="fa-solid fa-plus"></i>
                </div>
            </div>
            <div class="service-cards">
                <div>Tyres & Wheels Grooming</div>
                <div>Exterior Waxing</div>
                <div>Windscreen Treatments</div>
                <div>Undercarriage Degreasing</div>
                <div>Vehicle Inspection</div>
                <div>Engine Degreasing</div>
                <div>Interior Detailing</div>
                <div>Exterior Detailing</div>
                <div>Wash & Vacuum packages</div>
                <div>Tyre & Spare Parts shop</div>
                <div>Nano / Quartz coating</div>
                <div>Engine Tune-up</div>
            </div>
            <div class="bill-history-area">
                <input type="button" value="Bill History">
            </div>
        </div>
    </div>
</body>
</html>