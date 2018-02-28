<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
  
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	
%>






<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><%=session.getAttribute("username") %>欢迎登录餐餐乐！</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/blockui.js"></script>

</head>

<body style='background:transparent'>
	<script>
		var PDV_PAGEID = '1';
		var PDV_RP = '';
		var PDV_COLTYPE = 'index';
		var PDV_PAGENAME = 'index';
		var totalprice= 0;
		var amount = 0;
		function addFood(price){
		
		}
		
	</script>

	<div id='contain'
		style='width:900px;background:rgb(255,255,255);margin:0px auto;padding:0px'>

		<div id='top'
			style='width:900px;height:108px;background:none transparent scroll repeat 0% 0%'>


			<%--include index_top --%>
    		<%@ include file="index_top.jspf" %>
   			<%--/include index_top --%>
			<!-- 二级导航菜单 -->

			<div id='pdv_3605' class='pdv_class'
				style='width:898px;height:41px;top:65px;left:0px; z-index:6'>
				<div id='spdv_3605' class='pdv_top'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">

							<link href="css/A.css" rel="stylesheet" type="text/css" />
							<script type="text/javascript" src="js/channelmenu_dc.js"></script>

							<div id="menu">
								<div class="mainmenuleft"></div>
								<div class="mainmenuright"></div>

								<div id="mainmenu">
									<ul>

										<li><a href="index.jsp" target="_self">首页</a></li>

										<li><a href="search.jsp" target="_self">订单查询</a></li>

										<li><a href="orderhelp.jsp" target="_self">订餐指南</a></li>

										<li><a href="center.jsp" target="_self">会员中心</a></li>

										<li><a href="<%=basePath %>FoodOrder/queryList1.do" target="_self">我的订单</a></li>

										<li><a href="restaurant.jsp" target="_self">店铺详情</a></li>

										<li><a href="note.jsp" target="_self">顾客留言</a></li>

									</ul>
								</div>

								<div id="smenu">
									<div class="smenuleft"></div>
									<div class="smenuright"></div>
									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

								</div>
							</div>
							<script>
								showMenu(0);
							</script>

						</div>
					</div>

				</div>
			</div>

			<!-- 网站标志 -->

			<div id='pdv_3608' class='pdv_class' title=''
				style='width:208px;height:101px;top:0px;left:0px; z-index:9'>
				<div id='spdv_3608' class='pdv_top'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">


							<img src="images/1257477260.gif" border="0" width="100%" />


						</div>
					</div>

				</div>
			</div>
		</div>
		<div id='content'
			style='width:900px;height:1570px;background:none transparent scroll repeat 0% 0%;margin:10px auto'>


			<!-- 订餐时间信息 -->

			<div id='pdv_3604' class='pdv_class' title='订餐时间'
				style='width:243px;height:195px;top:0px;left:655px; z-index:1'>
				<div id='spdv_3604' class='pdv_content'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
								订餐时间</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">

							<link href="css/dingcantimeinfo.css" rel="stylesheet"
								type="text/css">

							<div id="dingcantime">
								<div id="dingcantime2">

									<div id="dingcantime_top">
										<div id="dingcantime_top_left">订餐时间</div>
										<div id="dingcantime_top_right">&nbsp;</div>
									</div>

									<div style="padding:px;">

										<div class="dingcantimeinfo">
											<div style="height:24px;font-size:14px;font-weight:bold;">
												<font style="color:#ef6906;">午餐：</font><font
													style="color:#404040;">9:00&nbsp;-&nbsp;13:00</font>
											</div>
											<div style="height:24px;font-size:14px;font-weight:bold;">
												<font style="color:#ef6906;">晚餐：</font><font
													style="color:#404040;">16:00&nbsp;-&nbsp;19:00</font>
											</div>
											<div style="height:20px;font-size:12px;color:#e52614;">注：周六日或其他时间用餐，请提前来电</div>
											<div
												style="height:24px;font-size:14px;font-weight:bold;color:#f16906;">电话订餐：4008008818</div>
											<div style="text-align:center;">


												<img src='images/qq_offline.gif' border='0' />&nbsp;&nbsp;&nbsp;
											</div>
											<div style="text-align:center;padding-top:5px;">
												<a href='msnim:chat?contact=dingcan@hotmail.com'
													style='font-weight:bold;color:#ee6a06;' tareget='_blank'>msn:dingcan@hotmail.com<img
													src='images/msn.gif' border='0' /></a>
											</div>
										</div>


									</div>

								</div>
							</div>

							<div id="dingcantime_bottom_left">&nbsp;</div>
							<div id="dingcantime_bottom_right">&nbsp;</div>

						</div>
					</div>

				</div>
			</div>

			<!-- 订餐车 -->

			<div id='pdv_3614' class='pdv_class' title='我的餐车'
				style='width:243px;height:123px;top:201px;left:655px; z-index:2'>
				<div id='spdv_3614' class='pdv_content'
					style='overflow:visible;width:100%;'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
								我的餐车</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">

							<link href="css/dingcanche.css" rel="stylesheet" type="text/css">
							<script language="javascript" src="js/dingcanall.js"></script>
							<script language="javascript" src="js/dingcansubmit.js"></script>

							<div id="dingcanche">
								<div id="dingcanche2">

									<div id="dingcanche_top">
										<div id="dingcanche_top_left">我的餐车</div>
										<div id="dingcanche_top_right">&nbsp;</div>
									</div>

									<div style="padding:px;margin-bottom:10px;">

										<div
											style="height:13px;background:#f6f6f6;margin:0px 3px 1px 3px;">
											<div style="float:left;padding-left:60px;">名称</div>
											<div style="float:right;padding-right:3px;">取消</div>
											<div style="float:right;padding-right:10px;">份数</div>
											<div style="float:right;padding-right:10px;">单价</div>
										</div>

										<div id="dcinfo" style="margin:0px 3px 1px 3px;"></div>

										<div style="height:24px;margin:5px 3px 1px 3px;">
											<div style="float:left;line-height:24px;padding-left:25px;">小&nbsp;&nbsp;计：</div>
											<div id="total" style="float:right;line-height:24px;padding-right:15px;">
												<font id="allnums" style="color:#ff0000;">${total}</font>份
											</div>
											<div id="all_price" style="float:right;line-height:24px;padding-right:30px;">
												<font id="cpprice" style="color:#ff0000;">${totalprice }</font>元
											</div>
										</div>

										<div style="height:26px;margin:5px 3px 1px 3px;">
											<div id="cartsubmit"
												style="float:left;padding-left:90px;cursor:pointer;">
												<div id="food1"></div>
												<a href="<%=basePath%>Cart/zhifu.do">
												<img src="images/canche_submit.gif" border="0" />
												</a>
											</div>
											<div style="float:left;padding-left:10px;cursor:pointer;"
												onClick="delAll();">
												<img src="images/quxiao2.gif" border="0" />
											</div>
										</div>


									</div>

								</div>
							</div>

							<div id="dingcanche_bottom_left">&nbsp;</div>
							<div id="dingcanche_bottom_right">&nbsp;</div>

							<input type="hidden" name="modnums_b" id="modnums_b" value="" />

							<script>
								$("div.cpline_d:even").addClass("cpline_s");
							</script>


						</div>
					</div>

				</div>
			</div>

			<!-- 文章列表 -->

			<div id='pdv_3603' class='pdv_class' title='网站公告'
				style='width:243px;height:186px;top:336px;left:655px; z-index:3'>
				<div id='spdv_3603' class='pdv_content'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="border:0px;height:100%;padding:0;margin:0;background:url(base/border/640/images/left.jpg) repeat-y">
						<div
							style="height:100%;background:url(images/right.jpg) right repeat-y">
							<div
								style="height:43px;background:url(images/bg.jpg) 0px 0px no-repeat">
								<div
									style="float:left;font:bold 16px/43px 'Microsoft YaHei','SimSun',Arial,Sans-Serif;text-align:left;padding-left:50px;color:#feab43;">
									网站公告</div>
								<div
									style="float:right;width:60px;height:43px;text-align:right;background:url(images/bg.jpg) -840px 0px no-repeat">
									<a href="news/class/"
										style="font:12px/43px simsun;color:#505050;margin-right:12px;display:inline">更多&gt;&gt;</a>
								</div>
							</div>
							<div style="margin:0px 3px;padding:10px;">

								<link href="css/newslist_time2.css" rel="stylesheet"
									type="text/css" />
								<ul class="newslist_time2">

									<li class="newslist_time2"><div class="time">09/27</div> <a
										href="news/html/?297.jsp" target="_self"
										class="newslist_time2">金秋来临，菜品赠品大升级</a></li>

									<li class="newslist_time2"><div class="time">09/27</div> <a
										href="news/html/?296.jsp" target="_self"
										class="newslist_time2">积分换电影票，奖品大变样</a></li>

									<li class="newslist_time2"><div class="time">09/27</div> <a
										href="news/html/?295.jsp" target="_self"
										class="newslist_time2">精品盖浇饭上市喽</a></li>

									<li class="newslist_time2"><div class="time">09/27</div> <a
										href="news/html/?294.jsp" target="_self"
										class="newslist_time2">10月团体订餐优惠活动开始</a></li>

									<li class="newslist_time2"><div class="time">09/27</div> <a
										href="news/html/?293.jsp" target="_self"
										class="newslist_time2">节日放假通知</a></li>

								</ul>

							</div>
						</div>
					</div>
					<div
						style="margin-top:-10px;height:10px;line-height:10px;background:url(images/bg.jpg) 0px -220px no-repeat">&nbsp;</div>
					<div
						style="float:right;margin-top:-10px;width:10px;height:10px;line-height:10px;background:url(images/bg.jpg) -890px -220px no-repeat">&nbsp;</div>

				</div>
			</div>

			<!-- 本周菜单 -->

			<div id='pdv_3613' class='pdv_class' title='本周菜单'
				style='width:243px;height:100px;top:534px;left:655px; z-index:5'>
				<div id='spdv_3613' class='pdv_content'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
								本周菜单</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">

							<link href="css/dingcanweekmenu.css" rel="stylesheet"
								type="text/css">

							<div id="dingcanweekmenu">
								<div id="dingcanweekmenu2">

									<div id="dingcanweekmenu_top">
										<div id="dingcanweekmenu_top_left">本周菜单</div>
										<div id="dingcanweekmenu_top_right">&nbsp;</div>
									</div>

									<div style="padding:px;">

										<div class="dingcanweekmenuinfo">

											<table width="100%" border="0" cellspacing="0"
												cellpadding="3" height="30" style="background:#fef0d3;">
												<tr>
													<td rowspan="2" align="center"><span
														style="background:#f99d20;color:#ffffff;">07</span></td>
													<td>一</td>
													<td>二</td>
													<td>三</td>
													<td>四</td>
													<td>五</td>
													<td>六</td>
													<td>日</td>
												</tr>

												<tr>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=04'
														class='puriqiclass'>04</a></td>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=05'
														class='puriqiclass'>05</a></td>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=06'
														class='puriqiclass'>06</a></td>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=07'
														class='puriqiclass'>07</a></td>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=08'
														class='puriqiclass'>08</a></td>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=09'
														class='puriqiclass'>09</a></td>
													<td class='riqi'><a href='dingcan/caipu.php?m=07&d=10'
														class='puriqiclass'>10</a></td>
												</tr>

											</table>

										</div>


									</div>

								</div>
							</div>

							<div id="dingcanweekmenu_bottom_left">&nbsp;</div>
							<div id="dingcanweekmenu_bottom_right">&nbsp;</div>

						</div>
					</div>

				</div>
			</div>

			<!-- 餐品展示与订购 -->

			<div id='pdv_3606' class='pdv_class' title=''
				style='width:648px;height:1409px;top:0px;left:0px; z-index:12'>
				<div id='spdv_3606' class='pdv_content'
					style='overflow:visible;width:100%;'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">

							<link href="css/dingcanall.css" rel="stylesheet" type="text/css">
							<script language="javascript" src="js/dingcanall.js"></script>

							<div id="dingcanall">
								<div id="dingcanall2">

									<div id="dingcanall_top">
										<div id="dingcanall_top_left">&nbsp;</div>
										<div id="dingcanall_top_mid">
											<div>
												<div id="tt_01" class="dingcanall_menunow"
													style="display:block;" onClick="changeBq('01','02','03');">自选订餐</div>
												<div id="tt_02" class="dingcanall_menu"
													style="display:block;" onClick="changeBq('02','01','03');">固定套餐</div>
												<div id="tt_03" class="dingcanall_menu"
													style="display:block;" onClick="changeBq('03','02','01');">组合套餐</div>
											</div>
										</div>
										<div id="dingcanall_top_right">&nbsp;</div>
									</div>

									<div style="margin-top:-35px;padding:px;">

										<div id="mm_01" class="dingcanall_connow">
											<table>
												<c:forEach items="${page.list}" var="all" varStatus="status">
													<c:if test="${status.index % 2 == 0}">
														<tr></tr>
													</c:if>


													<td style="width:330px;margin-top:10px;">
														<div>
															<table>
																<tr>
																	<td rowspan="5" class="bookPic"><img
																		src="<%=basePath %>${all.picture }" style="border:1px solid #300;width:100px;height:100px" /></td>
																	<td><span>菜名:</span></td>
																	<td><span><strong>${all.foodname}</strong></span></td>
																</tr>
																<tr>
																	<td><span>市场价格:</span></td>
																	<td><span>${all.price}</span></td>
																</tr>
																<tr>
																	<td><span>剩余量:</span></td>
																	<td><span><strong style="color:red;">${all.rest}</strong></span></td>
																</tr>
																<tr>
																	<td><span>总销量:</span></td>
																	<td><span>${all.totalsell }</span></td>
																</tr>
																<tr>
																	<td><span>评星:</span></td>
																	<td><span>${all.stars }</span></td>
																</tr>
																<tr>
																	<td colspan="2" style="height:40px;">
																	
																	<a href="<%=basePath%>Index/addFood.do?price=${all.price}">
																	<img src="images/cart.png" onclick="addFood(${all.price})" />
																	</a>
																	</td>
																	<td></td>
																</tr>
															</table>
														</div>
													</td>


												</c:forEach>
											</table>
										</div>

										<%--<div id="mm_02" class="dingcanall_con">
        <table>
       
                              <tr>
                           	  <td style="width:330px;margin-top:10px;">
                            	   <div>
                                	<table>
                                    	<tr>
                                        	<td rowspan="5" class="bookPic"><img src="images/1257398155.jpg" style="border:1px solid #300;"/></td>
                                            <td><span>菜名:</span></td>
                                            <td><span><strong>测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>市场价格:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>会员价格:</span></td>
                                            <td><span><strong style="color:red;">测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>制做说明:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>菜品类型:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td colspan="2" style="height:40px;"><img src="images/cart.png"/></td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                         	<td>
                            	<div>
                                	<table>
                                    	<tr>
                                        	<td rowspan="5" class="bookPic"><img src="images/1257835997.jpg"style="border:1px solid #300;"/></td>
                                            <td><span>菜名:</span></td>
                                            <td><span><strong>测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>市场价格:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>会员价格:</span></td>
                                            <td><span><strong style="color:red;">测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>制做说明:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>菜品类型:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td colspan="2" style="height:40px;"><img src="images/cart.png"/></td>
                                        </tr>
                                    </table>
                                </div>
                           </td>
                           </tr>
						</table>
        </div>
		 
		
		<div id="mm_03" class="dingcanall_con">
        <table>
                              <tr>
                           	  <td style="width:330px;margin-top:10px;">
                            	   <div>
                                	<table>
                                    	<tr>
                                        	<td rowspan="5" class="bookPic"><img src="images/1257397027.jpg" style="border:1px solid #300;"/></td>
                                            <td><span>菜名:</span></td>
                                            <td><span><strong>测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>市场价格:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>会员价格:</span></td>
                                            <td><span><strong style="color:red;">测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>制做说明:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>菜品类型:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td colspan="2" style="height:40px;"><img src="images/cart.png"/></td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                         	<td>
                            	<div>
                                	<table>
                                    	<tr>
                                        	<td rowspan="5" class="bookPic"><img src="images/1257396703.jpg"style="border:1px solid #300;"/></td>
                                            <td><span>菜名:</span></td>
                                            <td><span><strong>测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>市场价格:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>会员价格:</span></td>
                                            <td><span><strong style="color:red;">测试文字</strong></span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>制做说明:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td><span>菜品类型:</span></td>
                                            <td><span>测试文字</span></td>
                                        </tr>
                                        <tr>
                                        	<td colspan="2" style="height:40px;"><img src="images/cart.png"/></td>
                                        </tr>
                                    </table>
                                </div>
                           </td>
                           </tr>
						</table>
        </div>
		--%>
									</div>

								</div>
							</div>
							<div class="list-page">  ${page.currentPage}/${page.totalPage}页 共${page.total}行
                   
                    <a id="shang" href="Index/queryList.do?page=${page.currentPage-1}">上一页</a>
                    <a id="xia" href="Index/queryList.do?page=${page.currentPage+1}">下一页</a>
                    </div> 

							<div id="dingcanall_bottom_left">&nbsp</div>
							<div id="dingcanall_bottom_right">&nbsp;</div>

							<input type="hidden" name="picw" id="picw" value="150" /> <input
								type="hidden" name="pich" id="pich" value="140" /> <input
								type="hidden" name="fittype" id="fittype" value="auto" />


						</div>
					</div>

				</div>

			</div>
			
			<!-- 图片/FLASH -->

			<div id='pdv_3602' class='pdv_class' title=''
				style='width:649px;height:151px;top:1421px;left:0px; z-index:13'>
				<div id='spdv_3602' class='pdv_content'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">


							<img src="images/1254038036.gif" border="0" width="100%" />

						</div>
					</div>

				</div>
			</div>
		</div>
		<div id='bottom'
			style='width:900px;height:173px;background:none transparent scroll repeat 0% 0%'>


			<!-- 底部信息编辑区 -->

			<div id='pdv_3610' class='pdv_class' title='脚注信息'
				style='width:898px;height:106px;top:65px;left:0px; z-index:7'>
				<div id='spdv_3610' class='pdv_bottom'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
								脚注信息</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">
							<div
								style="width:100%;text-align:center;font:12px/20px Arial, Helvetica, sans-serif">
								<div style="LINE-HEIGHT: 30px">电话：0573-87654321
									售前QQ：241457 45761112 地址：浙江省嘉兴市建国南路1586号 邮编：314000 （商务合作）</div>
								<div style="LINE-HEIGHT: 30px">网上快餐店 Copyright(C)2009-2010</div>
							</div>

						</div>
					</div>

				</div>
			</div>


			<link href="css/A.css" rel="stylesheet" type="text/css" />
			<div id="bottommenu">

				<a href="onwe.jsp" target="_self">关于我们</a>| <a href="orderhelp.jsp"
					target="_self">订餐指南</a>| <a href="carryshow.jsp" target="_self">配送说明</a>|

				<a href="linkman.jsp" target="_self">联系方式</a>| <a href="advise.jsp"
					target="_self">投诉建议</a>|

			</div>
			<!-- 底部菜单（一级） -->

			<div id='pdv_3612' class='pdv_class'
				style='width:898px;height:35px;top:0px;left:0px; z-index:8'>
				<div id='spdv_3612' class='pdv_bottom'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px"></div>
					</div>

				</div>
			</div>

			<!-- 文字友情链接 -->

			<div id='pdv_3609' class='pdv_class' title=''
				style='width:898px;height:30px;top:35px;left:0px; z-index:10'>
				<div id='spdv_3609' class='pdv_bottom'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:inline">
								<a href="advs/link/" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:5px">

							<ul style="margin:0;padding:0">

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://food.39.net/" target="_self">39健康网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://eat.51ttyy.com/" target="_self">天天营养网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.canyin.com/" target="_self">中国餐饮网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.canyinshijie.com/" target="_self">餐饮世界网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.tesecai.cn/" target="_self">特色菜网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.westfood.com.cn/" target="_self">中国西餐网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.chinavegan.com/" target="_self">中华素食网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.kclm.org/" target="_self">中国快餐联盟网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.souchu.com/" target="_self">搜厨网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.cantingsheji.com/" target="_self">餐厅设计网</a>
								</li>

								<li
									style="list-style-type:none;float:left;margin:0px;padding:3px 10px 3px 10px; white-space:nowrap">
									<a href="http://www.meishichina.com/" target="_self">美食中国</a>
								</li>

							</ul>

						</div>
					</div>

				</div>
			</div>

			<!-- 图片/FLASH -->

			<div id='pdv_3611' class='pdv_class' title=''
				style='width:121px;height:44px;top:94px;left:656px; z-index:11'>
				<div id='spdv_3611' class='pdv_bottom'
					style='overflow:hidden;width:100%;height:100%'>
					<div class="pdv_border"
						style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
						<div style="height:25px;margin:1px;display:none;background:;">
							<div
								style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">

							</div>
							<div style="float:right;margin-right:10px;display:none">
								<a href="-1" style="line-height:25px;color:">更多</a>
							</div>
						</div>
						<div style="padding:0px">


							<img src="images/1253157163.jpg" border="0" width="100%" />

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id='bodyex'></div>

</body>
</html>
