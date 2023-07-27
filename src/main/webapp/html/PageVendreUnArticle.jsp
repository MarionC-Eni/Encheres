<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>
<form method="POST" action="/Enchere-Eni/PageVendreUnArticle">
<label for="nom">Nom :</label>
<input type="text" id="nom" name="nom" required>
<label for="Description">Description :</label>
<input type="text" id="description" name="description" required>
<label for="date">Début d'enchère :</label>
<input type="date"  id="date" name="dateDebut" required> 
<label for="date">Fin de l'enchère :</label>
<input type="date"  id="date" name="dateFin" required> 
<label for="prixVente">Le prix initial de mon article est :</label>
<input type="number"  id="prixVente" name="prixVente" required> 
<label for="miseAPrix">Je ne descendrai pas en dessous de (euros) :</label>
<input type="number"  id="miseAPrix" name="miseAPrix" required> 
<input type="submit" value="Créer un article">
<a href="/Enchere-Eni/AccueilSite"><button>Annuler</button></a>

</form>
<p></p>
</body>
</html>