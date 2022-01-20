package es.studium.world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexiones {
	private final static String MySQL_DB_USUARIO = "root";
	private final static String MySQL_DB_PASSWORD = "Studium2020;";
 
	private final static String MySQL_DB_DRIVER = "com.mysql.jc.jdbc.Driver";
	private final static String MySQL_DB_URL = "jdbc:mysql://localhost/hotelbd";
 
	/**
	 * Conecta con la base de datos dada dentro del servidor MySQL localhost
	 * 
	 * @param database Nombre de la base de datos
	 * @return La conexi�n con la base de datos
	 * @throws Captura las excepciones de tipo ClassNotFoundException y SQLException                
	 */
	public static Connection getMySQL_Connection(String database) {
		Connection connMySQL = null;
		try {
			Class.forName(MySQL_DB_DRIVER);
			connMySQL = DriverManager.getConnection(MySQL_DB_URL + database + "?&useSSL=false", MySQL_DB_USUARIO, MySQL_DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException eq) {
            eq.printStackTrace();
		}
		return connMySQL;
	}
}
