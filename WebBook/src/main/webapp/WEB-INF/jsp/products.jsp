<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/2
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String names = request.getParameter("name");
    String title = request.getParameter("title");
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Products</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/products.css" type="text/css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <script>
        function clickCheck(e) {
            console.log(e);
            var form = document.productsForm;
            form.submit();
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/index/insertBook" method="post" name="productsForm">
<%--        <tr>--%>
<%--            <td>图书名：</td>--%>
<%--            <td>--%>
<%--                <input class="textSize" type="text" name="bname"  />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>类型：</td>--%>
<%--            <td>--%>
<%--                <input class="textSize" type="text" name="type"  />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>价格：</td>--%>
<%--            <td>--%>
<%--                <input class="textSize" type="text" name="price"  />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>数量：</td>--%>
<%--            <td>--%>
<%--                <input class="textSize" type="text" name="number"  />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>销量：</td>--%>
<%--            <td>--%>
<%--                <input class="textSize" type="text" name="sale"  />--%>
<%--            </td>--%>
<%--        </tr>--%>
        <div class="f_box">
            <div class="img_box">
                <img class="img_style" src="${pageContext.request.contextPath}/images/5.3_t350.png"/>
            </div>
            <div class="if_box">
                <div class="f_c_title">
                    资料填写
                </div>
                <div class="f_component">
                    <div class="f_title">图书名：</div>
                    <div class="f_input">
                        <input class="input_style" type="text" name="name">
                    </div>
                </div>
                <div class="f_component">
                    <div class="f_title">系列名：</div>
                    <div class="f_input">
                        <input class="input_style" type="text" name="sid">
                    </div>
                </div>
                <div class="f_component">
                    <div class="f_title">作者：</div>
                    <div class="f_input">
                        <input class="input_style" type="text" name="author">
                    </div>
                </div>
                <div class="f_component">
                    <div class="f_title">种类：</div>
                    <div class="f_input">
                        <input class="input_style" type="text" name="category_name">
                    </div>
                </div>
                <div class="f_component">
                    <div class="f_title">限制年龄：</div>
                    <div class="f_input">
                        <input class="input_style" type="text" name="age">
                    </div>
                </div>
                <div class="func_box">
                    <div class="func_input" style="float: none">
                        <input class="input_b_style" type="button" value="插入" onclick="clickCheck()" />
                    </div>
                    <div class="func_input">
                        <input class="input_b_style" type="button" value="注册" onclick="clickCheck(2)" />
                    </div>
                </div>
            </div>
        </div>
        <div class="uf_box">

        </div>

    </form>
</body>
</html>
