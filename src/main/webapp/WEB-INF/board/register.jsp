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
	
	<section id="body" class="col-lg-8 col-lg-offset-2">
		<div class="section-heading text-center">
			<h2 class="h-bold">BOARD REGISTER</h2>
		</div>
		<form role="form" method="post">	
			<input type="hidden" name="page" value="${page}" />
			<div class="box-body">
				<div class="form-group">
					<label for="title">Title</label>
					<input type="text" name="title" class="form-control" placeholder="Enter Title" />
				</div>
				<div class="form-group">
					<label for="content">Content</label>
					<textarea class="form-control" name="content" rows="3" placeholder="Enter ..."></textarea>
				</div>
				<div class="form-group">
					<label for="writer">Writer</label>
					<input type="text" name="writer" class="form-control" placeholder="Enter Writer" />
				</div>
			</div>
			<!-- /.box-body -->
		</form>
	</section>
	<section class="box-footer col-lg-8 col-lg-offset-2">
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="submit" class="btn btn-warning">Cancel</button>
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
				 self.location = "/board/list?page=${page}";
			});
						
			$(".btn-primary").click(function(){
				formObj.submit();
			});
		});
	</script>
</body>
</html>