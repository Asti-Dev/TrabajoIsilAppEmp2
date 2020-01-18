package isil.trabajo.model;

public class Producto {
	protected int id;
	protected String nombre;
	protected String categoria;
	protected int cantidad;
	protected double precio_uni;
	protected double precio_total; 

public Producto (int id, String nombre, String categoria, 
		int cantidad, double precio_uni, double precio_total ) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.categoria = categoria;
	this.cantidad = cantidad;
	this.precio_uni = precio_uni;
	this.precio_total = precio_total;
	
}

public Producto (String nombre, String categoria, 
		int cantidad, double precio_uni, double precio_total ) {
	super();
	this.nombre = nombre;
	this.categoria = categoria;
	this.cantidad = cantidad;
	this.precio_uni = precio_uni;
	this.precio_total = precio_total;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public double getPrecio_uni() {
	return precio_uni;
}

public void setPrecio_uni(double precio_uni) {
	this.precio_uni = precio_uni;
}

public double getPrecio_total() {
	return precio_total;
}

public void setPrecio_total(double precio_total) {
	this.precio_total = precio_total;
}





}