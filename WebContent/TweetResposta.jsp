<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<center>
	<h3>Tweetlet a responder.</h3>
		<div id=tweetOriginal
			style="border-style: groove; border-radius: 4px; width: 500px;">
			<label>${TweetAResponder.mensagem }</label> <br />
			<div id=tweetletOwner
				style="float: right; font-family: sans-serif; font-size: x-small;">
				${TweetAResponder.dono.login } <br /> ${TweetAResponder.data }
			</div>
			<br /> <br />
		</div>
	</center>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>