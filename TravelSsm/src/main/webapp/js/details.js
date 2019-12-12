$(function() {
		loadData();
		collect();
});

	//绑定收藏按钮
	function collect(){
		$("#to_collected").click(function(){
			var rid = getParameter("rid");
			$.get("/TravelSsm/details/save",{rid:rid},function(data){
				if(data == "ok"){
					//设置收藏按钮
					$("#to_collected").hide();
					$("#collected").show();
					//设置收藏数
					$.get("/TravelSsm/details/count",{rid:rid},function(data){
						console.log(data);
						$("#collection").html("已收藏"+data+"次");
					});
				}else if(data == "login"){
					alert("请先登录再操作");
//					location.href="login.html";
				}
			});
		});
		
	}
	
	//焦点图效果
	//点击图片切换图片
	function changePic(){
		
        $(".little_img").on("mousemove", function() {
            $(".little_img").removeClass("cur_img");
            var big_pic = $(this).data("bigpic");
            $(".big_img").attr("src", big_pic);
            $(this).addClass("cur_img");
        });
           //上下切换
        var picindex = 0;
        var nextindex = 4;
        $(".down_img").on("click",function(){
            var num = $(".little_img").length;
            if((nextindex + 1) <= num){
                $(".little_img:eq("+picindex+")").hide();
                $(".little_img:eq("+nextindex+")").show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $(".up_img").on("click",function(){
            var num = $(".little_img").length;
            if(picindex > 0){
                $(".little_img:eq("+(nextindex-1)+")").hide();
                $(".little_img:eq("+(picindex-1)+")").show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
	}
	
	//加载请求数据
	function loadData(){
		var rid = getParameter("rid");
		//请求数据并加载
		$.get("/TravelSsm/details/getDetails",{rid:rid},function(details){
			$("#title").html(details.rname);
			$("#pros_title").html(details.rname);
			$("#price").html("￥"+details.price);
			$("#collection").html("已收藏"+details.count+"次");
			//设置商家信息
			$("#seller_name").html("经营商家  ："+details.seller.sname);
			$("#seller_phone").html("咨询电话 : "+details.seller.consphone);
			$("#seller_address").html("地址 ： "+details.seller.address);
			//设置收藏按钮
			if(details.favorite == true){
				$("#to_collected").hide();
			}else{
				$("#collected").hide();
			}
			//设置图片
			var str = "<a class='up_img up_img_disable'></a>";
			var list = details.imgList;
			for(var i = 0;i < list.length;i++){
				if(i == 0){
					$(".big_img").attr("src","../"+list[0].bigPic);
				}
				str += "<a title='' class='little_img' data-bigpic='../"+list[i].bigPic+"'><img src='../"+list[i].smallPic+"'></a>";
			}
			str += "<a class='down_img down_img_disable' style='margin-bottom: 0;'></a>";
			$("#imgList").html(str);
			//图片绑定事件
			changePic();
			//  自动播放
	         var timer = setInterval("auto_play()", 5000);
		});
	}

    //自动轮播方法
    function auto_play() {
        var cur_index = $(".prosum_left dd").find("a.cur_img").index();
        cur_index = cur_index - 1;
        var num = $(".little_img").length;
        var max_index = 3;
        if ((num - 1) < 3) {
            max_index = num - 1;
        }
        if (cur_index < max_index) {
            var next_index = cur_index + 1;
            var big_pic = $(".little_img:eq(" + next_index + ")").data("bigpic");
            $(".little_img").removeClass("cur_img");
            $(".little_img:eq(" + next_index + ")").addClass("cur_img");
            $(".big_img").attr("src", big_pic);
        } else {
            var big_pic = $(".little_img:eq(0)").data("bigpic");
            $(".little_img").removeClass("cur_img");
            $(".little_img:eq(0)").addClass("cur_img");
            $(".big_img").attr("src", big_pic);
        }
    }