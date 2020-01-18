<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>login</title>
	</head>
<body>
	<form action="<%=request.getContextPath()+"/ProvaP" %>" method="get">
		<label for="nome">Nome</label>
		<input type="text" name="nome" value="">
		<br>
		<label for="cognome">Cognome</label>
		<input type="text" name="cognome" value="">
		<br>
		<button type="submit" name="invia">Invia</button>
	</form>
	<br>
	<form action="<%=request.getContextPath()+"/ProvaP" %>" method="post">
		<label for="nome">Nome</label>
		<input type="text" name="nome" value="">
		<br>
		<label for="cognome">Cognome</label>
		<input type="text" name="cognome" value="">
		<br>
		<button type="submit" name="invia">Invia</button>
	</form>
	
	
</body>
</html>