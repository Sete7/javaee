<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="shortcut icon" href="assets/images/favicon.png"
	type="image/x-icon">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body>
	<div class="container list-schedule">
		<div class="content__">
			<h1>Agenda de contatos</h1>
			<div>
				<a href="novo.html" class="btn-acesso">Novo contato</a> <a
					href="report" class="btn-acesso">Relatório</a>
			</div>
			<hr class="line">
			<table>
				<thead class="theader__">
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Telefone</th>
						<th>E-mail</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody class="tbody__">
					<%
						for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getFone()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>">Editar</a>
							<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)">Excluir</a>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

		</div>
	</div>

	<script src="assets/js/confirmador.js"></script>
</body>
</html>