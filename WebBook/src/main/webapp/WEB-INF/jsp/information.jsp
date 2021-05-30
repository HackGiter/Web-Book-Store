<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/2
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String names = request.getParameter("name");
    String title = request.getParameter("title");
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Information</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/information.css" type="text/css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <script>function ACTION(e) {
        console.log(e);
    }


    </script>
</head>
<body>

    <div class="center_box">
        <div class="inner_box">
            <div class="left_box">
                <div class="func_button" name="books" onclick="ACTION('books')">图书</div>
                <div class="func_button" name="products" onclick="ACTION('products')">商品</div>
                <div class="func_button" name="managers" onclick="ACTION('managers')">123</div>
                <div class="func_button" name="sales" onclick="ACTION('sales')">123</div>
                <div class="func_button" name="storages" onclick="ACTION('storages')">123</div>
                <div class="func_button" name="buys" onclick="ACTION('buys')">123</div>
                <div class="func_button" name="buys" onclick="ACTION('buys')">123</div>
          </div>
            <div class="right_box">
                <div class="info_box">
                    <jsp:include page="/WEB-INF/jsp/products.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
