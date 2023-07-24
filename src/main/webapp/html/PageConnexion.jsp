<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Page connexion</title>
</head>
<body>
<h1>ENI-Enchères</h1>
<h2>Page de connexion</h2>
<% if (request.getAttribute("error") != null) { %> 
<h1><%= request.getAttribute("error") %> !</h1>
<% } %>
<form method="POST" action="/Enchere-Eni/PageConnexion">
<label for="Identifiant">Identifiant :</label>
<input type="text" id="Identifiant" name="email" placeholder="NineJea@NineJea" required/><br><br>
<label for="Mot de passe">password :</label>
<input type="password" id="Mot de passe" name="motDePasse" placeholder="*******" required/><br><br>
<input type="submit" value="connexion" />
<input type="checkbox" id="checkbox" name="checkbox" value="true" />
<label for="checkbox"> Se souvenir de moi</label>
</form>
<form method="GET" action="/Enchere-Eni/PageCreerCompte">
<input type="submit" value="Créer un compte" />
</form>
</body>
</html>