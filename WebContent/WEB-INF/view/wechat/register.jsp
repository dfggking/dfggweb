<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ include file="../common/phoneConfig.jsp"%>
  <!-- 引入样式 -->
  <link href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.min.css" rel="stylesheet">
  <link href="${ctx}/css/wechat/main.css" rel="stylesheet">
  <style type="text/css">
    .weui-loadmore {
      width: 65%;
      margin: 1.5em auto;
      line-height: 1.6em;
      font-size: 14px;
      text-align: center;
    }
    .weui-loadmore_line {
      border-top: 1px solid #fafafa;
      margin-top: 2.4em;
    }
    .weui-loadmore__tips {
      display: inline-block;
      vertical-align: middle;
    }
    .weui-loadmore_line .weui-loadmore__tips {
      position: relative;
      top: -.9em;
      padding: 0 .55em;
      background-color: #55B3EE;
      color: #fafafa;
    }
    
    body {
      background: #55B3EE;
    }
    .app__header {
      color: #fafafa;
    }
    .app_header-title {

    }
    .app_header-desc {
      
    }
    .app__container {
      padding: 1em 2em;
    }
    .app__container .select__box {
      display: -webkit-flex;
      display: flex;
      justify-content: space-around;
      margin: 1em 0 3em 0;
    }
    .form__box {
      margin-bottom: 1.5em;
    }
    .form__box .form__input {
      width: calc(100% - 2em);
      border: 0;
      padding: 1.2em 1em;
      background: #fafafa;
      line-height: 1.2em;
      color: #ccc;
      font-size: 14px;
    }
    .form__box .input-username {
      border-bottom: 1px solid #ccc;
      border-top-left-radius: 4px;
      border-top-right-radius: 4px;
      border-bottom-left-radius: 0;
      border-bottom-right-radius: 0;
    }
    .form__box .input-pwd {
      border-top-left-radius: 0;
      border-top-right-radius: 0;
      border-bottom-left-radius: 4px;
      border-bottom-right-radius: 4px;
    }
    .oper__box .submit-button {
      width: 100%;
    }
    .forget__pwd .forget__pwd-tips{
      padding: .3em .5em;
      text-align: right;
      font-size: 12px;
      color: #fafafa;
    }
    .otherlogin__box {
      display: -webkit-flex;
      display: flex;
      justify-content: space-around;
    }
    .icon {
      display: block;
      width: 35px;
      height: 35px;
      margin: 7.5px;
    }
    .icon-weibo {
      background: url('/img/common/weibo-55B3EE.png') center center;
      background-size: cover;
    }
    .icon-qq {
      background: url('/img/common/qq-55B3EE.png') center center;
      background-size: cover;
    }
    .icon-wechat {
      background: url('/img/common/wechat-55B3EE.png') center center;
      background-size: cover;
    }
    .app__footer {
      
    }
  </style>
</head>
<body>
  <header class="app__header">
    <h1 class="app_header-title">LOGIN</h1>
    <p class="app_header-desc">嘿！~还不快来玩下</p>
  </header>
  <div class="app__container">
    <div class="select__box">
      <button class="button button-raised button-primary button-pill">登录</button>
      <button class="button button-raised button-plain button-pill">注册</button>
    </div>
    <div class="form__box">
      <form action="" method="post">
        <input class="form__input input-username" type="text" name="username" placeholder="请输入用户名" />
        <input class="form__input input-pwd" type="password" name="password" placeholder="请输入密码" />
      </form>
    </div>
    <div class="oper__box">
      <button class="button button-block button-rounded button-action submit-button">登录</button>
    </div>
    <div class="forget__pwd">
      <p class="forget__pwd-tips">找回密码</p>
    </div>
    <div class="weui-loadmore weui-loadmore_line">
      <span class="weui-loadmore__tips">or</span>
    </div><!-- 华丽分割线 -->
    <div class="otherlogin__box">
      <a class="button button-large button-circle login-way"><i class="icon icon-weibo"></i></a>
      <a class="button button-large button-circle login-way"><i class="icon icon-qq"></i></a>
      <a class="button button-large button-circle login-way"><i class="icon icon-wechat"></i></a>
    </div>
  </div>
  <footer class="app__footer">
    
  </footer>
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/Buttons/2.0.0/js/buttons.min.js"></script>
</body>
</html>