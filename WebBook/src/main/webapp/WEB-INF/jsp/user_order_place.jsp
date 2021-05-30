<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/15
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="generalClass.AllOrders" %>
<%@ page import="generalClass.Orders" %>
<%@ page import="java.text.DecimalFormat" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int have = (int) request.getAttribute("have");
    List<AllOrders> allOrdersList = (List<AllOrders>) request.getAttribute("UAllOrder");
    List<List<Orders>> ordersList = (List<List<Orders>>) request.getAttribute("LLOrders");
    DecimalFormat df =  new DecimalFormat( "0.00");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>已购书单</title>
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_order_place.css" type="text/css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
    <div class="main_table">
        <div class="main_title">
            已购书单
        </div>
        <% if (have == 1) {
            for (int i = 0; i < allOrdersList.size(); i++) {
        %>
        <div class="form_table">
            <div class="form_title">
                <div>订单编号：&nbsp; <%=allOrdersList.get(i).getAid()%></div>
            </div>
            <div class="form_self">
                    <table class="table_self">
                        <tr class="line" style="font-size: 19px">
                            <td class="item">书名</td>
                            <td class="item">数量</td>
                            <td class="item">价格</td>
                        </tr>
                        <% for (int a = 0; a < ordersList.get(i).size(); a++) { %>
                        <tr class="line">
                            <td class="item"><%=ordersList.get(i).get(a).getName()%></td>
                            <td class="item"><%=ordersList.get(i).get(a).getNumber()%> 本</td>
                            <td class="item"><%=df.format(ordersList.get(i).get(a).getPrice())%> 元</td>
                        </tr>
                        <% } %>
                        <tr class="line" style="font-size: 19px">
                            <td class="item"></td>
                            <td class="item">总价：</td>
                            <td class="item"><%=df.format(allOrdersList.get(i).getPays())%> 元</td>
                        </tr>
                    </table>
            </div>
        </div>
        <% }} else { %>
        <div class="tail_title">
            你尚未购买任何书籍
        </div>
        <% } %>
        <div class="tail"></div>
    </div>
</body>
</html>
