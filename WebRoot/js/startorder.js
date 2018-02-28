
//淇敼椁愬搧浠芥暟鏃讹紝鍏堣褰曞綋鍓嶇殑浠芥暟
function giveModNums(cn){
	$("#modnums_b")[0].value=cn.value;
}


//淇敼椁愬搧浠芥暟锛屽苟鏇存柊鐩稿簲鐨勯鍝佹�讳唤鏁板拰鎬讳环
function modNums(cn, perprice, mcent){
	
	var nowallnums=$("#allnums").html();  //椁愯溅涓殑椁愬搧鎬绘暟閲�
	var nowcpprice=$("#span_tjine").html();  //椁愯溅涓殑椁愬搧鎬讳环
	var nowcent=$("#span_tcent").html();  //椁愯溅涓殑绉垎鎬绘暟
	
	var modnums_b=$("#modnums_b")[0].value;  //淇敼鍓嶇殑浠芥暟
	var modnums_a=cn.value;  //淇敼鍚庣殑浠芥暟
	var modprice_b=perprice*modnums_b;  //淇敼鍓嶏紝褰撳墠椁愬搧鐨勬�讳环
	var modprice_a=perprice*modnums_a;  //淇敼鍚庯紝褰撳墠椁愬搧鐨勬�讳环
	var modcent_b=mcent*modnums_b;  //淇敼鍓嶏紝褰撳墠椁愬搧鐨勬�荤Н鍒�
	var modcent_a=mcent*modnums_a;  //淇敼鍚庯紝褰撳墠椁愬搧鐨勬�荤Н鍒�
	
	var cnid=cn.id;
	var cnid_arr=cnid.split("_");
	var goodstype=cnid_arr[1];
	var gid=cnid_arr[2];
	
	//鍒ゆ柇鎵�杈撳叆鐨勪唤鏁板�兼槸鍚︿负姝ｆ暣鏁�
	var r1= /^[0-9]*[1-9][0-9]*$/;
	if(!r1.test(modnums_a)){
		alert("璁㈣喘鏁伴噺閿欒");
		cn.value=modnums_b;
		return false;
	}
	
	if(modnums_a>0){
		//鍒ゆ柇鍗曚釜椁愬搧鐨勫簱瀛橀噺
		$.ajax({
			type: "POST",
			url:PDV_RP+"dingcan/post.php",
			data: "act=checkKucunDan&goodstype="+goodstype+"&gid="+gid+"&modnums="+modnums_a,
			success: function(msg){
				if(msg=="OK"){
					$("#jine_"+gid).html(modprice_a.toFixed(2));  //淇敼鍚庯紝褰撳墠椁愬搧灏忚
					$("#cent_"+gid).html(modcent_a);  //淇敼鍚庯紝褰撳墠椁愬搧绉垎灏忚
					$("#span_tcent").html(parseFloat(nowcent)-parseFloat(modcent_b)+parseFloat(modcent_a));  //淇敼鍚庯紝鎵�閫夐鍝佺Н鍒嗘�昏
					$("#allnums").html(parseFloat(nowallnums)-parseFloat(modnums_b)+parseFloat(modnums_a));
					$("#span_tjine").html((parseFloat(nowcpprice)-parseFloat(modprice_b)+parseFloat(modprice_a)).toFixed(2));
					$("#tjine")[0].value=(parseFloat(nowcpprice)-parseFloat(modprice_b)+parseFloat(modprice_a)).toFixed(2);
					
					//璁＄畻杩愯垂
					accountYunFei('qhold');
					getPaymethodIntro();
					
					//淇敼鐩稿簲鐨刢ookie
					$.ajax({
						type: "POST",
						url:PDV_RP+"setcookie.php",
						data: "act=setcookie&cookietype=modi&cookiename=DINGCANCART&goodstype="+goodstype+"&gid="+gid+"&nums="+modnums_a+"&fz=",
						success: function(msg){
							if(msg=="OK"){
								//window.location=PDV_RP+'shop/cart.php';
							}else if(msg=="1000"){
								alert("璁㈣喘鏁伴噺閿欒");
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
		//alert("瀵逛笉璧凤紝鎵�濉暟閲忓繀椤诲ぇ浜�);
		cn.value=modnums_b;
		return false;
	}

}


//鍒犻櫎褰撳墠鐨勬墍閫夐鍝�
function delOne(did, perprice){

	var nowallnums=$("#allnums").html();  //椁愯溅涓殑椁愬搧鎬绘暟閲�
	var nowcpprice=$("#span_tjine").html();  //椁愯溅涓殑椁愬搧鎬讳环
	
	var did_arr=did.split("_");
	var goodstype=did_arr[1];
	var gid=did_arr[2];
	var delnumsid="cpnums_"+goodstype+"_"+did_arr[2];
	var delnums=$("#"+delnumsid)[0].value;  //鍒犻櫎鎵�閫夐鍝佸悗锛岄渶鍑忓幓鐨勭浉搴斾唤鏁�
	var delprice=perprice*delnums; //鍒犻櫎鎵�閫夐鍝佸悗锛岄渶鍑忓幓鐨勭浉搴旈噾棰�
	
	$("#allnums").html(parseFloat(nowallnums)-parseFloat(delnums));
	$("#span_tjine").html((parseFloat(nowcpprice)-parseFloat(delprice)).toFixed(2));
	
	if($("#allnums").html()<="0"){$("#allnums").html("0");}
	if($("#span_tjine").html()<="0"){$("#span_tjine").html("0");}
	
	$('tr#'+did).remove();
	
	$().setBg();
	
	//鍒犻櫎鐩稿簲鐨刢ookie
	$.ajax({
		type: "POST",
		url:PDV_RP+"setcookie.php",
		data: "act=setcookie&cookietype=del&cookiename=DINGCANCART&goodstype="+goodstype+"&gid="+gid+"&nums="+delnums+"&fz=",
		success: function(msg){
			if(msg=="OK"){
				//window.location=PDV_RP+'shop/cart.php';
			}else if(msg=="1000"){
				alert("璁㈣喘鏁伴噺閿欒");
			}else{
				alert(msg);
			}
		}
	});
	
}


//鍒ゆ柇鏄惁鐧诲綍鍒嗗埆澶勭悊
$(document).ready(function(){
	
	$.ajax({
		type: "POST",
		url:PDV_RP+"post.php",
		data: "act=isLogin",
		success: function(msg){
			if(msg=="1"){
				$("div#notLogin").hide();
				$("div#isLogin").show();
				$("span#username").html(getCookie("MUSER"));

				//鑾峰彇鍘嗗彶璧勬枡
				$.ajax({
					type: "POST",
					url:PDV_RP+"dingcan/post.php",
					data: "act=getmemberinfo",
					success: function(msg){
						eval(msg);
						$("#name")[0].value=M.N;
						$("#tel")[0].value=M.T;
						$("#mov")[0].value=M.V;
					}
				});
				$().setBg();
			}else{
				$("div#isLogin").hide();
				$("div#notLogin").show();
				$('.loginlink').click(function() { 
					$().orderMemberLogin(1);
				});
				$().setBg();
			}
		}
	});
});


//浼氬憳閫�鍑�
$(document).ready(function(){
	
	$('.logoutlink').click(function(){ 
		
		$.ajax({
			type: "POST",
			url: PDV_RP+"post.php",
			data: "act=memberlogout",
			success: function(msg){
				if(msg=="OK"){
					window.location='startorder.php';
				}else{
					alert(msg);
				}
			}
		});
	

   }); 
});


//鑾峰彇寮瑰嚭寮忕櫥褰曟
(function($){
	$.fn.orderMemberLogin = function(act){
		
		//鑾峰彇鐧诲綍琛ㄥ崟
		$.ajax({
			type: "POST",
			url:PDV_RP+"member/post.php",
			data: "act=getpoploginform&RP="+PDV_RP,
			success: function(msg){
				
				$('html').append(msg);
				$.blockUI({message: $('div#loginDialog'),css:{width:'300px'}}); 
				$('.pwClose').click(function() { 
					if(act=="1"){
						$.unblockUI(); 
						$('div#loginDialog').remove();
					}else{
						window.location.reload();
					}
					
				}); 

				$('img#zhuce').click(function() { 
					$.unblockUI(); 
					window.location=PDV_RP+"member/reg.php";
				}); 

				$("img#fmCodeImg").click(function () { 
					$("img#fmCodeImg")[0].src=PDV_RP+"codeimg.php?"+Math.round(Math.random()*1000000);
				 });

				 $('#LoginForm').submit(function(){ 

					$('#LoginForm').ajaxSubmit({
						target: 'div#loginnotice',
						url: PDV_RP+'post.php',
						success: function(msg) {
							if(msg=="OK" || msg.substr(0,2)=="OK"){
								$('div#loginnotice').hide();
								$.unblockUI(); 
								$('div#loginDialog').remove();
								window.location.reload();
							}else{
								$('div#loginnotice').show();
							}
						}
					}); 
			   
				return false; 

			 }); 


			}
		});

		
	};
})(jQuery);


$(document).ready(function(){
	
	//鑾峰彇涓�绾ч厤閫佸尯鍩�
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/post.php",
		data: "act=getyunzone&pid=0",
		success: function(msg){

			$("#yunzone").append(msg);

			//涓�绾ч�夋嫨鏃惰幏鍙栦簩绾ч厤閫佸尯鍩�
			$("#yunzone").change(function(){
				var pid=$("#yunzone")[0].value;
				if(pid!=0){
					$.ajax({
						type: "POST",
						url:PDV_RP+"dingcan/post.php",
						data: "act=getyunzone&pid="+pid,
						success: function(msg){
							if(msg!=""){
								$("#subzone").html(msg).show();
								$("#zoneid")[0].value=$("#subzone")[0].value;
																
								//璁＄畻杩愯垂
								accountYunFei();
								getPaymethodIntro();

								$("#subzone").change(function(){
									$("#zoneid")[0].value=$("#subzone")[0].value;
									
									//璁＄畻杩愯垂
									accountYunFei();
									getPaymethodIntro();
								});
								$().setBg();
								
							}else{
								//璁＄畻杩愯垂
								accountYunFei();
								getPaymethodIntro();
							}
						}
					});
					
				}else{
					$("#subzone").hide();
					$("#zoneid")[0].value="0";
					//璁＄畻杩愯垂
					accountYunFei();
					getPaymethodIntro();
					$().setBg();
				}
			});

		}
	});

	//鍒濆鑾峰彇浠樻鏂规硶
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/post.php",
		data: "act=getpaymethod",
		success: function(msg){
			$("#payid").html(msg);
			
			//鑾峰彇鍒濆鏀粯璇存槑
			getPaymethodIntro();

			$("#payid").change(function(){
				getPaymethodIntro();
			});

		}
	});
	
	//鍒濆閫侀鏃堕棿
	var tcent=$("#span_tcent").html();
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/post.php",
		data: "act=getsctime&tcent="+tcent,
		success: function(msg){
			var msg_arr=msg.split("_");
			$("#sctime").html(msg_arr[3]);
			if(msg_arr[0]==1){
				$("#centinfo").html("閫夋嫨姝ゆ椂娈电殑绉垎姣斾緥涓�font style='color:#ff6600;font-weight:bold;'>"+msg_arr[1]+"</font>锛岃璁㈠崟鐨勬墍鑾风Н鍒嗕负<font style='color:#ff6600;font-weight:bold;'>"+msg_arr[2]+"</font>");
			}
		}
	});

});


//鑾峰彇鏀粯璇存槑
function getPaymethodIntro(){
	var payid=$("#payid")[0].value;
	if(payid=="0"){
		$.ajax({
			type: "POST",
			url:PDV_RP+"dingcan/post.php",
			data: "act=getmemberaccount",
			success: function(msg){
				if(msg=="0"){
					$("#payintro_text").html("鎮ㄥ皻鏈櫥褰�");
				}else{
					var ordertotal=$("span#ordertotal").html();
					if(Number(ordertotal)>Number(msg)){
						$("#payintro_text").html("鎮ㄧ殑浼氬憳甯愭埛浣欓锛�span id='memberaccount'>"+msg+"</span> 鍏冿紝浼氬憳甯愭埛浣欓涓嶈冻<br />璇烽�夋嫨绾夸笅鏀粯锛屾垨杩涜璐︽埛鍏呭��");
					}else{
						$("#payintro_text").html("鎮ㄧ殑浼氬憳甯愭埛浣欓锛�span id='memberaccount'>"+msg+"</span> 鍏冿紝鎮ㄥ彲浠ユ彁浜よ鍗曞苟浠庝細鍛樺笎鎴锋墸娆炬敮浠樿鍗�");
					}
				}
				$().setBg();
			}
		});
	}else{
		$.ajax({
			type: "POST",
			url:PDV_RP+"dingcan/post.php",
			data: "act=getpaymethodintro&payid="+payid,
			success: function(msg){
				$("#payintro_text").html(msg);
				$().setBg();
			}

		});
	}
}


//璇诲彇褰撳墠浼氬憳浣跨敤杩囩殑鍦板潃
$(document).ready(function(){
	
	var tjine=$("#tjine")[0].value;
	var iflogin=$("#ifmemberlogin")[0].value;
	
	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/post.php",
		data: "act=getmemberarea&tjine="+tjine,
		success: function(msg){
			if(iflogin==1){
				if(msg!=""){
					$("#oldarea").html(msg);
					
					//璁＄畻杩愯垂
					accountYunFei('qhold');
					getPaymethodIntro();
				}else{
					$("#memberareatype")[0].checked=false;
					$("#memberareatype2")[0].checked=true;
					$("#tr_oldarea").hide();
					$("#tr_jaddress").show();
					$("#yunzone").show();
					$("#tr_xaddress").show();
					
					$("#ifmemberlogin")[0].value=0;
					//璁＄畻杩愯垂
					accountYunFei('qhnew');
					getPaymethodIntro();
				}
			}else{
				//璁＄畻杩愯垂
				accountYunFei('qhold');
				getPaymethodIntro();
			}
		}
	});
	
});


