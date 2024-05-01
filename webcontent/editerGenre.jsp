<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification des genres</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des genres</div>
			<div class="card-body">
				<form action="updateGenre" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID Genre :</label> <input type="text"
							name="id" class="form-control" value="${genre.idG}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom Genre :</label> <input
							type="text" name="nom" class="form-control" value="${genre.nomG}" />
					</div>
					<div class="form-group">
						<label class="control-label">Date Genre : </label>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${genre.dateCreation}"
							var="formatDate" />
						<input type="date" name="dateCreation" class="form-control"
							value="${formatDate}"></input>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
