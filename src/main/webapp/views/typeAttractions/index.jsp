<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

 </head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

	<h1>Estos son los tipos disponibles actualmente</h1>

				<a href="/final1/typeAttractions/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i>Crear nuevo tipo de atracción
				</a>
			</div>
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Tipo de atracción</th>
      <th scope="col">Opciones de edición</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="types" items="${typeAttractions}" >
	<tr>
		<td> <c:out value="${types.id}"></c:out> </td>
		<td> <c:out value="${types.name}"></c:out> </td>
		<td>
		<a href="/final1/typeAttractions/edit.do?id=${types.id}" class="btn btn-sm btn-warning"><i class="bi-pencil-square"></i></a>
		<a href="/final1/typeAttractions/delete.do?id=${types.id}" class="btn btn-sm btn-danger"><i class="bi-archive-fill"></i> </a>
		</td>
	</tr>
	</c:forEach>
  </tbody>
</table>

	</main>

</body>
</html>