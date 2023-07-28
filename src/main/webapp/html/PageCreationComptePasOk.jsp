<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Identifiant incorrect</title>
</head>
<body>
<% if (request.getAttribute("errorIdentifiant") != null) { %> 
<h3><%= request.getAttribute("errorIdentifiant") %> !</h3>
<% } %>

<a href="/Enchere-Eni/PageConnexion"><button>Retour Menu Principal</button></a>
</body>
</html>