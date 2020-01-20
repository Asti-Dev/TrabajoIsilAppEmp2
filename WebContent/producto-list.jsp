<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title> Management Application</title>
	<style>
     <%@ include file="css/style.css"%>
	</style>
</head>
<body>
	
		<h2 align="center">[Isil Example] Gestion de Productos</h2>

    <div align="center">
        <table  border="1" cellpadding="5">
            <caption><h2>Lista de Productos</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Precio Total</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="producto" items="${listProducto}">
                <tr>
                    <td><c:out value="${producto.id}" /></td>
                    <td><c:out value="${producto.nombre}" /></td>
                    <td><c:out value="${producto.categoria}" /></td>
                    <td><c:out value="${producto.cantidad}" /></td>
                    <td><c:out value="${producto.precio_uni}" /></td>
                    <td><c:out value="${producto.precio_total}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${producto.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${producto.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
            <h3 align="center">
        	<a href="new">Add New Producto</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Productos</a>
        	
        </h3>
</body>
</html>
