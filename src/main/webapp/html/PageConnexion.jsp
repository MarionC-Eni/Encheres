<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script src="stylesjs.js"></script>
<title>Page connexion</title>
</head>
<body>
<h1>ENI-Enchères</h1><br>

<!-- On insere du Java dans le Html, on fait appel à la ligne 76 dans PageConnexion -->

<% if (request.getAttribute("error") != null) { %> 
<h1 class="msgerror"><%= request.getAttribute("error") %> !</h1>
<% } %>
<div class="container">
    <div class="wrapper">
      <form class="form-wrapper" method="POST" action="/Enchere-Eni/PageConnexion">
      <fieldset class="section is-active">
      <h3>Se connecter</h3><br>
<label for="Identifiant">Identifiant :</label>
<input type="text" id="Identifiant" name="email" placeholder="NineJea@NineJea" required/><br><br>
<label for="Mot de passe">password :</label>
<input type="password" id="Mot de passe" name="motDePasse" placeholder="*******" required/><br><br>
<input type="submit" value="connexion" />
<input type="checkbox" id="checkbox" name="checkbox" value="true" />
<label for="checkbox"> Se souvenir de moi</label><br><br>
<!-- On renvoie bien au doGet de la servlet. On aurait pu faire un href aussi -->
<a href="/Enchere-Eni/PageCreerCompte"><button type="button">Creation Compte</button></a>
</fieldset>
</form>
</div>
</div>
<br>
<br>


</body>
</html>