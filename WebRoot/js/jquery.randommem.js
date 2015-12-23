$(function () {
showRadomDiv();

function showRadomDiv(){
	
  var $ramdiv = $("#content .content_left .person_list_one");
  var total = $ramdiv.length;//获得div的总个数
  var rd= Math.ceil(Math.random()*total)-1;//获得显示div的随机数
  var rd2= Math.ceil(Math.random()*total)-1;
  var rd3= Math.ceil(Math.random()*total)-1;
  while(rd2 == rd){
	  rd2=Math.ceil(Math.random()*total)-1;	  
  }
  while(rd3 == rd||rd3 == rd2){
	  rd3=Math.ceil(Math.random()*total)-1;	  
  }
  for(var i=0;i<total;i++){
   if(i==rd||i==rd2||i==rd3)
   $($ramdiv[i]).show();//显示随机的div;
	else
   $($ramdiv[i]).hide();//隐藏其它div,
   }
}  
});
