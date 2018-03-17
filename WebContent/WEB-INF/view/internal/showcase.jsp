<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>手足文化 - 案列管理</title>
		
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
					<a class="navbar-brand" href="<%= request.getContextPath() %>/admin/main"><span>手足文化</span>后台管理</a>
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
			<div class="accordion-group">
				<div class="accordion-heading menu-tap">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
						<span class="glyphicon glyphicon-user"></span>案列管理
					</a>
				</div>
				<div id="collapseOne" class="accordion-body collapse in" style="height: 0px; ">
					<ul class="nav menu">
						<li class="active"><a href="<%=request.getContextPath() %>/admin/showcase"><span class="glyphicon glyphicon-search"></span> 查看案列</a></li>
						<li><a href="<%=request.getContextPath() %>/admin/edit"><span class="glyphicon glyphicon-plus"></span> 增加案列</a></li>
					</ul>
				</div>
			</div>
			<div class="attribution">(c) 成都手足文化  2017. 版权所有.  </div>
		</div><!--/.sidebar-->
		
		<!--余额管理主面板-->
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 col-xs-12 main">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="#"><span class="glyphicon glyphicon-plus"></span></a></li>
					<li class="active">案列查询信息</li>
				</ol>
			</div><!--/.row-->
			
			<!--这里是表格和相关按钮-->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel panel-heading">
							<button id="deletebtn" class="btn btn-primary" disabled="disabled" data-toggle="modal" data-target="#deleteModal">删除</button>
							<button id="updatebtn" class="btn btn-primary" disabled="disabled" onclick="toUpdate()">修改</button>
							<button id="showbtn" class="btn btn-primary" onclick="showCase()" disabled="disabled">查看详细</button>
							<button id="setcover" class="btn btn-primary" onclick="setcover()" disabled="disabled">设置封面</button>
						</div>
						<div class="panel-body">
							<table id="casetable" data-toggle="table" data-single-select="true"	data-pagination="true" data-search="true" data-show-refresh="true">
								<thead>
									<tr>
										<th data-filed="state" data-checkbox="true">选择</th>
										<th data-sortable="true" data-field="id">序号</th>
										<th data-field="title">标题</th>
										<th data-sortable="true" data-field="date">时间</th>
										<!-- <th data-filed="type">类型</th> -->
										<th data-sortable="true" data-field="click">点击量</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<!--删除模态框  -->	
			<!-- Modal -->
			<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">确认要删除案列吗?</h4>
			      </div>
			      <div class="modal-body">
			        <p style="color:red; font-size:20px">警告!</p>
			        <p style="color:orange">后台没有回收站功能,这将意味着永久删除,请谨慎操作!</p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消删除</button>
			        <button type="button" class="btn btn-primary" onclick="deleteCase()">确认删除</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
		<input id="contextPath" type="text" style="display: hiden;" value="<%=request.getContextPath() %>">
		<script type="text/javascript" src="<%= request.getContextPath() %>/static/js/backend/base/showcase.js"></script>
	</body>
</html>