var printData;
//외부 스크립트를 JQuery로 호출하는 부분
//콜백으로 해당 스크립트 소스가 전달되어 사용됨. --> 익명함수를 변수에 담아 사용하는법 확인할것 꼭!!!
$.getScript("/js/handlebars.js", function() {alert("handlebars.js Load OK");

Handlebars.registerHelper("prettifyDate", function(timeValue){
	var dateObj = new Date(timeValue);
	var year = dateObj.getFullYear();
	var month = dateObj.getMonth() +1;
	var date = dateObj.getDate();
	return year + "-" + month + "-" + date;
});

	printData = function(replyArr, target, templateObject){
	var template = Handlebars.compile(templateObject.html());
	var html = template(replyArr);
	target.after(html);
}
});
/*
var bno = $('input[name="bno"]').val();

function getPageList(page){
	
	$.getJSON("/replies/" + bno + "/" + page, function(data){
		console.log(data.size);
		
		var str = "";
		
		printData(data.content, $("#wallmessages"), $("#timelineReply"));
		
		/*
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
});*/