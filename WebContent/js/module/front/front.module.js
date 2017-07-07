/**
 * @Description 
 * @author dfggking@hotmail.com
 * @date 2017-6-27
 * @version 1.0
 */
require([ctx+'/js/app.js?v=' + new Date().getTime()], function(){
    require(['jquery', 'nprogress', 'unslider', 'jutil'], function ($, NProgress, unslider) {
        NProgress.inc();
        $(function(){
            var timeout = window.setTimeout(function(){
                NProgress.done();
                window.clearTimeout(timeout);       
            }, 2000);
            var unslider04 = $('#J_unslider').unslider({
                dots: true
            }),data04 = unslider04.data('unslider');
            $('.unslider-arrow04').click(function() {
                var fn = this.className.split(' ')[1];
                data04[fn]();
            });
        });
    });
});