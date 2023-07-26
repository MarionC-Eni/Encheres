<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PageProfil</title>
</head>
<body>
<h1>PageProfil</h1>
<!-- On utilise des expression language pour ne pas melanger le java du html qui nous permet de recupérer les attributs dans la servlet PageMonProfil -->
<!-- Voila à quoi sert le setAttribute -->
<c:if test="${utilisateur != null}">
<p>Nom : ${utilisateur.nom}</p>
<p>Prenom : ${utilisateur.prenom}</p>
<p>Rue : ${utilisateur.rue}</p>
<p>Ville : ${utilisateur.ville}</p>
<p>Code Postal : ${utilisateur.codePostal}</p>
<p>Email : ${utilisateur.email}</p>
<p>Pseudo : ${utilisateur.pseudo}</p> 
<p>Mot de Passe : ${utilisateur.motDePasse}</p>
<p>Telephone : ${utilisateur.telephone}</p>
</c:if>
<c:if test="${utilisateur == null}">
<p>Utilisateur non trouvé</p>
</c:if>
<a href="/Enchere-Eni/PageModifierProfil"><button>Modifier</button></a>
</body>
</html>
