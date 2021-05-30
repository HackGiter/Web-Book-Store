<%@ page import="generalClass.AllOrders" %>
<%@ page import="generalClass.Orders" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/9
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String[] titles = {"实体书","电子书"};
    String[] success = {"完成", "待完成"};
//    AllOrders allOrders = (AllOrders) request.getAttribute("allorders");
//    List<Orders> ordersList = (List<Orders>) request.getAttribute("ordersList");

%>
<html>
<head>
    <title>出库单信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/info.css">
    <script>
        var jqlist = [];
        $(function() {
            $(".info_edit_style").click(function (){
                jqlist.push(1);
                console.log(jqlist);
            });
        });
    </script>
</head>
<body>
    <div>
<%--        <form action="${pageContext.request.contextPath}/index/express2" method="post">--%>
        <div class="info_body">
                <div>
                    <table class="pd_info_table">
                        <tr class="pd_info_line">
                            <td class="pd_info_box">总订单编号</td>
                            <td class="pd_info_box">订单地址</td>
                            <td class="pd_info_box">订单联系方式</td>

                            <td class="pd_info_box">订单日期</td>
                            <td class="pd_info_box" style="width: 170px;">商品种类数量</td>
                            <td class="pd_info_box" style="width: 170px;">商品数量</td>
                            <td class="pd_info_box" style="width: 170px;">订单状况</td>
                        </tr>
                        <tr class="pd_info_line">
                            <td class="pd_info_box" style="letter-spacing: 1px;"><%=allOrders.getAid()%></td>
                            <td class="pd_info_box">
                                <%=allOrders.getAddress()%>

                            </td>
                            <td class="pd_info_box"><%=allOrders.getPhone()%></td>

                            <td class="pd_info_box"><%=allOrders.getDate()%></td>
                            <td class="pd_info_box" style="width: 170px;"><%=allOrders.getNumbers()%></td>
                            <td class="pd_info_box" style="width: 170px;"><%=allOrders.getAnumbers()%></td>

                            <td class="pd_info_box" style="width: 170px;">
                                <% if (allOrders.getSuccess() == '0') {%>
                                    <div>待完成</div>
                                <% } else {%>
                                    <div>完成</div>
                                <% } %>
                            </td>
                        </tr>
                    </table>
