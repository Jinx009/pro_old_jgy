<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="comingApp" ng-controller="comingController">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>走进巾帼园</title>
    <link rel="stylesheet" href="/themes/css/base.css" />
    <link rel="stylesheet" href="/themes/css/swiper.min.css" />
    <link rel="stylesheet" href="/themes/css/jgy.css" />
    <script type="text/javascript" src="/themes/js/jquery.js" ></script>
    <script type="text/javascript" src="//cdn.bootcss.com/Swiper/3.3.1/js/swiper.jquery.min.js" ></script>
    <script type="text/javascript" src="/themes/js/angular.min.js" ></script>
     <script type="text/javascript" src="/themes/js/common.js" ></script>
    <script type="text/javascript" src="/themes/angularController/comingController.js" ></script>
	<script type="text/javascript">
		$(function(){
			var mySwiper = new Swiper('.swiper-container',{
	    		preloadImages:false,
			    loop: true,
				autoplay: false,
				pagination: '.swiper-pagination', //导航分页
				paginationClickable: true, //导航点击切换
				lazyLoading : true,
				lazyLoadingInPrevNext : true
		    });
		})
	</script>
</head>
<body>
	<!--头部导航 	start-->
	<div class="back">
		<div class="back-left" onclick="openMenu();"><img src="/themes/img/menu.png"/></div>
		<span>走近巾帼园</span>
	</div>
	<!--头部导航 	end-->
	<!--左侧导航 	start-->
	<div class="menu">
		<ul>
			<li id="menu_1"><a href="/index.html" ><img src="/themes/img/small_menue_01.png" />巾帼园首页</a></li>
			<li class="active" id="menu_2"><a href="/coming.html" ><img src="/themes/img/small_menue_02.png"/>巾帼园介绍</a></li>
			<li id="menu_3"><a href="/public.html" ><img src="/themes/img/small_menue_03.png"/>公益课堂</a></li>
			<li id="menu_4"><a href="/housekeeping.html" ><img src="/themes/img/small_menue_04.png"/>jg365巾帼家政</a></li>
			<li id="menu_5"><a href="/train.html" ><img src="/themes/img/small_menue_05.png"/>小蓓蕾少儿培训</a></li>
			<li id="menu_6"><a href="/volunteer.html" ><img src="/themes/img/small_menue_06.png"/>巾帼志愿者</a></li>
			<li id="menu_7"><a href="/woman.html" ><img src="/themes/img/small_menue_07.png"/>NGO女性社会组织</a></li>
				<li id="menu_8"><a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1c0b240b67b3873e&redirect_uri=http://jinguoyuan.0angle.com/rights.html&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect" ><img src="/themes/img/small_menue_08.png"/>维权课堂</a></li>
			<li id="menu_9"><a href="/hot.html" ><img src="/themes/img/small_menue_09.png"/>热门活动</a></li>
		</ul>
	</div>
	<!--左侧导航 	end-->
	<div class="banner_img"><a href="http://mp.weixin.qq.com/s?__biz=MzA3MjI5MTMxNg==&mid=402999057&idx=1&sn=349827d29fdc811fcf4cfb08083bfed3&scene=0#wechat_redirect" ><img src="/themes/img/coming_banner.png"/></a></div>
	<div class="swiper-container slide-content">
	  <div class="swiper-wrapper">
	    <div class="swiper-slide">
	    	<a href="#"><img data-src="/themes/data/img/1.jpg" class="swiper-lazy"/><div class="swiper-lazy-preloader"></div></a>
	    </div>
	    <div class="swiper-slide">
	    	<a href="#"><img data-src="/themes/data/img/2.jpg" class="swiper-lazy"/><div class="swiper-lazy-preloader"></div></a>
	    </div>
	    <div class="swiper-slide">
	    	<a href="#"><img data-src="/themes/data/img/3.jpg" class="swiper-lazy"/><div class="swiper-lazy-preloader"></div></a>
	    </div>
	      <div class="swiper-slide">
	    	<a href="#"><img data-src="/themes/data/img/4.jpg" class="swiper-lazy"/><div class="swiper-lazy-preloader"></div></a>
	    </div>
	     <div class="swiper-slide">
	    	<a href="#"><img data-src="/themes/data/img/5.jpg" class="swiper-lazy"/><div class="swiper-lazy-preloader"></div></a>
	    </div>
	  </div>
	  <div class="swiper-pagination"></div>
	</div>
	<div class="recommend-list">
		<div class="recommend-col" ng-repeat="recommendItem in recommendList">
			<a  ng-attr-href = "{{recommendItem.url}}">
				<div class="recommend-left"><img ng-attr-src="{{recommendItem.recommendPicUrl}}"/></div>
				<div class="recommend-right">
					<h3>{{recommendItem.recommendTitle}}</h3>
					<p>{{recommendItem.recommendDesc}}</p>
				</div>
			</a>
		</div>
	</div>
</body>
</html>