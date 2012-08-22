<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel=StyleSheet href="css/entrar.css" type="text/css" media=screen>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweetlets - Inicio</title>
</head>
<body>
	<div id=mensagemBoasVindas>
		<label>${mensagemBoasVindas }</label>
	</div>
	<div id=menuNovoTweelet>
		<form action="submeterNovoTweetlet" method="post">
			<center>
				<br /> Tweetlet! <br />
				<textarea rows="4" cols=40 id=novoTweetlet name=novoTweetlet></textarea>
				<br />
				<button type="submit">Enviar</button>
			</center>
		</form>
	</div>
	<div id=listaTweetlets>
		<c:import url="leituratweetlets.jsp" />
	</div>
	<c:if test='${respostaEnvio != null }'>
		<label id=afirmativa>${respostaEnvio }</label>
	</c:if>
</body>
</html>