
//三种订餐方式的点击切捄1�7
function changeBq(bqnow,bq1,bq2){
	//标签切换之标预1�7
	var ttnow = document.getElementById("tt_"+bqnow);
	var tt1 = document.getElementById("tt_"+bq1);
	var tt2 = document.getElementById("tt_"+bq2);

	ttnow.className="dingcanall_menunow";
	tt1.className="dingcanall_menu";
	tt2.className="dingcanall_menu";
	
	//标签切换之内宄1�7
	var mmnow = document.getElementById("mm_"+bqnow);
	var mm1 = document.getElementById("mm_"+bq1);
	var mm2 = document.getElementById("mm_"+bq2);
	
	mmnow.className="dingcanall_connow";
	mm1.className="dingcanall_con";
	mm2.className="dingcanall_con";
	
	$().setBg();
}


//三种订餐方式下的丄1�7级分类切捄1�7
function changeCat(ty,catid,n,k){

	//切换样式
	for(var i=1; i<=n; i++){
		if(i==k){
			$("#cat_"+ty+"_"+i)[0].className="catfontnow";
		}else{
			$("#cat_"+ty+"_"+i)[0].className="catfont";
		}
	}
	
	//读取数据
	var picw=$('#picw')[0].value;
	var pich=$('#pich')[0].value;
	var fittype=$('#fittype')[0].value;
	
	if(ty=="zx"){
		var pf="DingCanAllZx.php";
		var mm="smm_01";
	}else if(ty=="gd"){
		var pf="DingCanAllGd.php";
		var mm="smm_02";
	}

	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/module/"+pf+"?myrp="+PDV_RP+"&catid="+catid+"&k="+k+"&picw="+picw+"&pich="+pich+"&fittype="+fittype,
		data: "act=dingcanall_"+ty,
		success: function(msg){
				
			var msg_arr=msg.split("::");
				
			if(msg_arr[0]=="OK"){
				$('#'+mm).html(msg_arr[1]);
				$().setBg();
			}else{
				$().alertwindow(msg,"");
			}
						
		}
	});
	
}


//首页的餐品展示与订购
$(document).ready(function(){

	var picw=$('#picw')[0].value;
	var pich=$('#pich')[0].value;
	var fittype=$('#fittype')[0].value;
	
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/module/DingCanAllZx.php?myrp="+PDV_RP+"&picw="+picw+"&pich="+pich+"&fittype="+fittype,
		data: "act=dingcanall_zx",
		success: function(msg){
			
			var msg_arr=msg.split("::");
			
			if(msg_arr[0]=="OK"){
				$('#mm_01').html(msg_arr[1]);
				$().setBg();
			}else{
				$().alertwindow(msg,"");
			}
					
		}
	});
	
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/module/DingCanAllGd.php?myrp="+PDV_RP+"&picw="+picw+"&pich="+pich+"&fittype="+fittype,
		data: "act=dingcanall_gd",
		success: function(msg){
			
			var msg_arr=msg.split("::");
			
			if(msg_arr[0]=="OK"){
				$('#mm_02').html(msg_arr[1]);
				$().setBg();
			}else{
				$().alertwindow(msg,"");
			}
					
		}
	});
	
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/module/DingCanAllZh.php?myrp="+PDV_RP,
		data: "act=dingcanall_zh",
		success: function(msg){
			
			var msg_arr=msg.split("::");
			
			if(msg_arr[0]=="OK"){
				$('#mm_03').html(msg_arr[1]);
				$().setBg();
			}else{
				$().alertwindow(msg,"");
			}
					
		}
	});
			
});


//首页的餐品展示与订购--组合套餐选择改变后，其价格积分信息实时跟随变劄1�7
function changeZhInfo(selzh){

	var zhid=selzh.value;
	
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/module/DingCanAllZh.php?myrp="+PDV_RP+"&zhid="+zhid,
		data: "act=dingcanall_zh_info",
		success: function(msg){
			
			eval(msg);
	
			if(M.O=="OK"){
				$('font#zhpp').html(M.P);
				$('font#zhmc').html(M.C);
				$('span#zuchenginfo').html(M.I);
				$('input#zucheng')[0].value=M.Z;
				$('img.zhcpimg')[0].id="zh_"+zhid+"_"+M.P;
				$().setBg();
			}else{
				$().alertwindow(msg,"");
			}
					
		}
	});

}


