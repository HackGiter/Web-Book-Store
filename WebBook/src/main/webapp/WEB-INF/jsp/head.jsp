<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Book Index</title>
    <meta content="text/html;charset=UTF-8" >
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Index">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css" type="text/css">
	<script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
  </head>
  <body>
<!--  <div class='l-curve'></div> -->
  <div class='head'>
  	<div class='head_inner'>
<%--		<form action="${pageContext.request.contextPath }/user/check" method="post" name="userForm"></form>--%>
<%--		<form action="${pageContext.request.contextPath}/orders/cart" method="post"></form>--%>
		<a href="${pageContext.request.contextPath }/user/check"><div class='box_item'>用户</div></a>
	  	<a href="${pageContext.request.contextPath}/orders/cart"><div class='box_item'>购物袋</div></a>
<%--		<div class='box_item' onclick=""><form action="${pageContext.request.contextPath }/user/check" method="post"><input class="user_item" type="submit" value="用户" /></form></div>--%>
<%--		<div class='box_item'><form action="${pageContext.request.contextPath}/orders/cart" method="post"><input class="user_item" type="submit" value="购物袋" /></form> </div>--%>
	  	<div class='box_item'>搜书</div>
		<a style="outline: none; color: #606266;" href="${pageContext.request.contextPath }/index/home"><div class='box_item'>书柜</div></a>
		<a href="${pageContext.request.contextPath }/orders/showAll"><div class='box_item' style="font-size: 15px">已购书单</div></a>
  	</div>
  </div>
<!--   <div class='r-curve'></div> -->
  
  </body>

</html>
