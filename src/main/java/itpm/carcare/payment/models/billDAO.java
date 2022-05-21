package itpm.carcare.payment.models;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.mysql.cj.protocol.Resultset;

import itpm.carcare.DBConnect;

public class billDAO {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs = null;

	// Retrieve bill item list
	public List<Service> getBillList() {
		// log
		System.out.println("\ngetBillList() => Bill loading in the table has started");

		List<Service> billList = new ArrayList<Service>();
		String READBILLSQL = "SELECT * FROM carcare.bill;";

		try {

			con = DBConnect.getConnection();

			pst = con.prepareStatement(READBILLSQL);
			// log
			System.out.println("SQL Query" + pst.toString());

			rs = pst.executeQuery();

			// log
			System.out.print("ResultSet Status: ");
			if (rs != null) {
				System.out.println("ResultSet initiated with data");
			} else {
				System.err.println("No Data in ResultSet");
			}

			// Enter data to the ArrayList
			while (rs.next()) {
				Service service = new Service();

				service.setServiceID(rs.getInt("service_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setDiscount(rs.getDouble("discount"));
				service.setPrice(rs.getDouble("price"));

				billList.add(service);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// log
		// bill
		System.out.print("Bill list status: ");
		if (!billList.isEmpty()) {
			System.out.println("Sucess");
		} else {
			System.err.println("Fail");
		}

		return billList;
	}

	// Delete bill item
	public void deleteBillItem(int id) {
		// log
		System.out.println("/nBill item deleting...");

		String DELETEBILLITEMSQL = "DELETE FROM `carcare`.`bill` WHERE service_id=?;";

		try {
			con = DBConnect.getConnection();

			pst = con.prepareStatement(DELETEBILLITEMSQL);
			pst.setInt(1, id);
			// log-SQL statement
			System.out.println(pst.toString());

			pst.execute();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	// Bill Total
	public double getBillTotal() {
		// log
		System.out.println("\ngetBillTotal() => Calculating bill total");
		double total = 0;

		List<Service> serviceList = getBillList();

		if (!serviceList.isEmpty()) {
			for (Service service : serviceList) {
				double price = service.getPrice();
				double discount = service.getDiscount();
				double discountPrice = (price / 100) * discount;
				double finalPrice = price - discountPrice;

				total += finalPrice;

				// log
				System.out.println("Prices: price = " + price + " discount = " + discount + " discountPrice = "
						+ discountPrice + " finalPrice = " + finalPrice);
			}
		}

		// log
		System.out.println("Total price: " + total);

		return total;
	}

	// Clear bill table data
	public void clearTable() {
		// log-Start
		System.out.println("\nClearing Bill Table");

		String CLEARTABLEQUERY = "TRUNCATE TABLE `carcare`.`bill`;";

		try {

			con = DBConnect.getConnection();
			pst = con.prepareStatement(CLEARTABLEQUERY);

			// log-Query
			System.out.println("Query " + pst.toString());

			pst.execute();

			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	// Generate Bills
	public void printBill() {
		String html = "";
		String bill_name_1st = "";
		String bill_name_2nd = "";
		String bill_name_3rd = "";
		String GET_LAST_MONTH = "SELECT * FROM bill_name WHERE month = ?;";
		String INSERT_BILL_NAME = "INSERT INTO `carcare`.`bill_name`(`bill_name`,`month`)VALUES(?,?);";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		List<Service> billList = getBillList();
		int count = 0;

		html = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "  <head>\r\n" + "    <meta charset=\"ISO-8859-1\" />\r\n"
				+ "    <title></title>\r\n" + "    <style>\r\n" + "      * {\r\n"
				+ "        /* border: 1px solid black; */\r\n" + "        scroll-behavior: smooth;\r\n"
				+ "        margin: 0;\r\n" + "        padding: 0;\r\n"
				+ "        font-family: \"Courier New\", Courier, monospace;\r\n" + "        word-wrap: break-word;\r\n"
				+ "        text-align: center;\r\n" + "        font-size: 10pt;\r\n" + "      }\r\n" + "\r\n"
				+ "      h1 {\r\n" + "        font-size: 14pt;\r\n" + "      }\r\n" + "\r\n" + "      h2 {\r\n"
				+ "        font-size: 12pt;\r\n" + "      }\r\n" + "\r\n" + "      h3 {\r\n"
				+ "        font-size: 11pt;\r\n" + "      }\r\n" + "\r\n" + "      p {\r\n"
				+ "        font-size: 10pt;\r\n" + "      }\r\n" + "\r\n" + "      hr {\r\n"
				+ "        margin: 10px 15px 20px;\r\n" + "        border: 1px dashed black;\r\n" + "      }\r\n"
				+ "\r\n" + "      body {\r\n" + "        width: 80mm;\r\n" + "        height: fit-content;\r\n"
				+ "        display: flex;\r\n" + "        justify-content: center;\r\n" + "        padding: 10px;\r\n"
				+ "      }\r\n" + "\r\n" + "      .main-container {\r\n" + "        display: grid;\r\n"
				+ "        grid-template-columns: auto;\r\n" + "      }\r\n" + "\r\n" + "      .body-headline {\r\n"
				+ "        padding: 0 0 20px;\r\n" + "      }\r\n" + "\r\n" + "      .bill-details {\r\n"
				+ "        display: grid;\r\n" + "        grid-template-columns: auto auto;\r\n"
				+ "        justify-content: space-around;\r\n" + "        padding: 0 0 20px;\r\n" + "      }\r\n"
				+ "\r\n" + "      table,\r\n" + "      th,\r\n" + "      td {\r\n"
				+ "        border: 1px dashed black;\r\n" + "        border-collapse: collapse;\r\n" + "      }\r\n"
				+ "\r\n" + "      table {\r\n" + "        width: 100%;\r\n" + "      }\r\n" + "\r\n" + "      th,\r\n"
				+ "      td {\r\n" + "        padding: 5px;\r\n" + "      }\r\n" + "\r\n" + "      .bold {\r\n"
				+ "        font-weight: bold;\r\n" + "      }\r\n" + "\r\n" + "      .bill-table {\r\n"
				+ "        padding: 0 0 20px;\r\n" + "      }\r\n" + "\r\n" + "      .footer h3 {\r\n"
				+ "        padding-top: 10px;\r\n" + "      }\r\n" + "    </style>\r\n" + "  </head>\r\n"
				+ "  <body class=\"background-black\">\r\n" + "    <div class=\"main-container background-white\">\r\n"
				+ "      <!-- Header -->\r\n" + "      <div class=\"header\">\r\n"
				+ "        <h1>CARCARE (PVT) LTD</h1>\r\n" + "        <p>No : 05, Maradana, Colombo 10</p>\r\n"
				+ "        <p>Tel:+94 77 124 3564</p>\r\n" + "        <p>Email:contact@carcare.lk</p>\r\n"
				+ "        <p>web:www.carcare.lk</p>\r\n" + "      </div>\r\n" + "\r\n"
				+ "      <!-- End of header -->\r\n" + "      <hr />\r\n" + "      <!-- body -->\r\n"
				+ "      <div class=\"body page-a4\">\r\n" + "        <!-- Body headline -->\r\n"
				+ "        <div class=\"body-headline\">\r\n" + "          <h2>INVOICE</h2>\r\n" + "        </div>\r\n"
				+ "\r\n" + "        <!-- bill details -->\r\n" + "        <div class=\"bill-details\">\r\n"
				+ "          <div class=\"label\">Date:</div>\r\n" + "          <div class=\"data\">";

		// Date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		html += formatter.format(date);

		html += "</div>\r\n" + "\r\n" + "        <div class=\"bill-table\">\r\n" + "          <table>\r\n"
				+ "            <thead>\r\n" + "              <tr>\r\n" + "                <th>Service ID</th>\r\n"
				+ "                <th>Service Name</th>\r\n" + "                <th>Discount</th>\r\n"
				+ "                <th>Price</th>\r\n" + "              </tr>\r\n" + "            </thead>\r\n"
				+ "            <tbody>";

		// Table
		if (!billList.isEmpty()) {
			for (Service s : billList) {
				html += "<tr>";
				html += "<td>";
				html += s.getServiceID();
				html += "</td>";
				html += "<td>";
				html += s.getServiceName();
				html += "</td>";
				html += "<td>";
				html += s.getDiscount();
				html += "</td>";
				html += "<td>";
				html += s.getPrice();
				html += "</td>";

				html += "</tr>";
			}
		}

		html += "<tr>\r\n" + "                <td colspan=\"3\" class=\"bold\">Bill Total</td>\r\n"
				+ "                <td class=\"bold\">";

		// Bill total
		html += getBillTotal();
		html += "</td>";
		html += "</tr>\r\n" + "            </tbody>\r\n" + "          </table>\r\n" + "        </div>\r\n"
				+ "      </div>\r\n" + "\r\n" + "      <!-- Footer -->\r\n" + "      <div class=\"footer\">\r\n"
				+ "        <p>If your have any concerns about this invoice, please contact</p>\r\n"
				+ "        <p>+94 77 123 1234</p>\r\n" + "        <h3>Thank you for Your Business!</h3>\r\n"
				+ "      </div>\r\n" + "    </div>\r\n" + "  </body>\r\n" + "</html>";

		// Generate file name
		SimpleDateFormat fileNameGenFormatter = new SimpleDateFormat("yymm");

		// get month
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();

		try {

			bill_name_1st = String.valueOf(year - 2000);
			bill_name_2nd = String.valueOf(month);

			// Get bill name 2nd part
			con = DBConnect.getConnection();
			pst = con.prepareStatement(GET_LAST_MONTH);
			pst.setInt(1, month);
			rs = pst.executeQuery();

			while (rs.next()) {
				count += 1;
			}

			if (count != 0) {
				count += 1;
			} else if (count == 0) {
				count = 1;
			}

			bill_name_3rd = String.valueOf(count);

			String bill_name = bill_name_1st + bill_name_2nd + bill_name_3rd;
			File pdfDest = new File(
					"D:\\Education\\Year 03\\Semester 01\\IT3040 - IT Project Management\\Final project\\Generated Bills\\"
							+ bill_name + ".pdf");
			ConverterProperties converterProperties = new ConverterProperties();

			HtmlConverter.convertToPdf(html, new FileOutputStream(pdfDest), converterProperties);
			Desktop.getDesktop().open(pdfDest);

			// Insert bill id to DB
			pst = con.prepareStatement(INSERT_BILL_NAME);
			pst.setString(1, bill_name);
			pst.setInt(2, month);
			pst.execute();
		} catch (IOException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
