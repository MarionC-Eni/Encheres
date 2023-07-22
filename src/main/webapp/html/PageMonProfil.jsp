<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PageMonProfil</title>
</head>
<body>
<%String identifiant = request.getParameter("Identifiant"); %>
<h1>PageMonProfil de <%=identifiant%></h1>
</body>
</html>