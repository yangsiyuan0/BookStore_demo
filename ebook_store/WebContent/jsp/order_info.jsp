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
	<title>订单</title>
</head>


<body>
<!-- 导航栏 -->
	<%@ include file="navi.jsp" %>
	<div class="container">
		<div class="row">

			<div style="margin:0 auto;margin-top:10px;width:950px;">
				<strong>订单详情</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<th colspan="5">订单编号:${orderBean.oid}</th>
						</tr>
						<tr class="warning">
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${orderBean.orderItems}" var="orderItem">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/${orderItem.bookBean.image}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank">${orderItem.bookBean.bname}</a>
								</td>
								<td width="20%">
									￥${orderItem.bookBean.price}
								</td>
								<td width="10%">
									${orderItem.count}
								</td>
								<td width="15%">
									<span class="subtotal">￥${orderItem.subtotal}</span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div style="text-align:right;margin-right:120px;">
				商品金额: <strong style="color:#ff6600;">￥${orderBean.total}元</strong>
			</div>

		</div>

		<div>
			<hr/>
			<form class="form-horizontal" style="margin-top:5px;margin-left:150px;" id="orderForm" method="post" action="${ pageContext.request.contextPath }/OrderServlet">
				<input type="hidden" name="method" value="payForfree"/>
				<input type="hidden" name="oid" value="${ orderBean.oid }"/>
				<div class="form-group" >
					<label for="username" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"  name="address"    placeholder="请输入收货地址">
					</div>
				</div>
				<p style="text-align:right;margin-right:100px;">
					<!-- <a href="javascript:document.getElementById('orderForm').submit();"> -->
					<a href="javascript:document.getElementById('orderForm').submit();">
						<input type="button" value="吃霸王餐" width="204" height="51" border="0" onclick="return window.confirm('  喂,110吗,这里有人要吃霸王..\n$%/啊$*^&哦%*喔%吃!吧$%@')"/>
					</a>
				</p>
				<hr/>
			</form>
			</div>
		</div>
</body>
</html>