package isil.trabajo.service;

import java.sql.SQLException;
import java.util.List;

import isil.trabajo.dao.ProductoDao;
import isil.trabajo.model.Producto;

public class ProductoServicio {
	ProductoDao dao= new ProductoDao();

	public void insertProducto(Producto producto) throws SQLException {
		dao.insertProducto(producto);
		} 

	public Producto selectProducto(int id) {
		return dao.selectProducto(id);
	}

	public List<Producto> selectAllProductos() {
		return dao.selectAllProductos();
	}

	public boolean deleteProducto(int id) throws SQLException {
		return dao.deleteProducto(id);
	}

	public boolean updateProducto(Producto producto) throws SQLException {
		return dao.updateProducto(producto);
	}
}
