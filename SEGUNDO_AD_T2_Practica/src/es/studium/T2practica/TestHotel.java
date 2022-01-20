package es.studium.T2practica;

import java.sql.SQLException;

public class TestHotel {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int id = ClientePersistencia.createCliente("María José", "Martínez", "mjmartinez@grupostudium.com", "12345678Z","Studium2020");
		System.out.println(id);
		System.out.println(ClientePersistencia.readCliente(id, "apellidosCliente"));
		ClientePersistencia.updateCliente(id, "apellidosCliente", "Martínez Navas");
		System.out.println(ClientePersistencia.readCliente(id, "apellidosCliente"));
		ClientePersistencia.deleteCliente(id);
		System.out.println(ClientePersistencia.readCliente(id, "apellidosCliente"));
	}

}
