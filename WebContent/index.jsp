<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页</title>
	<script src="<%=request.getContextPath() %>/static/front/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
<body>
	<div>
		<h2>页面加载中...</h2>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			window.location.href = "<%= request.getContextPath()%>/index";
		});
	</script>
</body>
</html>