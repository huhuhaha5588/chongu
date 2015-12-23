$(function () {
  // 首页菜单
  $("#index_menu_l ul li").hover(function () {
    $(this).children("div").show();
  }, function () {
    $(this).children("div").hide();
  });

  // 最近浏览
  $("#content .recent_plus").click(function () {
    $(this).toggleClass("minus");
    $("#content .recent_list").toggle();
  });
  $("#content .recent_title").click(function () {
    $("#content .recent_plus").click();
  });

  // 栏目分页
 setContentPager();
  
    // 详情页分页
  //setDetailPager();

  // 加载二级菜单
  initialSubMenu(1);

  // 历史访问记录
  initialViewHistory();
  //随即出现放在了单独的js中
 // showRadomDiv();
  //mouseOver1();
 	//mouseOver2();
 // mouseOver3();

  // 设置二级栏目
  // 取得所有的内容分页
 /* $("#content .detail_menu li").mouseover(function () {
    $(this).addClass("on");
  }, function () {
    $(this).removeClass("on");
  });*/
  //列表页左侧导航展开
  $("#content .content_left .content_list_s .content_list_s_products").click(function(){
    $(".subchannel2").slideToggle("normal");})
  $("#content .content_left .content_list_s .content_list_s_plans").click(function(){
    $(".subchannel1").slideToggle("normal");})
$("#content .content_left .content_list_s .content_list_s_service").click(function(){
    $(".subchannel3").slideToggle("normal");})
	
	
	//随即出现员工放在了randommem中
/*function showRadomDiv(){
	
  var $ramdiv = $("#content .content_left .person_list_one");
  var total = $ramdiv.length;//获得div的总个数
  var rd= Math.ceil(Math.random()*total)-1;//获得显示div的随机数
  var rd2= Math.ceil(Math.random()*total)-1;
  while(rd2 == rd){
	  rd2=Math.ceil(Math.random()*total)-1;
  }
  for(var i=0;i<total;i++){
   if(i==rd||i==rd2)
   $($ramdiv[i]).show();//显示随机的div;
	else
   $($ramdiv[i]).hide();//隐藏其它div,
   }
} */ 
	
	
	
	
  // 查看更多员工
  /*$("#content a.viewmore").click(function () {
    var $pdiv = $(this).parent("div");
    var hasNext = $pdiv.hasClass("next");

    if (hasNext == true) {
      $("#content .person_list_one").show("slow");
      $pdiv.removeClass("next").addClass("prev");
      $(this).text("隐藏员工简介");
    } else {
      $("#content .person_list_one:gt(1)").hide();
      $pdiv.removeClass("prev").addClass("next");
      $(this).text("浏览更多员工简介");
    }
  });*/
});

// 初始化二级菜单
function initialSubMenu(type) {
  var $menulist = $("#navmenulist li:not(:last)");
  var len = $menulist.length - 1;

  var cssClass = type == 0 ? "submenu" : "submenu2";
  $menulist.each(function (i) {
    var $this = $(this);

    // 栏目ID
    var pid = $this.attr("item-id");

    // 绝对定位偏差
    var pright = -(len - i) * $this.width() - 112;

    var backcolor = "#d9ab01";
    if (i == 1) {
      backcolor = "#b5ab01";
    } else if (i == 2) {
      backcolor = "#81ab01";
    }

    // 加载二级菜单列表
    /*$.get("/ComteckService.asmx/SelectChannelByPid?pid=" + pid, {}, function (response) {
      var result = $(response).text();
      result = jQuery.parseJSON(result);

      if (result == null || result.length == 0) {
        return;
      }

      var html = '<div class="' + cssClass + '" style="background-color:' + backcolor + ';right:' + pright + 'px;"><ul>';

      for (var k = 0; k < result.length; k++) {
        html = html
             + '<li><a href="Channel.aspx?id=' + result[k].ID + '" title="">' + result[k].Name + '</a></li>';
      }

      html = html + "</ul></div>";

      $this.append(html);
    });*/
  });
}

