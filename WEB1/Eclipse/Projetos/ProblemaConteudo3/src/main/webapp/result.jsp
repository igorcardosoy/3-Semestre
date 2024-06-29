<%@ 
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="java.util.List, br.edu.ifsp.arq.arqweb1.conteudo5.model.Person"
%>
	
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Listagem de Pessoas</title>
		<link rel="stylesheet" type="text/css" href="styles/global.css">
		<link rel="stylesheet" type="text/css" href="styles/table.css">
	</head>
	<body>
	    <main>
			<%List<Person> persons = (List<Person>) request.getAttribute("list"); %>
			
			<table>
				<tr>
					<th>Nome</th>
					<th>CPF</th>
					<th>E-mail</th>
				</tr>
			<% for(Person person: persons){ %>
	
			<tr>
				<td><%= person.getName() %></td>
				<td><%= person.getCpf() %></td>
				<td><%= person.getEmail() %></td>
			</tr>
			
			<% } %>
			
			
			</table>
		</main>
	</body>
</html>