<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>PageVenteSupprimer</title>
</head>
<body>
<h1>Suppression de ma vente</h1>

<!-- test -->

<% if (request.getAttribute("Ventesupprime") != null) { %> 
<h3><%= request.getAttribute("Ventesupprime") %> !</h3>
<% } %>
<a href="/Enchere-Eni/PagesListeEncheresConnecte"><button>Retour à la liste des encheres</button></a>
</body>
</html> 