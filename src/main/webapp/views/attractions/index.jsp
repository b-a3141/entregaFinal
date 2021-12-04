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
<!-- 
//Inserto lo que tenía en la versión primitiva

  
</head>
<body>
    

  



 -->
		<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/final1/attractions/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Descripción</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${attractions}" var="attraction">
					<tr>
						<td><strong><c:out value="${attraction.name}"></c:out></strong></td>
						<td><p><c:out value="${attraction.descripcion}"></c:out></p></td>
						<td><c:out value="${attraction.cost}"></c:out></td>
						<td><c:out value="${attraction.duration}"></c:out></td>
						<td><c:out value="${attraction.capacity}"></c:out></td>

						<td><c:if test="${user.admin}">
								<a href="/final1/attractions/edit.do?id=${attraction.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/turismo/attractions/delete.do?id=${attraction.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> <c:choose>

								<c:when
									test="${user.canAfford(attraction) && user.canAttend(attraction) && attraction.canHost(1)}">
									<a href="/final1/attractions/buy.do?id=${attraction.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
					
					<tr>
					<img src="${attraction.imagen}" id="miImagen">
					</tr>
				</c:forEach>
			</tbody>
		</table>

	<div class="container py-3"  >
	
	<c:forEach items="${attractions}" var="attraction">

		<div class="row py-3">
		 
	     <div class="col" >
			<a href="#" class="list-group-item" style ="list-group-color: gray-900;"
				aria-current="true">
				<div class="d-flex w-80 justify-content-between">
				
				
					<h5 class="mb-1"><strong><c:out value="${attraction.name}"></c:out></strong></h5>
					<small>Valor <c:out value="${attraction.cost}"></c:out></small> 
					<small>Tiempo requerido <c:out value="${attraction.duration}"> hs.</c:out></small>
				</div>
				<p class="mb-1"><c:out value="${attraction.descripcion}"></c:out></p> 
				<small>Contamos con más de 30 variedades de platos</small> 
				
			</a>
		</div>
			   
			 <div class="col" >
			   <a class="btn btn-secondary" href="principalAdmin.html">Ver más</a> 
			   <a class="btn btn-success" href="logout.html">Comprar</a>
			 </div>
		   
		 </div>
		   
		
	</div>
  
		</c:forEach>


	</main>

</body>
</html>