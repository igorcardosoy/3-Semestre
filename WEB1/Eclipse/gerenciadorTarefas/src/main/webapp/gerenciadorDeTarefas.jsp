<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="includes/header.jsp"/>

<div class="container">
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Descrição</th>
      <th scope="col"></th>  
    </tr>
  </thead>
  <tbody>
 
  	<c:if test="${not empty listaDeTarefas}">
		<c:forEach var="tarefa" items="${listaDeTarefas}">
		    <tr>
		      <th scope="row">${tarefa.id}</th>
		      <td>${tarefa.nome}</td>
		      <td>${tarefa.descricao}</td>
		      <td><a href="excluirTarefa?id=${tarefa.id}" 
		      		class="btn btn-danger"> Excluir </a></td>
      		  <td><a href="editarTarefa?id=${tarefa.id}" 
      		class="btn btn-warning"> Editar </a></td>
		    </tr>			
		</c:forEach>
	</c:if>
  
  </tbody>
</table>
</div>






<c:import url="includes/footer.jsp"/>
			
</body>
</html>