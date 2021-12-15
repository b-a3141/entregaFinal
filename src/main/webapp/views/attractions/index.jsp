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
			<h1>Estas son las atracciones de la Tierra Media</h1>
		</div>

	<div class="container py-3"  >
	
	
	
	    <c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/final1/attractions/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>
			</div>
		</c:if>
		
		
	
		<div class=" col-lg-4 col-md-3 col-sm-2 bg-info p-4 mb-3 rounded">
			<h3><c:out value="${user.getTypeAttractions().toUpperCase()}"></c:out></h3>
			<h3>Lo que más le gusta</h3>
		</div>


 <c:forEach items="${attractionsPreferidas}" var="attractionsPreferidas">


	<div class="card" style="width: 100%;">
	  <img src="${attractionsPreferidas.getImagen()} " class="card-img-top" alt="imagen_atraccion">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${attractionsPreferidas.name}"></c:out></h5>
	    <p class="card-text"><c:out value="${attractionsPreferidas.descripcion}"></c:out></p>
	  </div>
	  <ul class="list-group list-group-flush">
	    <li class="list-group-item">Valor <c:out value="${attractionsPreferidas.cost}"></c:out></li>
	    <li class="list-group-item">Tiempo requerido <c:out value="${attractionsPreferidas.duration}"> hs.</c:out></li>
	  </ul>
	 
	  <div class="card-body">
		<c:choose>

			 <c:when test="${user.canAfford(attractionsPreferidas) && user.canAttend(attractionsPreferidas) && attractionsPreferidas.canHost(1)}">
				<a href="/final1/attractions/buy.do?id=${attractionsPreferidas.id}"
						class="btn btn-success rounded" role="button">Comprar</a>
			</c:when>
			<c:otherwise>
			<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
			</c:otherwise>
			
		</c:choose>
		<c:if test="${user.admin}">
			<a href="/final1/attractions/edit.do?id=${attractionsPreferidas.id}"
			class="btn btn-light rounded-0" role="button"><i class="bi bi-pencil-fill"></i></a>
			<a href="/turismo/attractions/delete.do?id=${attractionsPreferidas.id}"
			class="btn btn-danger rounded" role="button"><i class="bi bi-x-circle-fill"></i></a>
		</c:if>
      </div>
    </div>

 </c:forEach>
	
		<div class=" col-lg-4 col-md-3 col-sm-2 
		 bg-info p-4 mt-5 mb-5 rounded">
			<h4>Si no ha encontrado algo de su gusto principal, le sugerimos lo siguiente:</h4>
		</div>

	
		
 <c:forEach items="${attractionsNotPreferidas}" var="attractionsNotPreferidas">


	<div class="card" style="width: 100%;">
	  <img src="${attractionsNotPreferidas.getImagen()} " class="card-img-top" alt="imagen_atraccion">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${attractionsNotPreferidas.name}"></c:out></h5>
	    <p class="card-text"><c:out value="${attractionsNotPreferidas.descripcion}"></c:out></p>
	  </div>
	  <ul class="list-group list-group-flush">
	    <li class="list-group-item">Valor <c:out value="${attractionsNotPreferidas.cost}"></c:out></li>
	    <li class="list-group-item">Tiempo requerido <c:out value="${attractionsNotPreferidas.duration}"> hs.</c:out></li>
	  </ul>
	 
	  <div class="card-body">
		<c:choose>

			 <c:when test="${user.canAfford(attractionsNotPreferidas) && 
			 user.canAttend(attractionsNotPreferidas) && attractionsNotPreferidas.canHost(1)}">
				<a href="/final1/attractions/buy.do?id=${attractionsNotPreferidas.id}"
						class="btn btn-success rounded" role="button">Comprar</a>
			</c:when>
			<c:otherwise>
			<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
			</c:otherwise>
			
		</c:choose>
		<c:if test="${user.admin}">
			<a href="/final1/attractions/edit.do?id=${attractionsNotPreferidas.id}"
			class="btn btn-light rounded-0" role="button"><i class="bi bi-pencil-fill"></i></a>
			<a href="/turismo/attractions/delete.do?id=${attractionsNotPreferidas.id}"
			class="btn btn-danger rounded" role="button"><i class="bi bi-x-circle-fill"></i></a>
		</c:if>
      </div>
      
      
    </div>

 </c:forEach>
		
	
		</div>
 

	</main>

</body>
</html>