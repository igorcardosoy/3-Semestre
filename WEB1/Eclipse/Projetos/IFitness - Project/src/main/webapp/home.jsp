<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	<link rel="stylesheet" href="css/home.css">
	<title>IFitness - Página Principal</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">IFitness</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link" href="activity-register.jsp">
	          	Nova Atividade</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">
	          	Estatísticas</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${name}
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">Minha Conta</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Sair</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-2" type="search" 
	        	placeholder="Pesquisar" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">
	        	Pesquisar</button>
	      </form>
	    </div>
	  </div>
	</nav>
	<div class="container">
		<div class="center col-lg-10 col-sm-12">
			<h1 class="text-center">Listagem de Atividades</h1>
			<c:choose>
				<c:when test="${fn:length(userActivities) > 0}">
					<table class="table table-striped table-hover table-responsive">
						<tr>
							<th>#</th>
							<th>Tipo</th>
							<th>Data</th>
							<th>Distância (km)</th>
							<th>Duração (minutos)</th>
							<th>Ações</th>
						</tr>
						<c:forEach var="activity" 
							items="${userActivities}" varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>
									<c:choose>
										<c:when test="${activity.type == 'CORRIDA'}">
											<img src="img/running_icon.png" alt="Corrida">
										</c:when>
										<c:when test="${activity.type == 'CAMINHADA'}">
											<img src="img/walking_icon.png" alt="Caminhada">
										</c:when>
										<c:when test="${activity.type == 'CICLISMO'}">
											<img src="img/cycling_icon.png" alt="Ciclismo">
										</c:when>
										<c:when test="${activity.type == 'NATACAO'}">
											<img src="img/swimming_icon.png" alt="Natação">
										</c:when>
									</c:choose>
								
								</td>
								<td>
									<fmt:parseDate value="${activity.date}" 
										pattern="yyyy-MM-dd" var="parsedDate"
										type="date" />
									<fmt:formatDate value="${parsedDate}" 
										var="formattedDate" type="date"
										pattern="dd/MM/yyyy"/>
									${formattedDate}
								</td>
								<td>${activity.distance}</td>
								<td>${activity.duration}</td>
								<td>
									<a class="btn" data-bs-toggle="tooltip" data-bs-placement="top" 
										title="Editar"
										href="activityRegister?action=update&activity-id=${activity.id}">
										<img src="img/pencil-square.svg" alt="Editar">
									</a>
									<a class="btn" data-bs-toggle="tooltip" data-bs-placement="top" 
										title="Remover"
										href="activityRegister?action=delete&activity-id=${activity.id}">
										<img src="img/trash.svg" alt="Remover">
									</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<c:out value="Nenhuma atividade cadastrada."></c:out>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/home.js"></script>
</body>
</html>