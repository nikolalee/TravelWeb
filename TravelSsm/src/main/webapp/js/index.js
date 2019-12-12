$(function () {
   
   setHeader();
});

function setHeader(){
	$.get("/TravelSsm/user/getUser",{},function(data){
		console.log(data);
		if(data == null){
			$(".login").hide();
			$(".login_out").show();
		}else{
			var msg = "欢迎回来，"+data;
			$("#index_username").html(msg);
		}
		
	});
}