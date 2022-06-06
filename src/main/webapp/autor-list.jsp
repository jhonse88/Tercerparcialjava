<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-info">
<div>
<a href="autor-list.jsp" class="navbar-brand"> ADMINISTRAR
AUTORES </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/listAutor"
class="nav-link">VER AUTORES</a></li>
<li><a href="<%=request.getContextPath()%>/new"
class="nav-link">INSERTAR AUTORES</a></li>
</ul>
</nav>
</header>
<br>
<div class="row">
<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
<div class="container">
<h3 class="text-center">LISTA DE AUTORES</h3>
<hr>
<div class="container text-left">
<a href="<%=request.getContextPath()%>/new" class="btn btn-info">INSERTAR NUEVO AUTORES</a>
</div>
<br>
<table class="table table-bordered">
<thead>
<tr>
<th>ID</th>
<th>NOMBRE</th>
<th>E-MAIL</th>
<th>PAIS</th>
<th>LIBROS</th>
<th>ACCIONES</th>
</tr>
</thead>
<tbody>
<!-- for (Todo todo: todos) { -->
<c:forEach var="user" items="${listUser}">
<tr>
<td><c:out value="${user.id}" /></td>
<td><c:out value="${user.name}" /></td>
<td><c:out value="${user.email}" /></td>
<td><c:out value="${user.country}" /></td>
<td><c:out value="${user.libro}" /></td>
<td><a href="edit?id=<c:out value='${user.id}' />">EDITAR</a>
&nbsp;&nbsp;&nbsp;&nbsp; <a
href="delete?id=<c:out value='${user.id}' />">ELIMINAR</a></td>
</tr>
</c:forEach>
<!-- } -->
</tbody>
</table>
</div>
</div>
</body>
</html>