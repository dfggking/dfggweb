<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="J_sidebar" class="sidebar">
  <div class="sidebar-group" v-on:click="sidebarClick(0)" data-sidebar="index">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">首页</span>
  </div>
  <div class="sidebar-group" v-on:click="sidebarClick(1)" data-sidebar="dispatch">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">调度</span>
  </div>
  <div class="sidebar-group" v-on:click="sidebarClick(2)" data-sidebar="notice">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">通知</span>
  </div>
  <div class="sidebar-group" v-on:click="sidebarClick(3)" data-sidebar="power">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">力量</span>
  </div>
  <div class="sidebar-group" v-on:click="sidebarClick(4)" data-sidebar="statstc">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">统计</span>
  </div>
  <div class="sidebar-group" v-on:click="sidebarClick(5)" data-sidebar="callRoll">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">点名</span>
  </div>
  <div class="sidebar-group" v-on:click="sidebarClick(6)" data-sidebar="other">
    <img class="sidebar-img" alt="" src="${ctx}/img/xfz/sys-logo.png" />
    <span class="sidebar-name">其他</span>
  </div>
</div>
<div class="sidebar-menu animated flipInX">
  <div class="sub-menu" data-submenu="index">
    <h2 class="menu-h2">首页</h2>
    <div class="menu">
      <span></span>
    </div>
    <div class="menu">
      <span></span>
    </div>
    <div class="menu">
      <span></span>
    </div>
  </div>
  
  <div class="sub-menu" data-submenu="dispatch">
    <h2 class="menu-h2">调派</h2>
    <div class="menu">
      <span>调派</span>
    </div>
    <div class="menu">
      <span>指挥</span>
    </div>
    <div class="menu">
      <span>历史</span>
    </div>
  </div>
  
  <div class="sub-menu" data-submenu="notice">
    <h2 class="menu-h2">通知</h2>
    <div class="menu">
      <span>新建</span>
    </div>
    <div class="menu">
      <span>通知列表</span>
    </div>
  </div>
  
  <div class="sub-menu" data-submenu="power">
    <h2 class="menu-h2">力量</h2>
    <div class="menu">
      <span>站点管理</span>
    </div>
    <div class="menu">
      <span>人员管理</span>
    </div>
  </div>
  
  <div class="sub-menu" data-submenu="statstc">
    <h2 class="menu-h2">统计</h2>
    <div class="menu">
      <span>人员统计</span>
    </div>
    <div class="menu">
      <span>车辆统计</span>
    </div>
    <div class="menu">
      <span>点名统计</span>
    </div>
  </div>
  
  <div class="sub-menu" data-submenu="callRoll">
    <h2 class="menu-h2">点名</h2>
    <div class="menu">
      <span>视频点名</span>
    </div>
    <div class="menu">
      <span>点名统计</span>
    </div>
  </div>
  
  <div class="sub-menu" data-submenu="other">
    <h2 class="menu-h2">其他</h2>
    <div class="menu">
      <span></span>
    </div>
    <div class="menu">
      <span></span>
    </div>
  </div>
  
</div>