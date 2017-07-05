<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta charset="UTF-8">
<meta name="renderer" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<title>WEB技能圈儿</title>
<meta http-equiv="pragma" content="no-cache" />
<meta name="description" content="">
<!-- user-scalable=no 表示不允许移动端缩放  -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<link rel="shortcut icon" href="${ctx}/favicon.ico"/>
<!-- 样式优先加载  -->
<!-- bootstrap已经依赖 <link href="https://cdn.bootcss.com/normalize/7.0.0/normalize.min.css" rel="stylesheet"> -->
<link href="//cdn.bootcss.com/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<%-- <link href="${ctx}/css/common/font-awesome.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome-animation/0.0.10/font-awesome-animation.min.css" rel="stylesheet"> --%>
<script src="https://cdn.bootcss.com/modernizr/2.8.3/modernizr.min.js"></script>
<script src="${ctx}/js/plugins.js"></script>
<!--[if lt IE 9]>
<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script>
var ctx = '${ctx}';
</script>
