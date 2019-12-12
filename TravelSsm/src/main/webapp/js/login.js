$(function(){
		$("#errorMsg").hide();
	    $("#loginBtn").click(function(){
	    	console.log("正在加载登录...");
	    	$("#errorMsg").html("正在加载登录...");
	    	$("#errorMsg").css("color","green");
			$("#errorMsg").show();
	    	if(checkUserName() && checkPwd() && checkCheckCode()){
	    		var data = $("#loginForm").serialize();
	    		$.post("/TravelSsm/user/login",data,function(data){
	    			//console.log(data.msg);
	    			//服务器端用Jackson发送json，content-type为application/json,所以不需要解析
//	    			var d = $.parseJSON(data);
	    			if(data.code == "1"){
	    				$("#errorMsg").html("登录成功！");
	    		    	$("#errorMsg").css("color","green");
	    				setTimeout(function(){
	    					location.href = "/TravelSsm/index.html";
	    				},3000);
	    			}else{
	    				$("#errorMsg").html(data.msg);
	    				$("#errorMsg").css("color","red");
	    			}
	    		})
	    	}
	    });
	    
	    $("#username").blur(checkUserName);
	    $("#pwd").blur(checkPwd);
	    $("#check").blur(checkCheckCode);
});

function checkUserName(){
	//获取username元素值
	var username = $("#username").val();
	//定义正则表达式
	var reg_username = /^[a-zA-Z0-9_-]{8,20}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_username.test(username);
	if(flag){
		$("#username").css("border","1px solid black");
		
	}else{
		$("#username").css("border","1px solid red");
		
	}
	
	return flag;
}

function checkPwd(){
	//获取元素信息
	var password = $("#pwd").val();
	//定义正则表达式
	var reg_password = /^\w{8,20}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_password.test(password);
	if(flag){
		$("#pwd").css("border","1px solid black");
		
	}else{
		$("#pwd").css("border","1px solid red");
		
	}
	return flag;
}

function checkCheckCode(){
	//获取元素信息
	var check = $("#check").val();
	//定义正则表达式
	var reg_check = /^[a-zA-Z0-9-]{4}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_check.test(check);
	if(flag){
		$("#check").css("border","1px solid black");
		
	}else{
		$("#check").css("border","1px solid red");
		
	}
	return flag;
}