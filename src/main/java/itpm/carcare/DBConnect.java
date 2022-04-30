package itpm.carcare;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String url = "jdbc:mysql://localhost:3306/carcare";
	private static String username = "root";
	private static String password = "Apple@2022";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			if(con != null) {
				System.out.println("Database Connected");
			}
			
		} catch (Exception e) {
			
			System.err.println("DB Connection error");
			System.err.println(e.getMessage() + "\n");
			
		}
		
		return con;
		
	}
}
