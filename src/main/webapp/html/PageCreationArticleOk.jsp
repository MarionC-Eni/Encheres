<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Felicitation vous venez de créer un article</title>
</head>
<body>


<h1>Félicitations vous venez de créer un article</h1>


<c:if test="${article != null}">
<p>Article : ${article.nomArticle}</p>

</c:if>

<a href="/Enchere-Eni/PageModifierVente?noArticle=${noArticle}"><button>Modifier mon article</button></a>

<a href="/Enchere-Eni/PageSuppressionVente?noArticle=${noArticle}"><button>Supprimer mon article</button></a>

<a href="/Enchere-Eni/PagesAccueilNonConnecte"><button>Retour Menu Principal</button></a>
</body>
</html>