<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PageProfil</title>
</head>
<body>
<h1>PageProfil</h1>

    <c:if test="${utilisateur != null}">
        <p>Nom : ${utilisateur.nom}</p>
        <p>Adresse : ${utilisateur.adresse}</p>
        <p>Email : ${utilisateur.email}</p>
    </c:if>
    <c:if test="${utilisateur == null}">
        <p>Utilisateur non trouv�</p>
    </c:if>
</body>
</html>