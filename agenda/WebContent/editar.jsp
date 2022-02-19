<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link rel="shortcut icon" href="assets/images/favicon.png"
	type="image/x-icon">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body>
	<div class="main__">
		<div class="container__">
			<div class="form-schedule">

				<div class="title">
					<h1>Editar contato</h1>
				</div>
				<form name="frmContato" action="update">
					<div class="group col-idcon__">
						<input type="hidden" id="idcon__" readonly name="idcon"
							value="<%out.print(request.getAttribute("idcon"));%>" />
					</div>
					<div class="group">
						<input type="text" name="nome"
							value="<%out.print(request.getAttribute("nome"));%>" />
					</div>
					<div class="group col-fone">
						<input type="text" name="fone"
							value="<%out.print(request.getAttribute("fone"));%>" />
					</div>
					<div class="group col-email__">
						<input type="email" id="email__" readonly name="email"
							value="<%out.print(request.getAttribute("email"));%>" />
					</div>
					<input type="submit" class="btn-submit" value="Atualizar"
						onclick="validar()" />
				</form>
			</div>
		</div>
	</div>
	<script src="assets/js/validador.js"></script>
</body>
</html>