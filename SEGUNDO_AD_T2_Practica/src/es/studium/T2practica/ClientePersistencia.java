package es.studium.T2practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientePersistencia {
	static Statement statement = null;
	static Connection connection = GestorConexiones.getMySQL_Connection("hotelbd"); // permite conectar
	static ResultSet rs = null;

	public static int createCliente(String nombre, String apellidos, String email, String dni, String clave) {

		int id = 0;
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "insert into clientes values (Null,'" + nombre + "','" + apellidos + "','" + email + "','"
					+ dni + "','" + clave + "')";
			statement.executeUpdate(consulta);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta2 = "select * from clientes order by idCliente desc limit 1";
			rs = statement.executeQuery(consulta2);
			while (rs.next()) {
				id = rs.getInt("idCliente");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return id;
	}

	public static String readCliente(int idCliente, String campo) {
		/*
		 * Devuelve el valor de la columna "campo" del cliente identificado por
		 * "idCliente"
		 */
		String contenido = "";
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "Select " + campo + " from clientes where idCliente ='" + idCliente + "'  ;";
			rs = statement.executeQuery(consulta);
			while (rs.next()) {
				contenido = rs.getString(campo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return contenido;
	}

	public static boolean updateCliente(int idCliente, String campo, String nuevoValor) {
		/*
		 * Actualiza el valor de la columna "campo" del cliente identificado por
		 * "idCliente". Devuelve true si se ha logrado actualizar.
		 */
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "UPDATE clientes SET " + campo + "='" + nuevoValor + "' where idCliente ='" + idCliente
					+ "';";
			statement.executeUpdate(consulta);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public static boolean deleteCliente(int idCliente) {
		/*
		 * Elimina el cliente identificado por "idCliente". Devuelve true si se ha
		 * logrado eliminar.
		 */
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "delete from clientes where idCliente=" + idCliente + ";";
			statement.executeUpdate(consulta);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
