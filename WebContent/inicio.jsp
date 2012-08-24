
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Tweetlet!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 60px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<link rel=StyleSheet href="css/timeline.css" type="text/css"
	media=screen>
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
</head>

<body>

<c:import url="cabecalho.jsp"></c:import>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span4">
				<div class="well sidebar-nav"
					style="border-radius: 15px; position: fixed">
					<ul class="nav nav-list">
						<li class="nav-header"><p>Novo tweetlet</p></li>
						<li class="active" style="border-radius: 15px">
							<form action="submeterNovoTweetlet" method="post">
								<textarea rows="5" cols="60" id="novoTweetlet"
									name="novoTweetlet"
									style="border-radius: 15px; height: 100px; width: 350px;"></textarea>
								<br>
								<button type="submit">Enviar</button>
							</form>
						</li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span5">
				<c:forEach var="tweet" items="${tweets }">
					<div>
						<div class="hero-unit">
							<div id=tweetletBody>
								<p>${tweet.mensagem }
								<p>
							</div>
							<div id=tweetletOwner>
								${tweet.dono.login } <br /> ${tweet.data }
							</div>
							<c:if test="${resposta == true }">
								Em resposta ao ${idRespondido }
							</c:if>
							<c:if test="${tweet.mensagem != 'Nenhum Tweetlet ainda.'}">
								<div id=acoesTweetlet>
									<form method="post" action="retweeter"
										style="float: left; padding-right: 2px">
										<input type="hidden" value="${tweet.id }" id=tweetId
											name=tweetId>
										<button type="submit" class=retweet>
											<i class="icon-share"></i>
										</button>
									</form>
									<form method="post" action="responderTweet" style="float: left">
										<input type="hidden" value="${tweet.id }" id=tweetId
											name=tweetId>
										<button type="submit">
											<i class="icon-edit"></i>
										</button>
									</form>
								</div>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<hr>

	<footer>
		<p>&copy;Triadworks 2012</p>
	</footer>

	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery.js"></script>
	<script src="../assets/js/bootstrap-transition.js"></script>
	<script src="../assets/js/bootstrap-alert.js"></script>
	<script src="../assets/js/bootstrap-modal.js"></script>
	<script src="../assets/js/bootstrap-dropdown.js"></script>
	<script src="../assets/js/bootstrap-scrollspy.js"></script>
	<script src="../assets/js/bootstrap-tab.js"></script>
	<script src="../assets/js/bootstrap-tooltip.js"></script>
	<script src="../assets/js/bootstrap-popover.js"></script>
	<script src="../assets/js/bootstrap-button.js"></script>
	<script src="../assets/js/bootstrap-collapse.js"></script>
	<script src="../assets/js/bootstrap-carousel.js"></script>
	<script src="../assets/js/bootstrap-typeahead.js"></script>

</body>
</html>
