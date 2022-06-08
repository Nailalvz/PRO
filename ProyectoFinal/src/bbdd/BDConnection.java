package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

	private static Connection conexion;
	private static final String URL = "jdbc:mysql://localhost:3307/decoracion_hogar?useServerPrepStmts=true";
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	public BDConnection() {
		startConnection();
	}
	
	public void startConnection() {
		conexion = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		} catch(ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static void endConnection() {
		try {
			if(conexion != null) {
				conexion.close();
			}
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
	
	
	
}
