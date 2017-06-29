<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ include file="../common/phoneConfig.jsp"%>
  <!-- 引入样式 -->
  <link href="//cdn.bootcss.com/weui/1.1.1/style/weui.min.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/jquery-weui/1.0.1/css/jquery-weui.min.css" rel="stylesheet">
  <link href="${ctx}/css/wechat/main.css" rel="stylesheet">
</head>
<body>
  <header class="app__header">
    <h1 class="header-title">LOGIN</h1>
    <p class="header-desc">注册即可永久保存您的信息</p>
  </header>
  <div class="app__container">
    <div class="login_type-select">
      <a href="javascript:;" class="weui-btn weui-btn_plain-default wechat"><i class="icon"></i>通过微信注册</a>
    </div>
    <div class="login_type-select">
      <a href="javascript:;" class="weui-btn weui-btn_plain-default sina"><i class="icon"></i>通过微博注册</a>
    </div>
    <div class="login_type-select">
      <a href="javascript:;" class="weui-btn weui-btn_plain-default qq"><i class="icon"></i>通过QQ注册</a>
    </div>
    <div class="weui-loadmore weui-loadmore_line">
      <span class="weui-loadmore__tips">或者</span>
		</div>
		<div class="login_type-select">
      <a href="javascript:;" class="weui-btn weui-btn_plain-default sina"><i class="icon"></i>通过微博注册</a>
    </div>
    <div class="login_type-select">
      <a href="javascript:;" class="weui-btn weui-btn_plain-default sina"><i class="icon"></i>通过微博注册</a>
    </div>
  </div>
  <footer class="app__footer">
  
  </footer>
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
  <script src="https://cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
</body>
</html>