/**
 * @Description 
 * @author dfggking@hotmail.com
 * @date 2017-6-27
 * @version 1.0
 */
require.config({
    urlArgs : 'version=2.0.0',
    baseUrl : ctx+'/js/',
    paths : {
        // 框架类
        'jquery'    : '//cdn.bootcss.com/jquery/3.2.1/jquery.min',
        'Vue'       : '//cdn.bootcss.com/vue/2.2.1/vue',
        'amap'      : '//webapi.amap.com/maps?v=1.3&key=0eb030454d05a6f2bf80394b6245f54e',
//        'AMapUI'    : '//webapi.amap.com/ui/1.0/main',
        // 工具类
        'Lodash'    : '//cdn.bootcss.com/lodash.js/4.17.4/lodash.min',
        // 插件类
        'nprogress' : '//cdn.bootcss.com/nprogress/0.2.0/nprogress.min',
        'unslider'  : '//cdn.bootcss.com/unslider/2.0.3/js/unslider-min',
        'swiper'    : '//cdn.bootcss.com/Swiper/3.4.2/js/swiper.min',
        'fullscreen': '//cdn.bootcss.com/screenfull.js/3.3.1/screenfull.min',
        'videojs'     : '//cdn.bootcss.com/video.js/6.2.4/video.min',
        'videojs-lang': '//cdn.bootcss.com/video.js/6.2.4/lang/zh-CN',
        'lightbox'  : 'https://cdn.bootcss.com/lightbox2/2.9.0/js/lightbox.min',
        // 样式类
        'bootstrap' : '//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min',
        // 动画类
        'velocity'  : '//cdn.bootcss.com/velocity/1.4.3/velocity.min',
        // 自定义类
        'jutil'     : 'util/jutil/Jutil',
        'jmap'      : 'util/jmap/jmap',
    },
    shim : {
        'unslider' : {
            deps: ['jquery'],
            exports:'unslider'
        },
        'swiper' : {
            deps : ['jquery'],
            exports : 'swiper'
        },
//        'AMapUI' : {
//            deps : ['jquery'],
//            exports : 'AMapUI'
//        },
        'jmap' : {
            deps : ['jquery', 'amap'],
            exports : 'jmap'
        },
        'jutil' : {
            deps : ['jquery'],
            exports : 'jutil'
        },
        'videojs-lang' : {
            deps : ['videojs'],
            exports : 'videojs-lang'
        },
        'zoomjs' : {
            deps : ['jquery'],
            exports : 'zoomjs'
        },
        'bootstrap' : {
            deps : ['jquery'],
            exports : 'bootstrap'
        }
        
    }
});

require(['jquery'], function($){
    $.fn.extend({
        animateCss: function (animationName) {
            var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            this.addClass('animated ' + animationName).one(animationEnd, function() {
                $(this).removeClass('animated ' + animationName);
            });
            return this;
        }
    });
});















