<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>商品列表</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
	<style>
		body {
			margin-top: 20px;
			margin: 0 auto;
			width: 100%;
		}
		.carousel-inner .item img {
			width: 100%;
			height: 300px;
		}
	</style>
</head>

<body>
<!-- 导航栏  -->
	<%@ include file="navi.jsp" %>
<!-- 商品列表栏 -->
<div class="row" style="width:1210px;margin:0 auto;">
	<c:forEach items="${pageBean.list}" var="book">
		<div class="col-md-2">
			<a href="${pageContext.request.contextPath}/BookServlet?method=findByBid&bid=${book.bid}&time=<%= new Date().getTime() %>">
				<img src="${pageContext.request.contextPath}/${book.image}" width="170" height="170" style="display: inline-block;">
			</a>
			<p><a href="${pageContext.request.contextPath}/BookServlet?method=findByBid&bid=${book.bid}" style='color:green'>${fn:substring(book.bname,0,10)}</a></p>
			<p><font color="#FF0000">价格：&yen;${book.price} </font></p>
		</div>
	</c:forEach>
</div>
<!-- 分页栏 -->
	<div style="width:380px;margin:0 auto;margin-top:50px;">
		<ul class="pagination" style="text-align:center; margin-top:10px;">
		<!-- 上一页 -->
		<c:if test="${ pageBean.currentPage ==1 }">
			<li class='disabled'>
			<a href="javaScript:void(0)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
		</c:if>
		<c:if test="${ pageBean.currentPage !=1 }">
			<li>
			<a href="${ pageContext.request.contextPath }/BookServlet?method=findPageByCid&currentPage=${pageBean.currentPage-1}&cid=${param.cid}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
		</c:if>
			<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
				<c:choose>
					<c:when test="${ pageBean.currentPage == i }">
						<li class="active"><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/BroductServlet?method=findPageByCid&currentPage=${i}&cid=${param.cid}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ pageBean.currentPage == pageBean.totalPage }">
				<li class='disabled'>
				<a href="javaScript:void(0)" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
				</li>
			</c:if>
			<c:if test="${ pageBean.currentPage != pageBean.totalPage }">
				<li>
				<a href="${ pageContext.request.contextPath }/BroductServlet?method=findPageByCid&currentPage=${pageBean.currentPage+1}&cid=${param.cid}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
			</c:if>
		</ul>
	</div>
	<!-- 分页结束=======================  -->
	
</body>
</html>