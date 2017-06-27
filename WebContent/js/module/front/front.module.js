/**
 * @Description 
 * @author dfggking@hotmail.com
 * @date 2017-6-27
 * @version 
 */
require([ctx+'/js/app.js'], function(){
	require(['jquery', 'vue', 'nprogress', 'velocity'], function ($, Vue, NProgress) {
		NProgress.start(); // 进度条启动
		NProgress.inc();
		$(function(){
			window.setTimeout(function(){
				NProgress.done();
			}, 6000);
		});
	});
});