//首页的餐品展示与订购--对组合餐品的选择数量进行判断
function checkSelNums(cb){
	
	//获取扄1�7点�1�7�的checkbox信息
	var cbname=cb.name;
	var cbid_str=cb.id;
	var cbid_arr=cbid_str.split("_");
	var cbcatid=cbid_arr[1];
	var cbid=cbid_arr[2];
	
	//对当前所选组合套餐的组成进行处理
	var zucheng=$("#zucheng")[0].value;
	var zucheng_arr=zucheng.split(",");
	var zucheng_arr_nums=zucheng_arr.length;
	for(var i=0; i<zucheng_arr_nums; i++){
		var zucheng_arr2=zucheng_arr[i].split(":");
		if(zucheng_arr2[0]==cbcatid){
			var nowcatnums=zucheng_arr2[1];
		}
	}

	//获取当前餐品类别下所选餐品的数量
	var cbcatlength;
	cbcatlength=$("input[name='"+cbname+"']:checked").length;
	
	//对当前所选餐品类别下选择的餐品数目进行判斄1�7
	if(cbcatlength>nowcatnums){
		alert("当前套餐限定该餐品最多只可�1�7�择"+nowcatnums+"丄1�7");
		cb.checked=false;
	}else{
		var nowzhmemo=$("#zhmemo")[0].value;
		if(cb.checked==true){
			if(nowzhmemo==""){
				var tozhmemo=cbid+":1";
			}else{
				var nowzhmemo_arr=nowzhmemo.split(",");
				if((cbid+":1") in nowzhmemo_arr){
					var tozhmemo=nowzhmemo;
				}else{
					var tozhmemo=nowzhmemo+","+cbid+":1";
				}
			}
			$("#zhmemo")[0].value=tozhmemo;
		}else{
			var delidinfo=cbid+":1";
			if(nowzhmemo!=""){
				var tozhmemo2=nowzhmemo.replace(delidinfo, "");
				var tozhmemo=tozhmemo2.replace(/,,/g, ",");
				if(tozhmemo.substr(tozhmemo.length-1)==","){
					tozhmemo=tozhmemo.substr(0,tozhmemo.length-1);
				}
			}
			$("#zhmemo")[0].value=tozhmemo;
		}
	}
	
}


//首页的餐品展示与订购--对组合餐品的选择数量进行提交判断
function checkSelNumsAll(dg){
	
	//对当前所选组合套餐的组成进行处理
	var zucheng=$("#zucheng")[0].value;
	var zucheng_arr=zucheng.split(",");
	var zucheng_arr_nums=zucheng_arr.length;
	for(var i=0; i<zucheng_arr_nums; i++){
		var zucheng_arr2=zucheng_arr[i].split(":");
		var cbname="zhcp_"+zucheng_arr2[0];
		var cbcatlength;
		cbcatlength=$("input[name='"+cbname+"']:checked").length;
		if(cbcatlength>zucheng_arr2[1]){
			
			$.ajax({
				type: "POST",
				url:"dingcan/module/DingCanAllZh.php?zhcatid="+zucheng_arr2[0]+"&maxnums="+zucheng_arr2[1]+"&yxnums="+cbcatlength,
				data: "act=dingcanall_zh_cuoxuan",
				success: function(msg){
					alert(msg);
				}
			});
			
			return false;
			
		}else if(cbcatlength<zucheng_arr2[1]){
			
			$.ajax({
				type: "POST",
				url:"dingcan/module/DingCanAllZh.php?zhcatid="+zucheng_arr2[0]+"&maxnums="+zucheng_arr2[1]+"&yxnums="+cbcatlength,
				data: "act=dingcanall_zh_cuoxuan",
				success: function(msg){
					alert(msg);
				}
			});
			
			return false;
			
		}
	}
	
	 addCart(dg);
	
}


