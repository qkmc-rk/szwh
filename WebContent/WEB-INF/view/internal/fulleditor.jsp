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
					<select class="form-control name="type">
						<option value="new">新闻</option>
						<option value="case">案列</option>
					</select>
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">来源</span>
					<input class="form-control type="text" name="origin" id="origin" placeholder="例如:cnbtl" />
				</div><br />
			</div>
			
		    <div id="editor">
		        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
		    </div>
		    <button class="btn btn-primary" onclick="get()">保存案列</button>
		     <script type="text/javascript">
		        var E = window.wangEditor;
		        var editor = new E('#editor');
		        // 或者 var editor = new E( document.getElementById('editor') );
		        editor.create();
		        
		        function get(){
		        	alert(editor.txt.html());
		        }
		    </script>
	</body>
</html>
