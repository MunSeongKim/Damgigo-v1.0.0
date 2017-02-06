// Load the SDK asynchronously
/*(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s); js.id = id;
	js.src = "//connect.facebook.net/ko_KR/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));*/
(function(d){  
	var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];  
	if (d.getElementById(id)) {
		return ;
	}  
	js = d.createElement('script');
	js.id = id;
	js.async = true;  
	js.src = "//connect.facebook.net/ko_KR/all.js";
	ref.parentNode.insertBefore(js, ref);  
}(document));

//로그인 초기화 및 로그인 상태 점검
window.fbAsyncInit = function() {
	FB.init({
		appId      : '707596019409480',
		cookie     : true,  // enable cookies to allow the server to access 
							// the session
		xfbml      : true,  // parse social plugins on this page
		version    : 'v2.8' // use graph api version 2.8
	});
	
	FB.Event.subscribe('auth.logout', function(response) {
		document.location.reload();
	});
	//FB.Event.subscribe('auth.login', function(response) {
	//	signUpFacebook();
	//});
	//Now that we've initialized the JavaScript SDK, we call 
	//FB.getLoginStatus().  This function gets the state of the
	//person visiting this page and can return one of three states to
	//the callback you provide.  They can be:
	//
	//1. Logged into your app ('connected')
	//2. Logged into Facebook, but not your app ('not_authorized')
	//3. Not logged into Facebook and can't tell if they are logged into
	//your app or not.
	//
	//These three cases are handled in the callback function.
	//사이트 접속시 로그인 상태 확인
	FB.getLoginStatus(function(response) {
		console.log('Check the status in initializing');
		console.log(response);
		if (response.status === 'connected') {
			  // Logged into your app and Facebook.
			$('#menu ul li:last>a').remove();
			$('#menu ul li:last').append('<a href="#" onclick="FB.logout();">Sign Out</a>');
		} else if (response.status === 'not_authorized') {
		  // The person is logged into Facebook, but not your app.
		  //document.getElementById('status').innerHTML = 'Please log into this app.';
		} else {
		  // The person is not logged into Facebook, so we're not sure if
		  // they are logged into this app or not.
		  //document.getElementById('status').innerHTML = 'Please log into Facebook.';
		}
	});
};

function setUpModal(user){
	//Modal창 레이블, 루터 변경
	$('#modal-footer').text("");
	$('#modalLabel').text("추가정보");
	//사용자 정보 대입
	$('#email').text(user.email);
	$('#name').val(user.name);
	//Modal 내부 화면 변경
	$('#login').toggle();
	$('#addInform').toggle();
}

function handleRegisterUserInfo(user) {
	setUpModal(user);
	$('#cancel').click(function(){
		if( $('#addInform').css("display") != "none" ){
			FB.logout();
		}
	});
	
	$('#sendRegister').click(function() {
		var cls = $('input[name="classify"]:checked').val();
		var deptmt;
		var year;
		var pos;
		
		if( cls == "교직원" ){
			deptmt = $('#department').val();
			year = null;
			pos = $('#position').val();
		} else {
			deptmt = $('#major').val();
			year = $('#number').val();
			pos = null;
		}

		var userData = {
				id:user.id,
				password:null,
				name:user.name,
				email:user.email,
				classify: cls,
				department: deptmt,
				year: year,
				position: pos,
				type:"facebook"
		};
		
		$.ajax({
			url: "/user",
			type: 'POST',
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType:"text",
			data: JSON.stringify(userData),
			success: function(res) {
				document.location.reload();
				$('#menu ul li:last>a').remove();
				$('#menu ul li:last').append('<a href="#" onclick="FB.logout();">Sign Out</a>');
				return;
			},
			error: function(res, status, err){
				alert("Communication Server Error");
				console.log(res);
				return;
			}
		});
	});
}

//로그인한 사용자 정보 조회
function handleInquireUserInfo(){
	FB.api( '/me',
			'GET',
			{"fields":"id,name,email", "locale":"ko_KR"},
			function(user) {
				var url = "/user/" + user.id;
				
				$.ajax({
					url: url,
					type: 'GET',
					headers: {
						"Content-Type": "application/json",
						"X-HTTP-Method-Override" : "GET"
					},
					dataType:"json",
					success: function(res){
						if(res == true){
							$('#menu ul li:last>a').remove();
							$('#menu ul li:last').append('<a href="#" onclick="FB.logout();">Sign Out</a>');
							$('#signUpModal').modal("hide");
						} else {
							handleRegisterUserInfo(user);
						}
						return;
					},
					error: function(data, status, err) {
						alert("[Error]: Communication to server")
						return;
					}
				});
			});
}
/* callFacebookLogin() 사용으로 폐기
function signUpFacebook() {  
	// 페이스북 로그인 상태 체크
	FB.getLoginStatus(function(response){
		if (response.status === "connected") {
			// 페이스북 로그인 YES! and 앱 허가 YES!
			console.log("Clicked to button about Sign In");
			console.log(response);
			handleInquireUserInfo();
		} else if (response.status === "not_authorized") {
			alert("로그인 취소 되었습니다.");
		} else {	// 페이스북 로그아웃 상태.
		}
	});	
}
*/
function callFacebookLogin() {
	FB.login(function(response) {
		 if (response.status === 'connected') {
			 console.log("Clicked to button about Sign In");
			 console.log(response);
			 handleInquireUserInfo();
		 } else if (response.status === 'not_authorized') {
			 alert("로그인 취소 되었습니다.");
		 } else {
		    // The person is not logged into Facebook, so we're not sure if
		    // they are logged into this app or not.
		 }
	}, {scope: 'public_profile, email'});
}