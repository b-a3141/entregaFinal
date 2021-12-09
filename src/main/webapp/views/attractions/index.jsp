<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

  <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
    crossorigin="anonymous"></script>
   
     <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
    crossorigin="anonymous">
    

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
		
 <c:forEach items="${attractions}" var="attraction">


	<div class="card" style="width: 100%;">
	  <img src="${attraction.getImagen()} " class="card-img-top" alt="imagen_atraccion">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${attraction.name}"></c:out></h5>
	    <p class="card-text"><c:out value="${attraction.descripcion}"></c:out></p>
	  </div>
	  <ul class="list-group list-group-flush">
	    <li class="list-group-item">Valor <c:out value="${attraction.cost}"></c:out></li>
	    <li class="list-group-item">Tiempo requerido <c:out value="${attraction.duration}"> hs.</c:out></li>
	  </ul>
	 
	  <div class="card-body">
		<c:choose>

			 <c:when test="${user.canAfford(attraction) && user.canAttend(attraction) && attraction.canHost(1)}">
				<a href="/final1/attractions/buy.do?id=${attraction.id}"
						class="btn btn-success rounded" role="button">Comprar</a>
			</c:when>
			<c:otherwise>
			<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
			</c:otherwise>
			
		</c:choose>
		<c:if test="${user.admin}">
			<a href="/final1/attractions/edit.do?id=${attraction.id}"
			class="btn btn-light rounded-0" role="button"><i class="bi bi-pencil-fill"></i></a>
			<a href="/turismo/attractions/delete.do?id=${attraction.id}"
			class="btn btn-danger rounded" role="button"><i class="bi bi-x-circle-fill"></i></a>
		</c:if>
      </div>
    </div>

 </c:forEach>
	
</div>
  
			


	</main>

</body>
</html>