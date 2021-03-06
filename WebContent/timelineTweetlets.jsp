<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel=StyleSheet href="css/timeline.css" type="text/css"
	media=screen>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=todosTweetlets>
		<c:forEach var="tweet" items="${tweets }">
			<div id=TweetletCompleto>
				<div id=tweetletBody>${tweet.mensagem }</div>
				<br />
				<div id=tweetletOwner>
				<c:if test="${resposta != null}"></c:if>
					${tweet.dono.login } <br /> ${tweet.data }
				</div>
				<br /> <br />
				<div id=acoesTweetlet>
					<form method="post" action="retweeter">
						<input type="hidden" value="${tweet.id }" id=tweetId name=tweetId>
						<button type="submit" class=retweet>
							<i class="icon-share"></i>
						</button>
					</form>
					<form method="post" action="responderTweet">
						<input type="hidden" value="${tweet.id }" id=tweetId name=tweetId>
						<button type="submit">
							<i class="icon-edit"></i>
						</button>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>