// 历史访问记录
// type 0:内容,1:新闻
function initialViewHistory() {
  var url = "";

  // 加载二级菜单列表
  /*$.get("/ComteckService.asmx/SelectViewHistoryList", {}, function (response) {
    var result = $(response).text();
    result = jQuery.parseJSON(result);

    if (result == null || result.length == 0) {
      return;
    }

    var html = '<div class="recent_list">';

    var type = 0;
    var key = 0;

    for (var k = 0; k < result.length; k++) {
      type = result[k].Type;
      key = result[k].Key;

      if (type == 0) {
        if (key == 25) {
          url = "PersonnelList.aspx?id=";
        } else if (key == 28) {
          url = "NewsList.aspx?id=";
		} else {
          url = "Channel.aspx?id=";
        }
      } else if (type == 1) {
        url = "News.aspx?id=";
      } else {
        continue;
      }

      html = html
           + '<div>'
           + '<a href="' + url + key + '" title="">'
           + result[k].Name
           + '</a>'
           + '</div>';
    }

    html = html + "</div>";

    $("div.content_right").append(html);
  });*/
}

// 设置内容分页
function setContentPager() {
  // 取得所有的内容分页
  var $menu = $("#content .detail_menu");
  var $lis = $menu.find("li");
  var $detail = $("#content .content_list_c .item_list");

  $lis.hover(function () {
    // 取得索引
    var index = $lis.index(this);

    $lis.removeClass("on");
    $(this).addClass("on");
    $detail.hide().eq(index).show();
    if (index == 0) {
      $("#content .con_pager_up").parent("div").hide();
      $("#content .con_pager_down").parent("div").show();
    } else if (index == $lis.length - 1) {
      $("#content .con_pager_up").parent("div").show();
      $("#content .con_pager_down").parent("div").hide();
    }
  });

  // 上一页
  $("#content .con_pager_up").click(function () {
    var index = $lis.index($menu.find(".on"));
	pageScroll()
    if (index <= 0) {
      return;
    }

    $("#content .con_pager_down").parent("div").show();
    $lis.eq(index).removeClass("on").end().eq(index - 1).addClass("on");
    $detail.eq(index).hide().end().eq(index - 1).show();
    if (index - 1 == 0) {
      $("#content .con_pager_up").parent("div").hide();
    }
  });

  // 下一页
  $("#content .con_pager_down").click(function () {
    var index = $lis.index($menu.find(".on"));
	pageScroll()
    if (index >= $lis.length - 1) {
      return;
    }

    $("#content .con_pager_up").parent("div").show();
    $lis.eq(index).removeClass("on").end().eq(index + 1).addClass("on");
    $detail.eq(index).hide().end().eq(index + 1).show();
    if (index + 1 == $lis.length - 1) {
      $("#content .con_pager_down").parent("div").hide();
    }
  });
  $("#picmini2").mouseover(function() {
	$("#picLagerid").src="./pics/pic (2).jpg"
	});
  $("#picmini2").mouseout(function() {
	$("#picLagerid").src="./pics/pic (2).jpg"
	});
}


