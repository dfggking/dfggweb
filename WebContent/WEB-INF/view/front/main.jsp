<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<meta charset="UTF-8">
	<%@ include file="../common/config.jsp"%>
	<!-- 引入样式 -->
	<link href="https://cdn.bootcss.com/unslider/2.0.3/css/unslider-dots.css" rel="stylesheet">
	<link href="https://cdn.bootcss.com/unslider/2.0.3/css/unslider.css" rel="stylesheet">
	<link href="${ctx}/css/front/main.css" rel="stylesheet">
</head>
<body>
  <!--[if lt IE 7]>
      <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
  <![endif]-->
  
  <div class="top-line">
    <span></span>
  </div>
  <div class="top-title">
    <span class="top-title_span">WELCOME TO MY WEBSITE DFGGWEB</span>
  </div>
  <header class="header container-fluid">
    <div class="header-login col-md-offset-1 col-md-2">
      <span class="user-icon"></span>
      <span class="user-name">HARPIA KING</span>
    </div>
    <ul class="header-nav col-md-6">
      <li><a href="#">主页</a></li>
      <li><a href="#">相册</a></li>
      <li class="active"><a href="#">我们</a></li>
      <li><a href="#">作品</a></li>
      <li><a href="#">关于</a></li>
    </ul>
    <div class="header-search col-md-offset-1 col-md-2">
      <span class="search-icon"></span>
      <input type="text" class="input" placeholder="" />
      <span class="submit">搜索</span>
    </div>
  </header>
  <div class="unslider-box container-fluid" id="J_unslider">
    <ul>
      <li><img src="${ctx}/img/01.jpg" alt="" width="100%" height="700" ></li>
      <li><img src="${ctx}/img/02.jpg" alt="" width="100%" height="700" ></li>
      <li><img src="${ctx}/img/03.jpg" alt="" width="100%" height="700" ></li>
      <li><img src="${ctx}/img/04.jpg" alt="" width="100%" height="700" ></li>
      <li><img src="${ctx}/img/05.jpg" alt="" width="100%" height="700" ></li>
    </ul>
    <a href="javascript:void(0);" class="unslider-arrow04 prev">
      <img class="arrow" id="al" src="${ctx}/img/arrowl.png" alt="prev" width="20" height="35">
    </a>
    <a href="javascript:void(0);" class="unslider-arrow04 next">
      <img class="arrow" id="ar" src="${ctx}/img/arrowr.png" alt="next" width="20" height="37">
    </a>
  </div>
  <footer>
    
  </footer>
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/nprogress/0.2.0/nprogress.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdn.bootcss.com/unslider/2.0.3/js/unslider-min.js"></script>
  <script>
			NProgress.inc();
      $(function(){
    	      var timeout = window.setTimeout(function(){
    	          NProgress.done();
    	          window.clearTimeout(timeout);       
    	      }, 2000);
    	      var unslider04 = $('#J_unslider').unslider({
    	          dots: true
    	      }),data04 = unslider04.data('unslider');
    	      $('.unslider-arrow04').click(function() {
    	          var fn = this.className.split(' ')[1];
    	          data04[fn]();
    	      });
      });
      
  </script>
  <%-- <script data-main="${ctx}/js/module/front/front.module.js" src="https://cdn.bootcss.com/require.js/2.3.3/require.min.js"></script> --%>
  <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
  <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
  </script>
</body>
</html>