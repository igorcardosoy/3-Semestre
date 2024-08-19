<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="includes/header.jsp" />

<div class="container">

	<c:if test="${not empty msg }">
		<div class="alert alert-danger" role="alert">${msg}</div>
	</c:if>


	<h1>Formulário de Tarefas</h1>
	<form action="editarTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}">
		<div class="row my-1 align-items-center">
			<div class="col-2">
				<label for="nome" class="form-label"> Nome: </label>
			</div>
			<div class="col-8">
				<input name="nome" class="form-control" value="${tarefa.nome}">
			</div>
		</div>

		<div class="row my-1 align-items-center">
			<div class="col-2">
				<label for="texto" class="form-label"> Texto: </label>
			</div>
			<div class="col-8">
				<textarea rows="5" name="texto" class="form-control">${tarefa.descricao}</textarea>
			</div>
		</div>

		<button class="btn btn-primary">Enviar</button>
	</form>
</div>

<c:import url="includes/footer.jsp"></c:import>