<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie Genre</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp"%>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">Saisie des Genres</div>
            <div class="card-body">
                <form action="saveGenre" method="post">
                    <div class="form-group">
                        <label class="control-label">Nom Genre :</label> 
                        <input type="text" name="nom" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Date Genre : </label> 
                        <input type="date" name="dateGenre" class="form-control"></input>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-primary">Ajouter</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
