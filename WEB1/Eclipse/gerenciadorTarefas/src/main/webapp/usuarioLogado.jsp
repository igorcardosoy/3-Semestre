<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="includes/header.jsp" />

<div class="container">
	<c:choose>
		<c:when test="${empty usuario}">
			<c:redirect url="login.jsp" />
		</c:when>
		<c:otherwise>
			<div class="row my-1 align-items-center">
				<div class="col-xs-12 col-sm-12 col-md-2">
					<label for="nome" class="form-label"> Nome: </label>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-10">
					<input name="nome" class="form-control" value=${usuario.nome }
						readonly>
				</div>
			</div>
			<div class="row my-1 align-items-center">
				<div class="col-xs-12 col-sm-12 col-md-2">
					<label for="email" class="form-label"> Email: </label>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-10">
					<input name="email" class="form-control" value=${usuario.email }
						readonly>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<c:import url="includes/footer.jsp"></c:import>
