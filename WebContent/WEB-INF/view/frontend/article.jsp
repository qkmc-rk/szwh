<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>案列</title>
		<meta name="keywords" content="营销策划、媒体传播、行业人脉、市场研究" />
		<meta name="description" content="成都手足文化有限公司创立于1998年，是一家以会展服务、品牌策划、礼品开发服务为一体的专业广告营销服务机构" />
		<link href="<%=request.getContextPath() %>/static/front/css/global.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/static/front/css/public.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/front/css/bootstrap/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/front/css/bootstrap/bootstrap.min.css"/>
		<script src="<%=request.getContextPath() %>/static/front/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/static/front/Inc/Search.js"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/static/front/js/jquery-1.11.1.min.js"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/static/front/js/public.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<script type="text/javascript">
			function goToPage(option){
				window.location.href = "article?currentPage=" + $(option).val();
			}
		</script>
	</head>

	<body>
		<!--顶部电话显示栏  -->
		<div id="topcall">
			<div id="callpic">
				<img src="<%=request.getContextPath() %>/static/front/images/call.png" style="width:100%;padding-top:8%"></img>
			</div>
		</div>
		<!--/*头部加入收藏*/-->
		<div class="Index_top_1">
			<div class="Index_top_1_1">

				<div class="Index_top_1_1_1">
					<a href="<%=request.getContextPath() %>/index"><img src="<%=request.getContextPath() %>/static/front/images/logo.jpg" style="width: 224px; height:173px; -webkit-box-shadow: 2px 7px 8px #444243; border-radius: 5%;" /></a>
				</div>
				<div class="Index_top_1_1_2">
					<div class="Index_top_1_2_1">
						<ul>
							<!--导航-->
							<li class="off">
								<a href="<%=request.getContextPath() %>/index"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />首页<i style="font-weight: 700;">HOME</i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/about"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />关于<i style="font-weight: 700;">ABOUT</i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/service"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />服务<i style="font-weight: 700;">SERVICE</i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/article" class="on"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />案例<i>CASE</i></a>
							</li>
							<li class="off">
								<a href="<%=request.getContextPath() %>/contact"><img src="<%=request.getContextPath() %>/static/front/images/search.png" style="width: 18px;" />联系<i style="font-weight: 700;">CONTACT</i></a>
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

		<div class="sperate">
			<hr style="height: 0px; border: solid 5px darkgray; margin-top: 70px;" />
		</div>
		<div class="y_index_ny">

			<div class="cls"></div>
			<div class="y_index_nyi">

				<!--右边-->
				<div class="y_index_y4">
					<div class="y_indexi_2" style="min-height:520px; _height:520px; padding-bottom:10px;">
						<!--内容-->
						<!--内容-->
						<!--合作伙伴-->
						<div class="cls"></div>
						<div class="genius_index6" style="margin-top:-10px;">
							<div class="genius_index6_1">

							</div>
						</div>
						<!--合作伙伴-->

						<div class="bd_n">
							<ul class="sc2_n">
								<c:forEach var="case1" items="${page.list }" varStatus="status" >
									<li>
										<a href="<%=request.getContextPath() %>/article_show?id=${case1.id}"><img id="case${status.index }" src="" alt="中国人寿双养签约仪式新闻发布会" /><span></span>
											<h3>${case1.title}</h3>
										</a>
									</li>
									<div style="display: none" id="case_${status.index }">
										${case1.content}
									</div>
								</c:forEach>
							</ul>
						</div>

						<div id="pagger" style="text-align: center">
							<div style="width:100%;float:left;">
								<span>共${page.totalPage }页，当前为第${page.currentPage }页，每页${page.pageRowNum }条，合计${page.totalRowNum }条</span>
								<a style="margin-right:5px;" href="<%=request.getContextPath() %>/article?currentPage=1">首页</a>
								
								<c:if test="${page.currentPage == 1  }">
									<a style="margin-right:5px;" href="<%=request.getContextPath() %>/article?currentPage=1">上一页</a>
								</c:if>
								<c:if test="${page.currentPage > 1  }">
									<a style="margin-right:5px;" href="<%=request.getContextPath() %>/article?currentPage=${page.currentPage - 1}">上一页</a>
								</c:if>
								
								<c:forEach varStatus="status" begin="1" end="${page.totalPage }">
									<c:if test="${page.currentPage == status.index}">
										<span style="margin-right:5px;font-weight:Bold;color:red;">${page.currentPage}</span>
									</c:if>
									<c:if test="${page.currentPage != status.index && status.index <= 5}">
										<a href="<%=request.getContextPath() %>/article?currentPage=${status.index}" style="margin-right:5px;">${status.index}</a>
									</c:if>
									<c:if test="${status.index == 6}">
										<span style="margin-right:5px;font-weight:Bold;color:black;">...</span>
									</c:if>
								</c:forEach>
								
								<c:if test="${page.currentPage == page.totalPage  }">
									<a style="margin-right:5px;" href="<%=request.getContextPath() %>/article?currentPage=${page.totalPage}">下一页</a>
								</c:if>
								<c:if test="${page.currentPage < page.totalPage  }">
									<a style="margin-right:5px;" href="<%=request.getContextPath() %>/article?currentPage=${page.currentPage + 1}">下一页</a>
								</c:if>
								
								<a style="margin-right:5px;" href="<%=request.getContextPath() %>/article?currentPage=${page.totalPage}">尾页</a>&nbsp;&nbsp;转到
								
								<select name="pagger_input" id="pagger_input" onchange="goToPage(this)">
									<c:forEach varStatus="status" begin="1" end="${page.totalPage}">
										<c:if test="${page.currentPage == status.index }">
											<option value="${status.index}" selected="true">${status.index}</option>
										</c:if>
										<c:if test="${page.currentPage != status.index }">
											<option value="${status.index}">${status.index}</option>
										</c:if>
									</c:forEach>
								</select> 页
							</div>
						</div>
					</div>

				</div>

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
								</div>
								<p>手足官网微博</p>
							</div>
							<div class="wechat">
								<div class="wechat_img">
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
		
		<!--偷懒写的js  -->
		<script language="javascript" type="text/javascript">
			$(document).ready(function(){
				$("#case_0 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case0").attr('src',$(this).attr("src"));
		 		});
				$("#case_1 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case1").attr('src',$(this).attr("src"));
		 		});
				$("#case_2 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case2").attr('src',$(this).attr("src"));
		 		});
				$("#case_3 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case3").attr('src',$(this).attr("src"));
		 		});
				$("#case_4 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case4").attr('src',$(this).attr("src"));
		 		});
				$("#case_5 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case5").attr('src',$(this).attr("src"));
		 		});
				$("#case_6 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case6").attr('src',$(this).attr("src"));
		 		});
				$("#case_7 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case7").attr('src',$(this).attr("src"));
		 		});
				$("#case_8 img").each(function(i){
		   			//alert("no:"+"  src:"+$(this).attr("src"));
		   			//替换某个img的src
		   			$("#case8").attr('src',$(this).attr("src"));
		 		});
			});
		</script>
		<!-- 使用div设置背景图片 -->
		<div id="bg" style="position:absolute; width:100%; height:100%; left:0px; top:0px;z-index:-99">
			<img style="position: fixed;  width:100%; height:100%;" src="<%=request.getContextPath() %>/static/front/images/bjtp-loss.jpg"></img>
		</div>
	</body>

</html>