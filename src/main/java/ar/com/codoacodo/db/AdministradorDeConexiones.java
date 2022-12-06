package ar.com.codoacodo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	public static Connection getConnection() {
		
		String host ="127.0.0.1";//localhost
		String port ="3306";
		String password ="root";
		String username ="root";
		
		//Driver de conexion a la base de datos
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		//Nombre de la base de datos
		String dbName = "22569";
		
		//No voy a explicar try catch, solo lo vamos a usar. 
		Connection connection;
		try {
			Class.forName(driverClassName);
			
			String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?serverTimeZone=UTC&useSSL=false";
			connection = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			connection = null;
			
		}
		
		return connection;
	}
}