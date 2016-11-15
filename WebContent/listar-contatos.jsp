<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dao.*, beans.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Listagem de Contato!</h1>
	
	<table>
	
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data de Nascimento</td>
		</tr>
	
		<% 
			ContatoDAO contatoDAO = new ContatoDAO();
			List<Contato> contatos =  contatoDAO.listar();
			
			for(Contato contato : contatos){
		%>
			<tr>
				<td><%= contato.getNome() %></td>
				<td><%= contato.getEmail() %></td>
				<td><%= contato.getEndereco() %></td>
				<td><%= contato.getDataNascimento().getTime() %></td>
			</tr>
		<% 
			}
		%>
		
	</table>

</body>
</html>