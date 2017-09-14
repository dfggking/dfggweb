<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="body-container swiper-slide" id="J_app_index">
  <div class="map-container" id="J_amap_container">
  
  </div><!-- container end -->
  <div class="index-leftpanel" id="J_index_leftPanel">
    <div class="searchbox clearfix">
      <div class="searchbox-container">
        <div class="searchbox-content is-complete clearfix">
          <input class="searchbox-content-input" id="J_index_search_input" name="J_index_search_input" type="text" @click="suggestShow" @blur="" />
          <!-- <div class="searchbox-content-button right-button loading-button cancel-button" data-title="清空"></div> -->
        </div>
      </div>
      <button id="J_index_search_button"></button>
    </div>
    <div id="J_index_search_suggest" class="search-suggest-wrap" >
      
    </div>
    <ul class=""></ul>
    <ul class=""></ul>
    <ul class=""></ul>
  </div>
  
  <div class="toolbar" id="J_index_toolbar">
    <span class="ding-logo" id="J_index_toolbar_ding" @click="'true'==dingStatus ? toolbarUnding() : toolbarDing()" title="锁定"></span>
    <div class="toolbar-scroll">
      <div></div><!-- 某开关 -->
      <div class="today-info">
        <p class="date" v-text="nowDate"></p>
        <p class="n-date">丁酉年六月廿四</p>
        <p class="weather">
          天气不错，酷热指数39°，西南风7米/秒。最高气温35°。今晚晴朗，最低气温28°。
        </p>
      </div>
      <div class="toolbar-wrap">
        <div class=" toolbar-box">
          <h2 class="toolBar-title">站点信息</h2>
          <div style="padding: 15px;">
            <a href="${ctx}/img/xfz/20061112185101000512.jpg" style="float: left;width: 49%; height: 49%;" data-lightbox="example-set">
              <img width="100%" height="100%" alt="" src="${ctx}/img/xfz/20061112185101000512.jpg" data-action="zoom" />
            </a>
            <a href="${ctx}/img/xfz/20061112185101000512.jpg" style="float: left;width: 49%; height: 49%;" data-lightbox="example-set">
              <img width="100%" height="100%" alt="" src="${ctx}/img/xfz/20061112185101000512.jpg" data-action="zoom" />
            </a>
            <a href="${ctx}/img/xfz/20061112185101000512.jpg" style="float: left;width: 49%; height: 49%;" data-lightbox="example-set">
              <img width="100%" height="100%" alt="" src="${ctx}/img/xfz/20061112185101000512.jpg" data-action="zoom" />
            </a>
            <a href="${ctx}/img/xfz/20061112185101000512.jpg" style="float: left;width: 49%; height: 49%;" data-lightbox="example-set">
              <img width="100%" height="100%" alt="" src="${ctx}/img/xfz/20061112185101000512.jpg" data-action="zoom" />
            </a>
          </div>
        </div>
        <div class="toolbar-box">
          <h2 class="toolBar-title">站点信息</h2>
        </div>
        <div class="toolbar-box">
          <h2 class="toolBar-title">站点信息</h2>
        </div>
        <div class="toolbar-box">
          <h2 class="toolBar-title">站点信息</h2>
        </div>
      </div>
    </div>
  </div>
</div>
