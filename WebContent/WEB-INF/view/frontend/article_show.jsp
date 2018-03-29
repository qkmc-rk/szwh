<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>手足文化 - 会展服务、品牌策划、礼品开发</title>
		<meta name="keywords" content="营销策划、媒体传播、行业人脉、市场研究" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--对于IE8使用最新的内核渲染页面,以解决部分兼容性问题  -->
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
		<meta name="description" content="成都手足文化有限公司创立于1998年，是一家以会展服务、品牌策划、礼品开发服务为一体的专业广告营销服务机构" />
		<link href="<%=request.getContextPath() %>/static/front/css/global.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/static/front/css/public.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/front/css/bootstrap/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/front/css/bootstrap/bootstrap.min.css"/>
	</head>
	<body>
		<!--顶部电话显示栏  -->
		<div id="topcall">
			<div id="callpic">
				<img src="<%=request.getContextPath() %>/static/front/images/call.png" style="width:15px;"></img><span>&nbsp;<b></>联系电话:<i>028-</b><b style="font-size:20px">85120685</b></i></span>
 			</div>
		</div>
		<!--/*头部加入收藏*/-->
		<div class="Index_top_1">
			<div class="Index_top_1_1">

				<div class="Index_top_1_1_1">
					<a href="<%=request.getContextPath() %>/index"><img class="logoimg" src="<%=request.getContextPath() %>/static/front/images/logo.jpg"  /></a>
				</div>
				<div class="Index_top_1_1_2">
					<div class="Index_top_1_2_1">
						<ul>
							<!--导航-->
							<li class="off">
								<a href="<%=request.getContextPath() %>/index"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />首页<i style="font-weight: 700;"><b>HOME</b></i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/about"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />关于<i style="font-weight: 700;"><b>ABOUT</b></i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/service"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />服务<i style="font-weight: 700;"><b>SERVICE</b></i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/article"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />案例<i><b>CASES</b></i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/contact"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />联系<i style="font-weight: 700;"><b>CONTACT</b></i></a>
							</li>
							<!--导航-->
						</ul>
					</div>
				</div>
			</div>

			<div class="cls"></div>
			<!--/*滚动图*/-->

			<div class="header" style="background:url('<%=request.getContextPath() %>/static/front/images/case.jpg') no-repeat center top;">

			</div>
			<!--/*滚动图*/-->

		</div>
		<!--/*头部加入收藏*/-->

		<div class="cls"></div>

		<!-- <div style=" width:100%;margin-top:30px; margin-bottom:20px;border-bottom:3px solid #C9C9C9;">
			<div class="genius_index" style="padding-bottom:10px;">

				<div class="genius_index_1">
					<ul>
						<li class="">
							<a href="Article.html">
							</a>
						</li>
					</ul>
				</div>

				<div class="genius_index_1">
					<ul>
						<li class="">
							<a href="Article.html">
							</a>
						</li>
					</ul>
				</div>

				<div class="genius_index_1">
					<ul>
						<li class="on">
							<a href="Article.html">
							</a>
						</li>
					</ul>
				</div>

				<div class="genius_index_1">
					<ul>
						<li class="">
							<a href="Article.html">
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div> -->
		<div class="sperate" style="max-width:1920px; margin:auto;">
			<hr style="height: 0px; border: solid 5px darkgray; margin-top: 120px;"/>
		</div>

		<div class="cls"></div>
		<div class="y_index_ny">

			<div class="cls"></div>
			<div class="y_index_nyi">

				<!--右边-->
				<div class="y_index_y4">
					<div class="y_indexi_2" style="min-height:520px; _height:520px; padding-bottom:10px;">
						<!--内容-->
						<!--内容-->

						<div class="biaoti_div">

							<h2 style="font-size:30px;" class="articles">${case1.title}</h2>

							<%-- <div id="about_proInfo_0">
								<p class="laiyuan">
									<span>${case1.origin}</span>
									<span>${case1.date}</span>
									<span>点击次数：<font id="CCdiv">${case1.click}</font><script language="JavaScript" type="text/javascript">
   ClickCount("CCdiv/news/226/11");
  </script></span>
								</p>
							</div> --%>
						</div>

						<div class="content_txt" style="width:100%; max-width:100%; margin:auto;">

							<font id="Zoom" style="line-height:1.5em;">
								${case1.content}
							</font>

						</div>

						<div class="cls"></div>
						<div class="row text-center" style="max-width: 1933px; margin: auto; border-top:dashed 1px #000000;">
							<div class=" col-lg-offset-4 col-lg-2 col-xs-offset-4 col-xs-2 col-md-offset-4 col-md-2 text-center">
								<font style="line-height:33px;">
									<c:if test="${empty case0}">
										<p>上一页:没有了</p>
									</c:if>
									<c:if test="${not empty case0}">
										<a href='<%=request.getContextPath() %>/article_show?id=${case0.id}'>上一页:${case0.title}</a>
									</c:if>
								</font>
							</div>
							<div class="col-lg-2 col-xs-2 col-md-2 text-center">
								<font style="line-height:33px;">
									<c:if test="${empty case2}">
										<p>下一页:没有了</p>
									</c:if>
									<c:if test="${not empty case2}">
										<a href='<%=request.getContextPath() %>/article_show?id=${case2.id}'>下一页:${case2.title}</a>
									</c:if>
								</font>
							</div>
						</div>
						

						<!--rightbox end-->

						<!--内容-->
						<!--内容-->
					</div>

				</div>
				<!--右边-->

				<div class="cls"></div>
			</div>
		</div>
		<div class="cls"></div>
		<!--bootstrap实现底部4块div-->
		<div class="genius_index8">
			<div class="row" style="max-width: 1933px; margin: auto;">
				<div class="col-lg-6 col-md-6 col-xs-6" style="padding: 0;">
					<div class="genius_index8_1" style="background-color: red;">
						<div class="genius_index8_1_img">
							<img src="<%=request.getContextPath() %>/static/front/images/opacity_logo.png" style="width: 200px;"/>
						</div>
						<div class="genius_index8_1_letters">
							<p style="font-size: 18px;">成都市高新区永丰路20号附1号大中华办公楼</p>
							<p style="font-size: 12px;">DAZHONGHUA OFFICE BUILDING, NO. 20, YONGFENG ROAD.</p>
							<p style="font-size: 12px;">HIGH-TECH ZONE, CHENGDU</p>
						</div>
					</div>
				</div>
					<div class="col-lg-6 col-md-6 col-xs-6" style="padding: 0;">
						<div class="genius_index8_2" style="background-color:rgb(48,48,48)">
							<div class="genius_index8_2_letters">
								<p style="font-size: 24px;">为您服务：028-85120685</p>
								<p style="font-size: 24px;">服务时间：周一至周五8：30-18：00</p>
								<p style="font-size: 24px;width:405px; display:block;margin:auto; background-color:red;">www.cdszwh.com</p>
							</div>
						</div>
					</div>
			</div>
			<div class="row" style="max-width: 1933px; margin: auto;">
				<div class="col-lg-6 col-md-6 col-xs-6" style="padding: 0;">
					<div class="genius_index8_3" style="background-color: gainsboro;">
						<div class="qrcode">
							<div class="weibo">
								<div class="weibo_img">
									<img alt="微博" src="<%=request.getContextPath() %>/static/front/images/wb.jpg" style="width:100%; height:100%;">
								</div>
								<p>手足官网微博</p>
							</div>
							<div class="wechat">
								<div class="wechat_img">
									<img alt="微博" src="<%=request.getContextPath() %>/static/front/images/wx.jpg" style="width:100%; height:100%;">
								</div>
								<p>手足官方微信</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-xs-6" style="padding: 0;">
					<div class="genius_index8_4">
						<iframe src="<%=request.getContextPath() %>/static/front/map.html" width="100%" height="100%"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="cls"></div>
		<div class="footer">
			<div style="height: 10px;"></div>
			<ul>
				<div class="footer_0">
					<a href="<%=request.getContextPath() %>/index">首页</a>
					<a href="<%=request.getContextPath() %>/about">关于</a>
					<a href="<%=request.getContextPath() %>/service">服务</a>
					<a href="<%=request.getContextPath() %>/article">案例</a>
					<a href="<%=request.getContextPath() %>/contact">联系</a>
				</div>
			</ul>
		</div>
		<div class="loyalinfo" style="color:#fff;background-color:black;text-decoration: none;border-top:1px solid #fff; text-align:center;">
			<li>Copyright<font style="font-family:Arial"> ©</font>&nbsp;2018&nbsp;&nbsp;手足（成都）有限公司&nbsp;版权所有&nbsp;&nbsp;<a href="http://www.miibeian.gov.cn/" target="_blank">蜀ICP备18006206号-1</a>
				<span id="footer1_copyright" style="font-size:14px;">技术支持：<a href="mailto:qkmc@outlook.com" target="_blank">qkmc@outlook.com</a></span>
			</li>
		</div>
		<!-- 使用div设置背景图片 -->
		<%-- <div id="bg" style="position:absolute; width:100%; height:100%; left:0px; top:0px;z-index:-99">
			<img style="position: fixed; width:100%; height:100%;" src="<%=request.getContextPath() %>/static/front/images/bjtp-loss.jpg"></img>
		</div> --%>
		<script src="<%=request.getContextPath() %>/static/front/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/static/front/Inc/Search.js"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/static/front/js/jquery-1.11.1.min.js"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/static/front/js/public.js"></script>
	</body>
</html>