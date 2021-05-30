<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/9
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ page import="java.util.*" pageEncoding="UTF-8"%>--%>
<%--<%@ page import="generalClass.Books" %>--%>
<%--<%@ page import="generalClass.Products" %>--%>
<%--<%@ page import="generalClass.Series" %>--%>
<%
    String[] titles = {"文学", "流行", "文化", "生活", "经管", "科技"};
    String[] types = {"实体书", "电子书"};
    String[] success = {"未完成", "完成"};
//    List<Books> booksList = null;
//    List<Products> productsList = null;
//    List<Series> seriesList = null;
//    int command = (int) request.getAttribute("command");
//    int count = 0;
//    int pages = 0;
//    if (command == 3) {
//        booksList = (List<Books>) request.getAttribute("booksList");
//        pages = booksList.size()/17;
//        if ((booksList.size()%14)>0) {
//            pages += 1;
//        }
//    } else if (command == 4){
//        productsList = (List<Products>) request.getAttribute("productsList");
//        pages = productsList.size()/17;
//        if ((productsList.size()%14)>0) {
//            pages += 1;
//        }
//    } else if (command == 5) {
//        seriesList = (List<Series>) request.getAttribute("seriesList");
//        pages = seriesList.size()/17;
//        if ((seriesList.size()%14)>0) {
//            pages += 1;
//        }
//    }
//    System.out.println(have);
//    System.out.println(booksList);
%>
<html>
<head>
    <title>商品信息库</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/info.css">
