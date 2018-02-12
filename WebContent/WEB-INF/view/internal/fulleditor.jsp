<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>cnbtl - 案列增加</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<!--引入css-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/bootstrap-theme.min.css"/>
		<!--一些自定义的样式-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/styles.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/base/index.css"/>
		<!--引入js-->
		<script src="<%= request.getContextPath() %>/static/js/backend/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/js/backend/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/js/backend/wangEditor.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<%= request.getContextPath() %>/admin/main"><span>CNBTL</span>后台管理</a>
					<ul class="user-menu">
						<li class="dropdown pull-right">
							<input type="hidden" id="userid" value="${user.id}">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span><span>欢迎您,${user.name}</span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="<%= request.getContextPath() %>/admin/logoff"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
							</ul>
						</li>
					</ul>
				</div>
								
			</div><!-- /.container-fluid -->
		</nav>
		
		<!--左侧的导航栏-->
		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
			<form role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="查找">
				</div>
			</form>
			<div class="accordion-group">
				<div class="accordion-heading menu-tap">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
						<span class="glyphicon glyphicon-user"></span>案列管理
					</a>
				</div>
				<div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
					<ul class="nav menu">
						<li><a href="<%= request.getContextPath() %>/admin/showcase"><span class="glyphicon glyphicon-sunglasses"></span> 查看案列</a></li>
						<li class="active"><a href="<%= request.getContextPath() %>/admin/edit"><span class="glyphicon glyphicon-shopping-cart"></span> 增加案列</a></li>
					</ul>
				</div>
			</div>
			<div class="attribution">(c) CNBTL  2017. 版权所有.  </div>
		</div><!--/.sidebar-->
		
		<!--管理主面板-->
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 col-xs-12 main">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="#"><span class="glyphicon glyphicon-jpy"></span></a></li>
					<li class="active">添加一个新的案列</li>
				</ol>
				
			</div><!--/.row-->
			
			<!--这里是editor-->
			<!-- 加载编辑器的容器 -->
			<div class="mini-info" style="width: 250px;">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">标题</span>
					<input class="form-control" type="text" name="title" id="title" placeholder="输入案列/新闻标题" />
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">类别</span>
					<select class="form-control name="type" id="type">
						<option value="brand">品牌咨询</option>
						<option value="activity">会展活动</option>
						<option value="design">平面设计</option>
						<option value="movie">影视制作</option>
					</select>
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">来源</span>
					<input class="form-control type="text" name="origin" id="origin" value="手足文化" disabled="disabled" />
				</div><br />
			</div>
			<input type="hidden" id="contextPath" value="<%= request.getContextPath()%>" />
		    <div id="editor">
		        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
		    </div>
		    <!-- <button class="btn btn-primary" onclick="getHtml()">获取html</button> -->
		    <button class="btn btn-primary" onclick="uploadHtml()">上传html</button>
		     <script type="text/javascript">
		        var E = window.wangEditor;
		        var editor = new E('#editor');
		        // 或者 var editor = new E( document.getElementById('editor') );
		         //配置图片上传
		        var rootPath = $('#contextPath').val();
		        editor.customConfig.uploadImgServer = rootPath + "/upload/uploadimg";
		        editor.customConfig.uploadFileName = "img";
		        //alert((window.location.href).split("/cnbtl")[0] + rootPath + "/upload/uploadimg");
		        editor.customConfig.debug = true;
		        //事件函数,修改相对路径
		        editor.customConfig.uploadImgHooks = {
		        	customInsert:function (insertImg, result, editor) {
		        		 var url = (window.location.href).split("/cnbtl")[0] + rootPath + result.data[0];
		        		 //alert(url);
		        	     insertImg(url);
				    },
				    fail:function (xhr, editor, result) {
						if(result.errno == -1){
							alert("服务器没有接收到图片信息!");
						}
					}
				}
		        editor.create();


		        //获取案列上传案列方法
		        function getHtml(){
			        //alert(editor.txt.html());
			        return editor.txt.html();
			    }
			    function uploadHtml(){
				    //首先获取内容,然后使用jquery的ajax发送上传请求给服务器
				    var editor = $("#userid").val();
				    var title = $("#title").val();
				    var type = $("#type").val();
				    var origin = $("#origin").val();
				    var content = getHtml();
				    console.log(editor+title+type+origin+content);
				    $.ajax({
						url:rootPath + "/case/add",
						dataType: "json",
						type:"post",
						data:{
							"editor":editor,
							"title":title,
							"type":type,
							"origin":origin,
							"content":content
						},
						success:function(data){
							if(data.result === "false")
								alert("上传出错,请检查时候完整填写!");
							if(data.result === "true")
								alert("上传完成!");
						},
						error:function(){
							alert("上传出错了!!!!检查一下填写的内容")
						}
					});
				}
		    </script>
		</div>
	</body>
</html>