//濉啓鍖哄煙鏃剁殑閫夋嫨鍒ゆ柇
$(document).ready(function(){
	$("#xaddress")[0].readOnly=true;
	$("#sarea").click(function(){
		if($("#sarea")[0].checked==true){
			$("#yunzone")[0].disabled=false;
			$("#subzone")[0].disabled=false;
			$("#jaddress")[0].readOnly=false;
			$("#xaddress")[0].readOnly=true;
			
			//璁＄畻杩愯垂
			accountYunFei();
			getPaymethodIntro();
		}
	});
	
	$("#warea").click(function(){
		if($("#warea")[0].checked==true){
			$("#yunzone")[0].disabled=true;
			$("#subzone")[0].disabled=true;
			$("#jaddress")[0].readOnly=true;
			$("#xaddress")[0].readOnly=false;
			
			//璁＄畻杩愯垂
			accountYunFei();
			getPaymethodIntro();
		}			
	});
});


//浼氬憳鐧诲綍鐘舵�佷笅锛屽垽鏂槸浣跨敤鍘熸潵鐨勫湴鍧�锛岃繕鏄～鍐欐柊鐨勫湴鍧�
$(document).ready(function(){
	
	$("#tr_jaddress").hide();
	$("#subzone").hide();
	$("#tr_xaddress").hide();
	
	if($("#ifmemberlogin")[0].value==1){
		$("#yunzone").hide();
	}else{
		$("#yunzone").show();
	}
	
	$("#memberareatype").click(function(){
		if($("#memberareatype")[0].checked==true){
			var yunzonevalue=$("#yunzone")[0].value;
			
			$("#tr_oldarea").show();
			$("#tr_jaddress").hide();
			$("#yunzone").hide();
			$("#tr_xaddress").hide();
			if(yunzonevalue==0){
				$("#subzone").hide();
			}else{
				$("#subzone").show();
			}
			
			$("#ifmemberlogin")[0].value=1;
			//璁＄畻杩愯垂
			accountYunFei('qhold');
			getPaymethodIntro();
		}			
	});
	
	$("#memberareatype2").click(function(){
		if($("#memberareatype2")[0].checked==true){
			$("#tr_oldarea").hide();
			$("#tr_jaddress").show();
			$("#yunzone").show();
			$("#tr_xaddress").show();
			
			$("#ifmemberlogin")[0].value=0;
			//璁＄畻杩愯垂
			accountYunFei('qhnew');
			getPaymethodIntro();
		}			
	});
	
});


