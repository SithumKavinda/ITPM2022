package itpm.carcare.payment.models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class categoryModel {

	public void getTable() {
		HttpURLConnection connection;
		try {
			URL url = new URL("http://localhost:8051/categoryapi/webapi/categories");
			connection = (HttpURLConnection) url.openConnection();

			// Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();
			System.out.println("Status: " + status);

		} catch (MalformedURLException e) {
			System.out.print("MalformedURLException: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("IOExceptiom: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
