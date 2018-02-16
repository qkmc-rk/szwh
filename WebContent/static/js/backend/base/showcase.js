var url_prefix = $("#contextPath")[0].value;

$(window).ready(function () {
	refreshVip();
	
	//监听切换按钮的状态
	$('#casetable').on('check.bs.table',function(row,elem){
		openBtns();
	});
	$('#casetable').on('uncheck.bs.table',function(row,elem){
		closeBtns();
	});
});


//选中case记录时切换按钮开启状态
function closeBtns(){
	$("#deletebtn").attr('disabled','disabled');
	$("#updatebtn").attr('disabled','disabled');
	$("#showbtn").attr('disabled','disabled');
}
function openBtns(){
	$('#deletebtn').removeAttr('disabled');
	$('#updatebtn').removeAttr('disabled');
	$('#showbtn').removeAttr('disabled');
}



//显示案列页面
function showCase(){
	var rows = $('#casetable').bootstrapTable('getSelections');
	//alert($(rows).last()[0].id);
	var id = $(rows).last()[0].id;
	window.open('article_show?id=' + id);
	
}

//删除案列
function deleteCase(){
	var rows = $('#casetable').bootstrapTable('getSelections');
	var id = $(rows).last()[0].id;
	
	//删除案列
	$.ajax({
		url : "delete/" + id,
		dataType : "json",
		type : "delete",
		success : function(data) {
			if (data.result === "false")
				alert("删除时发生了意想不到的错误!");
			if (data.result === "true")
				alert("删除成功!");
			 	$("#deleteModal").modal('hide');
			 	refreshVip();
			 	closeBtns();
		},
		error : function() {
			alert("出现了一些错误,请检查操作是否无误!")
		}
	});
}
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
//去修改页面
function toUpdate(){
	var rows = $('#casetable').bootstrapTable('getSelections');
	var id = $(rows).last()[0].id;
	window.open("update?id=" + id);
}

