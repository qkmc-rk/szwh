<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>手足文化 - 案列更新</title>
		
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
		<script src="<%= request.getContextPath() %>/static/js/backend/base/updatecase.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><span>手足文化</span>后台管理</a>
					<ul class="user-menu">
						<li class="dropdown pull-right">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span><span>欢迎您,${user.name}</span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
							</ul>
						</li>
					</ul>
				</div>
								
			</div><!-- /.container-fluid -->
		</nav>
		
		<!--左侧的导航栏-->
		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
			<div class="accordion-group">
				<div class="accordion-heading menu-tap">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
						<span class="glyphicon glyphicon-user"></span>案列管理
					</a>
				</div>
				<div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
					<ul class="nav menu">
						<li><a href=""><span class="glyphicon glyphicon-sunglasses"></span> 查看案列</a></li>
						<li class="active"><a href=""><span class="glyphicon glyphicon-shopping-cart"></span> 增加案列</a></li>
					</ul>
				</div>
			</div>
			<div class="attribution">(c) 成都手足文化  2017. 版权所有.  </div>
		</div><!--/.sidebar-->
		
		<!--余额管理主面板-->
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 col-xs-12 main">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href=""><span class="glyphicon glyphicon-jpy"></span></a></li>
					<li class="active">修改案列内容</li>
				</ol>
				
			</div><!--/.row-->
			
			<!--这里是editor-->
			<!-- 加载编辑器的容器 -->
			<div class="mini-info" style="width: 250px;">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">ID</span>
					<input class="form-control" type="text" name="id" id="id" disabled="disabled" value="${case1.id }"/>
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">类别</span>
					<select class="form-control name="type" id ="type">
						<option value="brand">品牌咨询</option>
						<option value="activity">会展活动</option>
						<option value="design">平面设计</option>
						<option value="movie">影视制作</option>
					</select>
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">标题</span>
					<input class="form-control type="text" name="title" id="title" value="${case1.title }" />
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">来源</span>
					<input class="form-control type="text" name="title" id="origin" value="${case1.title }" disabled="disabled"/>
				</div><br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">点击次数</span>
					<input type="number" class="form-control name="click" id="click" value="${case1.click }"/>
				</div><br />
			</div>
			
		    <div id="editor">
		        
		    </div>
		    <div id="content" style="display:none;" value="">${case1.content}</div>
		    <button class="btn btn-primary" onclick="update()">更新案列</button>
		     <script type="text/javascript">
		        var E = window.wangEditor;
		        var editor = new E('#editor');
		        // 或者 var editor = new E( document.getElementById('editor') );
		        editor.create();
		        var content = $("#content").html();
		       // alert(content);
		        editor.txt.html(content);
		    </script>
		</div>
	</body>
</html>
