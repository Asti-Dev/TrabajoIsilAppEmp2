package isil.trabajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import isil.trabajo.dao.Conexion;
import isil.trabajo.model.Producto;
import isil.trabajo.util.Constantes;

public class ProductoDao {

	public void insertProducto(Producto producto) throws SQLException {
		System.out.println(Constantes.INSERT_USERS_SQL);
		try (Connection connection = Conexion.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Constantes.INSERT_USERS_SQL)){
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getCategoria());
			preparedStatement.setInt(3, producto.getCantidad());
			preparedStatement.setDouble(4, producto.getPrecio_uni());
			preparedStatement.setDouble(5, producto.getPrecio_total());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Producto selectProducto(int id) {
		Producto producto = null;
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Constantes.SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String categoria = rs.getString("categoria");
				int cantidad = rs.getInt("cantidad");
				double precio_uni = rs.getDouble("precio_uni");
				double precio_total = rs.getDouble("precio_total");
				producto = new Producto(id, nombre, categoria, cantidad, precio_uni, precio_total);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return producto;
	}
	
	public List<Producto> selectAllProductos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Producto> productos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(Constantes.SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String categoria = rs.getString("categoria");
				int cantidad = rs.getInt("cantidad");
				double precio_uni = rs.getDouble("precio_uni");
				double precio_total = rs.getDouble("precio_total");
				productos.add(new Producto(id, nombre, categoria, cantidad, precio_uni, precio_total));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return productos;
	}
	
	public boolean deleteProducto(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constantes.DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateProducto(Producto producto) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constantes.UPDATE_USERS_SQL);) {
			statement.setString(1, producto.getNombre());
			statement.setString(2, producto.getCategoria());
			statement.setInt(3, producto.getCantidad());
			statement.setDouble(4, producto.getPrecio_uni());
			statement.setDouble(5, producto.getPrecio_total());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
					}
				}
			}
		}
}
