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
    <span class="top-title_span">欢迎访问网站</span>
  </div>
  <header class="header container-fluid">
    <div class="header-login col-md-offset-1 col-md-2">
      <span class="user-info">
        <span class="user-icon"></span>
        <span class="user-name">金英飞</span>
      </span>
      <span class="dropdown-icon"></span>
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
    <ul class="unslider-ul">
      <li><img class="unslider-img" src="${ctx}/img/front/01.jpg" /></li>
      <li><img class="unslider-img" src="${ctx}/img/front/02.jpg" /></li>
      <li><img class="unslider-img" src="${ctx}/img/front/03.jpg" /></li>
      <li><img class="unslider-img" src="${ctx}/img/front/04.jpg" /></li>
      <li><img class="unslider-img" src="${ctx}/img/front/05.jpg" /></li>
    </ul>
    <a href="javascript:void(0);" class="unslider-arrow04 prev">
      <img class="arrow" id="al" src="${ctx}/img/front/arrowl.png" alt="prev" width="20" height="35">
    </a>
    <a href="javascript:void(0);" class="unslider-arrow04 next">
      <img class="arrow" id="ar" src="${ctx}/img/front/arrowr.png" alt="next" width="20" height="37">
    </a>
  </div>
  <div class="works container-fluid">
    <div class="works-link col-md-offset-1 col-md-3 col-xs-12">
      <p class="title">作品链接</p>
      <div>
        <a class="link">http://www.jinyingfei.com</a>
        <a class="link">http://www.weibo.com/dfggweb</a>
      </div>
    </div>
    <div class="public-media col-md-7 col-xs-12">
      <a class="media" href="https://www.toutiao.com/c/user/4577591139/#mid=52536399165" target="_blank">
        <span class="icon todayNews-icon"></span>
        <span class="media-name">今日头条</span>
        <span></span>
      </a>
      <a class="media" href="" target="_blank">
        <span class="icon baidu-icon"></span>
        <span class="media-name">百家号</span>
        <span></span>
      </a>
      <a class="media" href="" target="_blank">
        <span class="icon wechat-icon"></span>
        <span class="media-name">订阅号</span>
        <span></span>
      </a>
      <a class="media" href="http://www.weibo.com/dfggweb" target="_blank">
        <span class="icon sina-icon"></span>
        <span class="media-name">新浪微博</span>
        <span></span>
      </a>
    </div>
  </div>
  <div class="works container-fluid">
    <div class="works-display col-md-offset-1 col-md-10">
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
        <div></div>
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
        <div></div>
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
        <div></div>
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
        <div></div>
      </div>
    </div>
  </div>
  <div class="latest-works container-fluid">
    <h2>最新作品</h2>
    <p>用心做每一个作品，不断完善</p>
    <div class="latest-display col-md-offset-1 col-md-10">
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
      </div>
      <div class="display-panel col-xs-12">
        <img class="work-img" src="${ctx}/img/front/work-pic1.jpg" />
      </div>
    </div>
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