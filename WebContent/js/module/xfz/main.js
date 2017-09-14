/**
 * @author jinyf@hollysos.com
 * @date 2017-7-17
 * @since 1.0
 */
require([ctx+'/js/app.js?v=' + new Date().getTime()], function(){
    
    require(['bootstrap']);
    require(['lightbox'], function(lightbox){ // http://lokeshdhakar.com/projects/lightbox2/#options
        lightbox.option({
            albumLabel : '%1 / %2',
//          disableScrolling : false, // default false
            fadeDuration : 300,
            imageFadeDuration : 300,
            positionFromTop : 150,
            resizeDuration : 300
        });
    }, function(){ // require, 模块加载失败处理
        require(['jquery'], function($){
            $('[data-lightbox="example-set"]').attr('href', '#');
        });
    });
    
    /* 进度条功能 */
    require(['nprogress'], function(NProgress){
        NProgress.inc(); /* 初始化加载进程效果 */
        window.onload = function(){ /* 完全加载完毕 */
            NProgress.done();
        }
    });
    
    /* 播放器功能 */
    require(['videojs'], function(){
        
    });
    
    /* 头部功能 */
    require(['Vue', 'jquery', 'fullscreen'], function(Vue, $){
        window.HEADER_VUE = new Vue({
            el : '#J_header',
            data : {},
            mounted : function(){
                var that = this;
                that.headerInit();
            },
            methods : {
                headerInit : function(){
                    $('#J_header').animateCss('slideInDown');
                    
                    // 只能用户手动触发，不能JS模拟点击
                    document.getElementById('J_fullscreen_btn').addEventListener('click', function(){
                        if (screenfull.enabled) {
                            screenfull.toggle();
                        }
                    });
                }
            }
        });
    });
    
    /* sidebar功能 */
    require(['Vue', 'jquery', 'swiper'], function(Vue, $){
        /* 模块切换swiper */
        var mainSwiper = new Swiper ('.swiper-container', {
            onlyExternal : true,
            effect : 'fade'
        });
        
        /* sidebar Vue */
        window.SIDEBAR_VUE = new Vue({
            el : '#J_sidebar',
            mounted : function(){
                var that = this;
                that.sidebarInit();
                that.sidebarMenuInit();
            },
            methods : {
                sidebarInit : function(){
                    $('#J_sidebar').animateCss('slideInLeft');
                },
                sidebarMenuInit : function(){
                    /* 菜单效果控制 */
                    var $sidebarMenu = $('.sidebar-menu');
                    $('.sidebar-group').hover(function(){
                        var $that = $(this),
                            _sidebar = $that.data('sidebar');
                        $('.sub-menu').removeClass('on');
                        $('[data-submenu="'+ _sidebar +'"]').addClass('on');
                        var sideBarMenuTop = $that.offset().top;
                        if($(window).height() - sideBarMenuTop > $sidebarMenu.height()){
                            $sidebarMenu.css({'top' : sideBarMenuTop});
                        }
                        $sidebarMenu.show();
                    }, function(){
                        var $that = $(this);
                        window.setTimeout(function(){
                            if(!($('.sidebar-menu:hover').length || $('.sidebar-group:hover').length)){
                                $sidebarMenu.hide();
                            }
                        }, 500);
                    });
                    $sidebarMenu.hover(function(){/*  */}, function(){
                        window.setTimeout(function(){
                            if(!($('.sidebar-menu:hover').length || $('.sidebar-group:hover').length)){
                                $sidebarMenu.hide();
                            }
                        }, 500);
                    });
                },
                sidebarClick : function(index){
                    mainSwiper.slideTo(index, 400, false);
                    
                }
            }
        });
    });
    
    /* leftPanel功能 */
    require(['Vue', 'jquery'], function(Vue, $){
        window.LEFTPANEL_VUE = new Vue({
            el : '#J_index_leftPanel',
            data : {
                message : 'hello'
            },
            mounted : function(){
                var that = this;
                that.suggestInit();
            },
            methods : {
                suggestInit : function(){
                    var that = this;
                    
                    document.onclick = function(e){ // 点击其他位置隐藏suggest下拉框
                        var $target = $(e.target);
                        if(!($target.closest('.search-suggest-wrap').length || $target.closest('.searchbox-container').length)){
                            that.suggestHide();
                        }
                    };
                },
                suggestShow : function(){
                    var that = this;
                    var $searchSuggest = $('#J_index_search_suggest');
                    $searchSuggest.show();
                },
                suggestHide : function(){
                    var that = this;
                    var $searchSuggest = $('#J_index_search_suggest');
                    $searchSuggest.hide();
                }
            }
        });
    });
    
    /* 首页地图功能 */
    require(['Vue', 'jquery', 'jmap'], function (Vue, $) {
        
        /* map Vue */
        window.MAP_VUE = new Vue({
            el : '#J_amap_container',
            data : {
            },
            mounted : function(){
                var that = this;
                that.mapInit();
            },
            methods : {
                mapInit : function() {
                    var that = this;
                    var _map = $('#J_amap_container').jmap({
                        resizeEnable: true,
                        zoom: 15,
                        center: [116.397428, 39.90923],
                        plugins: [ 'AMap.Scale', 'AMap.MapType', 'AMap.Autocomplete', 'AMap.PlaceSearch'],
//                        layers: ['AMap.Traffic'],
//                        keyboardEnable : false
                        selectPlaceSearch: function(data){
                        }
                    });
//                    模拟批量打点
//                    var simulationAddress = [
//                        [116.368904,39.923423],[116.382122,39.961276],
//                        [116.387761,39.923201],[116.398258,39.914639],
//                        [116.368504,39.923423],[116.382122,39.923276],
//                        [116.387271,39.922501],[116.398258,39.914330],
//                        [116.368984,39.923423],[116.382122,39.922176],
//                        [116.383271,39.922701],[116.398258,39.911600]
//                    ];
//                    
//                    for (var i = 0; i < simulationAddress.length; i++) {
//                        var addr = simulationAddress[i];
//                        
//                        
//                        var marker = _map.setMarker({
//                            position : addr,
//                            infoWindow : {
//                                isCustom : true, // 使用自定义窗体
//                                title : '假日酒店宾馆',
//                                subTitle : '价格：883',
//                                siteImg : 'https://tpc.googlesyndication.com/simgad/5843493769827749134',
//                                siteName : '北京市朝阳区阜通东大街6号院3号楼东北8.3公里',
//                                phone : '010-64733333',
//                                content : 'AMap.SiteInfoWindow'
//                            }
//                        });
//                    }
                }
            }
        });
        
    });
    
    /* ToolBar功能 */
    require(['Vue', 'jquery', 'jutil'], function(Vue, $){
        /* toolbar Vue */
        window.TOOLBAR_VUE = new Vue({
            el : '#J_index_toolbar',
            data : {
                nowDate : (new Date()).format('MM月dd日 EEE'),
                dingStatus : true
            },
            mounted : function(){
                var that = this;
                localStorage.dingStatus || (localStorage.dingStatus=true);
                that.dingStatus = localStorage.dingStatus;
                that.toolbarInit();
            },
            methods : {
                toolbarInit : function(){
                    var that = this;
                    var $toolbar = $('#J_index_toolbar');
                    $toolbar.animateCss('slideInRight');
                    window.setTimeout(function(){
                        if('true' == that.dingStatus){ // 如果ding
                            that.toolbarDing();
                        }else{
                            that.toolbarUnding();
                        }
                    }, 3000);
                    
                },
                toolbarDing : function(){
                    var that = this;
                    $(document).unbind('mousemove');
                    $('#J_index_toolbar_ding').removeClass('unding').addClass('ding');
                    localStorage.dingStatus = true;
                    that.dingStatus = localStorage.dingStatus;
                },
                toolbarUnding : function(){
                    var that = this;
                    var $toolbar = $('#J_index_toolbar');
                    var toolbarWidth = $toolbar.width();
                    var _Fa = $(window).width() - toolbarWidth; // 控制入口：鼠标离开到ToolBar 宽度就隐藏
                    $(document).bind('mousemove', function(e){
                        if(e.pageX > _Fa && $toolbar.is(':hidden')){
                            that.toolbarShow();
                        }else if(e.pageX < _Fa && $toolbar.is(':visible')){
                            that.toolbarHide();
                        }
                    });
                    $('#J_index_toolbar_ding').removeClass('ding').addClass('unding');
                    localStorage.dingStatus = false;
                    that.dingStatus = localStorage.dingStatus;
                },
                toolbarShow : function(){
                    var that = this;
                    var $toolbar = $('#J_index_toolbar');
                    $toolbar.show().animateCss('slideInRight');
                },
                toolbarHide : function(){
                    var that = this;
                    var $toolbar = $('#J_index_toolbar');
                    $toolbar.animateCss('slideOutRight').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
                        $toolbar.hide();
                    });
                }
            }
        });
    });
    
    
    
});







