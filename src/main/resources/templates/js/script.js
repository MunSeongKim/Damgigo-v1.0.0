$(document).ready(function(){
	function setUpYear(){
		for(var i = 1970; i <= 2017; i++){
			var output = '';
			output += "<option value=" + i + ">" + i + "</option>";
			$('select[name="year"]').append(output);
		}
	}
	setUpYear();
	
	$('#addInform').hide();
	$('#clickTeacher').hide();
	
	$('input[type="classify"]').click(function(){
		if( $(this).val() == "교직원" ){
			$('#clickNotTeacher').hide();
			$('#clickTeacher').show();
		} else {
			$('#clickNotTeacher').show();
			$('#clickTeacher').hide();
		}
	});
	
	var source;
	$("img.sns").hover(function(){
		source = $(this).attr("src");
		var subSource = source.substr(0, 15);
		change = subSource + "_ov.png"
			$(this).attr("src", change);
		},
		function(){
			$(this).attr("src", source);
	});
});
