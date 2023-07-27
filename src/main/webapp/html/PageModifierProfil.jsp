<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PageModifierProfil</title>
</head>
<body>
<h1>PageModifierProfil</h1>
<% if (request.getAttribute("Profilajour") != null) { %> 
<h2><%= request.getAttribute("Profilajour") %> !</h2>
<% } %>
<form method="POST" action="/Enchere-Eni/PageModifierProfil">
<label for="pseudo">pseudo :</label>
<input type="text" id="pseudo" name="pseudo" value="${utilisateur.pseudo}" required>
<label for="nom">Nom :</label>
<input type="text" id="nom" name="nom" value="${utilisateur.nom}" required>
<label for="Prenom">Prenom :</label>
<input type="text" id="Prenom" name="prenom" value="${utilisateur.prenom}"required>
<label for="email">Email :</label>
<input type="email" id="email" name="email" maxlength= "40" value="${utilisateur.email}"required>
<label for="telephone">Telephone :</label>
<input type="tel" id="telephone" name="telephone" maxlength= "10" value="${utilisateur.telephone}"required>
<label for="rue">Rue :</label>
<input type="text" id="rue" name="rue" value="${utilisateur.pseudo}"required>
<label for="codePostal">Code postal :</label>
<input type="number" id="codePostal" name="codePostal" maxlength= "5" value="${utilisateur.codePostal}"required>
<label for="ville">Ville :</label>
<input type="text" id="ville" name="ville" maxlength= "25" value="${utilisateur.ville}"required>
<label for="motDePasse">Mot de passe :</label>
<input type="password" id="motDePasse" name="motDePasse" required>
<input type="submit" value="Enregistrer">
</form>
<form method="POST" action="/Enchere-Eni/PageSuppressionProfil">
<input type="submit" value="Supprimer">
<a href="/Enchere-Eni/PagesAccueilNonConnecte"><button>Retour Menu Principal</button></a>
</form>
</body>
</html>