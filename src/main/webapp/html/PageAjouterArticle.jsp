<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Nouvelle Vente</title>
</head>
<body>
<form method="POST" action="/Enchere-Eni/PageAjouterArticle">
<label for="nom">Nom :</label>
<input type="text" id="nom" name="nom" required><br>
<label for="Description">Description :</label>
<input type="text" id="description" name="description" required><br>
<label for="date">Début d'enchère :</label>
<input type="date"  id="date" name="dateDebut" required> <br>
<label for="date">Fin de l'enchère :</label>
<input type="date"  id="date" name="dateFin" required> <br>
<label for="prixVente">Le prix initial de mon article est :</label>
<input type="number"  id="prixVente" name="prixVente" required> <br>
<label for="miseAPrix">Je ne descendrai pas en dessous de (euros) :</label>
<input type="number"  id="miseAPrix" name="miseAPrix" required><br>
<input type="submit" value="Créer un article">
<a href="/Enchere-Eni/AccueilSite"><button>Annuler</button></a>

</form>
<p></p>
</body>
</html>