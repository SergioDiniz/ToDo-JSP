<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mtags" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Adicionar Contato</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/estilo.css" />
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>

	<div class="col-md-offset-3 col-md-6">
		
		<h2 class="text-center">Novo Contato</h2>
	
		<form action="adicionarContato" method="post">
			<div class="form-group">
				<label for="nome">Nome:</label>
		    	<input type="text" class="form-control input-lg" id="nome" name="nome" placeholder="Nome">
	    	</div>
	    	<div class="form-group">
				<label for="email">E-mail:</label>
		    	<input type="email" class="form-control input-lg" id="email" name="email" placeholder="E-mail">
	    	</div>
	    	<div class="form-group">
				<label for="endereco">Endereço:</label>
		    	<input type="text" class="form-control input-lg" id="endereco" name="endereco" placeholder="Endereço">
	    	</div>
	    	<div class="form-group">
				<label for="dataNascimento">Data de Nascimento:</label>
		    	<mtags:campoData placeholder="Data de Nascimento" id="dataNascimento"></mtags:campoData>
	    	</div>
			<input type="submit" class="btn btn-primary btn-lg" value="Gravar"/>
		</form>
	</div>
	

</body>
</html>