
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
				<div class="well sidebar-nav" style="border-radius: 15px;">
					<ul class="nav nav-list">
						<li class="nav-header"><p>Tweetlet original</p></li>
						<li class="active" style="border-radius: 15px">
							<div id=tweetOriginal style="border-radius: 4px; width: 350px;">
								<label>${TweetAResponder.mensagem }</label> <br />
								<div id=tweetletOwner
									style="float: right; font-family: sans-serif; font-size: x-small;">
									${TweetAResponder.dono.login } <br /> ${TweetAResponder.data }
								</div>
								<br /> <br />
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!--/span-->
			<div class="span6">
				<div>
					<div class="hero-unit"
						style="width: 350px; height: 150px; border-radius: 15px; padding-top: 10px;">
						<div class="nav-header">
							<h6>Resposta</h6>
						</div>
						<form action="submeterRespostaTweetlet" method="post">
							<input type="hidden" value="${TweetAResponder.id }"
								id=tweetRespondidoID name=tweetRespondidoID>
							<textarea rows="5" cols="60" id="respostaTweetlet"
								name="respostaTweetlet" style="border-radius: 15px; width: 350px;"></textarea>
							<br>
							<button type="submit">Enviar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>

	<footer>
		<p>&copy;Triadworks 2012</p>
	</footer>


</body>
</html>
