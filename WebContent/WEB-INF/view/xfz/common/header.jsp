<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--[if lt IE 9]>
  <div class="alert alert-warning alert-dismissible fade in" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
    您正在使用<strong>过时的</strong> 浏览器。请 <a target="_blank" href="http://browsehappy.com/">更新浏览器</a> 否则会影响系统使用
  </div>
<![endif]-->
<!-- <div></div> --><!-- 顶部默认隐藏用于显示个人介绍的  -->
<header id="J_header" class="header">
  <div class="sys_logo" href="javascript:;">
    <img class="sys_logo-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sys_name">非现役消防调度云平台</span>
  </div>
  
  <div class="header-domain">
    <div class="statstc">
      <span class="statstc-text">站点数：</span>
      <span class="statstc-num">100</span>
    </div>
    <div class="statstc">
      <span class="statstc-text">人员数：</span>
      <span class="statstc-num">200</span>
    </div>
    <div class="search">
      <input class="search-input" />
    </div>
    <div class="sys_status">
      <span class="status-text">系统状态：</span>
      <span class="status-span status-normal">正常</span> / <span class="status-span status-other">异常</span>
    </div>
  </div>
  
  <div class="sys_user">
    <img class="user-avatar" alt="" src="${ctx}/img/xfz/sys-logo.png">
    <div class="sys_user-info">
      <span class="user-name">随州消防支队随州消防支队</span>
      <div class="user-oper">
        <button class="oper-opened">开班</button>
        <button class="oper-changed">换岗</button>
        <button id="J_fullscreen_btn" class="oper-closed">全屏</button>
      </div>
    </div>
  </div>
</header>