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

		<h2 align="center">Isil Example - Gestion de Productos</h2>

    <div align="center">
		<c:if test="${producto != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${producto == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${producto != null}">
            			Edit Producto
            		</c:if>
            		<c:if test="${producto == null}">
            			Add New Producto
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${producto != null}">
        			<input type="hidden" name="id" value="<c:out value='${producto.id}' />" />
        		</c:if>            
            <tr>
                <th>Nombre del Producto: </th>
                <td>
                	<input type="text" name="nombre" size="45"
                			value="<c:out value='${producto.nombre}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Categoria del Producto: </th>
                <td>
                	<input type="text" name="categoria" size="45"
                			value="<c:out value='${producto.categoria}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Cantidad: </th>
                <td>
                	<input type="text" name="cantidad" size="15"
                			value="<c:out value='${producto.cantidad}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Precio unitario: </th>
                <td>
                	<input type="text" name="precio_uni" size="15"
                			value="<c:out value='${producto.precio_uni}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Precio Total: </th>
                <td>
                	<input type="text" name="precio_total" size="15"
                			value="<c:out value='${producto.precio_total}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
        <h3 align="center">
        	<a href="new">Add New Producto</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Productos</a>
        	
        </h3>
</body>
</html>
