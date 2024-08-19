<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Scriptlet</title>
</head>
<body>

	<%
		int a = 5;
		int b = 10;
		int soma = a + b;	
	%>
	
	<h2> Exemplo de Scriptlet </h2>
	
	<p>  <%= a %> + <%= b %> = <%= soma %> </p>

</body>
</html>