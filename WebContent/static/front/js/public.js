$(window).ready(function(){
	var width = $(window).width();
	document.getElementById("topcall").style.height = width/33 + "px";
	
	//监听logo hover 事件
	$(".Index_top_1_1_1").hover(
		function(){
			$(".logoimg").attr("src","static/front/images/logo2.jpg");
		},
		function(){
			$(".logoimg").attr("src","static/front/images/logo.jpg");
		}
	);
});

$(window).resize(function(){
	var width = $(window).width();
	document.getElementById("topcall").style.height = width/33 + "px";
});