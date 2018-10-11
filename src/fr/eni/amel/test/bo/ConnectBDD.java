package fr.eni.amel.test.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBDD {
	
private static Connection connection;
	

	//ex�cut� la premi�re fois que la classe est appel�e 
	static {
		//d�marrer le driver
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection jdbcConnexion() throws SQLException {
		connection = null;
		//driver se connecte � la bdd
		connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BDD_QCM","sa", "Pa$$w0rd");

		return connection;
	}
	
	public static void closeConnection(){
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection=null;
		}
	}
	

}