//首页的餐品展示与订购--加入购物轄1�7
function addCart(dg){

	var imgid=dg.id;
	var imgid_arr=imgid.split("_");
	var goodstype=imgid_arr[0];  //当前餐品类型：diy,tc zh
	var gid=imgid_arr[1];  //当前餐品ID
	var perprice=imgid_arr[2];  //当前餐品单价
	var nowallnums=$("#allnums").html();  //餐车中的餐品总数釄1�7
	var nowcpprice=$("#cpprice").html();  //餐车中的餐品总价
	var div_id_strold="div_"+goodstype+"_"+gid;
	
	if(goodstype!="zh"){
		var snid=goodstype+"_"+gid+"_sn";
		var nums=$("#"+snid)[0].value;  //当前餐品扄1�7选数釄1�7
	}else{
		var nums=1;
		var memo=$("#zhmemo")[0].value;
	}

	var cpd=$(".cpline_d").length;
	var cps=$(".cpline_s").length;
	
	var ifhave_cpd="";
	var ifhave_cps="";
	
	for(var i=0; i<cpd; i++){
		var div_id_stri=$(".cpline_d")[i].id;
		if(goodstype!="zh" && div_id_stri==div_id_strold){
			ifhave_cpd="yes";
		}
	}
	
	for(var k=0; k<cps; k++){
		var div_id_strk=$(".cpline_s")[k].id;
		if(goodstype!="zh" && div_id_strk==div_id_strold){
			ifhave_cps="yes";
		}
	}

	if(ifhave_cpd=="yes" || ifhave_cps=="yes"){
	
		var nowcpnums=$("input#cpnums_"+goodstype+"_"+gid)[0].value;
		$("input#cpnums_"+goodstype+"_"+gid)[0].value=parseFloat(nowcpnums)+parseFloat(nums);
		$("#allnums").html(parseFloat(nowallnums)+parseFloat(nums));
		$("#cpprice").html(parseFloat(nowcpprice)+(parseFloat(perprice)*parseFloat(nums)));
		
		//写入cookie
		$.ajax({
			type: "POST",
			url:PDV_RP+"setcookie.php",
			data: "act=setcookie&cookietype=add&cookiename=DINGCANCART&goodstype="+goodstype+"&gid="+gid+"&nums="+nums+"&fz=",
			success: function(msg){
				if(msg=="OK"){
					//window.location=PDV_RP+'shop/cart.php';
				}else if(msg=="1000"){
					alert("订购数量错误");
				}else{
					alert(msg);
				}
			}
		});
		
	}else{
	
		$.ajax({
			type: "POST",
			url:PDV_RP+"dingcan/post.php?goodstype="+goodstype+"&gid="+gid+"&nums="+nums,
			data: "act=addcart",
			success: function(msg){
				
				eval(msg);
				
				if(M.O=="OK"){
					$('div#dcinfo').append(M.S);
					$("#allnums").html(parseFloat(nowallnums)+parseFloat(nums));
					$("#cpprice").html(parseFloat(nowcpprice)+(parseFloat(perprice)*parseFloat(nums)));
					$().setBg();
					$("div.cpline_d:even").addClass("cpline_s");
					
					//写入cookie
					var fz=$("#zhmemo")[0].value;
					$.ajax({
						type: "POST",
						url:PDV_RP+"setcookie.php",
						data: "act=setcookie&cookietype=add&cookiename=DINGCANCART&goodstype="+goodstype+"&gid="+gid+"&nums="+nums+"&fz="+fz,
						success: function(msg){
							if(msg=="OK"){
								//window.location=PDV_RP+'shop/cart.php';
							}else if(msg=="1000"){
								alert("订购数量错误");
							}else{
								alert(msg);
							}
						}
					});
					
				}else{
					//$().alertwindow(M.S,"");
					alert(M.S);
				}
						
			}
		});
	
	}
	
}


//首页的餐品展示与订购--清空购物轄1�7
function delAll(){
	$('div.cpline_d').remove();
	$('div.cpline_s').remove();
	
	$("#allnums").html("0");
	$("#cpprice").html("0");
	
	$().setBg();
	
	//清除cookie
	$.ajax({
		type: "POST",
		url:PDV_RP+"setcookie.php",
		data: "act=setcookie&cookietype=empty&cookiename=DINGCANCART",
		success: function(msg){
			if(msg=="OK"){
				//window.location=PDV_RP+'shop/cart.php';
			}else if(msg=="1000"){
				alert("订购数量错误");
			}else{
				alert(msg);
			}
		}
	});
}

