<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweelets - Login</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<center>
	<form action="FazerLogin" method="post">
		Login:<input type="text" id=login name=login> 
		Senha:<input type="password" id=senha name=senha>
		<button type="submit">Entrar</button>
	</form>
	</center>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>