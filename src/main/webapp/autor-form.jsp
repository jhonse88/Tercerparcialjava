<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-info">
<div>
<a href="autor-list.jsp" class="navbar-brand"> ADMINISTRAR AUTORES </a>
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
<div class="container col-md-5">
<div class="card">
<div class="card-body">
<c:if test="${autor != null}">
<form action="update" method="post">
</c:if>
<c:if test="${autor == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${autor != null}">
EDITAR AUTORES
</c:if>
<c:if test="${autor == null}">
INSERTAR NUEVO AUTORES
</c:if>
</h2>
</caption>
<c:if test="${autor != null}">
<input type="hidden" name="id" value="<c:out value='${autor.id}' />" />
</c:if>
<fieldset class="form-group">
<label>NOMBRE</label> <input type="text"
value="<c:out value='${autor.name}' />" class="form-control"
name="name" required="required">
</fieldset>
<fieldset class="form-group">
<label>E-MAIL</label> <input type="text"
value="<c:out value='${autor.email}' />" class="form-control"
name="email">
</fieldset>

<fieldset class="form-group">
<label>PAIS</label> <input type="text"
value="<c:out value='${autor.country}' />" class="form-control"
name="country">
</fieldset>

<fieldset class="form-group">
<label>LIBROS</label> <input type="text"
value="<c:out value='${autor.libro}' />" class="form-control"
name="libro">
</fieldset>
<button type="submit" class="btn btn-info">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>
