$(function () {
    $.get("html/header2.html",function (data) {
        $("#header").html(data);
        search();
    });
    $.get("html/footer2.html",function (data) {
        $("#footer").html(data);
    });
    
    setHeader();
    
    $.get("/TravelSsm/category/findAllAsJson",{},function(data){
//    	console.log(data);
    	var html = '<li class="nav-active"><a href="index.html">首页</a></li>';
    	for(var i = 0;i < data.length;i++){
    		var li = '<li><a href="html/route_list.html?cid='+data[i].cid+'">'+ data[i].cname +'</a></li>'
    		html += li;
    	}
    	html += '<li><a href="html/favoriterank.html">收藏排行榜</a></li>';
    	
    	$("#category").html(html);
    });
    
});

function setHeader(){
	$.get("/TravelSsm/user/getUser",{},function(data){
		if(data == null){
			$(".login").hide();
			$(".login_out").show();
		}else{
			$(".login_out").hide();
			var msg = "欢迎回来，"+data;
			$("#index_username").html(msg);
		}
		
	});
}

function search(){
	$("#searchBtn").click(function(){
    	
    	var rname = $("#search_input").val();
    	var cid = getParameter("cid");
    	location.href = "html/route_list.html?cid="+cid+"&rname="+rname;
    });
}