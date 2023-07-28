<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script src="stylesjs.js"></script>
<title>Eni-Encheres</title>
</head>
<body>
<h1>ENI-Encheres</h1>
	<p><a class="seconnecter" href="/Enchere-Eni/PageConnexion">se connecter</a></p>
	<div class="container">
    <div class="wrapper">
      <form class="form-wrapper" >
      <fieldset class="section is-active">
      <h2>Liste des enchères</h2><br>
	<label for="filtresEnchere">Filtres :</label>
	<input type=search id="filtresEnchere" name="filtreEnchere" placeholder="Le nom de l'article contient"><br><br>
	<label for="Categorie">Categorie :</label>
	<select id="Categorie" name="Categorie" >
	<option value="Toutes"> Toutes</option>
		<option value="Informatique"> Informatique</option>
		<option value="Ameublement"> Ameublement</option>
		<option value="Vêtement"> Vêtement</option>
		<option value="Sport§Loisirs"> Sport§Loisirs</option>
		</select>
		<input type="submit" value="Rechercher"><br><br><br>
			<p class="nous">by dream team alias : nabil, marion et nicolas dit la mambo n°5</p>
		</fieldset>
	</form>
	</div>
	</div>

</body>
</html>