</head>
<body>
    <div class="info_body" style="margin-left: 2px">
        <% if (have == 1) {%>
        <% if (command == 3 && managers.getLevel()=='0') {%>
        <div style="width: 1520px">
            <div style="margin: auto">
                <form action="${pageContext.request.contextPath}/books/search" method="post">
                    <table class="pd_info_table" border="0">
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">图书名称<input class="pd_info_input" style="width: 140px;font-size: 15px;" name="name" /></td>
                            <td class="pd_info_box">图书作者<input class="pd_info_input" style="width: 140px;font-size: 15px;" name="author" /></td>
                            <td class="pd_info_box">作者国籍<input class="pd_info_input" style="width: 140px;font-size: 15px;" name="country" /></td>
<%--                            <td class="pd_info_box">图书系列<input name="sid" /></td>--%>
                            <td class="pd_info_box">限制年龄<select class="select_option" name="age">
                                <option v-for="a in ageyear" v-model="a">{{a}}</option>
                            </select></td>
                            <td class="pd_info_box">图书类型<select class="select_option" name="category">
                                <% for (int i = 0; i < titles.length; i++) { %>
                                <option value="<%=i%>"><%=titles[i]%></option>
                                <% } %>
                            </select></td>
                            <td class="pd_info_box">操作<input class="submit_button" type="submit" value="查询" /></td>
                        </tr>
                    </table>
                </form>
            </div>
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box" style="width: 140px;">图书编号</td>
                    <td class="pd_info_box" style="width: 8%;">系列编号</td>
                    <td class="pd_info_box" style="width: 20%">图书名称</td>
                    <td class="pd_info_box" style="width: 20%">图书作者</td>
                    <td class="pd_info_box">作者国籍</td>
                    <td class="pd_info_box">图书系列</td>
                    <td class="pd_info_box">限制年龄</td>
                    <td class="pd_info_box" style="width: 15%">表单操作</td>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int i = 0; i < booksList.size(); ) {
                        count += 1;
                        for (int a=i; a < count*17 && a < booksList.size(); a++) {
                %>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td  class="pd_info_box"><%=booksList.get(a).getBid()%></td>
                    <% if (booksList.get(a).getSid()!=null) {%>
                    <td class="pd_info_box"><%=booksList.get(a).getSid()%></td>
                    <% } else {%>
                    <td class="pd_info_box"></td>
                    <% }%>
                    <td class="pd_info_box"><%=booksList.get(a).getName()%></td>
                    <td class="pd_info_box"><%=booksList.get(a).getAuthor()%></td>
                    <td class="pd_info_box"><%=booksList.get(a).getCountry()%></td>
                    <td class="pd_info_box"><%=titles[booksList.get(a).getCategory()-'0']%></td>
                    <td class="pd_info_box"><%=booksList.get(a).getAge()%></td>
                    <td class="pd_info_box">
                        <% if (booksList.get(a).getAccess() == '1') { %>
                        <form  action="${pageContext.request.contextPath}/index/deleteProduct" method="post" class="form_info">
                            <input name="bid" type="hidden" value="<%=booksList.get(a).getBid()%>">
                            <input name="command" type="submit" value="移除" class="info_detail_style" />
                        </form>
                        <% } else {%>
                        <form  action="${pageContext.request.contextPath}/index/getProducts" method="post" class="form_info">
                            <input name="bid" type="hidden" value="<%=booksList.get(a).getBid()%>">
                            <input name="command" type="submit" value="添加" class="info_detail_style" />
                        </form>
                        <% } %>

                        <form action="${pageContext.request.contextPath}/index/editbook" method="post" class="form_info">
                            <input name="bid" type="hidden" value="<%=booksList.get(a).getBid()%>">
                            <input name="command" type="submit" value="编辑" class="info_edit_style"/>
                        </form>
                    </td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <div class="add_bar">
            <form action="${pageContext.request.contextPath}/index/admin" method="post">
                <input type="submit" class="add_input" value="添加"/>
                <input style="display: none" name="command" value=1 />
                <input style="display: none" name="ids" value=<%=command%> />
            </form>
        </div>
        <% } else if (command == 4){%>
        <div style="width: 1520px">
            <div style="margin: auto;">
                <form action="${pageContext.request.contextPath}/products/searchProducts" method="post">
                    <table class="pd_info_table" border="0">
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">商品类型<select class="select_option" name="type">
                                <option value="0">实体书</option>
                                <option value="1">电子书</option>
                            </select></td>
                            <td class="pd_info_box">商品价格<select class="select_option" name="price">
                                <option value="0">0</option>
                                <option v-for="a in ageyear" v-model="a*10">{{a*10}}</option>
                            </select></td>
                            <td class="pd_info_box">商品数量<select class="select_option" name="number">
                                <option value="0">0</option>
                                <option v-for="a in ageyear" v-model="a*150">{{a*150}}</option>
                            </select></td>
                            <td class="pd_info_box">商品销量<select class="select_option" name="sale">
                                <option value="0">0</option>
                                <option v-for="a in ageyear" v-model="a*150">{{a*150}}</option>
                            </select></td>
                            <td class="pd_info_box">库存地址<input class="pd_info_input" style="width: 140px;font-size: 15px;" name="address" /></td>
                            <td class="pd_info_box" style="width: 140px;"><input class="submit_button" type="submit" value="查询" /></td>
                        </tr>
                    </table>
                </form>
            </div>
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box" style="width: 155px;">商品编号</td>
                    <td class="pd_info_box" style="width: 155px;">图书编号</td>
                    <td class="pd_info_box">商品类型</td>
                    <td class="pd_info_box">商品价格</td>
                    <td class="pd_info_box" style="width: 155px;">商品数量</td>
                    <td class="pd_info_box" style="width: 155px;">商品销量</td>
                    <td class="pd_info_box">商品仓库地址</td>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < productsList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < productsList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box" style="width: 155px;"><%=productsList.get(a).getPid()%></td>
                    <td class="pd_info_box" style="width: 155px;"><%=productsList.get(a).getBid()%></td>
                    <td class="pd_info_box"><%=types[productsList.get(a).getType()-'0']%></td>
                    <td class="pd_info_box"><%=productsList.get(a).getPrice()%> 元</td>
                    <td class="pd_info_box" style="width: 155px;"><%=productsList.get(a).getNumber()%> 件</td>
                    <td class="pd_info_box" style="width: 155px;"><%=productsList.get(a).getSale()%> 件</td>
                    <td class="pd_info_box"><%=productsList.get(a).getAddress()%></td>
<%--                    <td class="pd_info_box"></td>--%>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 5) {%>
        <div style="width: 1520px">
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box" style="width: 155px;">系列编号</td>
                    <td class="pd_info_box" style="width: 155px;">作者名称</td>
                    <td class="pd_info_box">系列名称</td>
                    <td class="pd_info_box">类别</td>
                    <td class="pd_info_box" style="width: 155px;">系列书籍数量</td>
                    <td class="pd_info_box">表单操作</td>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i <seriesList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < seriesList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box" style="width: 155px;"><%=seriesList.get(a).getSid()%></td>
                    <td class="pd_info_box"><%=seriesList.get(a).getName()%></td>
                    <td class="pd_info_box"><%=seriesList.get(a).getAuthor()%></td>
                    <td class="pd_info_box" style="width: 155px;"><%=titles[seriesList.get(a).getCategory()-'0']%></td>
                    <td class="pd_info_box" style="width: 155px;"><%=seriesList.get(a).getNumber()%></td>
                    <td class="pd_info_box"></td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 6) {%>
        <div style="width: 1520px">
            <div style="margin: auto;">
                <form action="${pageContext.request.contextPath}/orders/searchOrders" method="post">
                    <table class="pd_info_table" border="0">
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">
                                订单编号
                            </td>
                            <td class="pd_info_box">
                                用户姓名
                            </td>
                            <td class="pd_info_box">
                                用户地址
                            </td>
                            <td class="pd_info_box">
                                用户联系方式
                            </td>
                            <td class="pd_info_box">订单日期
                            </td>
                            <td class="pd_info_box">付款金额</td>
                            <td class="pd_info_box">商品种类数量</td>
                            <td class="pd_info_box">商品数量</td>
                            <td class="pd_info_box">订单状况

                            </td>
                            <td class="pd_info_box" style="width: 140px;">操作</td>
                        </tr>
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">
                                <input class="pd_info_input" style="width: 140px;" name="aid" />
                            </td>
                            <td class="pd_info_box">
                                <input class="pd_info_input" style="width: 140px;" name="name" />
                            </td>
                            <td class="pd_info_box">
                                <input class="pd_info_input" style="width: 140px;" name="address" />
                            </td>
                            <td class="pd_info_box">
                                <input class="pd_info_input" style="width: 140px;" name="phone" />
                            </td>
                            <td class="pd_info_box">
                                <input type="date" :value="this.ndate" name="sqlDate" style="border: none; outline: none;" />
                            </td>
                            <td class="pd_info_box"><select name="pays" class="select_option">
                                <option value="0">0</option>
                                <option v-for="a in ageyear" v-model="a*20">{{a*20}}</option>
                            </select></td>
                            <td class="pd_info_box"><select class="select_option" name="numbers">
                                <option value="0">0</option>
                                <option v-for="a in ageyear" v-model="a*2">{{a*2}}</option>
                            </select></td>
                            <td class="pd_info_box"><select class="select_option" name="anumbers">
                                <option value="0">0</option>
                                <option v-for="a in ageyear" v-model="a*4">{{a*4}}</option>
                            </select></td>
                            <td class="pd_info_box">
                            <select class="select_option" style="width: 70px;" name="success">
                                <option value="0">待完成</option>
                                <option value="1">完成</option>
                            </select>
                            </td>
                            <td class="pd_info_box" style="width: 140px;"><input class="submit_button" type="submit" value="查询" /></td>
                        </tr>
                    </table>
                </form>
            </div>
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box">订单编号</td>
<%--                    <td class="pd_info_box" style="width: 140px;">用户编号</td>--%>
                    <td class="pd_info_box" style="width: 20%">用户地址</td>
                    <td class="pd_info_box">用户联系方式</td>
                    <td class="pd_info_box">订单日期</td>
                    <td class="pd_info_box" style="width: 8%;">用户付款金额</td>
                    <td class="pd_info_box" style="width: 8%;">商品种类数量</td>
                    <td class="pd_info_box" style="width: 8%;">订单状况</td>
<%--                    <td class="pd_info_box" style="width: 8%;">订单详细</td>--%>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i <allOrdersList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < allOrdersList.size(); a++)  {%>

                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box" @click="clickToControl(document.eform_<%=a%>, 0)"><%=allOrdersList.get(a).getAid()%></td>
<%--                    <td class="pd_info_box"><%=allOrdersList.get(a).getUid()%></td>--%>
                    <td class="pd_info_box" style="width: 20%"><%=allOrdersList.get(a).getAddress()%></td>
                    <td class="pd_info_box"><%=allOrdersList.get(a).getPhone()%></td>
                    <td class="pd_info_box"><%=allOrdersList.get(a).getDate()%></td>
                    <td class="pd_info_box" style="width: 8%;"><%=allOrdersList.get(a).getPays()%>元</td>
                    <td class="pd_info_box" style="width: 8%;"><%=allOrdersList.get(a).getNumbers()%></td>
                    <td class="pd_info_box" style="width: 8%;"><%=success[allOrdersList.get(a).getSuccess()-'0']%></td>
<%--                    <td class="pd_info_box" style="width: 8%;">--%>
<%--                        <form action="${pageContext.request.contextPath}/orders/details" method="post">--%>
<%--                            <input style="display: none" type="text" name="AID" value="<%=allOrdersList.get(a).getAid()%>" />--%>
<%--                            <input type="submit" class="submit_button" value="提交" />--%>
<%--                        </form>--%>
<%--                    </td>--%>
                    <td style="display: none">
                        <form method="post" name="eform_<%=a%>">
                            <input type="text" name="aid" value="<%=allOrdersList.get(a).getAid()%>" />
                        </form>
                    </td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 7) {%>
        <div style="width: 1520px">
            <div style="margin: auto;">
                <form action="${pageContext.request.contextPath}/buys/searchBuys" method="post">
                    <table class="pd_info_table" border="0">
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box" style="width: ">
                                采购单编号
                            </td>
                            <td class="pd_info_box">
                                采购日期
                            </td>
                            <td class="pd_info_box">
                                采购种类数量
                            </td>
                            <td class="pd_info_box">
                                采购数量
                            </td>
                            <td class="pd_info_box">
                                付款金额
                            </td>
                            <td class="pd_info_box">提供方
                            </td>
                            <td class="pd_info_box">采购情况</td>
                            <td class="pd_info_box">采购情况
                            </td>
                            <td class="pd_info_box" style="width: 140px;">操作</td>
                        </tr>
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">
                                <input class="pd_info_input" style="width: 140px;" name="abid" />
                            </td>
                            <td class="pd_info_box">
                                <input style="border: none; outline: none;" type="date" :value="this.ndate" name="sqlDate" />
                            </td>
                            <td class="pd_info_box">
                                <select class="select_option" name="number">
                                    <option value="0">0</option>
                                    <option v-for="a in ageyear" v-model="a*2">{{a*2}}</option>
                                </select>
                            </td>
                            <td class="pd_info_box">
                                <select class="select_option" name="anumber">
                                    <option value="0">0</option>
                                    <option v-for="a in ageyear" v-model="a*150">{{a*150}}</option>
                                </select>
                            </td>
                            <td class="pd_info_box">
                                <input class="pd_info_input" style="width: 140px;" name="price" value="0" />
                            </td>
                            <td class="pd_info_box"><input class="pd_info_input" style="width: 140px;" name="provider" /></td>
                            <td class="pd_info_box"></td>
                            <td class="pd_info_box">
                                <select class="select_option" name="success">
                                    <option value="0">待完成</option>
                                    <option value="1">完成</option>
                                </select>
                            </td>
                            <td class="pd_info_box" style="width: 140px;"><input class="submit_button" type="submit" value="查询" /></td>
                        </tr>
                    </table>
                </form>
            </div>
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box" style="width: 155px;">采购单编号</td>
                    <td class="pd_info_box" style="width: 155px;">采购日期</td>
                    <td class="pd_info_box" style="width: 120px;">采购种类数量</td>
                    <td class="pd_info_box" style="width: 120px;">采购商品数量</td>
                    <td class="pd_info_box" style="width: 140px;">付款金额</td>
                    <td class="pd_info_box" style="width: 155px;">提供方</td>
                    <td class="pd_info_box" style="width: 140px;">联系方式</td>
<%--                    <td class="pd_info_box">联系邮箱</td>--%>
                    <td class="pd_info_box" style="width: 140px;">采购情况</td>
<%--                    <td class="pd_info_box">操作方式</td>--%>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i <allBuysList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < allBuysList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box" style="width: 155px;" @click="clickToControl(document.aform_<%=a%>, 1)">
                        <%=allBuysList.get(a).getAbid()%>
                    </td>
                    <td class="pd_info_box"><%=allBuysList.get(a).getDate()%></td>
                    <td class="pd_info_box" style="width: 120px;"><%=allBuysList.get(a).getNumber()%></td>
                    <td class="pd_info_box" style="width: 120px;"><%=allBuysList.get(a).getAnumber()%></td>
                    <td class="pd_info_box" style="width: 140px;"><%=allBuysList.get(a).getPrice()%>元</td>
                    <td class="pd_info_box" style="width: 155px;"><%=allBuysList.get(a).getProvider()%></td>
                    <td class="pd_info_box" style="width: 140px;"><%=allBuysList.get(a).getPhone()%></td>
<%--                    <td class="pd_info_box"><%=allBuysList.get(a).getEmail()%></td>--%>

                    <%if (allBuysList.get(a).getSuccess() == '0') {%>
                    <%if (managers.getLevel()=='4') {%>
                    <td class="pd_info_box" style="width: 140px;"><%=success[allBuysList.get(a).getSuccess()-'0']%></td>
                    <%} else  {%>
                    <td class="pd_info_box" style="width: 140px;">
                        <form action="${pageContext.request.contextPath}/index/editBuy" method="post"><input type="submit" value="编辑" class="info_edit_style" />
                            <input style="display: none;" name="abid" value="<%=allBuysList.get(a).getAbid()%>" />
                        </form>
                    </td>
                    <%}%>
                    <%} else {%>
                    <td class="pd_info_box" style="width: 140px;"><%=success[allBuysList.get(a).getSuccess()-'0']%></td>
                    <%}%>

                    <td style="display: none">
                        <form method="post" name="aform_<%=a%>">
                            <input type="text" name="abid" value="<%=allBuysList.get(a).getAbid()%>" />
                        </form>
                    </td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 8) {%>
        <div style="width: 1520px">
            <div style="margin: auto;">
                <form action="${pageContext.request.contextPath}/orders/searchAllStorages" method="post">
                    <table class="pd_info_table" border="0">
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">入库编号</td>
                            <td class="pd_info_box">采购编号</td>
                            <td class="pd_info_box">入库日期</td>
                            <td class="pd_info_box">入库种类数量</td>
                            <td class="pd_info_box">入库状况</td>
                            <td class="pd_info_box">操作</td>
                        </tr>
                        <tr class="pd_info_line_head">
                            <td class="pd_info_box">
                                <input class="pd_info_input" name="arid" />
                            </td>
                            <td class="pd_info_box">
                                <input class="pd_info_input" name="abid" />
                            </td>
                            <td class="pd_info_box">
                                <input type="date" :value="this.ndate" name="sqlDate" style="border: none; outline: none;" />
                            </td>
                            <td class="pd_info_box"><select class="select_option" name="numbers">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="4">4</option>
                                <option value="8">8</option>
                            </select></td>
                            <td class="pd_info_box">
                                <select class="select_option" style="width: 70px;" name="success">
                                    <option value="0">待完成</option>
                                    <option value="1">完成</option>
                                </select>
                            </td>
                            <td class="pd_info_box" style="width: 140px;"><input class="submit_button" type="submit" value="查询" /></td>
                        </tr>
                    </table>
                </form>
            </div>
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box" style="width: 155px;">入库编号</td>
                    <td class="pd_info_box" style="width: 155px;">采购编号</td>
                    <td class="pd_info_box">入库时间</td>
                    <td class="pd_info_box">入库种类数量</td>
                    <td class="pd_info_box">入库状况</td>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < allStoragesList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < allStoragesList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box" style="width: 155px;"><%=allStoragesList.get(a).getArid()%></td>
                    <td class="pd_info_box"><%=allStoragesList.get(a).getAbid()%></td>
                    <td class="pd_info_box"><%=allStoragesList.get(a).getDate()%></td>
                    <td class="pd_info_box" style="width: 155px;"><%=allStoragesList.get(a).getNumber()%></td>
                    <td class="pd_info_box"><%=success[allStoragesList.get(a).getSuccess()-'0']%></td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 9) {%>
        <div style="width: 1520px">
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box" style="width: 155px;">出库单编号</td>
                    <td class="pd_info_box" style="width: 155px;">订单编号</td>
                    <td class="pd_info_box">出库数量</td>
                    <td class="pd_info_box">出库时间</td>
                    <td class="pd_info_box">出库状况</td>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < allExpressesList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < allExpressesList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box" style="width: 155px;"><%=allExpressesList.get(a).getEid()%></td>
                    <td class="pd_info_box"><%=allExpressesList.get(a).getAid()%></td>
                    <td class="pd_info_box"><%=allExpressesList.get(a).getNumber()%></td>
                    <td class="pd_info_box" style="width: 155px;"><%=allExpressesList.get(a).getDate()%></td>
                    <td class="pd_info_box"><%=success[allExpressesList.get(a).getSuccess()-'0']%></td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 10) {%>
        <div style="width: 1520px">
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box">图书详情编号</td>
                    <td class="pd_info_box" style="width: 20%;">图书原作名</td>
                    <td class="pd_info_box" style="width: 15%">图书出版社</td>
                    <td class="pd_info_box">图书出版时间</td>
                    <td class="pd_info_box">图书页数</td>
                    <td class="pd_info_box">图书装订</td>
                    <td class="pd_info_box" style="width: 15%">ISBN</td>
                    <td class="pd_info_box" style="width: 15%">图书出品方</td>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < booksDetailList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < booksDetailList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box"><%=booksDetailList.get(a).getBdid()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getOtitle()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getPublisher()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getDate()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getPages()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getBinding()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getIsbn()%></td>
                    <td class="pd_info_box"><%=booksDetailList.get(a).getProducer()%></td>
                </tr>
                <% }
                    i = count * 17;
                } %>
                </tbody>
            </table>
        </div>
        <% } else if (command == 11) { %>
        <div style="width: 1520px">
            <form action="${pageContext.request.contextPath}/index/addStorage" method="post">
            <table class="pd_info_table" border="0">
                <thead>
                <tr class="pd_info_line_head">
                    <td class="pd_info_box">仓库编号</td>
                    <td class="pd_info_box">仓库地址</td>
                    <td class="pd_info_box">仓库存储情况</td>
                    <td class="pd_info_box">仓储容量</td>
                    <td class="pd_info_box">仓库宽度</td>
                    <td class="pd_info_box">仓库长度</td>
                    <td class="pd_info_box">仓库高度</td>
                    <td class="pd_info_box">操作</td>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < storageInfoList.size(); ) {
                    count += 1;
                    for (int a=i; a < count*17 && a < storageInfoList.size(); a++)  {%>
                <tr class="pd_info_line" v-if="pageNow==<%=count-1%>">
                    <td class="pd_info_box"><%=storageInfoList.get(a).getSaid()%></td>
                    <td class="pd_info_box"><%=storageInfoList.get(a).getAddress()%></td>
                    <td class="pd_info_box"><%=storageInfoList.get(a).getContains()%></td>
                    <td class="pd_info_box"><%=storageInfoList.get(a).getSize()%></td>
                    <td class="pd_info_box"><%=storageInfoList.get(a).getWidth()%></td>
                    <td class="pd_info_box"><%=storageInfoList.get(a).getLength()%></td>
                    <td class="pd_info_box"><%=storageInfoList.get(a).getHeight()%></td>
                    <td class="pd_info_box">无</td>
                </tr>
                <% }
                    i = count * 17;
                } %>

                    <tr class="pd_info_line" v-if="sl==1">
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="said" />
                        </td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="address" />
                        </td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="contains" />
                        </td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="size" />
                        </td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="width" />
                        </td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="length" />
                        </td>
                        <td class="pd_info_box">
                            <input class="pd_info_input" type="text" name="height" />
                        </td>
                        <td class="pd_info_box">
                            <input type="submit" class="select_option" value="提交" />
                        </td>
                    </tr>

                </tbody>
            </table>
            </form>
            <div class="add_bar">
                <input v-if="sl==1" class="add_input" type="button" @click="addStorage()" value="取消" />
                <input v-if="sl==0" class="add_input" type="button" @click="addStorage()" value="添加" >
            </div>
        </div>
        <% } %>

        <div class="bottom_list">
            <button class="bottom_button" v-bind:class="{chose_button:(pageNow==ps-1)}" v-for="ps in pageAll" @click="getPage(ps)">{{ps}}</button>
        </div>
        <% } %>
    </div>
</body>
</html>
