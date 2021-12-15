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

		<form action="/final1/adminUsers/edit.do" method="post">
			<input type="hidden" name="id" value="${attraction.id}">
			<jsp:include page="/views/adminUsers/form2.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>