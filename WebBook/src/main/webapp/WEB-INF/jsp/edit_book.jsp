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
<html>
<head>
    <title>编辑图书信息</title>

</head>
<body>
    <div>
        <%if (command == 1) {%>
            <% if (ids == 3) { %>
        <div class="form_head">
                <h2>
                    添加图书信息
                </h2>
        </div>
        <div>
                <form action="${pageContext.request.contextPath}/books/insertBook" method="post" name="booksForm" enctype="multipart/form-data">
                    <div class="table_wrapper" style="float: left">
        <table class="pd_info_table">
            <thead class="pd_info_line_head">
            <tr class="pd_info_line">
                <td colspan="2" class="pd_info_box_1">图书信息填写</td>
            </tr>
            </thead>
            <tbody>

            <tr class="pd_info_line">
                <td class="pd_info_box_1">图书名：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="name">
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">系列编号：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="sid">
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">作者：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="author">
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">作者国籍：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="country">
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">种类：</td>
                <td class="pd_info_box_1">
                    <select name="category" class="select_option">
                        <option value='0'>文学</option>
                        <option value='1'>流行</option>
                        <option value='2'>文化</option>
                        <option value='3'>生活</option>
                        <option value='4'>经管</option>
                        <option value='5'>科技</option>
                    </select>
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">限制年龄：</td>
                <td class="pd_info_box_1">
                    <select name="age" class="select_option">
                        <option v-for="a in ageyear" v-model="a">{{a}}</option>
                    </select>
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">评分：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="score">
                </td>
            </tr>
            <tr class="pd_info_box">
                <td colspan="2">商品信息填写</td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">商品类型：</td>
                <td class="pd_info_box_1">
                    <select name="type" class="select_option">
                        <option value='0'>实体书</option>
                        <option value='1'>电子书</option>
                    </select>
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">商品价格：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="price">元
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">商品数量：</td>
                <td class="pd_info_box_1">
                    <input class="pd_info_input" type="text" name="number">件
                </td>
            </tr>
            <tr class="pd_info_line">
                <td class="pd_info_box_1">商品入库编号：</td>
                <td class="pd_info_box_1">
                    <select class="select_option" name="said">
                        <% for (int i = 0; i < stringList.size(); i++) { %>
                        <option value="<%=stringList.get(i)%>"><%=stringList.get(i)%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <input style="display: none" name="sale" value=0 />
            </tbody>
        </table>

    </div>
                    <div class="table_wrapper" >
                        <table class="pd_info_table">
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1" colspan="2">图书详细信息填写</td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">原作名：</td>
                                <td class="pd_info_box_1">
                                    <input class="pd_info_input" type="text" name="otitle" />
                                </td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">出版社：</td>
                                <td class="pd_info_box_1">
                                    <input class="pd_info_input" type="text" name="publisher" />
                                </td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">译者：</td>
                                <td class="pd_info_box_1">
                                    <input class="pd_info_input" type="text" name="translator" />
                                </td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">出版日期：</td>
                                <td class="pd_info_box_1">
                                    <input class="pd_info_input" type="date" name="date" />
                                </td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">页数：</td>
                                <td class="pd_info_box_1">
                                    <input class="pd_info_input" type="text" name="pages" />
                                </td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">装订：</td>
                                <td class="pd_info_box_1">
                                    <select name="binding" class="select_option">
                                        <option value="精装">精装</option>
                                        <option value="平装">平装</option>
                                    </select>
                                </td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">ISBN:</td>
                                <td class="pd_info_box_1"><input class="pd_info_input" type="text" name="isbn" /></td>
                            </tr>
                            <tr class="pd_info_line">
                                <td class="pd_info_box_1">出品方：</td>
                                <td class="pd_info_box_1"><input class="pd_info_input" type="text" name="producer" /></td>
                            </tr>
                            <tr class="pd_info_box">
                                <td class="pd_info_box_1">图书封面：</td>
                                <td class="pd_info_box_1"><input class="file_button" type="file" name="imgFile" /></td>
                            </tr>
                        </table>
                        <div style="float: right">
                            <input class="cancel_button" type="submit" value="取消" onclick="cancel()"/>
                            <% if (command == 1) {%>
                            <input class="submit_button" type="submit" value="添加商品" />
                            <% } else if (command == 0) {%>
                            <input class="submit_button" type="submit" value="更改商品" />
                            <% } else {%>
                            <% } %>
                        </div>
                    </div>
                </form>
        </div>

            <% } else if (ids == 4) { %>

            <% }%>
        <% } else if (command == 0) { %>

        <% } else { %>
        <% } %>
    </div>
</body>
</html>
