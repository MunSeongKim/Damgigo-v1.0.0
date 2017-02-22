<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Board Testing</title>

	<!-- css -->
	<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="/css/nivo-lightbox.css" rel="stylesheet" />
	<link href="/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
	<link href="/css/owl.carousel.css" rel="stylesheet" media="screen" />
	<link href="/css/owl.theme.css" rel="stylesheet" media="screen" />
	<link href="/css/flexslider.css" rel="stylesheet" />
	<link href="/css/animate.css" rel="stylesheet" />
	<link href="/css/style.css" rel="stylesheet">
	<link href="/color/default.css" rel="stylesheet">
	
	<style>
		#modDiv {
			width: 300px;
			height: 100px;
			background-color: gray;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-top: -50px;
			margin-left: -150px;
			padding: 10px;
			z-index: 1000;
		}
	</style>
</head>

<body>
	<nav>
		<jsp:include page="../index/nav.jsp" flush="false" />
	</nav>

	<section id="body">
		<div>
			<div>
				REPLYER <input type="text" name="replyer" id="newReplyer" />
			</div>
			<div>
				REPLY TEXT <input type="text" name="replytext" id="newReplytext" />
			</div>
			<button id="replyAddBtn">ADD REPLY</button>
		</div>
		<hr />
		<ul id="replies">
		</ul>
	</section>

	<nav>
	  	<ul class="pager">
		</ul>
	</nav>	

	<div id="modDiv" style="display:none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext" />
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">Delete</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>
	

	
	<script src="/js/jquery.min.js"></script>	 
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>
	<script src="/js/jquery.flexslider-min.js"></script>
	<script src="/js/jquery.easing.min.js"></script>	
	<script src="/js/jquery.scrollTo.js"></script>
	<script src="/js/jquery.appear.js"></script>
	<script src="/js/stellar.js"></script>
	<script src="/js/wow.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/nivo-lightbox.min.js"></script>
	<script src="/js/custom.js"></script>
	<script src="/js/script.js"></script>
	<script src="/js/event.reply.js"></script>
	
</body>
</html>