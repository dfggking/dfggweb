<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.css">
  <link rel="stylesheet" href="/css/feh/style.css">
  <title>飞鹰号</title>
</head>
<body>
  <header class="header">
    <nav class="nav header-nav-content">
      <a class="logo" href="javascript:void(0);">
        <span class="logo-span">
          <span class="glyphicon glyphicon-tint l-img"></span>
          <span class="l-text">飞鹰号</span>
        </span>
      </a>
      <ul class="header-user">
        <li class="notice-message">
          <div class="message-wrap">
            <i class="glyphicon glyphicon-envelope"></i>
          </div>
          <div class="notice-message-hover">
            <div class="hover-top"></div>
            <ul>
              <li>
                <div class="action message">
                  <span>通知</span>
                </div>
              </li>
              <li class="li-seperator">
                <div class="action-seperator"></div>
              </li>
              <li>
                <div class="action message">
                  <span>评论</span>
                </div>
              </li>
            </ul>
          </div>
        </li>
        <li class="seperator"><%--分离器--%></li>
        <li class="author">
          <span class="avatar">
            <img class="portrait" src="/img/avatar.jpeg" /><%--肖像--%>
          </span>
          <span class="name">WEB技能圈儿</span>
          <div class="author-oper-hover" style="display: none">
            <div class="hover-top"></div>
            <ul>
              <li>
                <div class="action message">
                  <span>通知</span>
                </div>
              </li>
              <li class="li-seperator">
                <div class="action-seperator"></div>
              </li>
              <li>
                <div class="action message">
                  <span>评论</span>
                </div>
              </li>
            </ul>
          </div>
        </li>
      </ul>
    </nav>
  </header>
  
  
  <script src="/node_modules/jquery/dist/jquery.js"></script>
  <script src="/node_modules/bootstrap/dist/js/bootstrap.js"></script>
  <script src="/js/feh/script.js"></script>
</body>
</html>