<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="indexApp" ng-controller="indexController">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>巾帼园首页</title>
    <link rel="stylesheet" href="/themes/css/base.css" />
    <link rel="stylesheet" href="/themes/css/jgy.css" />
    <script src="/themes/js/jquery.js" ></script>
    <script src="/themes/js/common.js" ></script>
    <script src="/themes/js/angular.min.js" ></script>
    <script src="/themes/angularController/indexController.js" ></script>
</head>
<body>
	<!--头部导航 	start-->
	<div class="back">
		<div class="back-left" onclick="openMenu();"><img src="/themes/img/menue.png"/></div>
		<span>巾帼园首页</span>
	</div>
	<!--头部导航 	end-->
	<!--左侧导航 	start-->
	<div class="menu">
		<ul>
			<li class="active" id="menu_1"><a  href="/index.html"  ><img src="/themes/img/small_menue_01.png" />巾帼园首页</a></li>
			<li id="menu_2"><a href="/coming.html" ><img src="/themes/img/small_menue_02.png"/>巾帼园介绍</a></li>
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
	<!--banner 		start-->
	<div class="banner">
		<dl>
			<a href="/coming.html">
				<dt><img src="/themes/img/menue_1.png"/></dt>
				<dd>走近巾帼园</dd>
			</a>
		</dl>
		<dl>
			<a href="/public.html">
				<dt><img src="/themes/img/menue_2.png"/></dt>
				<dd>公益课堂</dd>
			</a>
		</dl>
		<dl>
			<a href="/housekeeping.html">
				<dt><img src="/themes/img/menue_3.png"/></dt>
				<dd>巾帼家政</dd>
			</a>
		</dl>
		<dl>
			<a href="/train.html">
				<dt><img src="/themes/img/menue_4.png"/></dt>
				<dd>小蓓蕾</dd>
			</a>
		</dl>
		<dl>
			<a href="/volunteer.html">
				<dt><img src="/themes/img/menue_5.png"/></dt>
				<dd>巾帼志愿者</dd>
			</a>
		</dl>
		<dl>
			<a href="/woman.html">
				<dt><img src="/themes/img/menue_6.png"/></dt>
				<dd>女性NGO</dd>
			</a>
		</dl>
		<dl>
			<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1c0b240b67b3873e&redirect_uri=http://jinguoyuan.0angle.com/rights.html&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect">
				<dt><img src="/themes/img/menue_7.png"/></dt>
				<dd>维权课堂</dd>
			</a>
		</dl>
		<dl>
			<a href="/hot.html">
				<dt><img src="/themes/img/menue_8.png"/></dt>
				<dd>热门活动</dd>
			</a>
		</dl>
	</div>
	<!--banner	 	end-->
	<div class="content">
		<h1>热门推荐</h1>
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
</body>
</html>