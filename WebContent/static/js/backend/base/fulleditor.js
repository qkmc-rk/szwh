var E = window.wangEditor;
var editor = new E('#editor');
// 配置图片上传
var rootPath = $('#contextPath').val();
editor.customConfig.uploadImgServer = rootPath + "/upload/uploadimg";
editor.customConfig.uploadFileName = "img";
// alert((window.location.href).split("/szwh")[0] + rootPath +
// "/upload/uploadimg");
editor.customConfig.debug = true;
// 事件函数,修改相对路径
editor.customConfig.uploadImgHooks = {
	customInsert : function(insertImg, result, editor) {
		/*var url = (window.location.href).split("/szwh")[0] + rootPath*/ //if xxx/szwh
		var url = (window.location.href).split("/")[0] + rootPath
				+ result.data[0];
		// alert(url);
		insertImg(url);
	},
	fail : function(xhr, editor, result) {
		if (result.errno == -1) {
			alert("服务器没有接收到图片信息!");
		}
	}
}
editor.create();

// 获取案列上传案列方法
function getHtml() {
	// alert(editor.txt.html());
	return editor.txt.html();
}
function uploadHtml() {
	// 首先获取内容,然后使用jquery的ajax发送上传请求给服务器
	var editor = $("#userid").val();
	var title = $("#title").val();
	var type = $("#type").val();
	var origin = $("#origin").val();
	var content = getHtml();
	
	console.log(editor+ "   ----"  + title+ "   ----" + type+ "   ----" + origin+ "   ----" + content);
	origin = "手足文化";
	
	$.ajax({
		url : rootPath + "/case/add",
		dataType : "json",
		type : "post",
		data : {
			"editor" : editor,
			"title" : title,
			"type" : type,
			"origin" : origin,
			"content" : content
		},
		success : function(data) {
			if (data.result === "false")
				alert("上传出错,请检查时候完整填写!");
			if (data.result === "true")
				alert("上传完成!");
		},
		error : function() {
			alert("上传出错了!!!!检查一下填写的内容")
		}
	});
}





