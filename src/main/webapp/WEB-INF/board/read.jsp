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
	
</head>

<body>
	<nav>
		<jsp:include page="../index/nav.jsp" flush="false" />
	</nav>
	
	<section id="body">
		<form role="form" method="post">
			<input type="hidden" name="bno" value="${board.bno}" />
			<input type="hidden" name="page" value="${page}" />
		</form>
		
		<div class="box-body">
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" name="title" class="form-control" value="${board.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" name="content" rows="3" readonly="readonly">
					${board.content}
				</textarea>
			</div>
			<div class="form-group">
				<label for="writer">Writer</label>
				<input type="text" name="writer" class="form-control" value="${board.writer}" readonly="readonly">
			</div>
		</div>
		<!-- /.box-body -->
		
		<div class="box-footer">
			<button type="submit" class="btn btn-warning">Modify</button>
			<button type="submit" class="btn btn-danger">Remove</button>
			<button type="submit" class="btn btn-primary">List</button>
		</div>
	</section>
	
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
	<script>
		$(document).ready(function(){
			var formObj = $("form[role='form']");
			
			$(".btn-warning").click(function(){
				formObj.attr("action", "/board/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			
			$(".btn-danger").click(function(){
				formObj.attr("action", "/board/remove");
				formObj.submit();
			});
			
			$(".btn-primary").click(function(){
				formObj.find("[name='bno']").remove();
				
				formObj.attr("method", "get");
				formObj.attr("action", "/board/list");
				formObj.submit();
			});
		});
	</script>
</body>
</html>