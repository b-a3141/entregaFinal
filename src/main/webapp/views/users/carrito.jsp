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

 <c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/final1/users/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Alta Usuario
				</a>
			</div>
		</c:if>
		
	



		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las ofertas que usted ha adquirido</h1>
		</div>

	<div class="container py-3"  >
	
	
	
	<table class="table table-light table-striped
	 table-hover">
  <thead>
    <tr>
     
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Costo</th>
      <th scope="col">Tiempo</th>
    </tr>
  </thead>
  <tbody>
    
    	
 <c:forEach items="${promotionsOwned}" var="promotionsOwned">
    
    <tr>
      
      <td><c:out value="${promotionsOwned.name}"></c:out></td>
      <td><c:out value="${promotionsOwned.description}"></c:out></td>
      <td><c:out value="${promotionsOwned.cost}"></c:out></td>
       <td><c:out value="${promotionsOwned.duration}"></c:out></td> 
    </tr>
  </c:forEach>
   
   <c:forEach items="${attractionsOwned}" var="attractionsOwned">
    
    <tr>
      
      <td><c:out value="${attractionsOwned.name}"></c:out></td>
      <td><c:out value="${attractionsOwned.descripcion}"></c:out></td>
      <td><c:out value="${attractionsOwned.cost}"></c:out></td>
       <td><c:out value="${attractionsOwned.duration}"></c:out></td> 
    </tr>
  </c:forEach>
  </tbody>
</table>
	
</div>
  
			


	</main>

</body>
</html>