//首页的餐品展示与订购--删除当前的所选餐哄1�7
function delOne(did, perprice){

	var nowallnums=$("#allnums").html();  //餐车中的餐品总数釄1�7
	var nowcpprice=$("#cpprice").html();  //餐车中的餐品总价
	
	var did_arr=did.split("_");
	var goodstype=did_arr[1];
	var gid=did_arr[2];
	var delnumsid="cpnums_"+goodstype+"_"+did_arr[2];
	var delnums=$("#"+delnumsid)[0].value;  //删除扄1�7选餐品后，需减去的相应份敄1�7
	var delprice=perprice*delnums; //删除扄1�7选餐品后，需减去的相应金预1�7
	
	$("#allnums").html(parseFloat(nowallnums)-parseFloat(delnums));
	$("#cpprice").html(parseFloat(nowcpprice)-parseFloat(delprice));
	
	if($("#allnums").html()<="0"){$("#allnums").html("0");}
	if($("#cpprice").html()<="0"){$("#cpprice").html("0");}
	
	$('div#'+did).remove();
	$("div.cpline_s").removeClass("cpline_s");
	$("div.cpline_d:even").addClass("cpline_s");
	
	$().setBg();
	
	//删除相应的cookie
	$.ajax({
		type: "POST",
		url:PDV_RP+"setcookie.php",
		data: "act=setcookie&cookietype=del&cookiename=DINGCANCART&goodstype="+goodstype+"&gid="+gid+"&nums="+delnums+"&fz=",
		success: function(msg){
			if(msg=="OK"){
				//window.location=PDV_RP+'shop/cart.php';
			}else if(msg=="1000"){
				alert("订购数量错误");
			}else{
				alert(msg);
			}
		}
	});
	
}


//首页的餐品展示与订购--修改餐品份数时，先记录当前的份数
function giveModNums(cn){
	$("#modnums_b")[0].value=cn.value;
}


//首页的餐品展示与订购--修改餐品份数，并更新相应的餐品�1�7�份数和总价
function modNums(cn, perprice){
	
	var nowallnums=$("#allnums").html();  //餐车中的餐品总数釄1�7
	var nowcpprice=$("#cpprice").html();  //餐车中的餐品总价
	
	var modnums_b=$("#modnums_b")[0].value;  //修改前的份数
	var modnums_a=cn.value;  //修改后的份数
	var modprice_b=perprice*modnums_b;  //修改前，当前餐品的�1�7�价
	var modprice_a=perprice*modnums_a;  //修改后，当前餐品的�1�7�价
	
	var cnid=cn.id;
	var cnid_arr=cnid.split("_");
	var goodstype=cnid_arr[1];
	var gid=cnid_arr[2];
	
	//判断扄1�7输入的份数�1�7�是否为正整敄1�7
	var r1= /^[0-9]*[1-9][0-9]*$/;
	if(!r1.test(modnums_a)){
		alert("订购数量错误");
		cn.value=modnums_b;
		return false;
	}
	
	if(modnums_a>0){
		//判断单个餐品的库存量
		$.ajax({
			type: "POST",
			url:PDV_RP+"dingcan/post.php",
			data: "act=checkKucunDan&goodstype="+goodstype+"&gid="+gid+"&modnums="+modnums_a,
			success: function(msg){
				if(msg=="OK"){
					$("#allnums").html(parseFloat(nowallnums)-parseFloat(modnums_b)+parseFloat(modnums_a));
					$("#cpprice").html(parseFloat(nowcpprice)-parseFloat(modprice_b)+parseFloat(modprice_a));
					
					//修改相应的cookie
					$.ajax({
						type: "POST",
						url:PDV_RP+"setcookie.php",
						data: "act=setcookie&cookietype=modi&cookiename=DINGCANCART&goodstype="+goodstype+"&gid="+gid+"&nums="+modnums_a+"&fz=",
						success: function(msg){
							if(msg=="OK"){
								//window.location=PDV_RP+'shop/cart.php';
							}else if(msg=="1000"){
								alert("订购数量错误");
							}else{
								alert(msg);
							}
						}
					});
				}else{
					alert(msg);
					cn.value=modnums_b;
					return false;
				}
			}
		});
	}else{
		//alert("对不起，扄1�7填数量必须大亄1�7);
		cn.value=modnums_b;
		return false;
	}
	
}