//璁＄畻杩愯垂
function accountYunFei(obj){

	var tjine=$("#tjine")[0].value;
	var zoneid=$("#zoneid")[0].value;
	
	if($("#ifmemberlogin")[0].value==0){
		//闈炰細鍛樼姸鎬佷笅锛岀洿鎺ユ牴鎹墍閫夋嫨鐨勫湴鍧�濉啓鏂瑰紡璁＄畻杩愯垂
		if($("#sarea")[0].checked==true){
			var areatype=1;
		}else if($("#warea")[0].checked==true){
			var areatype=2;
		}
	}else{
	
		//浼氬憳鐧诲綍鐘舵�佷笅锛屽湪閫夋嫨浣跨敤鍘熸潵鐨勫湴鍧�鏃讹紝鏍规嵁鐐瑰嚮涓嶅悓鐨勫湴鍧�璁＄畻杩愯垂
		if($("#memberareatype")[0].checked==true){
			if(obj==0){
				var areatype=2;
				var zoneid=0;
			}else{
				var areatype=1;
				var zoneid=obj;
			}
		}
		
		//浼氬憳鐧诲綍鐘舵�佷笅锛屽湪浠庘�滀娇鐢ㄦ柊鍦板潃鈥濆垏鎹㈠埌鈥滀娇鐢ㄥ師鏉ョ殑鍦板潃鈥濇椂閲嶆柊璁＄畻杩愯垂
		if(obj=='qhold'){
			var getObj=$("input[name='oldarea']");
			for(var i=0; i<getObj.length; i++){
				if(getObj[i].checked==true){
					var id_arr=getObj[i].id.split("_");
					var zoneid=id_arr[1];
					if(zoneid==0){
						var areatype=2;
					}else{
						var areatype=1;
					}
				}
			}
		}
		
		//浼氬憳鐧诲綍鐘舵�佷笅锛屽湪浠庘�滀娇鐢ㄥ師鏉ョ殑鍦板潃鈥濆垏鎹㈠埌鈥滀娇鐢ㄦ柊鍦板潃鈥濇椂閲嶆柊璁＄畻杩愯垂
		if(obj=='qhnew'){
			if($("#sarea")[0].checked==true){
				var areatype=1;
			}else if($("#warea")[0].checked==true){
				var areatype=2;
			}
		}
		
	}

	$.ajax({
		type: "POST",
		url:PDV_RP+"dingcan/post.php",
		data: "act=accountyunfei&areatype="+areatype+"&zoneid="+zoneid+"&tjine="+tjine,
		success: function(msg){
			$("#span_yunfei").html(msg);
			
			//璁＄畻璁㈠崟鎬讳环
			var ordertotal=adv_format(Number($("input#tjine")[0].value)+Number(msg),2);
			$("#ordertotal").html(ordertotal);
		}
	});
}


