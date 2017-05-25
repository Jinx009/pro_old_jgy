<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="trainApp" ng-controller="trainController">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>小蓓蕾少儿培训班</title>
    <link rel="stylesheet" href="/themes/css/base.css" />
    <link rel="stylesheet" href="/themes/css/swiper.min.css" />
    <link rel="stylesheet" href="/themes/css/jgy.css" />
    <script type="text/javascript" src="/themes/js/jquery.js" ></script>
    <script type="text/javascript" src="/themes/js/common.js" ></script>
    <script type="text/javascript" src="//cdn.bootcss.com/Swiper/3.3.1/js/swiper.jquery.min.js" ></script>
   	<script type="text/javascript" src="/themes/js/angular.min.js" ></script>
   	<script type="text/javascript" src="/themes/angularController/trainController.js" ></script>
</head>
<body>
	<!--头部导航 	start-->
	<div class="back">
		<div class="back-left" onclick="openMenu();"><img src="/themes/img/menu.png"/></div>
		<span>小蓓蕾少儿培训班</span>
	</div>
	<!--头部导航 	end-->
	<!--左侧导航 	start-->
	<div class="menu">
		<ul>
			<li id="menu_1"><a  href="/index.html"  ><img src="/themes/img/small_menue_01.png" />巾帼园首页</a></li>
			<li id="menu_2"><a href="/coming.html" ><img src="/themes/img/small_menue_02.png"/>巾帼园介绍</a></li>
			<li id="menu_3"><a href="/public.html" ><img src="/themes/img/small_menue_03.png"/>公益课堂</a></li>
			<li id="menu_4"><a href="/housekeeping.html" ><img src="/themes/img/small_menue_04.png"/>jg365巾帼家政</a></li>
			<li id="menu_5" class="active" ><a href="/train.html" ><img src="/themes/img/small_menue_05.png"/>小蓓蕾少儿培训</a></li>
			<li id="menu_6"><a href="/volunteer.html" ><img src="/themes/img/small_menue_06.png"/>巾帼志愿者</a></li>
			<li id="menu_7"><a href="/woman.html" ><img src="/themes/img/small_menue_07.png"/>NGO女性社会组织</a></li>
				<li id="menu_8"><a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1c0b240b67b3873e&redirect_uri=http://jinguoyuan.0angle.com/rights.html&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect" ><img src="/themes/img/small_menue_08.png"/>维权课堂</a></li>
			<li id="menu_9"><a href="/hot.html" ><img src="/themes/img/small_menue_09.png"/>热门活动</a></li>
		</ul>
	</div>
	<!--左侧导航 	end-->
	<div class="banner_img"><a href="#" ><img src="/themes/img/train_banner.png"/></a></div>
	
	<!--tab切换		start-->
	<div class="train-content">
		<div class="tabs">
			<a href="#" class="active">最新招生</a>
			<a href="#">试听预约</a>
		</div>	
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide active">
					<div class="recommend-list">
						<div class="recommend-col" ng-repeat="recommendItem in recommendList">
							<a ng-attr-href = "{{recommendItem.url}}" >
								<div class="recommend-left"><img ng-attr-src="{{recommendItem.recommendPicUrl}}" /></div>
								<div class="recommend-right">
									<h3>{{recommendItem.recommendTitle}}</h3>
									<p>{{recommendItem.recommendDesc}}</p>
								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="recommend-list">
						<iframe height="600" allowTransparency="true" style="width:100%;border:none;overflow:auto;" frameborder="0" src="http://form.mikecrm.com/f.php?t=UjUdMt"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--tab切换		end-->
	<script type="text/javascript">
			$(function(){
				 // tab切换
			    var tabsSwiper = new Swiper('.swiper-container', {
			        speed: 500,
			        onSlideChangeStart: function() {
			            $(".tabs .active").removeClass('active');
			            $(".tabs a").eq(tabsSwiper.activeIndex).addClass('active');
			        }
			    });
			   
			    $(".tabs a").on('touchstart mousedown', function(e) {
			        e.preventDefault()
			        $(".tabs .active").removeClass('active');
			        $(this).addClass('active');
			        tabsSwiper.slideTo($(this).index());
			    });
			
			    $(".tabs a").click(function(e) {
			        e.preventDefault();
			    });
			})
		</script>
</body>
</html>