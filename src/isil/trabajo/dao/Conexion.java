package isil.trabajo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.isil.usermanagement.util.Constants;

public class Conexion {

	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(Constantes.JDBC_CLASS);
			connection = DriverManager.getConnection(Constantes.JDBC_URL,Constantes.JDBC_USERNAME , Constantes.JDBC_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
}
