<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/8
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
</head>
<body>
${fileDomain.description }
<br>
<!-- fileDomain.getMyFile().getOriginalFilename()-->
${fileDomain.myfile.originalFilename }
<img src="${pageContext.request.contextPath}/images/${fileDomain.myfile.originalFilename }">
</body>
</html>
