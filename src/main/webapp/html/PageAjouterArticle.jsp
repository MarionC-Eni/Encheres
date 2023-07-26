<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/Enchere-Eni/PageAjouterArticle">
<label for="nom">Nom :</label>
<input type="text" id="nom" name="nom" required>
<label for="Description">Description :</label>
<input type="text" id="description" name="description" required>
<label for="date">Début d'enchère :</label>
<input type="date"  id="date" name="date" required> 
<label for="date">Fin de l'enchère :</label>
<input type="date"  id="date" name="date" required> 
<label for="prixVente">Le prix initial de mon article est :</label>
<input type="number"  id="prixVente" name="prixVente" required> 

<input type="submit" value="Créer un article">
<a href="/Enchere-Eni/AccueilSite"><button>Annuler</button></a>

</form>
<p></p>
</body>
</html>