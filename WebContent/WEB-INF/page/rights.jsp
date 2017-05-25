<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="rightsApp" ng-controller="rightsController">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>维权课堂</title>
    <link rel="stylesheet" href="/themes/css/base.css" />
    <link rel="stylesheet" href="/themes/css/swiper.min.css" />
    <link rel="stylesheet" href="/themes/css/jgy.css" />
    <script type="text/javascript" src="/themes/js/angular.min.js" ></script>
    <script type="text/javascript" src="/themes/angularController/rightsController.js" ></script>
    <script type="text/javascript" src="/themes/js/jquery.js" ></script>
    <script type="text/javascript" src="//cdn.bootcss.com/Swiper/3.3.1/js/swiper.jquery.min.js" ></script>
    <script type="text/javascript" src="/themes/js/common.js" ></script>
    <script type="text/javascript">
    function addQuestion(){
    	var question = $('#question').val();
    	if(null==question||''==question){
    		alert('问题不能为空！');
    	}else{
    		var data = 'question='+question;
    		$.ajax({
    			url:'/data/leagl/save.html',
    			type:'POST',
    			data:data,
    			dataType:'json',
    			success:function(res){
    				if(200==res.code){
    					location.reload();
    				}
    			}
    		})
    	}
    }
    </script>
</head>
<body>
	<!--头部导航 	start-->
	<div class="back">
		<div class="back-left" onclick="openMenu();"><img src="/themes/img/menu.png"/></div>
		<span>维权课堂</span>
	</div>
	<!--头部导航 	end-->
	<!--左侧导航 	start-->
	<div class="menu">
		<ul>
			<li id="menu_1"><a  href="/index.html"  ><img src="/themes/img/small_menue_01.png" />巾帼园首页</a></li>
			<li id="menu_2"><a href="/coming.html" ><img src="/themes/img/small_menue_02.png"/>巾帼园介绍</a></li>
			<li id="menu_3"><a href="/public.html" ><img src="/themes/img/small_menue_03.png"/>公益课堂</a></li>
			<li id="menu_4"><a href="/housekeeping.html" ><img src="/themes/img/small_menue_04.png"/>jg365巾帼家政</a></li>
			<li id="menu_5"><a href="/train.html" ><img src="/themes/img/small_menue_05.png"/>小蓓蕾少儿培训</a></li>
			<li id="menu_6"><a href="/volunteer.html" ><img src="/themes/img/small_menue_06.png"/>巾帼志愿者</a></li>
			<li id="menu_7"><a href="/woman.html" ><img src="/themes/img/small_menue_07.png"/>NGO女性社会组织</a></li>
			<li class="active"  id="menu_8"><a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1c0b240b67b3873e&redirect_uri=http://jinguoyuan.0angle.com/rights.html&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect" ><img src="/themes/img/small_menue_08.png"/>维权课堂</a></li>
			<li id="menu_9"><a href="/hot.html" ><img src="/themes/img/small_menue_09.png"/>热门活动</a></li>
		</ul>
	</div>
	<!--左侧导航 	end-->
	<div class="banner_img"><img src="/themes/img/rights_banner.png"/></div>
	
	<!--tab切换		start-->
	<div class="train-content">
		<div class="tabs">
			<a href="#" class="active">最新问答</a>
			<a href="#">我的问答</a>
		</div>	
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide active">
					<div class="question-list">
						<div class="question-col"  ng-repeat="list in recommendList.list">
							<img src="/themes/img/small_bottom.png" class="small-bottom"/>
							<div class="question">
								<h3>{{list.customerNickName}}用户提问</h3>
								<p>{{list.customerQuestion}}</p>
							</div>
							<div class="question">
								<h3>{{list.replyer}}回答：</h3>
								<p>{{list.reply}}</p>
							</div>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="question-list">
						<div class="question-col"   ng-repeat="user in recommendList.user">
							<img src="/themes/img/small_bottom.png" class="small-bottom"/>
							<div class="question">
								<h3>问题</h3>
								<p>{{user.customerQuestion}}</p>
							</div>
							<div class="question">
								<h3>回复</h3>
								<p>{{user.reply}}</p>
							</div>
						</div>
						<form>
							<div class="form-inp"><textarea placeholder="编辑问题" id="question" rows="5"></textarea></div>
							<div class="form-inp"><button onclick="addQuestion()" >提交</button></div>
						</form>
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