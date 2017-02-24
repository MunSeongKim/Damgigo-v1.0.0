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
	<link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="/css/nivo-lightbox.css" rel="stylesheet">
	<link href="/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css">
	<link href="/css/owl.carousel.css" rel="stylesheet" media="screen">
	<link href="/css/owl.theme.css" rel="stylesheet" media="screen">
	<link href="/css/flexslider.css" rel="stylesheet">
	<link href="/css/animate.css" rel="stylesheet">
	<link href="/css/style.css" rel="stylesheet">
	<link href="/css/timeline.css" rel="stylesheet">
	<link href="/color/default.css" rel="stylesheet">
	
</head>

<body>
	<nav>
		<jsp:include page="../index/nav.jsp" flush="false" />
	</nav>
	
	<section id="boardRead" class="col-lg-8 col-lg-offset-2">
		<div class="row">
			<div class="box-header section-heading text-center margintop-20">
				<h2 class="h-bold">BOARD READ PAGE</h2>
			</div>
			
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
				<button type="submit" class="btn btn-warning" id="modifyBoard">Modify</button>
				<button type="submit" class="btn btn-danger" id="removeBoard">Remove</button>
				<button type="submit" class="btn btn-primary" id="goList">List</button>
			</div>
		</div>
	</section>
	
	<section id="replyRegist" class="col-lg-8 col-lg-offset-2">
		<div class="row">
			<div class="box-header">
				<p class="lead marginbot-10 margintop-30">ADD NEW REPLY</p>
			</div>
			<div class="box-body">
				<div class="form-group">
					<label for="replyer">Writer</label>
					<input class="form-control" type="text" placeholder="USERID" id="newReplyer" />
				</div>
				<div class="form-group">
					<label for="replytext">Reply Text</label>
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText" />
				</div>
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
			</div>
		</div>
	</section>
	
	<section id="replyTimeline" class="col-lg-8 col-lg-offset-2">
		<div class="row">
			<p class="lead marginbot-10 margintop-30">Replies List 
				<span><a class="btn-link" id="replyShow"><i class="fa fa-comments" aria-hidden="true"></i><small> show replies</small></a></span></p> 
		
		    <div class="qa-message-list" id="wallmessages">
				<!-- Timeline item -->
				<script id="timelineReply" type="text/x-handlebars-template">
				{{#each .}}
				<div class="message-item" data-rno={{rno}}>
					<div class="message-inner">
						<div class="message-head clearfix">
							<div class="user-detail">
								<h5 class="handle"><strong>{{rno}}</strong> - {{replyer}}</h5>
								<div class="post-meta">
									<div class="asker-meta">
										<span class="qa-message-what"><i class="fa fa-clock-o"></i></span>
										<span class="qa-message-when">
											<span class="qa-message-when-data">{{prettifyDate regdate}}</span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="qa-message-content">
							{{replytext}}
							
						</div>
						<div class="message-modify margintop-10">
							<button class="btn btn-primary btn-xs modifyMainBtn" data-toggle="modal" data-target="#modifyModal">Modify</button>
						</div>
					</div>
				</div>
				{{/each}}
				</script>
				<!-- /.Timeline item end -->
			</div>
		</div>
		<nav class="text-center">
		  	<ul class="pager">
			</ul>
		</nav>
	</section>
	
	<!--  Modal -->
	<div id="modifyModal" class="modal modal-primary fade margintop-100" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<!--  Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-rno>
					<p><input type="text" id="replytext" class="form-control"/></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">Delete</button>
					<button type="button" class="btn-link" data-dismiss="modal">Close</button>
				</div>
			</div>
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
	
	<!-- <Script src="/js/handlebars.extend.js"></Script> -->
	<Script src="/js/event.reply.js"></Script>
	<script>
		$(document).ready(function(){
			var formObj = $("form[role='form']");
			
			$("#modifyBoard").click(function(){
				formObj.attr("action", "/board/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			
			$("#removeBoard").click(function(){
				formObj.attr("action", "/board/remove");
				formObj.submit();
			});
			
			$("#goList").click(function(){
				formObj.find("[name='bno']").remove();
				
				formObj.attr("method", "get");
				formObj.attr("action", "/board/list");
				formObj.submit();
			});
		});
	</script>
</body>
</html>