<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
int status = (int) request.getAttribute("status");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
      <base href="<%=basePath%>">

      <title>书友登录</title>

      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
      <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
      <meta http-equiv="description" content="Login">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
      <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
      <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <script>
        function clickon(e) {
            var form = document.actionForm;
            form.command.value = e;
            form.submit();
        }
    </script>
    <script>
        <% if (status == 1) { %>
        $(document).ready(function () {
            alert("用户或密码错误!");
        })
        <% } %>
    </script>

</head>

<body>
<%--    <form action="${pageContext.request.contextPath }/user/login" method="post">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td colspan="2">--%>
<%--                    <img src="${pageContext.request.contextPath }/images/login.gif">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>姓名：</td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="email" class="textSize">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>密码：</td>--%>
<%--                <td>--%>
<%--                    <input type="password" name="upassw" class="textsize">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2">--%>
<%--                    <input type="image" src="${pageContext.request.contextPath }/images/ok.gif" onclick="gogo()">--%>
<%--                    <input type="image" src="${pageContext.request.contextPath }/images/cancel.gif" onclick="cancel()">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--        ${messageError }--%>
<%--    </form>--%>
  <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
  <div class="panel">
      <div class="login_panel">
          <div class="login_title">
<%--              书 &nbsp; &nbsp;登录--%>
            登录
          </div>
          <div class="form_box" method="post">
              <form action="${pageContext.request.contextPath}/user/loginOrRegister" method="post" name="actionForm">
                  <div class="input_box"><input type="text" class="login_user" name="user" placeholder="用户名" /></div>
                  <div class="input_box"><input type="password" class="login_password" name="password" placeholder="密码" /></div>
                  <input style="display: none" name="command" />
              </form>
              <div class="button_box">
                <input class="register_button" type="button" name="register" value="注册" onclick="clickon(0)" />
                <input class="login_button" type="button" name="login" value="登录" onclick="clickon(1)" />
              </div>
          </div>
      </div>
<%--      <div class="login_tips"></div>--%>
  </div>
  </body>
</html>
