<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./partials/head.jsp"></jsp:include>

<!-- Custom styles for this template -->

</head>
<body>

	<div class="col-lg-8 mx-auto p-3 py-md-5">

		<main>
		<div>
			<h1>Turismo en la Tierra Media</h1>
		</div>
		
<div  class = "pb-3 mt-2 mb-2">

<nav class="navbar navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="#ingresar"> Ingresar
      <img src="/final1/assets/img/flight.png" alt="" width="30" height="24">
    </a>
  </div>
</nav>

</div>

<div  id="carouselExampleIndicators"  "
class="carousel slide mt-3" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
 	<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4" aria-label="Slide 5"></button>
 
  </div>
  <div class="carousel-inner " >
    <div class="carousel-item active">
      <img id = "imgCarro" src="https://i.ibb.co/3mKr4Dh/Screenshot-20211212-091926-2.png" class="d-block w-100 " alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://i.ibb.co/dJnS7dP/Screenshot-20211214-102014-2.png" class="d-block w-100 " alt="...">
    </div>
    <div class="carousel-item">
      <img id = "imgCarro" src="https://i.ibb.co/Swc24vQ/Screenshot-20211212-091500-2.png" class="d-block w-100 "   alt="...">
    </div>
     <div class="carousel-item">
      <img id = "imgCarro" src="https://i.ibb.co/djJYxX5/Screenshot-20211214-101834-2.png" class="d-block w-100 " alt="...">
    </div>
     <div class="carousel-item">
      <img id = "imgCarro" src="https://i.ibb.co/86Ln6Y7/Screenshot-20211214-102238-2.png" class="d-block w-100 " alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>















			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
	
	<a name = "ingresar">  </a>
			<form action="login" method="post" >

				<div class="mb-3">
					<label for="username" class="form-label">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
				</div>
			</form>

		</main>
	</div>
</body>
</html>