//<![CDATA[
// 사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('ec15afcc345cbd69b93ea608830316df');
//]]>

function callKakaoLogin(){
	 Kakao.Auth.login({
	    success: function(authObj) {
	    	Kakao.API.request({
	            url: '/v1/user/me',
	            success: function(res) {
	              alert(JSON.stringify(res));
	            },
	            fail: function(error) {
	              alert(JSON.stringify(error));
	            }
	          });
	    },
	    fail: function(err) {
	      alert(JSON.stringify(err));
	    }
	  });
}


$(document).ready(function(){
	$('#kakao-logout').click(function(){
		Kakao.Auth.logout(function() {
			document.location.reload();
		});
	});
});
