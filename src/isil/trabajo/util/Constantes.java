package isil.trabajo.util;

public class Constantes {
	//Constantes
	   public static final String JDBC_CLASS="com.mysql.jdbc.Driver";
	   public static final String JDBC_URL="jdbc:mysql://localhost:3306/Proyecto01?useSSL=false&&serverTimezone=UTC";
	   public static final String JDBC_USERNAME="MySQL-Asti";
	   public static final String JDBC_PASSWORD="Asti-Dev";
	   
	   
	    public static final String INSERT_USERS_SQL = "INSERT INTO productos" + "  (nombre, categoria, cantidad, precio_uni, precio_total) VALUES "
				+ " (?, ?, ?, ?, ?);";
		public static final String SELECT_USER_BY_ID = "select id,nombre,categoria,cantidad,precio_uni,precio_total from productos where id =?";
		public static final String SELECT_ALL_USERS = "select * from productos";
		public static final String DELETE_USERS_SQL = "delete from productos where id = ?;";
		public static final String UPDATE_USERS_SQL = "update productos set nombre = ?,categoria= ?, cantidad =?, precio_uni =?, precio_total =? where id = ?;";
	   
}
