<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/8
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/onefile"
      method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="myfile"><br>
    文件描述：<input type="text" name="description"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
