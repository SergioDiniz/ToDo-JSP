<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dao.*, beans.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Contatos</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>

	<div class="container">
		<h1>Listagem de Contato!</h1>

		<jsp:useBean id="dao" class="dao.ContatoDAO" />

		<table class="table table-striped">

			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereço</td>
				<td>Data de Nascimento</td>
			</tr>

			<c:forEach var="contato" items="${ dao.listar() }">
				<tr>
					<td>${ contato.nome }</td>
					<td><c:choose>
							<c:when test="${ not empty contato.email }">
								<a href="mailto:${ contato.email } " target="_blank">${ contato.email }</a>
							</c:when>
							<c:otherwise>
							Email não informado.
						</c:otherwise>
						</c:choose></td>
					<td>${ contato.endereco }</td>
					<td><fmt:formatDate value="${ contato.dataNascimento.time }" pattern="dd/MM/yyyy"/> </td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>