
var initNaverInform = new naver_id_login("yQ9_7E8fO3zbT4EyHsoF", "http://localhost:8080/");

function callNaverLogin(){
    $.ajax({
		url: "https://nid.naver.com/oauth2.0/authorize",
		type: 'GET',
		headers: {
			"Content-Type": "application/x-www-form-urlencoded",
			"X-HTTP-Method-Override" : "GET"
		},
		dataType:"text",
		data: {
			"response_type":"code",
			"client_id":encodeURIComponent("yQ9_7E8fO3zbT4EyHsoF"),
			"redirect_uri": encodeURIComponent("http://localhost:8080/"),
			"state": String(initNaverInform.getUniqState())
		},
		success: function(res){
			console.log(res);
			$('#signUpModal').modal("hide");
		},
		error: function(data, status, err) {
			alert("[Error]: Communication to server")
			return;
		}
	});
}
