$(function () {
  // 首页菜单
  $("#index_menu_l ul li").hover(function () {
    $(this).children("div").show();
  }, function () {
    $(this).children("div").hide();
  });

  // 首页广告
  $('#adlist').kxbdSuperMarquee({
    distance: 980,
    time: 6,
    duration:15,
    navId: '#adlist_num',
    direction: 'left'
  });

//  $("#goright").click(function () {
//    $("#index_scrollnews ul").animate({ marginRight: '-780px' }, "slow");
//  });
//  $("#goleft").click(function () {
//    $("#index_scrollnews ul").animate({ marginRight: '+780px' }, "slow");
//  });
//  $("#index_scrollnews ul").width(6000).css("padding-left", 150);




    $('#index_scrollnews').kxbdSuperMarquee({
      isAuto: false,
      distance: 800,
      btnGo: { left: '#goleft', right: '#goright' },
      direction: 'left'
    });

  // 焦点新闻滚动
  //  $("#index_scrollnews").kxbdSuperMarquee({
  //    isMarquee: true,
  //    isEqual: false,
  //    scrollDelay: 40,
  //    controlBtn: { left: "#goleft", right: "#goright" },
  //    direction: "left"
  //  });

  // 加载二级菜单
  initialSubMenu(0);
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
    $.get("/ComteckService.asmx/SelectChannelByPid?pid=" + pid, {}, function (response) {
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
    });
  });
  $('#close_im').bind('click',function(){
		$('#main-im').css("height","0");
		$('#im_main').hide();
		$('#open_im').show();
	});
	$('#open_im').bind('click',function(e){
		$('#main-im').css("height","272");
		$('#im_main').show();
		$(this).hide();
	});
	$('.go-top').bind('click',function(){
		$(window).scrollTop(0);
	});
	$(".weixing-container").bind('mouseenter',function(){
		$('.weixing-show').show();
	})
	$(".weixing-container").bind('mouseleave',function(){        
		$('.weixing-show').hide();
	});
}