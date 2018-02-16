function update(){
	
	var id = $("#id").val();
	var type = $("#type").val();
	var title = $("#title").val();
	var click = $("#click").val();
	var origin = $("#origin").val();
	var content = editor.txt.html();
	alert(id + "\n" + type + title + click + origin);
	//请求更新
	$.ajax({
		url : "update/" + id,
		dataType : "json",
		type:"get",
		data:{
			"origin":origin,
			"type":type,
			"title":title,
			"click":click,
			"content":content,
		},
		type : "post",
		success : function(data) {
			if (data.result === "false")
				alert("更新时出现错误");
			if (data.result === "true")
				alert("更新成功!");
			window.close();
		},
		error : function(data) {
			alert("非法操作!!!" + data);
		}
	});
	
}