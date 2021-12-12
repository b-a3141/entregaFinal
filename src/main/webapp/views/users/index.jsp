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

<div class="container py-3"  >

	

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las ofertas que usted ha adquirido !!!</h1>
		</div>

	<div class="container py-3"  >
	
	 <c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/final1/users/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Alta Usuario
				</a>
			</div>
		</c:if>
		
	
 <c:forEach items="${attractionsOwned}" var="attractionsOwned">


	<div class="card" style="width: 100%;">
	  <img src="${attractionsOwned.getImagen()} " class="card-img-top" 
	  style="width: 50%;" alt="imagen_atraccion">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${attractionsOwned.name}"></c:out></h5>
	    <p class="card-text"><c:out value="${attractionsOwned.descripcion}"></c:out></p>
	  </div>
	  <ul class="list-group list-group-flush">
	    <li class="list-group-item">Valor <c:out value="${attractionsOwned.cost}"></c:out></li>
	    <li class="list-group-item">Tiempo requerido <c:out value="${attractionsOwned.duration}"> hs.</c:out></li>
	    
	  </ul>
	 
	  
    </div>

 </c:forEach>
			
	
			
 <c:forEach items="${promotionsOwned}" var="promotionsOwned">

	
	<div class="card" style="width: 100%;">
	  <img src="${promotionsOwned.getImagen()} " class="card-img-top" 
	  style="width: 50%;" alt="imagen_atraccion">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${promotionsOwned.name}"></c:out></h5>
	    <p class="card-text"><c:out value="${promotionsOwned.descripcion}"></c:out></p>
	  </div>
	  <ul class="list-group list-group-flush">
	    <li class="list-group-item">Valor <c:out value="${promotionsOwned.cost}"></c:out></li>
	  </ul>
	 
	  
    </div>

  </c:forEach>
		
	
  </div>
  
  </div>			

</main>

</body>
</html>