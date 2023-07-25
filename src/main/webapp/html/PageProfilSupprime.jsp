<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<h1>Suppression de mon Profil</h1>
<% if (request.getAttribute("Profilsupprime") != null) { %> 
<h3><%= request.getAttribute("Profilsupprime") %> !</h3>
<% } %>
<form method="POST" action="/Enchere-Eni/PageSuppressionProfil">
<input type="submit" value="Retour">
<a href="/Enchere-Eni/PageAccueilNonConnecte"><button>Retour à la page d'accueil</button></a>
</form>
</body>