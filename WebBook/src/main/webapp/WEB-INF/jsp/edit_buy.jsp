<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/20
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购单编辑</title>
</head>
<body>
<div>

<form action="${pageContext.request.contextPath}/index/editBuy2" method="post">
    <div>
        <table class="pd_info_table">
            <tr class="pd_info_line">
                <td class="pd_info_box">总采购单编号</td>
                <td class="pd_info_box">采购时间</td>
                <td class="pd_info_box">采购数量</td>
                <td class="pd_info_box">提供者</td>
                <td class="pd_info_box">联系方式</td>
                <td class="pd_info_box">电子邮件</td>
                <td class="pd_info_box">操作</td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box">
                    <input class="pd_info_input1" name="abid" value="<%=allBuys.getAbid()%>" />
                </td>
                <td class="pd_info_box">
                    <input readonly class="pd_info_input1" value="<%=dateFormat.format(allBuys.getDate())%>" />
                </td>
                <td class="pd_info_box">
                    <input class="pd_info_input1" name="number" value="<%=allBuys.getNumber()%>" />
                </td>
                <td class="pd_info_box">
                    <input class="pd_info_input1" name="provider" value="<%=allBuys.getProvider()%>" />
                </td>
                <td class="pd_info_box">
                    <input class="pd_info_input1" name="phone" value="<%=allBuys.getPhone()%>" />
                </td>
                <td class="pd_info_box">
                    <input class="pd_info_input1" name="email" value="<%=allBuys.getEmail()%>" />
                </td>
                <td class="pd_info_box" style="display: none">
                    <input class="pd_info_input1" name="mid" value="<%=allBuys.getMid()%>" />
                </td>
                <td class="pd_info_box">
                    <select name="success" class="select_remain">
                        <option value="0" selected>保留</option>
                        <option value="1">取消</option>
                    </select>
                </td>
            </tr>
        </table>
    </div>
    <div class="table_wrapper" style="float: left;margin: 50px 30px;overflow-y: scroll">
        <table style="width: 100%">
            <tr class="pd_info_line">
                <td class="pd_info_box">商品编号</td>
                <td class="pd_info_box">商品数量</td>
                <td class="pd_info_box">付款金额</td>
                <td class="pd_info_box">操作</td>
            </tr>
            <% for (int i = 0; i < buysList.size(); i++) { %>
            <tr class="pd_info_line">
                <td class="pd_info_box" style="display: none"><input class="pd_info_input1" name="buysList[<%=i%>].bid" value="<%=buysList.get(i).getBid()%>" /></td>
                <td class="pd_info_box"><input class="pd_info_input1" name="buysList[<%=i%>].pid" value="<%=buysList.get(i).getPid()%>"/></td>
                <td class="pd_info_box"><input class="pd_info_input1" name="buysList[<%=i%>].number" value="<%=buysList.get(i).getNumber()%>"/></td>
                <td class="pd_info_box"><input class="pd_info_input1" name="buysList[<%=i%>].price" value="<%=buysList.get(i).getPrice()%>"/></td>
                <td class="pd_info_box">
                    <select name="buysList[<%=i%>].success" class="select_remain">
                        <option value="0" selected>保留</option>
                        <option value="1">取消</option>
                    </select>
                </td>
            </tr>
            <% } %>
            <tr class="pd_info_line" v-for="(item, index) in clist">
                <td class="pd_info_box"><input class="pd_info_input1" :name="generateName(item.i, 'pid')" :value="item.value" /></td>
                <td class="pd_info_box"><input class="pd_info_input1" :name="generateName(item.i, 'number')" /></td>
                <td class="pd_info_box"><input class="pd_info_input1" :name="generateName(item.i, 'price')" /></td>
                <td class="pd_info_box" style="display: none"><input class="pd_info_input1" :name="generateName(item.i, 'success')" value=0 /></td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box" style="display: none"><input name="length" :value="cindex" /></td>
                <td class="pd_info_box"><input type="submit" value="提交" class="info_detail_style" /></td>
            </tr>
        </table>

    </div>
    <div  class="table_wrapper" style="margin: 50px 30px;overflow-y: scroll">
        <table>
            <tr class="pd_info_line">
                <td class="pd_info_box">商品编号</td>
                <td class="pd_info_box">图书编号</td>
                <td class="pd_info_box" style="width: 30%">商品名称</td>
                <td class="pd_info_box">操作</td>
            </tr>
            <% for (int i = 0; i < productsList.size(); i++) {%>
            <tr class="pd_info_line">
                <td class="pd_info_box"><%=productsList.get(i).getPid()%></td>
                <td class="pd_info_box"><%=productsList.get(i).getBid()%></td>
                <td class="pd_info_box"><%=productsList.get(i).getPName()%></td>
                <td class="pd_info_box">
                    <input type="checkbox" value="<%=productsList.get(i).getPid()%>" @click="checkEasy(<%=productsList.get(i).getPid()%>)" />
                </td>
            </tr>
            <% }%>
        </table>
    </div>
</form>

</div>

</body>
</html>
