$(function () {
   setPopular();
   setNew();
   setTheme();
   setDomestic();
   setAboard();
});


function setPopular(){
	$.get("/TravelSsm/index/getPopular",{},function(data){
//		console.log(data);
		var str = "";
		for(var i = 0;i < data.length;i++){
			var temp = "<div class='col-md-3'>"+
                       "<a href='html/route_detail.html?rid="+data[i].rid+"'>"+
                       "<img src='"+data[i].rimage+"' style='width:275px'>"+
                       "<div class='has_border'>"+
                       "<h3>"+data[i].rname+"</h3>"+
                       "<div class='price'>网付价<em>￥</em><strong>"+data[i].price+"</strong><em>起</em></div>"+
                       "</div></a></div>";
			str = str + temp;
		}
		$("#popularity > .row").html(str);
	});
}

function setNew(){
	$.get("/TravelSsm/index/getNew",{},function(data){
//		console.log(data);
		var str = "";
		for(var i = 0;i < data.length;i++){
			var temp = "<div class='col-md-3'>"+
                       "<a href='html/route_detail.html?rid="+data[i].rid+"'>"+
                       "<img src='"+data[i].rimage+"' style='width:275px'>"+
                       "<div class='has_border'>"+
                       "<h3>"+data[i].rname+"</h3>"+
                       "<div class='price'>网付价<em>￥</em><strong>"+data[i].price+"</strong><em>起</em></div>"+
                       "</div></a></div>";
			str = str + temp;
		}
		$("#newest > .row").html(str);
	});
}

function setTheme(){
	$.get("/TravelSsm/index/getTheme",{},function(data){
//		console.log(data);
		var str = "";
		for(var i = 0;i < data.length;i++){
			var temp = "<div class='col-md-3'>"+
                       "<a href='html/route_detail.html?rid="+data[i].rid+"'>"+
                       "<img src='"+data[i].rimage+"' style='width:275px'>"+
                       "<div class='has_border'>"+
                       "<h3>"+data[i].rname+"</h3>"+
                       "<div class='price'>网付价<em>￥</em><strong>"+data[i].price+"</strong><em>起</em></div>"+
                       "</div></a></div>";
			str = str + temp;
		}
		$("#theme > .row").html(str);
	});
}

function setDomestic(){
	$.get("/TravelSsm/index/getDomestic",{},function(data){
//		console.log(data);
		var str = "";
		for(var i = 0;i < data.length;i++){
			var temp = "<div class='col-md-4'>"+
                       "<a href='html/route_detail.html?rid="+data[i].rid+"'>"+
                       "<img src='"+data[i].rimage+"' style='width:241px'>"+
                       "<div class='has_border'>"+
                       "<h3>"+data[i].rname+"</h3>"+
                       "<div class='price'>网付价<em>￥</em><strong>"+data[i].price+"</strong><em>起</em></div>"+
                       "</div></a></div>";
			str = str + temp;
		}
		$("#domestic").html(str);
	});
}

function setAboard(){
	$.get("/TravelSsm/index/getAboard",{},function(data){
//		console.log(data);
		var str = "";
		for(var i = 0;i < data.length;i++){
			var temp = "<div class='col-md-4'>"+
                       "<a href='html/route_detail.html?rid="+data[i].rid+"'>"+
                       "<img src='"+data[i].rimage+"' style='width:241px'>"+
                       "<div class='has_border'>"+
                       "<h3>"+data[i].rname+"</h3>"+
                       "<div class='price'>网付价<em>￥</em><strong>"+data[i].price+"</strong><em>起</em></div>"+
                       "</div></a></div>";
			str = str + temp;
		}
		$("#aboard").html(str);
	});
}

