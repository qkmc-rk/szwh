$(window).ready(function(){
	var width = $(window).width();
	document.getElementById("topcall").style.height = width/33 + "px";
});

$(window).resize(function(){
	var width = $(window).width();
	document.getElementById("topcall").style.height = width/33 + "px";
});