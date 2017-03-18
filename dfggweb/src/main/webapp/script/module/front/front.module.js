require([ctx+'/script/app.js'], function(){
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