function pageScroll(){
    //把内容滚动指定的像素数（第一个参数是向右滚动的像素数，第二个参数是向下滚动的像素数）
    window.scrollBy(0,-100);
    //延时递归调用，模拟滚动向上效果
    scrolldelay = setTimeout('pageScroll()',30);
    //获取scrollTop值，声明了DTD的标准网页取document.documentElement.scrollTop，否则取document.body.scrollTop；因为二者只有一个会生效，另一个就恒为0，所以取和值可以得到网页的真正的scrollTop值
    var sTop=document.documentElement.scrollTop+document.body.scrollTop;
    //判断当页面到达顶部，取消延时代码（否则页面滚动到顶部会无法再向下正常浏览页面）
    if(sTop==0) clearTimeout(scrolldelay);
}
//detail page js
/*function setDetailPager() {
  // 取得所有的内容分页
  var $menu = $("#content .detail_menu");
  var $lis = $menu.find("li");
  var $detail = $("#content .content_list_c .item_details");

  $lis.mouseover(function () {
    // 取得索引
    var index = $lis.index(this);

    $lis.removeClass("on");
    $(this).addClass("on");
    $detail.hide().eq(index).show();
	//第一页只有下一页，最后一页只有上一页
    if (index == 0) {
      $("#content .con_pager_up").parent("div").hide();
      $("#content .con_pager_down").parent("div").show();
    } else if (index == $lis.length - 1) {
      $("#content .con_pager_up").parent("div").show();
      $("#content .con_pager_down").parent("div").hide();
    }
  });



  // 上一页()
  $("#content .con_pager_up").click(function () {
    var index = $lis.index($menu.find(".on"));

    if (index <= 0) {
      return;
    }

    $("#content .con_pager_down").parent("div").show();
    $lis.eq(index).removeClass("on").end().eq(index - 1).addClass("on");
    $detail.eq(index).hide().end().eq(index - 1).show();
    if (index - 1 == 0) {
      $("#content .con_pager_up").parent("div").hide();
    }
  });

  // 下一页
  $("#content .con_pager_down").click(function () {
    var index = $lis.index($menu.find(".on"));

    if (index >= $lis.length - 1) {
      return;
    }

    $("#content .con_pager_up").parent("div").show();
    $lis.eq(index).removeClass("on").end().eq(index + 1).addClass("on");
    $detail.eq(index).hide().end().eq(index + 1).show();
    if (index + 1 == $lis.length - 1) {
      $("#content .con_pager_down").parent("div").hide();
    }
	
  });
  
  
  $("#picmini2").mouseover(function() {
	$("#picLagerid").src="./pics/pic (2).jpg"
	});
  $("#picmini2").mouseout(function() {
	$("#picLagerid").src="./pics/pic (2).jpg"
	});
  
}*/
//detail page showingpic

function mouseOver1()
{
document.getElementById('picLagerid').src ="./pics/pic (1).jpg"
}
function mouseOut1()
{
document.getElementById('picLagerid').src ="./pics/pic (1).jpg"
}
function mouseOver2()
{
document.getElementById('picLagerid').src ="./pics/pic (2).jpg"
}
function mouseOut2()
{
document.getElementById('picLagerid').src ="./pics/pic (2).jpg"
}
function mouseOver3()
{
document.getElementById('picLagerid').src ="./pics/pic (3).jpg"
}
function mouseOut3()
{
document.getElementById('picLagerid').src ="./pics/pic (3).jpg"
}
function mouseOver4()
{
document.getElementById('picLagerid').src ="./pics/pic (4).jpg"
}
function mouseOut4()
{
document.getElementById('picLagerid').src ="./pics/pic (4).jpg"
}
function mouseOver5()
{
document.getElementById('picLagerid').src ="./pics/pic (5).jpg"
}
function mouseOut5()
{
document.getElementById('picLagerid').src ="./pics/pic (5).jpg"
}
function mouseOver6()
{
document.getElementById('picLagerid').src ="./pics/pic (6).jpg"
}
function mouseOut6()
{
document.getElementById('picLagerid').src ="./pics/pic (6).jpg"
}
function mouseOver7()
{
document.getElementById('picLagerid').src ="./pics/pic (7).jpg"
}
function mouseOut7()
{
document.getElementById('picLagerid').src ="./pics/pic (7).jpg"
}
function mouseOver8()
{
document.getElementById('picLagerid').src ="./pics/pic (8).jpg"
}
function mouseOut8()
{
document.getElementById('picLagerid').src ="./pics/pic (8).jpg"
}

