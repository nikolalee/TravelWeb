$(function(){
	var cid = getParameter("cid");
	var rname = getParameter("rname");
	showData(cid,rname);
})

function showData(cid,rname,currentPage){
	
	$.get("/TravelSsm/page/getPageBean",
		{cid:cid,currentPage:currentPage,rname:rname},
		function(data){
//		console.log(data.list);
		console.log(data);
		var list = data.list;
//		var curPage = data.currentPage;
		//显示列表信息
		var str = "";
		for(var i = 0;i < list.length;i++){
			var temp = "<li>"+
	        "<div class='img'><img src='../"+list[i].rimage+"' style='width:290px'></div>"+
	        "<div class='text1'>"+
	           "<p>"+list[i].rname+"</p>"+
	            "<br/>"+
	            "<p>"+list[i].routeIntroduce+"</p>"+
	       " </div>"+
	        "<div class='price'>"+
	            "<p class='price_num'>"+
	                "<span>&yen;</span>"+
	                "<span>"+list[i].price+"</span>"+
	                "<span>起</span>"+
	            "</p>"+
	            "<p><a href='route_detail.html?rid="+list[i].rid+"'>查看详情</a></p>"+
	        "</div>"+
	    "</li>";
			str = str + temp;
			
		}
//		console.log(str);
		$("#dataList").html(str);
		$("#pageNum").html(data.pageNum);
		$("#totalLines").html(data.totalLines);
		//显示索引条
		var barStr = "<li onclick='javascript:showData("+data.cid+",\""+rname+"\")' ><a href=''>首页</a></li>";
		//获取上一页的页码
		var preP = data.currentPage - 1;
		
		if(preP < 1){
			preP = 1;
		}
		barStr += "<li class='threeword' onclick='javascript:showData("+data.cid+",\""+rname+"\","+preP+")'><a href='javascript:void(0)'>上一页</a></li>";
		//设置显示页码数
		var start = 0,end = 0;
		if(data.pageNum < 10){
			start = 1;
			end = data.pageNum;
		}else{
			start = data.currentPage - 4;
			end = data.currentPage + 5;
			if(start < 1){
				start = 1;
				end = start + 9;
			}
			if(end > data.pageNum){
				end = data.pageNum;
				start = end - 9;
			}
		}
		
		for(var i = start;i <= end;i++){
			if(i == data.currentPage){
				var temp = "<li onclick='javascript:showData("+data.cid+",\""+rname+"\","+i+")' class='curPage'><a href='javascript:void(0)'>"+i+"</a></li>";
			}else{
				var temp = "<li onclick='javascript:showData("+data.cid+",\""+rname+"\","+i+")' ><a href='javascript:void(0)'>"+i+"</a></li>";
			}
			
			barStr = barStr + temp;
		}
		//获取下一页的页码
		var nextP = data.currentPage + 1;
		if(nextP > data.pageNum){
			nextP = data.pageNum;
		}
		barStr += "<li class='threeword' onclick='javascript:showData("+data.cid+",\""+rname+"\","+nextP+")'><a href='javascript:void(0);'>下一页</a></li>";
		barStr += "<li class='threeword' onclick='javascript:showData("+data.cid+",\""+rname+"\","+data.pageNum+")'><a href='javascript:void(0);'>末页</a></li>";
		$("#pageBar").html(barStr);
		
	})
	window.scrollTo(0,0);
}