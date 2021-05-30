<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/10
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="generalClass.Books" %>
<%@ page import="generalClass.Products" %>
<%@ page import="generalClass.BooksDetail" %>
<%
    Books books = (Books) request.getAttribute("books");
    Products products = (Products) request.getAttribute("products");
    BooksDetail booksDetail = (BooksDetail) request.getAttribute("booksDetail");
    String[] titles = {"文学", "流行", "文化", "生活", "经管", "科技"};
    String[] type = {"实体书", "电子书"};
%>
<html>
<head>
    <title>图书详情</title>
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book_info.css" type="text/css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/head.jsp"/>
    <div class="content_panel">
        <div class="inside_panel">
            <div class="panel_img_box">
                <img class="panel_img" src="${pageContext.request.contextPath}/images/<%=books.getBid()%>.jpg" alt="">
            </div>
            <div class="panel_info_box">
                <div class="tb_title">
                    图书商品详细信息：
                </div>
                <table style="margin: 0 10px 0 100px;width: 300px;display: inline-block;">
                    <tr class="tb_tr">
                        <td class="tb_td_title">书名：</td>
                        <td class="tb_td_value"><%=books.getName()%></td>
                    </tr>
                    <% if (!booksDetail.getOtitle().equals("")) {%>
                    <tr class="tb_tr">
                        <td class="tb_td_title">原作名：</td>
                        <td class="tb_td_value"><%=booksDetail.getOtitle()%></td>
                    </tr>
                    <% } %>
                    <tr class="tb_tr">
                        <td class="tb_td_title">作者：</td>
                        <td class="tb_td_value">[<%=books.getCountry()%>] <%=books.getAuthor()%></td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">类型：</td>
                        <td class="tb_td_value"><%=titles[books.getCategory()-'0']%></td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">推荐年龄：</td>
                        <td class="tb_td_value"><%=books.getAge()%> 岁及以上</td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">出版社：</td>
                        <td class="tb_td_value"><%=booksDetail.getPublisher()%></td>
                    </tr>
                    <% if (!booksDetail.getProducer().equals("")) {%>
                    <tr class="tb_tr">
                        <td class="tb_td_title">出品方：</td>
                        <td class="tb_td_value"><%=booksDetail.getProducer()%></td>
                    </tr>
                    <% } %>
                    <tr class="tb_tr">
                        <td class="tb_td_title">出版日期：</td>
                        <td class="tb_td_value"><%=booksDetail.getDate()%></td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">页数：</td>
                        <td class="tb_td_value"><%=booksDetail.getPages()%>页</td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">装帧：</td>
                        <td class="tb_td_value"><%=booksDetail.getBinding()%></td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">ISBN：</td>
                        <td class="tb_td_value"><%=booksDetail.getIsbn()%></td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">书籍类型：</td>
                        <td class="tb_td_value"><%=type[products.getType()-'0']%></td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">价格：</td>
                        <td class="tb_td_value"><%=products.getPrice()%>元</td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">库存数量：</td>
                        <td class="tb_td_value"><%=products.getNumber()%>件</td>
                    </tr>
                    <tr class="tb_tr">
                        <td class="tb_td_title">销量：</td>
                        <td class="tb_td_value"><%=products.getSale()%>件</td>
                    </tr>
                    <tr class="tb_tr">
                        <form action="${pageContext.request.contextPath}/orders/order_book" method="post">
                        <td class="tb_td_title">
                            <div style="margin: 10px">
                                <select class="select_number" name="number">
                                    <option class="option_number" value=1>1</option>
                                    <option class="option_number" value=2>2</option>
                                    <option class="option_number" value=3>3</option>
                                    <option class="option_number" value=4>4</option>
                                    <option class="option_number" value=5>5</option>
                                    <option class="option_number" value=6>6</option>
                                    <option class="option_number" value=7>7</option>
                                    <option class="option_number" value=8>8</option>
                                    <option class="option_number" value=9>9</option>
                                </select>
                            </div>
                        </td>
                        <td class="tb_td_value">
                            <input style="display: none" name="pid" value=<%=products.getPid()%> />
                            <input style="display: none" name="type" value=<%=products.getType()%> />
                            <input style="display: none" name="price" value=<%=products.getPrice()%> />
                            <input style="display: none" name="success" value='0' />
                            <input style="display: none" name="bid" value=<%=books.getBid()%> />
                            <input style="display: none" name="name" value=<%=books.getName()%> />
                            <input style="display: none" name="author" value=<%=books.getAuthor()%> />
                            <input style="display: none" name="country" value=<%=books.getCountry()%> />
                            <input style="display: none" name="isbn" value=<%=booksDetail.getIsbn()%> />
                            <input class="order_button" type="submit" value="添加" />
                        </td>
                        </form>
                    </tr>
                </table>
                <div class="score_panel">
                评分：
                    <div style="font-size: 38px;color: gold;text-align: center"><%=books.getScore()%></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
