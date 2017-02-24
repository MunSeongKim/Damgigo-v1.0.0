//외부 스크립트를 JQuery로 호출하는 부분
//콜백으로 해당 스크립트 소스가 전달되어 사용됨.
$.getScript("/js/handlebars.js", function() {
	Handlebars.registerHelper("prettifyDate", function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() +1;
		var date = dateObj.getDate();
		var hours = dateObj.getHours();
		var min = dateObj.getMinutes();
		var sec = dateObj.getSeconds();
		return year + "-" + month + "-" + date + " " + hours + ":" + min + ":" + sec;
	});

	printData = function(replyArr, target, templateObject){
		var template = Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		target.append(html);
	}
});