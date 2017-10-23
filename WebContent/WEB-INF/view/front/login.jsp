<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="UTF-8">
  <%@ include file="../common/config.jsp"%>
  <!-- 引入样式 -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.min.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">
  <link href="${ctx}/css/front/login.css?v=<%=new Date().getTime() %>" rel="stylesheet">
</head>
<body>
  <!--[if lt IE 9]>
      <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
  <![endif]-->
  <div class="welcome__top">
    <div class="welcome__detail">
      
    </div>
    <p id="J_welcome_title" class="welcome-title font-hei">欢迎访问</p>
  </div><!-- 顶部默认隐藏用于显示个人介绍的  -->
  <header class="header">
    
    
    
  </header><!-- nav end -->
  <div class="container">
    <form action="${ctx}/web/login/signIn" method="post">
      <input type="text" name="username">
      <input type="password" name="password">
      <button>提交</button>
    </form>
  </div><!-- container end -->
  <footer>
    
  </footer><!-- footer end -->
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    $(function(){
        var $J_welcome_title = $('#J_welcome_title');
        setTimeout(function(){
            $J_welcome_title.slideDown();
        }, 3000);
        $J_welcome_title.click(function(){
            var $welcome_detail = $('.welcome__detail');
            if($welcome_detail.is(':hidden')){
                $('.welcome__detail').slideDown();
                $('html').css('overflow','hidden');
            }else{
                $('.welcome__detail').slideUp();
                $('html').css('overflow','auto');
            }
        });
    });
  </script>
</body>
</html>