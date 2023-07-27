<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page modifier vente</title>
</head>
<h1>Page des ventes</h1>
<body>
<form method="POST" action="/Enchere-Eni/PageModifierVente">
<label for="pseudo">pas fait :</label>
<input type="text" id="pseudo" name="pseudo" value="${utilisateur.pseudo}" required>
<label for="nom">pas fait :</label>
<input type="text" id="nom" name="nom" value="${utilisateur.nom}" required>
<label for="Prenom">pas fait :</label>
<input type="text" id="Prenom" name="prenom" value="${utilisateur.prenom}"required>
<label for="email">pas fait :</label>
<input type="email" id="email" name="email" maxlength= "40" value="${utilisateur.email}"required>
<label for="telephone">pas fait :</label>
<input type="tel" id="telephone" name="telephone" maxlength= "10" value="${utilisateur.telephone}"required>
<label for="rue">pas fait:</label>
<input type="text" id="rue" name="rue" value="${utilisateur.pseudo}"required>
<label for="codePostal">pas fait :</label>
<input type="number" id="codePostal" name="codePostal" maxlength= "5" value="${utilisateur.codePostal}"required>
<label for="ville">pas fait :</label>
<input type="text" id="ville" name="ville" maxlength= "25" value="${utilisateur.ville}"required>
<label for="motDePasse">pas fait :</label>
<input type="password" id="motDePasse" name="motDePasse" required>
<input type="submit" value="Enregistrer">
</form>
<form method="POST" action="/Enchere-Eni/PageSuppressionVente">
<input type="submit" value="Supprimer">
</form>
<a href="/Enchere-Eni/PagesAccueilNonConnecte"><button>Retour Menu Principal</button></a>

</body>
</html>