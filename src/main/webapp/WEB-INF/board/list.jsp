<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<script>
		var result = '${msg}';
		
		if(result=='success'){
			alert("처리완료");
		}
	</script>
</head>

<body>
	<nav>
		<jsp:include page="../index/nav.jsp" flush="false" />
	</nav>

	<section id="body" class="col-lg-8 col-lg-offset-2">
		<div class="section-heading text-center">
			<br/>
			<h2 class="h-bold">BOARD LIST PAGE</h2>
		</div>
		<hr />
		<table class="table table-bordered">
			<tr>
				<th style="width: 10px">NO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th style="width: 40px">COUNT</th>
			</tr>
			
			<c:forEach items="${list.content}" var="board">
			<tr>
				<td>${board.bno}</td>
				<td><a href='/board/read?bno=${board.bno}&page=${list.number}'>${board.title}</a></td>
				<td>${board.writer}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}"/></td>
				<td><span class="badge bg-red">${board.viewcnt}</span></td>
			</tr>
			</c:forEach>
		</table>
	
		<nav>
		  	<ul class="pager">
		  		<c:if test="${!list.first }">
		    	<li class="previous">
		    		<a href="?page=${list.number-1 }"><span aria-hidden="true">&larr;</span> Previous</a>
		    	</li>
		    	</c:if>
		    	<c:if test="${!list.last }">
		    	<li class="next">
		    		<a href="?page=${list.number+1 }">Next <span aria-hidden="true">&rarr;</span></a>
		    	</li>
		    	</c:if>
			</ul>
		</nav>
	</section>
	<section class="box-footer col-lg-8 col-lg-offset-2">
		<a href="/board/register?page=${list.number}" class="btn btn-primary">Register</a>
	</section>	
</body>
</html>