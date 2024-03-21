<%@ 
	page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, br.edu.ifsp.arq.arqweb1.conteudo5.model.Person"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<table>
					<tr>
						<th>#</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>E-mail</th>
					</tr>

					<c:forEach var="person" items="${list}">
						<tr>
							<td>${count.count + 1}</td>
							<td>${person.name}</td>
							<td>${person.cpf}</td>
							<td>${person.email}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<c:out value="Nenhuma pessoa encontrada" />
				<p>Nenhuma pessoa encontrada</p>
			</c:otherwise>
		</c:choose>


	</main>
</body>
</html>