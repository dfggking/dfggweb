/**
 * @author JINYF
 * scriptUrl 位置 ${ctx}/js/script.url.js
 */
require.config({
	urlArgs : 'v='+(new Date()).getTime(),
	baseUrl : ctx+'/js/',
	paths : scriptUrl[0],
	shim : scriptUrl[1]
});

















