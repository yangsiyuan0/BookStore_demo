<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
		<meta charset="utf-8" />
		<title>商城主页</title>
	</head>
	<body>
	<!-- 一. 导航栏 -->
		<%@ include file="navi.jsp" %>
		
		<div class="container" style="height: 300px;margin-top: 200px; text-align: center;" >
			<div class="row">
			<h3 style="color: gray">主页正在施工中,&emsp;请前往其他页面...</h3>
			</div>
		</div>
		

	</body>
</html>
