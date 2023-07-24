<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Eni-Encheres</title>
</head>
<body>
<h1>ENI-Encheres</h1>
	    <nav>
        <ul class="navbar">
            <li class="nav-item"><a href="">Enchères</a></li>
            <li class="nav-item"><a href="/Enchere-Eni/PageVendreUnArticle">Vendre un article</a></li>
            <li class="nav-item"><a href="/Enchere-Eni/PageMonProfil">Mon profil</a></li>
            <li class="nav-item"><a href="/Enchere-Eni/PageDeconnexion">Déconnexion</a></li>
        </ul>
    </nav>
	
	<h2>Liste des enchères</h2>
<%String identifiant = request.getParameter("Identifiant"); %>
<h3>PageMonProfil de <%=identifiant%></h3>
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