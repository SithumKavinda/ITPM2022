package itpm.carcare;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String url = "jdbc:mysql://localhost:3306/carcare";
	private static String username = "root";
	private static String password = "Apple@2022";
	private static Connection con;

	public static Connection getConnection() {
		//log
		System.out.println("\ngetConnection() => Database Connection called");
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

			// log
			if (con != null) {
				System.out.println("Connection Status:" + "Connected\n");
			}

		} catch (Exception e) {

			System.err.println("Connection Status:" + "Disconnected");
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();

		}

		return con;

	}
}