//娴偣璁＄畻
function adv_format(value,num){
	var a_str = formatnumber(value,num);
	var a_int = parseFloat(a_str);
	if (value.toString().length>a_str.length){
		var b_str = value.toString().substring(a_str.length,a_str.length+1);
		var b_int = parseFloat(b_str);
		if (b_int<5){
			return a_str;
		}else{
			var bonus_str,bonus_int;
			if (num==0){
				bonus_int = 1;
			}else{
				bonus_str = "0.";
				for (var i=1; i<num; i++){
					bonus_str+="0";
				}
				bonus_str+="1";
				bonus_int = parseFloat(bonus_str);
			}
			a_str = formatnumber(a_int + bonus_int, num);
		}
	}
	return a_str;
}

//鐩存帴鍘诲熬
function formatnumber(value,num){
	var a,b,c,i;
	a = value.toString();
	b = a.indexOf('.');
	c = a.length;
	if (num==0){
		if (b!=-1){
			a = a.substring(0,b);
		}
	}else{
		if(b==-1){
			a = a + ".";
			for (i=1;i<=num;i++)
				a = a + "0";
		}else{
			a = a.substring(0,b+num+1);
			for (i=c;i<=b+num;i++){
				a = a + "0";
			}
		}
	}
	return a;
}


//绉垎璁＄畻锛嶈繘鍏ヨ鍗曢〉闈㈡椂鐨勫垵濮嬫彁绀�
$(document).ready(function(){
	$('#sctime').change(function(){ 
		var sctimeid=$("#sctime")[0].value;
		var tcent=$("#span_tcent").html();
		
		$.ajax({
			type: "POST",
			url:PDV_RP+"dingcan/post.php",
			data: "act=accountCent&sctimeid="+sctimeid+"&tcent="+tcent,
			success: function(msg){
				eval(msg);
				if(M.L==1){
					$("#centinfo").html("閫夋嫨姝ゆ椂娈电殑绉垎姣斾緥涓�font style='color:#ff6600;font-weight:bold;'>"+M.R+"</font>锛岃璁㈠崟鐨勬墍鑾风Н鍒嗕负<font style='color:#ff6600;font-weight:bold;'>"+M.C+"</font>");
				}
				
			}
		});
		
	});
});


