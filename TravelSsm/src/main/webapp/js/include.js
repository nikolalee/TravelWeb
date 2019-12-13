

$(function () {
    $.get("header.html",function (data) {
        $("#header").html(data);
        search();
    });
    $.get("footer.html",function (data) {
        $("#footer").html(data);
    });
    
    setHeader();
    
    $.get("/TravelSsm/category/findAllAsJson",{},function(data){
//    	console.log(window.location.pathname);
    	
    	//设置目录高亮
    	var cid = getParameter("cid");
    	var index = 0;
    	if(cid == null){
    		if(window.location.pathname=="/TravelSsm/html/favoriterank.html"){
    			index = 9;
    		}
    	}else{
    		index = Number(cid);
    	}
    	if(index == 0){
    		var html = '<li class="nav-active"><a href="../index.html">首页</a></li>';
    	}else{
    		var html = '<li ><a href="../index.html">首页</a></li>';
    	}
    	for(var i = 0;i < data.length;i++){
    		if(index == i + 1){
    			var li = '<li class="nav-active"><a href="route_list.html?cid='+data[i].cid+'">'+ data[i].cname +'</a></li>';
    		}else{
    			var li = '<li><a href="route_list.html?cid='+data[i].cid+'">'+ data[i].cname +'</a></li>';
    		}
    		html += li;
    	}
    	if(index == 9){
    		html += '<li class="nav-active"><a href="favoriterank.html">收藏排行榜</a></li>';
    	}else{
    		html += '<li ><a href="favoriterank.html">收藏排行榜</a></li>';
    	}
    	
    	$("#category").html(html);
    });
    
    
});

function setHeader(){
	$.get("/TravelSsm/user/getUser",{},function(data){
		console.log(data);
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
    	location.href = "route_list.html?cid="+cid+"&rname="+rname;
    });
}