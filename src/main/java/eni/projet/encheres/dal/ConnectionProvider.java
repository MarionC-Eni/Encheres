package eni.projet.encheres.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import eni.projet.encheres.config.*;

public class ConnectionProvider {

/**
	private static String URL="jdbc:sqlserver://localhost;encrypt=false;databaseName=USER_DB";
	private static String login ="sa";
	private static String password ="sql2022";

	public static Connection getConnection() {
		try {
			Connection cnx = DriverManager.getConnection(URL, login, password);
			System.out.println("connected...");
			return cnx;
		} catch (SQLException e) {
			//e.printStackTrace();
			e.printStackTrace();
			return null;
		}
	}
}

*/

		private Connection connection;
			
		public static Connection getConnection() {
			try {
				Connection cnx = DriverManager.getConnection(
						Settings.getProperty("url"), 
						Settings.getProperty("user"), 
						Settings.getProperty("password"));			
				System.out.println("Connected...");
				return cnx;
			} catch (SQLException e3) {			
				e3.printStackTrace();
				return null;
			}		
		}
		
		
	}


