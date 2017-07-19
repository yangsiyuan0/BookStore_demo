<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js" ></script>

<!-- 一.导航栏：直接利用BootStrap模块-->
		<nav class="navbar  " role="navigation">
		  <!-- Brand and toggle get grouped for better mobile display -->
		  <div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
		      <span class="sr-only">Toggle navigation</span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand" href="${pageContext.request.contextPath}/">小狗书城</a>
		  </div>
		
		  <!-- Collect the nav links, forms, and other content for toggling -->
		  <div class="collapse navbar-collapse navbar-ex1-collapse">
		    <ul class="nav navbar-nav" id= "categoryMenu">
		    
		    </ul>
		    <ul class="nav navbar-nav navbar-right" style="margin-right: 5px;">
		  
	    		<li><a href="#">你好,&nbsp;少年</a></li>
		   
		    	
		      <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">购物信息<b class="caret"></b></a>
		        <ul class="dropdown-menu">
	          	  <li><a href="${pageContext.request.contextPath}/jsp/cart.jsp"><i class="glyphicon glyphicon-shopping-cart"></i>&emsp;购物车</a></li>
	          	  <li><a href="${pageContext.request.contextPath}/OrderServlet?method=findAllOrder"><i class="glyphicon glyphicon-heart"></i>&emsp;我的订单</a></li>
	          	  <c:if test="${not empty existUser}">
		          	<li class="divider"></li>
		          	<li><a href="${pageContext.request.contextPath}/UserServlet?method=exit"><i class="glyphicon glyphicon-share-alt"></i>&emsp;注销</a></li>
		          </c:if>
		        </ul>
		      </li>
		    </ul>
		    
		    <form class="navbar-form navbar-right" role="search">
		      <div class="form-group">
		        <input type="text" class="form-control" placeholder="Search">
		      </div>
		      <button type="submit" class="btn btn-default" disabled="disabled">确定</button>
		    </form>
		  </div><!-- /.导航栏结束 -->
		</nav>