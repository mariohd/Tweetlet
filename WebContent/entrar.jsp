<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel=StyleSheet href="css/entrar.css" type="text/css" media=screen> -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweelets - Login</title>
</head>
<!-- <body style="background-color: #48D1CC;"> -->
<body>
	<div id=container-fluid>
		<c:import url="cabecalho.jsp"></c:import>
		<center>
			<div class=row-fluid>
				<form action="FazerLogin" method="post">
					Login:<input type="text" id=login name=login
						style="border-radius: 10px"> <br /> Senha:<input
						type="password" id=senha name=senha style="border-radius: 10px">
						<br/>
					<button type="submit">Entrar</button>
				</form>
				<c:import url="rodape.jsp"></c:import>
			</div>	
		</center>
	</div>
</body>
</html>