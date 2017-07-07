/**
 * @Description 
 * @author dfggking@hotmail.com
 * @date 2017-6-27
 * @version 1.0
 */
require.config({
    urlArgs : 'v=1.0.0',
    baseUrl : ctx+'/js/',
    paths : {
        // 框架类
        'jquery'    : 'https://cdn.bootcss.com/jquery/3.2.1/jquery.min',
        'vue'       : 'https://cdn.bootcss.com/vue/2.2.1/vue.min',
        // 工具类
        'Lodash'    : 'https://cdn.bootcss.com/lodash.js/4.17.4/lodash.min',
        'jutil'     : 'util/jutil/jutil',
        'jmap'      : 'util/jmap/jmap',
        // 插件类
        'nprogress' : 'https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min',
        'unslider'  : 'https://cdn.bootcss.com/unslider/2.0.3/js/unslider-min',
        // 样式类
        'bootstrap' : 'https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min',
        // 动画类
        'velocity'  : 'https://cdn.bootcss.com/velocity/1.4.3/velocity.min'
    },
    shim : {
        'unslider' : {
            deps: ['jquery'],
            exports:'unslider'
        },
        'jmap' : {
            deps : ['jquery'],
            exports : 'unslider'
        }
    }
});

















