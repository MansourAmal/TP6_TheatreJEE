<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Pieces</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div class="form-group">
						<label class="control-label">ID Pieces :</label> <input
							type="text" name="id" class="form-control"
							value="${piece.idPieceTheatre}" />
					</div>
					<div hidden class="form-group">
						<label class="control-label">Nom Pieces :</label> <input
							type="text" name="nom" class="form-control"
							value="${piece.nomPieceTheatre}" />
					</div>
					<div class="form-group">
						<label class="control-label">Auteur :</label> <input type="text"
							name="prix" class="form-control" value="${piece.auteur}" />
					</div>
					<div class="form-group">
						<select name="genre" class="form-control">
							<option value="${piece.genre.idG}" selected>${piece.genre.nomG}</option>
							<c:forEach items="${GenreModel.genres}" var="gen">
								<c:if test="${gen.idG != piece.genre.idG}">
									<option value="${gen.idG}">${gen.nomG}</option>
								</c:if>
							</c:forEach>
						</select>
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