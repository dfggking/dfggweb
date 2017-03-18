<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>FrontMain</title>
<%@ include file="../common/config.jsp"%>
<!-- 引入样式 -->
<link href="${ctx}/css/front/main.css" rel="stylesheet">
</head>
<body>
  <div>
    
  </div><!-- 顶部默认隐藏用于显示个人介绍的  -->
  <header class="header">
    <div class="container nav">
      <h4 class="logo">Dfggking</h4>
      <button class="btn btn-default pull-right">
        <i class="icon-align-justify nav-toggler"></i>
      </button>
    </div>
  </header><!-- nav end -->
  <div class="container">
    
  </div><!-- container end -->
  <footer>
    
  </footer><!-- footer end -->
  <script data-main="${ctx}/script/module/front/front.module.js" src="https://cdn.bootcss.com/require.js/2.3.3/require.min.js"></script>
</body>
</html>