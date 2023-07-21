<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Encheres</title>
</head>
<body>
<h1>ENI-Encheres</h1>
	<p><a href="/Enchere-Eni/PageConnexion">Se connecter - S'inscrire</a></p>
	
	<h2>Liste des enchères</h2>
	<form>
	<label for="filtresEnchere">Filtres :</label><br>
	<input type=search id="filtresEnchere" name="filtreEnchere" placeholder="Le nom de l'article contient"><br>
	<label for="Categorie">Categorie :</label>
	<select id="Categorie" name="Categorie" >
	<option value="Toutes"> Toutes</option>
		<option value="Informatique"> Informatique</option>
		<option value="Ameublement"> Ameublement</option>
		<option value="Vêtement"> Vêtement</option>
		<option value="Sport§Loisirs"> Sport§Loisirs</option>
		</select>
		<input type="submit" value="Rechercher">
	</form>
	<p>yolo</p>
</body>
</html>