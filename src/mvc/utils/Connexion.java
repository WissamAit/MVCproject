package mvc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 
 * Une classe de connexion pour créer un canal de communication avec la base de données
 */
public class Connexion {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/mvcproject","root", "");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
