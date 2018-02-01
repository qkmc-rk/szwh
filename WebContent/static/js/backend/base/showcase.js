var url_prefix = $("#contextPath")[0].value;

$(window).ready(function () {
	refreshVip();
});
//在这里定义加载数据到bootstraptable
function refreshVip(){
	//直接发送ajax获取数据.
	$.ajax({
		type:"get",
		url:url_prefix + "/case/allftd",
		async:true,
		dataType:'json',
		success:function(data){
			// alert("调试信息:读取数据成功" + data);
			$('#casetable').bootstrapTable('load',data);
		}
	});
}
			