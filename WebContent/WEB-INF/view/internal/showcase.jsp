<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>cnbtl - 案列管理</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<!--引入css-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/bootstrap-table.css"/>
		<!--一些自定义的样式-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/styles.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/backend/base/index.css"/>
		<!--引入js-->
		<script src="<%= request.getContextPath() %>/static/js/backend/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/js/backend/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/js/backend/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
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
						<li class="active"><a href="<%=request.getContextPath() %>/admin/showcase"><span class="glyphicon glyphicon-sunglasses"></span> 查看案列</a></li>
						<li><a href="<%=request.getContextPath() %>/admin/edit"><span class="glyphicon glyphicon-shopping-cart"></span> 增加案列</a></li>
					</ul>
				</div>
			</div>
			<div class="attribution">(c) CNBTL  2017. 版权所有.  </div>
		</div><!--/.sidebar-->
		
		<!--余额管理主面板-->
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 col-xs-12 main">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="#"><span class="glyphicon glyphicon-jpy"></span></a></li>
					<li class="active">案列查询信息</li>
				</ol>
			</div><!--/.row-->
			
			<!--这里是表格和相关按钮-->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel panel-heading">
							<button class="btn btn-primary" disabled="disabled">删除</button>
							<button class="btn btn-primary" disabled="disabled">修改</button>
							<button class="btn btn-primary" disabled="disabled">查看详细</button>
						</div>
						<div class="panel-body">
							<table id="casetable" data-toggle="table" data-single-select="true"	data-pagination="true" data-search="true" data-show-refresh="true">
								<thead>
									<tr>
										<th data-filed="state" data-checkbox="true">选择</th>
										<th data-sortable="true" data-field="id">序号</th>
										<th data-sortable="true" data-field="date">时间</th>
										<th data-field="title">标题</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<input id="contextPath" type="text" style="display: hiden;" value="<%=request.getContextPath() %>">
		<script type="text/javascript" src="<%= request.getContextPath() %>/static/js/backend/base/showcase.js"></script>
	</body>
</html>