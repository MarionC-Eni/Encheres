<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<% if (request.getAttribute("Profilsupprime") != null) { %> 
<h3><%= request.getAttribute("Profilsupprime") %> !</h3>
<% } %>
<form method="POST" action="/Enchere-Eni/PageModifierProfil">
<label for="pseudo">pseudo :</label>
<input type="text" id="pseudo" name="pseudo" required>
<label for="nom">Nom :</label>
<input type="text" id="nom" name="nom" required>
<label for="Prenom">Prénom :</label>
<input type="text" id="Prenom" name="prenom" required>
<label for="email">Email :</label>
<input type="email" id="email" name="email" maxlength= "40" required>
<label for="telephone">Téléphone :</label>
<input type="tel" id="telephone" name="telephone" maxlength= "10" required>
<label for="rue">Rue :</label>
<input type="text" id="rue" name="rue" required>
<label for="codePostal">Code postal :</label>
<input type="number" id="codePostal" name="codePostal" maxlength= "5" required>
<label for="ville">Ville :</label>
<input type="text" id="ville" name="ville" maxlength= "25" required>
<label for="motDePasse">Mot de passe :</label>
<input type="password" id="motDePasse" name="motDePasse" required>
<input type="submit" value="Enregistrer">
<a href="/Enchere-Eni/PageSuppressionProfil"><button>Supprimer mon compte</button></a>
</form>
</body>
</html>