//鎻愪氦璁㈠崟
$(document).ready(function(){
	$('#OrderForm').submit(function(){ 
		
		if($("#tjine")[0].value=="" || Number($("#tjine")[0].value)<0){
			alert("鎮ㄧ殑璐墿杞︿腑娌℃湁椁愬搧鎴栭鍝侀噾棰濋敊璇紝涓嶈兘鎻愪氦璁㈠崟");
			return false;
		}
		
		//閫侀鍦板潃鍒ゆ柇
		if($("#ifmemberlogin")[0].value==1 && $("#memberareatype")[0].checked==true){  //浼氬憳鐧诲綍鐘舵�佷笅锛屼娇鐢ㄥ師鏉ュ湴鍧�鐨勫垽鏂�
		
			var getObj=$("input[name='oldarea']");
			var kk=0;
			for(var i=0; i<getObj.length; i++){
				if(getObj[i].checked==true){
					kk++;
				}
			}
			if(kk!=1){
				alert("璇锋纭�夋嫨閫侀鍦板潃");
				return false;
			}
			
		}else{  //闈炰細鍛樼姸鎬佷笅锛屼互鍙婁細鍛樼櫥闄嗙姸鎬佷笅濉啓鏂板湴鍧�鏃剁殑鍒ゆ柇
		
			if($("#sarea")[0].checked==true){
				if($("#yunzone")[0].value=="0" || $("#yunzone")[0].value==""){
					alert("璇烽�夋嫨閫侀鍖哄煙");
					return false;
				}
			
				if($("#zoneid")[0].value=="0"){
					alert("璇烽�夋嫨閫侀鍖哄煙");
					return false;
				}
					
				if($("#jaddress")[0].value==""){
					alert("璇峰～鍐欏叿浣撳湴鍧�");
					return false;
				}
			}
				
			if($("#warea")[0].checked==true){
				if($("#xaddress")[0].value==""){
					alert("璇峰～鍐欒缁嗗湴鍧�");
					return false;
				}
			}
				
		}
		
		if($("#name")[0].value==""){
			alert("璇峰～鍐欏鎴峰悕绉�");
			return false;
		}

		var p=$("#tel")[0].value;
		var m=$("#mov")[0].value;
		if(p=="" && m==""){
			alert("鑱旂郴鐢佃瘽鍜屾墜鏈哄彿鐮侊紝蹇呴』鑷冲皯濉啓涓�涓�");
			return false;
		}else{
			if(m!=""){  //鎵嬫満鍙风爜鍒ゆ柇
				if(m.length<10){
					alert("璇疯緭鍏ユ纭殑鎵嬫満鍙风爜锛屽锛�912345678");
					return false;
				}
			}
		}

		if($("#payid")[0].value==""){
			alert("璇烽�夋嫨浠樻鏂瑰紡");
			return false;
		}
		
		if($("#sctime")[0].value==""){
			alert("璇烽�夋嫨閫侀鏃舵");
			return false;
		}

		$('#OrderForm').ajaxSubmit({
			target: 'div#notice',
			url: 'post.php',
			success: function(msg) {
				if(msg.substr(0,2)=="OK"){
					
					//娓呴櫎cookie
					$.ajax({
						type: "POST",
						url:PDV_RP+"setcookie.php",
						data: "act=setcookie&cookietype=empty&cookiename=DINGCANCART",
						success: function(msg){
						}
					});

					$('div#notice').hide();
					
					//鍒ゆ柇鏄惁鏀粯
					if(msg.substr(3,5)=="PAYED"){
						var orderid=msg.substr(9);
						$().alertwindow("鎮ㄧ殑璁㈠崟宸叉彁浜ゅ苟浠樻鎴愬姛锛屾垜浠細灏藉揩涓烘偍閫侀","orderdetail.php?orderid="+orderid);
					}else{
						var msg_arr=msg.split("_");
						var md=msg_arr[1];
						var orderid=msg_arr[2];
						//window.location="orderpay.php?orderid="+orderid;
						$().alertwindow("鎮ㄧ殑璁㈠崟宸叉彁浜ゆ垚鍔燂紝鎴戜滑浼氬敖蹇负鎮ㄩ�侀","orderdetail.php?orderid="+orderid+"&md="+md);
					}

				}else if(msg=="1000"){
					$('div#notice').hide();
					alert("鎮ㄧ殑璐墿杞︿腑娌℃湁椁愬搧");
				}else if(msg=="1001"){
					$('div#notice').hide();
					alert("璇锋纭�夋嫨閫侀鍦板潃");
				}else if(msg=="1002"){
					$('div#notice').hide();
					alert("璇烽�夋嫨閫侀鍖哄煙");
				}else if(msg=="1003"){
					$('div#notice').hide();
					alert("璇峰～鍐欏叿浣撳湴鍧�");
				}else if(msg=="1004"){
					$('div#notice').hide();
					alert("璇峰～鍐欒缁嗗湴鍧�");
				}else if(msg=="1005"){
					$('div#notice').hide();
					alert("璇烽�夋嫨浠樻鏂瑰紡");
				}else if(msg=="1006"){
					$('div#notice').hide();
					alert("鎮ㄥ皻鏈櫥褰曪紝涓嶈兘浠庝細鍛樺笎鎴锋墸娆炬敮浠樿鍗�");
				}else if(msg=="1007"){
					$('div#notice').hide();
					alert("椤甸潰瓒呮椂锛岃閲嶆柊閫夋嫨閫侀鏃舵");
					//閲嶆柊鍒濆閫侀鏃堕棿
					var tcent=$("#span_tcent").html();
					$.ajax({
						type: "POST",
						url:PDV_RP+"dingcan/post.php",
						data: "act=getsctime&tcent="+tcent,
						success: function(msg){
							var msg_arr=msg.split("_");
							$("#sctime").html(msg_arr[3]);
							if(msg_arr[0]==1){
								$("#centinfo").html("閫夋嫨姝ゆ椂娈电殑绉垎姣斾緥涓�font style='color:#ff6600;font-weight:bold;'>"+msg_arr[1]+"</font>锛岃璁㈠崟鐨勬墍鑾风Н鍒嗕负<font style='color:#ff6600;font-weight:bold;'>"+msg_arr[2]+"</font>");
							}
						}
					});
				}else if(msg=="1008"){
					$('div#notice').hide();
					alert("鎮ㄧ殑浼氬憳璐︽埛浣欓涓嶈冻锛岃閫夋嫨绾夸笅鏀粯鎴栬繘琛岃处鎴峰厖鍊�");
				}else if(msg=="1009"){
					$('div#notice').hide();
					alert("鑱旂郴鐢佃瘽鍜屾墜鏈哄彿鐮侊紝蹇呴』鑷冲皯濉啓涓�涓�");
				}else if(msg=="kongcart"){
					$('div#notice').hide();
					alert("鎮ㄧ殑璐墿杞︿腑娌℃湁椁愬搧");
				}else if(msg=="wrongcart"){
					$('div#notice').hide();
					alert("璁㈠崟閿欒");
				}else{
					$('div#notice')[0].className='noticediv';
					$('div#notice').show();
					$().setBg();
				}
			}
		});
		return false; 

   }); 
});




