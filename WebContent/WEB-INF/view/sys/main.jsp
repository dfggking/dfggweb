<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <%@ include file="../common/config.jsp" %>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/sys/style.css" rel="stylesheet">
  </head>
  <body>
    <header class="header">
      <h2 class="header-title">MANAGE</h2>
    </header>
    <div class="wrap">
      <div class="box box1">
        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
        <a class="box-title">欢迎</a>
      </div>
      <div class="box box2">
        <i class="fa fa-file-word-o" aria-hidden="true"></i>
        <a class="box-title">文章列表</a>
      </div>
      <div class="box box3">
        <i class="fa fa-file-code-o" aria-hidden="true"></i>
        <a class="box-title">新建文章</a>
      </div>
      <div class="box box4">
        <i class="fa fa-wordpress" aria-hidden="true"></i>
        <a class="box-title">主页</a>
      </div>
      <div class="box box5">
        <i class="fa fa-star-o" aria-hidden="true"></i>
        <a class="box-title">我的空间</a>
      </div>
      <div class="box box6">
        <i class="fa fa-github" aria-hidden="true"></i>
        <a class="box-title">Github</a>
      </div>
      <div class="box box7">
        <i class="fa fa-modx" aria-hidden="true"></i>
        <a class="box-title">更多栏目</a>
      </div>
      <div class="box box8">
        <i class="fa fa-linkedin-square" aria-hidden="true"></i>
        <a class="box-title">联系</a>
      </div>
    </div>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/vue/2.1.10/vue.js"></script>
    <script>
    $(function(){
        $('.box')
    })
    </script>
  </body>
</html>