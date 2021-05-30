<%@ page import="org.omg.PortableInterceptor.SUCCESSFUL" %><%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/9
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] success={"待完成", "完成"};
%>
<html>
<head>
    <title>入库表单信息</title>
</head>
<body>

<div class="info_body">
    <div>
        <table class="pd_info_table">
            <tr class="pd_info_line">
                <td class="pd_info_box">总采购单编号</td>
                <td class="pd_info_box">采购时间</td>
                <td class="pd_info_box">采购数量</td>
                <td class="pd_info_box">提供者</td>
                <td class="pd_info_box">联系方式</td>
                <td class="pd_info_box">电子邮件</td>
                <td class="pd_info_box">采购负责人</td>
                <td class="pd_info_box">总采购情况</td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box"><%=allBuys.getAbid()%></td>
                <td class="pd_info_box"><%=allBuys.getDate()%></td>
                <td class="pd_info_box"><%=allBuys.getNumber()%></td>
                <td class="pd_info_box"><%=allBuys.getProvider()%></td>
                <td class="pd_info_box"><%=allBuys.getPhone()%></td>
                <td class="pd_info_box"><%=allBuys.getEmail()%></td>
                <td class="pd_info_box"><%=allBuys.getMid()%></td>
                <td class="pd_info_box"><%=success[allBuys.getSuccess()-'0']%></td>
            </tr>
        </table>
    </div>
    <div>
        <table class="pd_info_table">
            <tr class="pd_info_line">
                <td class="pd_info_box">采购编号</td>
                <td class="pd_info_box">商品编号</td>
                <td class="pd_info_box">商品数量</td>
                <td class="pd_info_box">付款金额</td>
                <td class="pd_info_box">采购情况</td>
                <td class="pd_info_box">操作</td>
            </tr>
            <% for (int i = 0; i < buysList.size(); i++) { %>
            <tr class="pd_info_line">
                <td class="pd_info_box"><input class="pd_info_input1" readonly value="<%=buysList.get(i).getBid()%>" /></td>
                <td class="pd_info_box"><input class="pd_info_input1" readonly value="<%=buysList.get(i).getPid()%>"/></td>
                <td class="pd_info_box"><input class="pd_info_input1" readonly value="<%=buysList.get(i).getNumber()%>"/></td>
                <td class="pd_info_box"><input class="pd_info_input1" readonly value="<%=buysList.get(i).getPrice()%>"/></td>
                <td class="pd_info_box"><input class="pd_info_input1" readonly value="<%=success[buysList.get(i).getSuccess()-'0']%>"/></td>
                <% if (buysList.get(i).getSuccess() == '0') {%>
                <td class="pd_info_box"><input class="pd_info_input1" type="checkbox" @click="checkBuy(<%=buysList.get(i).getBid()%>, <%=buysList.get(i).getPid()%>, '<%=buysList.get(i).getAbid()%>', <%=buysList.get(i).getNumber()%>, <%=buysList.get(i).getPrice()%>)" />待完成</td>
                <% } else {%>
                <td class="pd_info_box"><input class="pd_info_input1" type="text" value="完成" readonly /></td>
                <% }%>
            </tr>
            <% } %>
        </table>
    </div>
    <form action="${pageContext.request.contextPath}/index/allstorage" method="post" name="storageForm">
    <div style="display: none">
            <div v-for="(item, index) in slist">
                <input :name="generateName(index, 'bid')" :value="item.bid">
                <input :name="generateName(index, 'pid')" :value="item.pid">
                <input :name="generateName(index, 'abid')" :value="item.abid">
                <input :name="generateName(index, 'number')" :value="item.number">
                <input :name="generateName(index, 'price')" :value="item.price">
            </div>
    </div>
        <% if (allBuys.getSuccess() == '0') { %>
        <div><input class="info_edit_style" type="submit" value="提交" /></div>
        <% } else { %>
        <% }%>

    </form>
</div>
</body>
</html>
