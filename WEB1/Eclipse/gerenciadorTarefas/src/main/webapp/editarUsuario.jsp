<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="includes/authRequired.jsp" />
<c:import url="includes/header.jsp" />

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-danger" role="alert">${msg}</div>
    </c:if>

    <h1>Formulário de Usuários</h1>
    <form action="editarUsuario" method="post">
        <input type="hidden" name="id" value="${usuario.id}">
        <div class="row my-1 align-items-center">
            <div class="col-2">
                <label for="nome" class="form-label"> Nome: </label>
            </div>
            <div class="col-8">
                <input name="nome" class="form-control" value="${usuario.nome}">
            </div>
        </div>

        <div class="row my-1 align-items-center">
            <div class="col-2">
                <label for="email" class="form-label"> Email: </label>
            </div>
            <div class="col-8">
                <input name="email" class="form-control" value="${usuario.email}">
            </div>
        </div>

        <div class="row my-1 align-items-center">
            <div class="col-2">
                <label for="senha" class="form-label"> Senha: </label>
            </div>
            <div class="col-8">
                <input type="password" name="senha" class="form-control" value="${usuario.senha}">
            </div>
        </div>

        <button class="btn btn-primary">Enviar</button>
    </form>
</div>

<c:import url="includes/footer.jsp"></c:import>
