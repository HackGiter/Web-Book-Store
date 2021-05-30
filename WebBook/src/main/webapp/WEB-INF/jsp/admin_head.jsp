<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/9
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>后端管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin_head.css">
</head>
<body>
    <div class="wrapper">
        <div class="wrapper_head">
            <div class="wrapper_head_component">
                欢迎 管理者：
                <a href="/WEB-INF/jsp/index.jsp" style="color: #E7E7E7"><%=managers.getName()%></a>
            </div>
        </div>
        <div class="wrapper_body">
            <h2>后端管理系统</h2>
        </div>
    </div>

</body>
</html>
