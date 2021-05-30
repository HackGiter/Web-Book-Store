<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/10
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String[] cate = {"文学", "流行", "文化", "生活", "经管", "科技"};
    int has = (int) request.getAttribute("has");
%>
<html>
<head>
    <title>编辑图书信息</title>
</head>
<body>
<div>
    <div class="form_head">
        <h2>
            添加图书信息
        </h2>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/books/editBook2" method="post" name="booksForm" enctype="multipart/form-data">
            <div class="table_wrapper" style="float: left">
                <table class="pd_info_table">
                    <tbody>
                    <tr class="pd_info_box">
                        <td colspan="2">图书信息填写</td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">图书名：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="books.name" value="<%=books.getName()%>">
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">系列编号：</td>
                        <td class="pd_info_box_1">
                            <% if (books.getSid()==null) {%>
                            <input class="pd_info_input" type="text" name="books.sid">
                            <% } else {%>
                            <input class="pd_info_input" type="text" name="books.sid" value="<%=books.getSid()%>">
                            <% }%>

                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">作者：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="books.author" value="<%=books.getAuthor()%>">
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">作者国籍：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="books.country" value="<%=books.getCountry()%>">
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">种类：</td>
                        <td class="pd_info_box_1">
                            <select name="books.category" class="select_option">
                                <% for (int i = 0; i < 6; i++) {%>
                                <% if (i==Integer.parseInt(String.valueOf(books.getCategory()))) {%>
                                <option value="<%=i%>" selected><%=cate[i]%></option>
                                <% } else {%>
                                <option value="<%=i%>"><%=cate[i]%></option>
                                <% }%>
                                <% } %>
                            </select>
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">限制年龄：</td>
                        <td class="pd_info_box_1">
                            <select name="books.age" class="select_option">
<%--                                <option v-for="a in ageyear" v-model="a">{{a}}</option>--%>
                                <% for ( int i = 1; i <=20; i++) {%>
    <% if (books.getAge()==i) {%>
    <option value=<%=i%> selected><%=i%></option>
    <% } else {%>
    <option value=<%=i%>><%=i%></option>
    <% }%>
    <% } %>
                            </select>岁
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">评分：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="books.score" value="<%=books.getScore()%>">
                        </td>
                    </tr>
                    <tr class="pd_info_box">
                        <td colspan="2">商品信息填写</td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">商品类型：</td>
                        <td class="pd_info_box_1">
                            <select name="products.type" class="select_option">
                                <% if (products.getType()=='0') {%>
                                <option value='0' selected>实体书</option>
                                <option value='1'>电子书</option>
                                <% } else {%>
                                <option value='0'>实体书</option>
                                <option value='1' selected>电子书</option>
                                <% } %>

                            </select>
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">商品价格：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="products.price" value="<%=products.getPrice()%>">元
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">商品数量：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="products.number" value="<%=products.getNumber()%>">件
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">商品入库地址：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="products.address" value="<%=products.getAddress()%>">
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">商品销量：</td>
                        <td class="pd_info_box_1">
                            <input style="display: none" name="products.sale" value="<%=products.getSale()%>" />
                        </td>
                    </tr>

                    </tbody>
                </table>

            </div>
            <div class="table_wrapper" >
                <table class="pd_info_table">
                    <tr class="pd_info_box">
                        <td colspan="2">图书详细信息填写</td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box">原作名：</td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="booksDetail.otitle" value="<%=booksDetail.getOtitle()%>" />
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">出版社：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="booksDetail.publisher" value="<%=booksDetail.getPublisher()%>" />
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">译者：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="booksDetail.translator" value="<%=booksDetail.getTranslator()%>" />
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">出版日期：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="date" name="booksDetail.date" value="<%=booksDetail.getDate()%>" />
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">页数：</td>
                        <td class="pd_info_box_1">
                            <input class="pd_info_input" type="text" name="booksDetail.pages" value="<%=booksDetail.getPages()%>" />
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">装订：</td>
                        <td class="pd_info_box_1">
                            <select name="booksDetail.binding" class="select_option">
                                <% if (booksDetail.getBinding().equals("精装")) {%>
                                <option value="精装" selected>精装</option>
                                <option value="平装">平装</option>
                                <% } else {%>
                                <option value="精装">精装</option>
                                <option value="平装" selected>平装</option>
                                <% } %>

                            </select>
                        </td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">ISBN:</td>
                        <td class="pd_info_box_1"><input class="pd_info_input" type="text" name="booksDetail.isbn" value="<%=booksDetail.getIsbn()%>" /></td>
                    </tr>
                    <tr class="pd_info_line">
                        <td class="pd_info_box_1">出品方：</td>
                        <td class="pd_info_box_1"><input class="pd_info_input" type="text" name="booksDetail.producer" value="<%=booksDetail.getProducer()%>" /></td>
                    </tr>
                    <tr class="pd_info_box">
                        <td class="pd_info_box_1">图书封面：</td>
                        <td class="pd_info_box_1"><input class="file_button" type="file" name="imgFile" /></td>
                    </tr>
                    <tr style="display: none">
                        <td><input name="booksDetail.bdid" value="<%=booksDetail.getBdid()%>" /></td>
                        <td><input name="books.bdid" value="<%=books.getBdid()%>" /></td>
                        <td><input name="products.pid" value="<%=products.getPid()%>" /></td>
                        <td><input name="books.bid" value="<%=books.getBid()%>" /></td>
                        <td><input name="products.bid" value="<%=products.getBid()%>" /></td>
                        <td><input name="has" value=<%=has%>></td>
                    </tr>
                </table>
                <div style="float: right">
                    <input class="cancel_button" type="submit" value="取消" onclick="cancel()"/>
                    <input class="submit_button" type="submit" value="更改商品" />
                </div>
            </div>
        </form>
    </div>

</div>
</body>
</html>
