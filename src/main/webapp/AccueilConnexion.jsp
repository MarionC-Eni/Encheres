<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<form method="POST" action="/Enchere-Eni/PageConnexion.jsp">
<label for="Identifiant">Identifiant :</label>
<input type="text" id="Identifiant" name="Identifiant" value="NineJea"/><br><br>
<label for="Mot de passe">passeword :</label>
<input type="text" id="Mot de passe" name="Mot de passe" value="*******"/><br><br>
<input type="submit" value="connexion" />
<input type="checkbox" id="checkbox" name="checkbox" value="true" />
<label for="checkbox"> Se souvenir de moi</label>
</form>
<form method="POST" action="Enchere-Eni/CreationCompte.jsp">
<input type="submit" value="Créer un compte" />
</form>
</body>
</html>