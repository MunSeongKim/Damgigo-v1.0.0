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
			
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</section>
</body>
</html>