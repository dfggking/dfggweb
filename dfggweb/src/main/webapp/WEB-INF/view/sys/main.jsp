<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 引入样式 -->
<link href="//cdn.bootcss.com/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
<link href="//cdn.bootcss.com/element-ui/1.1.6/theme-default/index.css" rel="stylesheet" />
</head>
<body>
	<div id="app">
		<el-button @click="visible = true">按钮</el-button>
		<template>
		  <el-button :plain="true" @click="open2">成功</el-button>
		  <el-button :plain="true" @click="open3">警告</el-button>
		  <el-button :plain="true" @click="open">消息</el-button>
		  <el-button :plain="true" @click="open4">错误</el-button>
		</template>
		<el-dialog v-model="visible" title="Hello world">
		  <p>欢迎使用 Element</p>
		</el-dialog>
	</div>
</body>
<script src="//cdn.bootcss.com/nprogress/0.2.0/nprogress.min.js"></script>
<!-- 先引入 Vue -->
<script src="//cdn.bootcss.com/vue/2.1.10/vue.js"></script>
<!-- 引入组件库 -->
<script src="//cdn.bootcss.com/element-ui/1.1.6/index.js"></script>
<script>
	new Vue({
		el : '#app',
		data : function() {
			return {
				visible : false
			}
		},
		methods: {
	      open() {
	        this.$message('这是一条消息提示');
	      },
	      open2() {
	        this.$message({
	          message: '恭喜你，这是一条成功消息',
	          type: 'success'
	        });
	      },
	      open3() {
	        this.$message({
	          message: '警告哦，这是一条警告消息',
	          type: 'warning'
	        });
	      },
	      open4() {
	        this.$message.error('错了哦，这是一条错误消息');
	      }
	    }
	});
	
	// 页面加载进度效果
	NProgress.inc();
</script>
</html>