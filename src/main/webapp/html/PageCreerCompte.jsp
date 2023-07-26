<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Creation compte</title>
</head>
<body>
<h1>ENI-Enchères</h1>
<h2>Mon profil</h2>

<!-- method="POST" nous renvoie au doPost de notre servlet PageCreerCompte -->

<form method="POST" action="/Enchere-Eni/PageCreerCompte">
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
<input type="submit" value="Créer mon compte">
<a href="/Enchere-Eni/AccueilSite"><button>Annuler</button></a>

</form>
<p></p>
</body>
</html>