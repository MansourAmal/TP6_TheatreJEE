<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des genres</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp"%>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">Liste des genres</div>
            <div class="card-body">
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Genre</th>
                        <th>Date Création</th>
                        <th>Suppression</th>
                        <th>Edition</th>
                    </tr>
                    <c:forEach items="${model.genres}" var="genre">
                        <tr>
                            <td>${genre.idG }</td>
                            <td>${genre.nomG }</td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy"
                                    value="${genre.dateCreation}" /></td>
                            <td><a onclick="return confirm('Etes-vous sûr ?')"
                                href="supprimerGenre?id=${genre.idG }">Supprimer</a></td>
                            <td><a href="editerGenre?id=${genre.idG }">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>