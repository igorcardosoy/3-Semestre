<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="includes/header.jsp" />

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-danger" role="alert">${msg}</div>
    </c:if>

    <h1>Formulário de Usuários</h1>
    <form action="adicionarUsuario" method="post">
        <div class="row my-1 align-items-center">
            <div class="col-xs-12 col-sm-12 col-md-2">
                <label for="nome" class="form-label"> Nome: </label>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-10">
                <input name="nome" class="form-control">
            </div>
        </div>

        <div class="row my-1 align-items-center">
            <div class="col-xs-12 col-sm-12 col-md-2">
                <label for="email" class="form-label"> Email: </label>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-10">
                <input name="email" class="form-control">
            </div>
        </div>

        <div class="row my-1 align-items-center">
            <div class="col-xs-12 col-sm-12 col-md-2">
                <label for="senha" class="form-label"> Senha: </label>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-10">
                <input type="password" name="senha" class="form-control">
            </div>
        </div>

        <div class="row align-items-center">
            <div class="col-12">
                <button class="btn btn-primary">Enviar</button>
            </div>
        </div>
    </form>
</div>

<c:import url="includes/footer.jsp"></c:import>
