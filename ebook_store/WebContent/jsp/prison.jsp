<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
<title>商城监狱</title>
</head>
<body>
<!-- 导航栏 -->
	<%@ include file="navi.jsp" %>
	<div class="container" style="height: 300px;text-align: center;" >
			<div class="row">
			<h1 style="text-align: center;margin-bottom: 20px"> 依法关押</h1>
			<img alt="" src="${pageContext.request.contextPath}/book_img/prison.jpg" width="50%">
			</div>
		</div>
</body>
</html>