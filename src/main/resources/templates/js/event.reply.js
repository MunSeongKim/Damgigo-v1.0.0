var bno = 123;

function getAllList(){
	var str = "";
	$.getJSON("/replies/all/" + bno, function(data){
		console.log(data.length);
		
		$(data).each(function(){
			str += "<li data-rno='" + this.rno + "' class='replyLi'>"
				+ this.rno + ":" + this.replytext
				+ "<button>MOD</button></li>" ;
		});
		
		$("#replies").html(str);
	});
}

function getPageList(page){
	
	$.getJSON("/replies/" + bno + "/" + page, function(data){
		console.log(data.size);
		
		var str = "";
		
		$(data.content).each(function(){
			str += "<li data-rno='" + this.rno + "' class='replyLi'>"
				+ this.rno + ":" + this.replytext +
				"<button>MOD</button></li>";
		});
		
		$("#replies").html(str);
		
		str = "";
		//pager 출력 부분
		if(!data.first){
			str += "<li class='previous'>" +
				"<a href='" + (Number(data.number)-1) + "'><span aria-hidden='true'>&larr;</span> Previous</a>" +
				"</li>"
		}
		
		if(!data.last){
			str += "<li class='next'>" +
			"<a href='" + (Number(data.number)+1) + "'>Next <span aria-hidden='true'>&rarr;</span></a>" +
			"</li>"
		}
		
		$(".pager").html(str);
	});
}

$(document).ready(function(){
	getPageList(0);
	
	$("#replyAddBtn").click(function(){
		var replyer = $("#newReplyer").val();
		var replytext = $("#newReplytext").val();
		
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
					getAllList();
				}
			}
		});
	});
	
	$("#replies").on("click", ".replyLi button", function(){
		var reply = $(this).parent();
		
		var rno = reply.attr("data-rno");
		var replytext = reply.text().split(":");
		
		$(".modal-title").html(rno);
		$("#replytext").val(replytext[1].replace(/MOD/gi, ""));
		$("#modDiv").show("slow");
	});
	
	$("#closeBtn").click(function(){
		$(".model-title").html("");
		$("#replytext").val("");
		$("#modDiv").hide("slow");
	});
	
	$("#replyDelBtn").click(function(){
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
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
					$("#modDiv").hide("slow");
					getAllList();
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
					$("#modDiv").hide("slow");
					getAllList();
				}
			}
		});
	});
	
	$(".pager").on("click", "li a", function(event){
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		getPageList(replyPage);
	});
});
