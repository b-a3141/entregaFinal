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
<<<<<<< HEAD

<main class="container">

		<c:if test="${promotion != null && !promotion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la promoción.</p>
			</div>
		</c:if>

		<form action="/final1/promotions/create.do" method="post">
		
		<jsp:include page="/views/promotions/form.jsp"></jsp:include>
		
		</form>
	</main>
=======
>>>>>>> main

	<main class="container">

		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la atracción.</p>
			</div>
		</c:if>

		<form action="/final1/promotions/create.do" method="post">
			<jsp:include page="/views/promotions/form.jsp"></jsp:include>
		</form>
	</main>
	
</body>
</html>
