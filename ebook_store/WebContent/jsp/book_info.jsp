<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>图书详情</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

		<%@ include file="navi.jsp" %>

		<div class="container">
			<div class="row">
				<div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
					<a href="#">首页&nbsp;&nbsp;&gt;</a>
				</div>
				
				<form id="form1" action="${ pageContext.request.contextPath }/CartServlet" method="post">
<!-- 隐藏表单项：用于传递CartServlet中需要的相关参数 -->
				<input type="hidden" name="method" value="addCart" />
				<input type="hidden" name="bid" value="${ bookBean.bid }" />
				<div style="margin:0 auto;width:950px;">
					<div class="col-md-6">
						<img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${ pageContext.request.contextPath }/${ bookBean.image}">
					</div>

					<div class="col-md-6">
						<div><strong>${ bookBean.bname }</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>作者：${ bookBean.author }</div>
						</div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>图书编号：${ bookBean.bid }</div>
						</div>

						<div style="margin:10px 0 10px 0;">商城价: <strong style="color:#ef0101;">￥：${ bookBean.price }元</strong> 
						</div>


						<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">

							<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
								<input id="count" name="count" value="1" maxlength="4" size="10" type="text"> </div>

							<div style="margin:20px 0 10px 0;;text-align: center;">
								<a href="javascript:document.getElementById('form1').submit()">
									<input style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="加入购物车" type="button">
						</div>
						
					</div>
				</div>
				</form>


	</body>

</html>