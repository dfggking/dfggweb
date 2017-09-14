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
  <link href="${ctx}/css/xfz/main.css" rel="stylesheet"></link>
</head>
<body>
  <%@ include file="common/header.jsp"%>
  <!-- nav end -->
  <%@ include file="common/sidebar.jsp"%>
  <!-- sidebar end -->
  <div class="domain-container swiper-container">
    <div class="swiper-wrapper">
      <!-- 首页 -->
      <%@ include file="index/index.jsp"%>
      <!-- 管理 -->
      <%@ include file="manage/manage.jsp"%>
      <div class="body-container swiper-slide" id="">
        <h2>body1</h2>
      </div>
      <div class="body-container swiper-slide" id="">
        <h2>body2</h2>
      </div>
      <div class="body-container swiper-slide" id="">
        <h2>body3</h2>
      </div>
      <div class="body-container swiper-slide" id="">
        <h2>body4</h2>
      </div>
      <div class="body-container swiper-slide" id="">
        <h2>body5</h2>
      </div>
    </div>
  </div>
  <%@ include file="common/footer.jsp"%>
  <!-- footer end -->
  
  <!-- 播放器 -->
  <%-- <div class="video-box">
    <video id="my-video" class="video-js" controls preload="auto" poster="MY_VIDEO_POSTER.jpg" data-setup="{}">
      <source src="${ctx}/img/xfz/oceans.mp4" type='video/mp4'>
      <p class="vjs-no-js">
        To view this video please enable JavaScript, and consider upgrading to a web browser that
        <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
      </p>
    </video>
  </div> --%>
  <!-- 播放器 end -->
  
  <!-- Baidu Analytics -->
  <script>
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?434b187d0a211ce2cca97d9da41b8eb4";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();
  </script>
  <script data-main="${ctx}/js/module/xfz/main" src="https://cdn.bootcss.com/require.js/2.3.3/require.min.js" defer async="true"></script>
</body>
</html>