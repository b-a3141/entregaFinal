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

		<form action="/final1/typeAttractions/edit.do?id=${typeAttraction.id}" method="post">
			<jsp:include page="/views/typeAttractions/form.jsp"></jsp:include>
		</form>
		
	</main>
</body>
</html>