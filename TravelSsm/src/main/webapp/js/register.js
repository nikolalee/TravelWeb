$(function () { 
    //表单提交时对表单数据进行验证
    $("#registerForm").submit(function(){
    	var flag =  checkUserName() && checkPassword() && checkEmail()
    	&& checkName() && checkTelephone() && checkBirthday()
    	&& checkCheckCode();
    	var data = $("#registerForm").serialize();

    	if(flag){
    		$("#server_msg").html("正在注册，请稍候...");
			$("#server_msg").css("color","green");
    		$.post("/TravelSsm/user/register",data,function(data){
//    			var data = $.parseJSON(d);
    			console.log(data.code);
    			if(data.code == 0){
    				//登录不成功，显示错误信息
    				$("#server_msg").html(data.msg);
    				$("#server_msg").css("color","red");
    			}else{
    				//登录成功，显示成功信息，并跳转登录成功页面
    				$("#server_msg").html(data.msg);
    				$("#server_msg").css("color","green");
    				
    				setTimeout(function(){
    					location.href="register_ok.html";
    				},3000);
    			}
    		});
    	}
    	console.log("Request sent.Please wait... ");
    	return false;
    });
    
    $("#username").blur(checkUserName);
    $("#password").blur(checkPassword);
    $("#email").blur(checkEmail);
    $("#name").blur(checkName);
    $("#telephone").blur(checkTelephone);
    $("#birthday").blur(checkBirthday);
    $("#check").blur(checkCheckCode);
});

function checkUserName(){
	//获取元素信息
	var username = $("#username").val();
	//定义正则表达式
	var reg_username = /^[a-zA-Z0-9_-]{2,20}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_username.test(username);
	if(flag){
		$("#username").css("border","1px solid black");
		
	}else{
		$("#username").css("border","1px solid red");
		
	}
	return flag;
}

function checkPassword(){
	//获取元素信息
	var password = $("#password").val();
	//定义正则表达式
	var reg_password = /^\w{8,20}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_password.test(password);
	if(flag){
		$("#password").css("border","1px solid black");
		
	}else{
		$("#password").css("border","1px solid red");
		
	}
	return flag;
}

function checkEmail(){
	//获取元素信息
	var email = $("#email").val();
	//定义正则表达式
	var reg_email = /^([a-zA-Z0-9_\.-]+)@([\da-zA-Z\.-]+)\.([a-zA-Z\.-]{2,6})$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_email.test(email);
	if(flag){
		$("#email").css("border","1px solid black");
		
	}else{
		$("#email").css("border","1px solid red");
		
	}
	return flag;
}

function checkName(){
	//获取元素信息
	var name = $("#name").val();
	//定义正则表达式
	var reg_name = /^[a-zA-Z]{2,20}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_name.test(name);
	if(flag){
		$("#name").css("border","1px solid black");
		
	}else{
		$("#name").css("border","1px solid red");
		
	}
	return flag;
}

function checkTelephone(){
	//获取元素信息
	var telephone = $("#telephone").val();
	//定义正则表达式
	var reg_telephone = /^\d{11}$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_telephone.test(telephone);
	if(flag){
		$("#telephone").css("border","1px solid black");
		
	}else{
		$("#telephone").css("border","1px solid red");
		
	}
	return flag;
}

function checkBirthday(){
	//获取元素信息
	var birthday = $("#birthday").val();
	//定义正则表达式
	var reg_birthday = /^\w+-\w+-\w+$/;
	
	//对元素的值进行判断及相应操作
	var flag = reg_birthday.test(birthday);
	if(flag){
		$("#birthday").css("border","1px solid black");
		
	}else{
		$("#birthday").css("border","1px solid red");
		
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
