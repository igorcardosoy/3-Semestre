<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon"
	href="https://cdn-icons-png.flaticon.com/512/2749/2749777.png"
	type="image/x-icon">
<title>IFitness - Página Principal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="styles/global.css" rel="stylesheet">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<header class="mb-4">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">


				<a class="navbar-brand" href="#"> <img class="me-2"
					alt="Icone Fit"
					src="https://cdn-icons-png.flaticon.com/512/2749/2749777.png"
					width="32" height="32"> IFitness
				</a>



				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<a class="navbar-brand" href="./activity-register.jsp">Adicionar Atividade</a>

					
				</div>

				<c:if test="${user.profilePicture != null}">
						<img class="rounded-circle" alt="Foto de perfil"
							src="${user.profilePicture}"
							width="32" height="32">
				</c:if>
				
				<c:if test="${user.profilePicture == null}">
					
				</c:if>
			</div>
		</nav>
	</header>

	<div class="container">
		<h1>Seja bem-vindo(a), ${user.name}</h1>
	</div>
</body>
</html>