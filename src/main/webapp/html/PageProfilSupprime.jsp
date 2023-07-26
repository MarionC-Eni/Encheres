<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PageProfilSupprimer</title>
</head>
<body>
<h1>Suppression de mon Profil</h1>

<!-- On fait appel a la ligne 81 de la servlet PageSuppressionProfil -->

<% if (request.getAttribute("Profilsupprime") != null) { %> 
<h3><%= request.getAttribute("Profilsupprime") %> !</h3>
<% } %>
<a href="/Enchere-Eni/PagesAccueilNonConnecte"><button>Retour à la page d'accueil</button></a>
</body>
</html> 