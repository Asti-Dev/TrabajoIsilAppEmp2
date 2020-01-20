package isil.trabajo.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isil.trabajo.model.Producto;
import isil.trabajo.service.ProductoServicio;


@WebServlet("/")
public class ProductoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ProductoServicio productoServicio;
	
	public void init() {
		productoServicio = new ProductoServicio();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertProducto(request, response);
				break;
			case "/delete":
				deleteProducto(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateProducto(request, response);
				break;
			default:
				listProducto(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Producto> listProducto = productoServicio.selectAllProductos();
		request.setAttribute("listProducto", listProducto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("producto-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("producto-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Producto existingProducto = productoServicio.selectProducto(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("producto-form.jsp");
		request.setAttribute("producto", existingProducto);
		dispatcher.forward(request, response);

	}

	private void insertProducto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio_uni = Double.parseDouble(request.getParameter("precio_uni"));
		double precio_total = Double.parseDouble(request.getParameter("precio_total"));
		Producto newProducto = new Producto(nombre, categoria, cantidad,precio_uni,precio_total);
		productoServicio.insertProducto(newProducto);
		response.sendRedirect("list");
	}

	private void updateProducto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio_uni = Double.parseDouble(request.getParameter("precio_uni"));
		double precio_total = Double.parseDouble(request.getParameter("precio_total"));

		Producto catalogo = new Producto(nombre, categoria, cantidad,precio_uni,precio_total);;
		productoServicio.updateProducto(catalogo);
		response.sendRedirect("list");
	}

	private void deleteProducto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productoServicio.deleteProducto(id);
		response.sendRedirect("list");

	}
	
}
