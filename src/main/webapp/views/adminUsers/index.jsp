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

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estos son los usuarios registrados en el sistema.</h1>
		</div>

	<div class="container py-3"  >
	
	
	
	 <c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/final1/adminUsers/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
				</a>
			</div>
		</c:if>

	<div class="container py-3"  >
	
	<table class="table table-light table-striped
	 table-hover">
  <thead>
    <tr>
     
      <th scope="col">Nombre</th>
      <th scope="col">Admin</th>
      <th scope="col">Coins</th>
      <th scope="col">Time</th>
      <th scope="col">TypeAttraction</th>
      <th scope="col">Admin options</th>
    </tr>
  </thead>
  <tbody>
    
    	
 <c:forEach items="${users}" var="user">
    
    <tr>
      
      <td><c:out value="${user.username}"></c:out></td>
      <td><c:out value="${user.admin}"></c:out></td>
      <td><c:out value="${user.coins}"></c:out></td>
      <td><c:out value="${user.time}"></c:out></td> 
      <td><c:out value="${user.typeAttractions}"></c:out></td> 
      <td>
      <a href="/final1/adminUsers/edit.do?id=${user.id}"
			class="btn btn-light rounded-0" role="button"><i class="bi bi-pencil-fill"></i></a>
	  <a href="/final1/adminUsers/delete.do?id=${user.id}"
			class="btn btn-danger rounded" role="button"><i class="bi bi-x-circle-fill"></i></a>
      </td>
    </tr>
  </c:forEach>
 
  </tbody>
</table>
	
</div>
  
			


	</main>

</body>
</html>