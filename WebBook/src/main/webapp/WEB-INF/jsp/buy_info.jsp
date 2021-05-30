<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/9
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购单信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/info.css">
</head>
<body>
<div>
    <div class="table_wrapper" style="float: left;">
        <form action="${pageContext.request.contextPath}/index/allBuy" method="post" name="buyForm">
            <table class="pd_info_table">
                <thead>

                <tr class="pd_info_line">
                    <td class="pd_info_box">商品编号</td>
                    <td class="pd_info_box">图书编号</td>
                    <td class="pd_info_box">商品数量</td>
                    <td class="pd_info_box">付款金额</td>
                </tr>
                </thead>
                <tbody style="overflow-y:scroll;">
                    <tr v-for="(item, index) in longlist" class="pd_info_line">
                        <td class="pd_info_box"><input class="pd_info_input1" readonly :name="generateName(index, 'pid')" :value="item.name" ></td>
                        <td class="pd_info_box"><input class="pd_info_input1" readonly :name="generateName(index, 'bid')" :value="item.v" ></td>
                        <td class="pd_info_box">
<%--                            <input class="pd_info_input1" :name="generateName(index, 'number')" type="text" >--%>
                            <select class="select_option" :name="generateName(index, 'number')">
                                <option value="50">50</option>
                                <option value="100">100</option>
                                <option value="200">200</option>
                                <option value="500">500</option>
                                <option value="750">750</option>
                                <option value="1000">1000</option>
                                <option value="1500">1500</option>
                                <option value="2000">2000</option>
                                <option value="4000">4000</option>
                            </select>
                        </td>
                        <td class="pd_info_box"><input class="pd_info_input1" :name="generateName(index,'price')" type="text" >元</td>
                    </tr>

                </tbody>
            </table>
            <table class="pd_info_table">
                <thead>
                <tr class="pd_info_line">
                    <td class="pd_info_box" style="width: 218px">提供方</td>
                    <td class="pd_info_box" style="width: 218px">联系方式</td>
                    <td class="pd_info_box" style="width: 218px">电子邮件</td>
                </tr>
                </thead>
                <tbody >
                <tr class="pd_info_line">
                    <td class="pd_info_box"><input class="pd_info_input2" name="provider" type="text" ></td>
                    <td class="pd_info_box"><input class="pd_info_input2" name="phone" type="text" ></td>
                    <td class="pd_info_box"><input class="pd_info_input2" name="email" type="text" ></td>
                </tr>
                <tr class="pd_info_line">
                    <td colspan="4"><input class="submit_button" type="submit" value="提交" @click="" /></td>
                </tr>
                </tbody>

            </table>
        </form>
    </div>
    <div class="table_wrapper">
        <table class="pd_info_table" style="table-layout: auto">
            <thead>
            <tr class="pd_info_box">
                <td colspan="4">商品列表</td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box">商品编号</td>
                <td class="pd_info_box">图书编号</td>
                <td class="pd_info_box" style="width: 30%">商品名称</td>
                <td class="pd_info_box">操作</td>
            </tr>
            </thead>
            <tbody style="overflow-y: scroll;">
<%--            <tr class="pd_info_line">--%>
<%--                <td class="pd_info_box">商品编号</td>--%>
<%--                <td class="pd_info_box">图书编号</td>--%>
<%--                <td class="pd_info_box">商品名称</td>--%>
<%--                <td class="pd_info_box">操作</td>--%>
<%--            </tr>--%>
                <% for(int i = 0; i < productsList.size(); i++) { %>
                <tr class="pd_info_line">
                    <td class="pd_info_box"><%=productsList.get(i).getPid()%></td>
                    <td class="pd_info_box"><%=productsList.get(i).getBid()%></td>
                    <td class="pd_info_box"><%=productsList.get(i).getPName()%></td>
                    <td class="pd_info_box">
                        <input type="checkbox" value="<%=productsList.get(i).getPid()%>" @click="checkInList(<%=productsList.get(i).getPid()%>, <%=productsList.get(i).getBid()%>)" />添加
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
