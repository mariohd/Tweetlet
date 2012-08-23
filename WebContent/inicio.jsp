<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel=StyleSheet href="css/inicio.css" type="text/css" media=screen>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweetlets - Inicio</title>
</head>
<body>
	<div>
		<c:import url="cabecalho.jsp"></c:import>
		<div id=mensagemBoasVindas>
			<label>${mensagemBoasVindas }</label>
		</div>
		<div id=menuNovoTweelet>
			<form action="submeterNovoTweetlet" method="post">
				<br /> Tweetlet! <br />
				<textarea rows="4" cols=40 id=novoTweetlet name=novoTweetlet style="border-radius: 10px"></textarea>
				<br />
				<button type="submit">Enviar</button>
			</form>
			<c:if test='${respostaEnvio != null }'>
				<label id=afirmativa>${respostaEnvio }</label>
			</c:if>
		</div>
	</div>
	<div id=listaTweetlets>
		<c:import url="timelineTweetlets.jsp" />
	</div>
	<!-- 						<div> -->
	<%-- 							<c:import url="rodape.jsp"></c:import> --%>
	<!-- 						</div> -->
</body>
</html>