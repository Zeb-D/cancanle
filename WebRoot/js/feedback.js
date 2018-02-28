


//鍙嶉琛ㄥ崟鎻愪氦
$(document).ready(function(){
	$('#feedbackform').submit(function(){ 
		$('#feedbackform').ajaxSubmit({
			target: 'div#notice',
			url: PDV_RP+'feedback/post.php',
			success: function(msg) {
				if(msg=="OK"){
					$('div#notice').hide();
					$().alertwindow("鎮ㄧ殑鐣欒█宸叉彁浜わ紝鎴戜滑浼氬敖蹇拰鎮ㄨ仈绯�,");
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


//鍏ㄧ珯鍙嶉琛ㄥ崟鎻愪氦
$(document).ready(function(){
	$('#feedbacksmallform').submit(function(){ 
		$('#feedbacksmallform').ajaxSubmit({
			target: 'div#notice',
			url: PDV_RP+'feedback/post.php',
			success: function(msg) {
				if(msg=="OK"){
					$('div#notice').hide();
					$().alertwindow("鎮ㄧ殑鐣欒█宸叉彁浜わ紝鎴戜滑浼氬敖蹇拰鎮ㄨ仈绯�,");
				}else{
					$('div#notice').hide();
					alert(msg);
				}
			}
		}); 
       return false; 

   }); 
});