<%--                    <table style="margin:0px auto;">--%>
<%--                        <tr class="pd_info_line">--%>
<%--                            <td class="pd_info_box" style="width: 140px;">订单编号</td>--%>
<%--                            <td class="pd_info_box" style="width: 140px;">商品编号</td>--%>
<%--                            <td class="pd_info_box" style="width: 140px;">商品类型</td>--%>
<%--                            <td class="pd_info_box" style="width: 140px;">商品数量</td>--%>
<%--&lt;%&ndash;                            <td class="pd_info_box" style="width: 220px;">邮递编号</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td class="pd_info_box" style="width: 220px;">邮递公司</td>&ndash;%&gt;--%>
<%--                            <td class="pd_info_box" style="width: 140px;">订单状况</td>--%>
<%--                            <td class="pd_info_box" style="width: 140px;">操作</td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
                    <div style="margin:0px auto;width: 1520px;max-height: 250px;overflow-y: scroll">
                        <table class="pd_info_table">
                            <tr class="pd_info_line">
                                <td class="pd_info_box">订单编号</td>
                                <td class="pd_info_box">商品编号</td>
                                <td class="pd_info_box">商品类型</td>
                                <td class="pd_info_box">商品数量</td>
                                <td class="pd_info_box">邮递编号</td>
                                <td class="pd_info_box">邮递公司</td>
                                <td class="pd_info_box">邮递时间</td>
                                <%--                            <td class="pd_info_box" style="width: 140px;">订单状况</td>--%>
                                <%--                            <td class="pd_info_box" style="width: 140px;">操作</td>--%>
                            </tr>
                            <% for (int i = 0; i < ordersList.size(); i++) { %>
                            <%--                        <form action="${pageContext.request.contextPath}/index/express" method="post">--%>
                            <% if (ordersList.get(i).getSuccess() == '1') { %>
                            <tr class="pd_info_line">
                                <td class="pd_info_box"><%=ordersList.get(i).getOid()%></td>
                                <td class="pd_info_box"><%=ordersList.get(i).getPid()%></td>
                                <td class="pd_info_box"><%=titles[ordersList.get(i).getType()-'0']%></td>
                                <td class="pd_info_box"><%=ordersList.get(i).getNumber()%></td>
                                <td class="pd_info_box"><%=expressesList.get(total).getEd()%></td>
                                <td class="pd_info_box"><%=expressesList.get(total).getDeliver()%></td>
                                <td class="pd_info_box"><%=expressesList.get(total).getDate()%></td>
                                <%--                            <% if (ordersList.get(i).getSuccess()=='0') {%>--%>
                                <%--                            <td class="pd_info_box" style="width: 220px;">--%>
                                <%--                                <input class="pd_info_input" name="ed" />--%>
                                <%--                            </td>--%>
                                <%--                            <td class="pd_info_box" style="width: 220px;">--%>
                                <%--                                <input class="pd_info_input" name="deliver" />--%>
                                <%--                            </td>--%>
                                <%--                            <% } else {%>--%>
                                <%--                            <td class="pd_info_box" style="width: 220px;"><input class="pd_info_input" readonly name="ed" value="<%=expressesList.get(total).getEd()%>" /></td>--%>
                                <%--                            <td class="pd_info_box" style="width: 220px;"><input class="pd_info_input" readonly name="deliver" value="<%=expressesList.get(total).getDeliver()%>" /></td>--%>
                                <%--                            <%--%>
                                <%--                                    total += 1;--%>
                                <%--                            } %>--%>

                                <%--                            <td class="pd_info_box" style="width: 140px;">--%>
                                <%--                                <% if (ordersList.get(i).getSuccess()=='0') {%>--%>
                                <%--                                    <div>待完成</div>--%>
                                <%--                                <% } else {%>--%>
                                <%--                                    <div>完成</div>--%>
                                <%--                                <% } %>--%>
                                <%--                            </td>--%>
                                <%--                            <td class="pd_info_box" style="width: 140px;">--%>
                                <%--&lt;%&ndash;                                <input name="oid" style="display: none" value="<%=ordersList.get(i).getOid()%>" />&ndash;%&gt;--%>
                                <%--&lt;%&ndash;                                <input name="aid" style="display: none" value="<%=allOrders.getAid()%>" />&ndash;%&gt;--%>
                                <%--&lt;%&ndash;                                <input class="order_button" type="submit" value="提交" />&ndash;%&gt;--%>
                                <%--&lt;%&ndash;                                <input style="display: none" :name="generateName2(index, 'deliverList', 'oid')" :value="item.oid">&ndash;%&gt;--%>
                                <%--                                <% if (ordersList.get(i).getSuccess()=='0') {%>--%>
                                <%--                                    <input class="info_edit_style" type="checkbox" @click="addExpress(<%=ordersList.get(i).getOid()%>)" />--%>
                                <%--                                <% } else {%>--%>
                                <%--                                    无--%>
                                <%--                                <% } %>--%>
                                <%--                            </td>--%>
                            </tr>
                            <%
                                    total += 1;
                                } %>
                            <%--                        </form>--%>
                            <% } %>
                        </table>
                    </div>
                </div>
            <form action="${pageContext.request.contextPath}/index/express2" method="post">
                <div class="select_list">
                    <table>
                        <thead>
                        <tr class="pd_info_line">
                            <td class="pd_info_box" style="width: 210px;">订单编号</td>
                            <td class="pd_info_box" style="width: 210px;">邮递编号</td>
                            <td class="pd_info_box" style="width: 210px;">邮递公司</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="pd_info_line" v-for="(item, index) in slist">
                            <td class="pd_info_box" style="width: 210px;">
                                <input class="pd_info_input" readonly :name="generateName2(index, 'deliverList', 'oid')" :value="item.oid">
                            </td>
                            <td class="pd_info_box" style="width: 210px;">
                                <input class="pd_info_input" :name="generateName2(index, 'deliverList', 'ed')" />
                            </td>
                            <td class="pd_info_box" style="width: 210px;">
                                <input class="pd_info_input" :name="generateName2(index, 'deliverList', 'deliver')" />
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="select_list" style="width: 800px">
                    <table>
                        <tr class="pd_info_line">
                            <td class="pd_info_box" style="width: 140px;">订单编号</td>
                            <td class="pd_info_box" style="width: 140px;">商品编号</td>
                            <td class="pd_info_box" style="width: 140px;">商品类型</td>
                            <td class="pd_info_box" style="width: 140px;">商品数量</td>
                            <td class="pd_info_box" style="width: 140px;">操作</td>
                        </tr>
                        <%
                            for (int i = 0; i < ordersList.size(); i++) {
                        %>
                        <% if (ordersList.get(i).getSuccess() == '0') { %>
                        <tr class="pd_info_line">
                            <td class="pd_info_box" style="width: 140px;"><%=ordersList.get(i).getOid()%></td>
                            <td class="pd_info_box" style="width: 140px;"><%=ordersList.get(i).getPid()%></td>
                            <td class="pd_info_box" style="width: 140px;"><%=titles[ordersList.get(i).getType()-'0']%></td>
                            <td class="pd_info_box" style="width: 140px;"><%=ordersList.get(i).getNumber()%></td>
                            <td class="pd_info_box" style="width: 140px;">
                                <input type="checkbox" @click="addExpress(<%=ordersList.get(i).getOid()%>)" />
                            </td>
                        </tr>
                        <% }%>
                        <%
                            }
                        %>

                    </table>
                </div>
                <div style="display: none">
                    <div>
                        <input name="aid" value="<%=allOrders.getAid()%>" />
                    </div>
                </div>
                <div><input class="info_edit_style" type="submit" value="提交" /></div>
            </form>
            <%--    </form>--%>
        </div>


    </div>
</body>
</html>
