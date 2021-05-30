<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/13
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="generalClass.Orders" %>
<%@ page import="generalClass.Books" %>
<%@ page import="java.text.DecimalFormat" %>
<%
    List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
    List<Books> booksList = (List<Books>) session.getAttribute("ordersBook");
    List<String> isbnList = (List<String>) session.getAttribute("isbnList");
    int length = 0;
    if (ordersList != null) {
        length = ordersList.size();
    }
    DecimalFormat df =  new DecimalFormat( "0.00");
    String[] types = {"实体书", "电子书"};
%>
<html>
<head>
    <title>购物书单</title>
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cart_info.css">
    <script>
        function Pushit(e) {
            console.log(e);
            e.action="${pageContext.request.contextPath}/orders/remove";
            e.submit();
        }
    </script>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
    <div class="cart_content" style="height: <%=length*245+250%>px;">
        <div class="cart_title">
            购物书单
        </div>
        <div class="cart_line"></div>
        <% if (ordersList == null) {%>
        <div style="text-align: center; font-size: 30px;height: 80px;margin-top: 20px">
            你尚未建立你的购物书单
        </div>
        <div class="cart_line"></div>
        <%} else {%>
        <div  class="cart_main_content" style="height: <%=length*245+90%>px;">
            <% for (int i = 0; i < ordersList.size(); i++) {%>
                    <div class="cart_item">
                        <div class="cart_item_img_box">
                            <img class="item_img" src="${pageContext.request.contextPath}/images/<%=booksList.get(i).getBid()%>.jpg">
                        </div>
                        <div class="cart_item_info">
                            <div class="text_item_1">
                                书名：<%=booksList.get(i).getName()%> &nbsp; &nbsp;
                            </div>
                            <div class="text_item_1">[<%=booksList.get(i).getCountry()%>] &nbsp;  <%=booksList.get(i).getAuthor()%></div>
                            <div class="text_item">
                                类型：<%=types[ordersList.get(i).getType()-'0']%> &nbsp; &nbsp; ISBN号： <%=isbnList.get(i)%>
                            </div>
                        </div>
                        <div class="cart_product_info">
                            <div class="wrap_select">
                                <form action="${pageContext.request.contextPath}/orders/change" method="post" name="form_<%=i%>">
                                    <select class="number_select" name="number" onchange="document.form_<%=i%>.submit();">
                                        <% for (int a = 1; a <=10 ; a++) {%>
                                        <% if (a == ordersList.get(i).getNumber()){%>
                                        <option selected="selected"><%=a%></option>
                                        <% } else {%>
                                        <option><%=a%></option>
                                        <% } } %>
                                    </select>
                                    <input style="display: none" name="id" value=<%=i%> />
                                    <input class="cancel_one" value="取消" type="button" onclick="Pushit(document.form_<%=i%>)" />
                                </form>
                            </div>
                            <div class="price_title">
                                <%=df.format(ordersList.get(i).getPrice())%>
                            </div>
                        </div>
                    </div>
            <%
            }%>

            <div class="cart_line"></div>
            <div style="height: 60px; float: right">
                <form action="${pageContext.request.contextPath}/orders/sold" method="post">
                    <input type="submit" class="send_class" value="购买" />
                </form>
            </div>
        </div>
        <%}%>
    </div>

</body>
</html>
