<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/16
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="generalClass.Users" %>
<%
    Users users = (Users) session.getAttribute("users");
    int ok = (int) request.getAttribute("ok");
%>
<html>
<head>
    <title>用户信息</title>
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profile.css">
    <script>
        function allIsNull(e) {
            var form = document.registForm;
            if (e === "登出") {
                form.action = "${pageContext.request.contextPath }/user/logout";
                form.submit();
            } else if (e === "注销") {
                form.action = "${pageContext.request.contextPath }/user/delete";
                form.submit();
            } else {
                var regNumber = /\d+/; //验证0-9的任意数字最少出现1次。
                var regString = /[a-zA-Z]+/; //验证大小写26个字母任意字母最少出现1次。
                //return false;
                form.action = "${pageContext.request.contextPath }/user/update";
                //console.log(form["upassw"]);
                //console.log(form["reupassw"]);
                //$("input[name='reupassw']").attr("disabled","disabled");
                console.log(form["sex"].value);
                if (form["phone"].value.length < 11 && !regString.test(form["phone"].value)) {
                    return false;
                } else if (form["address"].value.length < 5) {
                    return false;
                } else if (!regNumber.test(form["age"].value)) {
                    return false;
                } else {
                    form.method = "post";
                    form.submit();
                }
            }

        }
    </script>
    <script>

    </script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
<div class="panel" id="formApp">
    <div class="register_panel">
        <div class="register_title">
            用户信息
        </div>
        <form class="form_box" action="${pageContext.request.contextPath }/user/register" method="post" name="registForm">
            <input style="display: none" name="uid" value="<%=users.getUid()%>" />
            <table class="register_table" align="center">
                <tr>
                    <td>姓名：</td>
                    <td>
                        <input class="textSize" type="text" name="name" value="<%=users.getName()%>" />
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input v-model="password" @blur="animateSelf('password','blur')" @focus="animateSelf('password', 'focus')" class="textSize" type="text" maxlength="20" name="password" placeholder="密码" />
                    </td>
                </tr>
                <tr>
                    <td>电子邮箱：</td>
                    <td>
                        <input readonly class="textSize" name="email" value="<%=users.getEmail()%>" />
                    </td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <div style="width: 500px;height: calc(2.25rem + .25rem);margin: 5px auto; text-align: center;">
                            <% if (users.getSex() == '0') {%>
                            <label style="margin-right: 20px"><input class="register_radio" type="radio" name="sex" value="0" checked />男性</label>
                            <label><input class="register_radio" type="radio" name="sex" value="1" />女性</label>
                            <% } else {%>
                            <label style="margin-right: 20px"><input class="register_radio" type="radio" name="sex" value="0" />男性</label>
                            <label><input class="register_radio" type="radio" name="sex" value="1" checked />女性</label>
                            <% } %>

                        </div>
                    </td>
                </tr>
                <tr>
                    <td>地址：</td>
                    <td>
                        <input class="textSize" type="text" name="address" placeholder="寄送地址" value="<%=users.getAddress()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>联系方式：</td>
                    <td>
                        <input class="textSize" type="text" name="phone" placeholder="联系方式" value="<%=users.getPhone()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td>
                        <input class="textSize" type="text" name="age" placeholder="年龄" value="<%=users.getAge()%>"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <div class="button_list">
                            <input class="register3_button" type="button" value="登出" onclick="allIsNull('登出')" />
                            <input class="register1_button" type="button" value="提交" onclick="allIsNull('提交')" />
                            <input class="register2_button" type="button" value="注销" onclick="allIsNull('注销')" />
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="register_tips">
        <form>
            <tr>
                <td>
                    <p style="height: 250px" class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText">{{upasswmessage}}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="pText"></p>
                </td>
            </tr>
        </form>
    </div>
</div>
<script>
    new Vue({
        el: "#formApp",
        data: {
            password:'',
            upasswmessage:'',
            repassw:'',
            repasswmessage:'',
            email:'',
            emailmessage:'',
        },
        mounted:function () {
          this.password = "<%=users.getPassword()%>";
        },
        methods: {
            animateSelf(name, type) {
                if (name==="password") {
                    if (type === "blur") {
                        let a = 0;
                        let b = 0;
                        let c = 0;
                        // console.log(this.upassw);
                        for (let chars of this.password) {
                            console.log(chars);
                            if (chars >= "a" && chars <= "z") {
                                a = 1;
                            }
                            if (chars >= "A" && chars <= "Z") {
                                b = 1;
                            }
                            if (chars >= "0" && chars <= "9") {
                                c = 1;
                            }
                        }
                        // for (let i = 0; i < this.upassw.length; i++) {
                        //     if (this.upassw.charAt(i) >= 'a' && this.upassw.charAt(i) <= 'b') {
                        //
                        //     }
                        // }
                        if (a !== 1 || b !== 1 || c !== 1) {
                            this.upasswmessage = "密码必需包含数字，小写字母和大写字母";
                        }
                        console.log(a, b, c);
                    } else {
                        this.upasswmessage = "";
                    }
                } else if (name === "repassw") {
                    if (type === "blur") {
                        if (this.password.length === this.repassw.length) {
                            for (let i = 0; i < this.password.length; i++) {
                                if (this.password.charAt(i) !== this.repassw.charAt(i)) {
                                    this.repasswmessage = "确认密码错误";
                                }
                            }
                        } else {
                            this.repasswmessage = "确认密码错误";
                        }

                    } else {
                        this.repasswmessage = "";
                    }
                } else if (name === "email") {
                    if (type === "blur") {
                        let a = 0;
                        for (let chars of this.email) {
                            if (chars === '@') {
                                a = 1;
                            }
                        }
                        if (a !== 1) {
                            this.emailmessage = "请填写正确的电子邮箱"
                        }
                    } else {
                        this.emailmessage = "";
                    }
                }
            }
        }

    });
</script>
</body>
</html>
