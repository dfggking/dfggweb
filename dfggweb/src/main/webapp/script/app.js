/**
 * require config
 * @author jinyf
 */
require.config({
	urlArgs : 'v=1.0.0',
	baseUrl : ctx+'/script/',
	paths : { // paths
		
		// 框架类
		'jquery' : 'https://cdn.bootcss.com/jquery/3.1.1/jquery.min',
		'vue' : 'https://cdn.bootcss.com/vue/2.2.1/vue.min',
		
		// 工具类
		'Lodash' : 'https://cdn.bootcss.com/lodash.js/4.17.4/lodash.min',
		
		// 插件类
		'nprogress' : 'https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min',
		
		// 样式类
		'bootstrap' : 'https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min',
		
		// 动画类
		'velocity' : 'https://cdn.bootcss.com/velocity/1.4.3/velocity.min',
		
	},
	shim : { // shim
		'nprogress' : 'jquery',
		'velocity' : 'jquery',
		
	}
});

















