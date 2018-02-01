<%@page contentType="text/html; charset=utf-8"  language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录- </title>

<link href="<%= request.getContextPath() %>/static/css/adminlogin.css" rel="stylesheet" type="text/css" />

</head>
<body>


<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
				<div class="name">
					<label>账号</label><input type="text" class="text" id="value_1" placeholder="账号" name="value_1" tabindex="1"></input>
				</div>
				<div class="pwd">
					<label>密码</label><input type="password" class="text" id="value_2" placeholder="密码" name="value_2" tabindex="2"></input>
					<input type="button" class="submit" tabindex="3" value="登录" onclick="mylogin()"></input>
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="<%= request.getContextPath() %>/static/js/adminlogin/jQuery.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/js/adminlogin/fun.base.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/js/adminlogin/script.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/js/adminlogin/ajax_.js"></script>
</body>
</html>