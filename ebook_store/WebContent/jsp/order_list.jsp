<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
	<title>购物车</title>
</head>

<body>
<!-- 导航栏 -->
	<%@ include file="navi.jsp" %>
	
<!-- 页面主体 -->

		<div class="container">
			<div class="row">
				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
					
					<c:forEach items="${list}" var="order">
						<tbody>
<!-- 订单详情+状态 -->
							<tr class="success">
								<th colspan="5">
								订单编号:${ order.oid }&nbsp;&nbsp;&nbsp; 
								<c:if test="${ order.state == 1 }">
									<a href="${ pageContext.request.contextPath }/OrderServlet?method=findByOid&oid=${ order.oid }">付款</a>
								</c:if>
								<c:if test="${ order.state == 2 }">
									卖家未发货
								</c:if>
								<c:if test="${ order.state == 3 }">
									<a href="#">确认收货</a>
								</c:if>
								<c:if test="${ order.state == 4 }">
									订单结束
								</c:if>
								&nbsp;&nbsp;&nbsp; 
								总金额:￥${ order.total }元
								</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${ order.orderItems }" var="orderItem">
								<tr class="active">
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${ pageContext.request.contextPath }/${orderItem.bookBean.image}" width="70" height="60">
									</td>
									<td width="30%">
										<a target="_blank">${orderItem.bookBean.bname}</a>
									</td>
									<td width="20%">
										￥${orderItem.bookBean.price}
									</td>
									<td width="10%">
										￥${orderItem.count}
									</td>
									<td width="15%">
										<span class="subtotal">￥${orderItem.subtotal}</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:forEach>
					</table>
				</div>
			</div>
</body>
</html>