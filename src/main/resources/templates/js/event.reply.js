var bno = $('input[name="bno"]').val();

//외부 스크립트를 JQuery로 호출하는 부분
//콜백으로 해당 스크립트 소스가 전달되어 사용됨.
$.getScript("/js/handlebars.extend.js", function() {
	getPageList = function(page){
		$.getJSON("/replies/" + bno + "/" + page, function(data){
			console.log(data.size);
			
			printData(data.content, $("#wallmessages"), $("#timelineReply"));
			
			if(!data.last){
				var str = "<li class='next'>" +
				"<a href='" + (Number(data.number)+1) + "'>Next <span aria-hidden='true'>&rarr;</span></a>" +
				"</li>"
			}
			
			$(".pager").html(str);
		});
	}	
});

/* Function based on event */
$(document).ready(function(){
	$("#replyShow").click(function(){
		if($(".message-item").size() > 1){
			return;
		} else {
			getPageList(0);
			$(this).hide();
		}
	});
	
	$(".pager").on("click", "li a", function(event){
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		getPageList(replyPage);
	});
	
	$("#replyAddBtn").click(function(){
		var replyer = $("#newReplyer").val();
		var replytext = $("#newReplyText").val();
		
		$.ajax({
			type: 'POST',
			url: '/replies',
			headers: {
				"Content-type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: 'text',
			data: JSON.stringify({
				bno: bno,
				replyer: replyer,
				replytext: replytext
			}),
			success: function(result){
				if(result == 'SUCCESS'){
					alert("등록 되었습니다.");
					$("#newReplyer").val("");
					$("#newReplyText").val("");

					$("#replyShow").hide();
				
					$(".message-item").remove();
					getPageList(0);
				}
			}
		});
	});
	
	$(".qa-message-list").on("click", ".modifyMainBtn", function(event){
		var reply = $(this).closest(".message-item");
		
		$("#replytext").val(reply.find(".qa-message-content").text());
		$(".modal-title").html(reply.attr("data-rno"));
	});
	
	$("#replyDelBtn").click(function(){
		var rno = $(".modal-title").html();
		
		$.ajax({
			type: "DELETE",
			url: "/replies/" + rno,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType: "text",
			success: function(result){
				console.log("result: " + result);
				if( result == "SUCCESS" ){
					alert("삭제되었습니다.");
					$(".message-item").remove();
					getPageList(0);
					$("#modifyModal").modal("hide");
				}
			}
		});
	});
	
	$("#replyModBtn").click(function(){
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
		$.ajax({
			type: "PUT",
			url: "/replies/" + rno,
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "PUT"
			},
			data: JSON.stringify({replytext:replytext}),
			dataType: "text",
			success: function(result){
				console.log("result: " + result);
				if( result == "SUCCESS" ){
					alert("수정되었습니다.");
					$(".message-item").remove();
					getPageList(0);
					$("#modifyModal").modal("hide");
				}
			}
		});
	});
	
	
});