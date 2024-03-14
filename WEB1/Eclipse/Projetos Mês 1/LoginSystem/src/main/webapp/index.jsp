<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="styles/global.css">
		<link rel="stylesheet" type="text/css" href="styles/form.css">
		<link rel="stylesheet" type="text/css" href="styles/loginPage.css">
	</head>
	<body>

		<header>
			<h1>Login</h1>
		</header>
	
		<main>

			<%
				if(request.getSession().getAttribute("user") != null) {
			%>
				<h2>Olá,<%= (request.getSession().getAttribute("user").toString()) %></h2>

				<a href="ServletLogout">Sair</a>
			<%	
				} else { 
			%>

				<section class="form-container">
					<form action="ServletLogin" method="post">
						<label for="persons">E-mail</label> 
						<input type="email"name="email" id="email" required="required"> 
						
						<br>
						
						<label for="password">Senha</label> 
						<input type="password" name="password" id="password" required="required">
	
						<button type="submit">Enviar</button>
					</form>
				</section>

			<%
				}
			%>
		</main>
		
		<footer>
			<h2>Contas Pré-definidas: </h2>
		<ul>
			<li>Usuário: igor@gmail.com</li>
			<li>Senha: 123456</li>
		</ul>

		<ul>
			<li>|</li>
		</ul>

			<ul>
				<li>Usuário:eduardo@gmail.com</li>
				<li>Senha: 654321</li>
			</ul>
	</footer>
</body>
</html>