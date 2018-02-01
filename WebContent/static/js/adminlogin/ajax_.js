function mylogin(){
	//获取表单值
	var name = $("#value_1").val();
	var psd = $("#value_2").val();
	//alert(name + " " + psd);
	//ajax登录
	$.ajax({
		type:"post",
		url:"admin/adminlogin",
		async:true,
		data:{
			'username':name,
			'password':psd
		},
		//根据返回值
		
		
		success:function(data){
			var obj = JSON.parse(data);
			if(obj.result != null)
				//返回false,登录失败,alert提示
				alert("登录失败,请检查密码");
			else{
				if(obj.token != null){
					//返回token,存储到sessionStorage,重定向到管理页面
					//alert("登陆成功" + obj.token);
					window.sessionStorage.setItem("token",obj.token);
					//alert("session:" + window.sessionStorage.getItem("token"));
					window.location.href="admin/main";
					//登录成功后进入主面板
					
				}
			}
			
		},
		error:function(){
			alert("没有这个用户!");
		}
	});
}