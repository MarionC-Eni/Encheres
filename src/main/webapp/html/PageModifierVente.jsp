<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Page modifier vente</title>
</head>
<h1>Page des ventes</h1>
<body>


<% if (request.getAttribute("Ventemodifiee") != null) { %> 
<h3><%= request.getAttribute("Ventemodifiee") %> !</h3>
<% } %>

<form method="POST" action="/Enchere-Eni/PageModifierVente?noArticle=${article.noArticle}">

<label for="nom">Nom :</label>
<input type="text" id="nom" name="nomArticle" value="${article.nomArticle}" required>
<label for="Description">Description :</label>
<input type="text" id="description" name="description"  value="${article.description}" required>
<label for="date">D�but d'ench�re :</label>
<input type="date"  id="date" name="dateDebut"  value="${article.dateDebut}" required> 
<label for="date">Fin de l'ench�re :</label>
<input type="date"  id="date" name="dateFin"  value="${article.dateFin}" required> 
<label for="prixVente">Le prix initial de mon article est :</label>
<input type="number"  id="prixVente" name="prixVente"  value="${article.prixVente}" required> 
<label for="miseAPrix">Je ne descendrai pas en dessous de (euros) :</label>
<input type="number"  id="miseAPrix" name="miseAPrix"  value="${article.miseAPrix}" required> 
<input type="submit" value="Enregistrer">
</form>
<form method="POST" action="/Enchere-Eni/PageSuppressionVente">
<input type="submit" value="Supprimer">
</form>
<a href="/Enchere-Eni/PagesListeEncheresConnecte"><button>Retour � la liste des encheres</button></a>


</body>
</html>