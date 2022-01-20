package es.studium.world;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class world {
	private static void mostrarTodosLosPaises() throws SQLException {
        Connection conexion = GestorConexiones.getMySQL_Connection("world");
        String consulta = "SELECT * FROM country";		
        Statement st = conexion.createStatement();
		ResultSet res = st.executeQuery(consulta);
		while (res.next()) {
			System.out.println(
					"El país " + res.getString("Name") + " tiene " + res.getInt("Population") + " habitantes.");
		}
		res.close();
		st.close();
        conexion.close();
}
	private static void mostrarPaises(char letter) throws SQLException {
		Connection conexion = GestorConexiones.getMySQL_Connection("world");
		String query = "SELECT * FROM COUNTRY WHERE Name LIKE \"" + String.valueOf(letter) + "%\";";
 
		Statement st = conexion.createStatement();
		ResultSet resultado = st.executeQuery(query);
		while (resultado.next()) {
			System.out.println("El país " + resultado.getString("Name") + " tiene " + resultado.getInt("Population")
					+ " habitantes.");
		}
		resultado.close();
		st.close();
		   conexion.close();
			}
	private static void mostrarDatos() throws SQLException {
		Connection conexion;
		Statement st = conexion.createStatement();
		ResultSet res = st.executeQuery(QUERY_SELECT_ALL);
 
		ResultSetMetaData rma = res.getMetaData();
		int total = rma.getColumnCount();
		for (int i = 1; i <= total; i++) {
			/* Devuelve el tipo de dato y el nombre de la columna */
			System.out.println(rma.getColumnTypeName(i) + "--" + rma.getColumnLabel(i));
		}
 
		res.close();
		st.close();
	}
}
