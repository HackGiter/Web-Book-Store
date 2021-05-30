<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/21
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作人员</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/manage/add" method="post">
        <table class="table_wrapper">
            <thead>
            <tr class="pd_info_line">
                <td colspan="2" class="pd_info_box_1">添加人员</td>
            </tr>
            </thead>
            <tbody>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">员工姓名：</td>
                <td class="pd_info_box_1"><input class="pd_info_input" name="name" /></td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">员工性别：</td>
                <td class="pd_info_box_1">
                    <select class="select_option" name="sex">
                        <option value="0">男性</option>
                        <option value="1">女性</option>
                    </select>
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">员工年龄：</td>
                <td class="pd_info_box_1"><input class="pd_info_input" name="age" /></td>
            </tr>
<%--            <tr class="pd_info_line">--%>
<%--                <td class="pd_info_box_1">员工等级</td>--%>
<%--                <td class="pd_info_box_1">--%>
<%--                    <select class="select_option" name="level">--%>
<%--                        <option v-for="ls in levellist" :value="ls">{{ls}}</option>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">电子邮件</td>
                <td class="pd_info_box_1"><input class="pd_info_input" name="email" /></td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">联系方式</td>
                <td class="pd_info_box_1"><input class="pd_info_input" name="phone" /></td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">工资</td>
                <td class="pd_info_box_1"><input class="pd_info_input" name="wages" /></td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">部门</td>
                <td class="pd_info_box_1">
                    <select class="select_option" name="did">
                        <option value="1">决策部</option>
                    </select>
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">职业</td>
                <td class="pd_info_box_1">
                    <select class="select_option" name="position">
                        <option value="仓库管理">仓库管理</option>
                        <option value="采购管理">采购管理</option>
                        <option value="发货管理">发货管理</option>
                        <option value="入库管理">入库管理</option>
                    </select>
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">初始密码</td>
                <td class="pd_info_box_1"><input class="pd_info_input" type="password" name="password" /></td>
            </tr>
            <tr class="pd_info_line">
                <td colspan="2"><input class="select_option" type="submit" value="提交" /></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
