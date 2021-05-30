<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: lee19
  Date: 2021/4/9
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="generalClass.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML>
<%
    int command = (int) request.getAttribute("command");
    int have = (int) request.getAttribute("have");
    int ids = (int) request.getAttribute("ids");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    System.out.println(command);
//    System.out.println(ids);
    List<Books> booksList = null;
    List<Products> productsList = null;
    List<Series> seriesList = null;
    List<AllOrders> allOrdersList = null;
    List<AllBuys> allBuysList = null;
    List<AllStorages> allStoragesList = null;
    List<AllExpresses> allExpressesList = null;
    List<Expresses> expressesList = null;
    List<BooksDetail> booksDetailList = null;
    List<StorageInfo> storageInfoList = null;
    List<String> stringList = null;

    Books books = null;
    int count = 0;
    int pages = 0;
//    System.out.println(have);
    Managers managers = (Managers) session.getAttribute("managers");
    if (have == 1) {
        if (command == 3) {
            booksList = (List<Books>) request.getAttribute("booksList");
            pages = booksList.size()/17;
            if ((booksList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 0) {
            books = (Books) request.getAttribute("books");
        } else if (command == 4){
            productsList = (List<Products>) request.getAttribute("productsList");
            pages = productsList.size()/17;
            if ((productsList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 5){
            seriesList = (List<Series>) request.getAttribute("seriesList");
            pages = seriesList.size()/17;
            if ((seriesList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 6){
            allOrdersList = (List<AllOrders>) request.getAttribute("allOrdersList");
            pages = allOrdersList.size()/17;
            if ((allOrdersList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 7){
            allBuysList = (List<AllBuys>) request.getAttribute("allBuysList");
            pages = allBuysList.size()/17;
            if ((allBuysList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 8){
            allStoragesList = (List<AllStorages>) request.getAttribute("allStoragesList");
            pages = allStoragesList.size()/17;
            if ((allStoragesList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 9){
            allExpressesList = (List<AllExpresses>) request.getAttribute("allexpressesList");
            pages = allExpressesList.size()/17;
            if ((allExpressesList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 10) {
            booksDetailList = (List<BooksDetail>) request.getAttribute("booksDetailList");
            pages = booksDetailList.size()/17;
            if ((booksDetailList.size()%17)>0) {
                pages += 1;
            }
        } else if (command == 11) {
            storageInfoList = (List<StorageInfo>) request.getAttribute("storageInfoList");
            pages = storageInfoList.size()/17;
            if ((storageInfoList.size()%17)>0) {
                pages += 1;
            }
        }
    }


%>
<%
    BooksDetail booksDetail = null;
    Products products = null;
    Series series = null;
    AllOrders allOrders = null;
    AllBuys allBuys = null;
    AllStorages allStorages = null;
    AllExpresses allExpresses = null;
    List<Orders> ordersList = null;
    List<Buys> buysList = null;
    List<Storages> storagesList = null;
    int total = 0;
    if (command == 1) {
        stringList = (List<String>) request.getAttribute("stringList");

    }
    if (command == 0) {
        if (ids == 3) {
            books = (Books) request.getAttribute("books");
            products = (Products) request.getAttribute("products");
            booksDetail = (BooksDetail) request.getAttribute("booksDetail");
        } else if (ids == 4) {
            products = (Products) request.getAttribute("products");
        } else if (ids == 5) {
//            series = (Series) request.getAttribute("series");
            allBuys = (AllBuys) request.getAttribute("allBuys");
            buysList = (List<Buys>) request.getAttribute("buysList");
            productsList = (List<Products>) request.getAttribute("productsList");
        } else if (ids == 6) {
            allOrders = (AllOrders)  request.getAttribute("allOrders");
            ordersList = (List<Orders>) request.getAttribute("ordersList");
            expressesList = (List<Expresses>) request.getAttribute("expressesList");
        } else if (ids == 7) {
//            allBuys = (AllBuys) request.getAttribute("allBuys");
            productsList = (List<Products>) request.getAttribute("productsList");
        } else if (ids == 8) {
            allStorages = (AllStorages) request.getAttribute("allStorages");
            allBuys = (AllBuys) request.getAttribute("allBuys");
            buysList = (List<Buys>) request.getAttribute("buysList");
            storagesList = (List<Storages>) request.getAttribute("storagesList");
        } else if (ids == 9) {
            allExpresses = (AllExpresses) request.getAttribute("allExpresses");
        } else if (ids == 0) {

        }
    } else if (command == 2) {

    } else {

    }
%>

<html>
<head>
    <title>后台管理系统（Admin）</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin_head.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/info.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
    <script>
        function cancel() {
            var form = document.booksForm;
            form.action = "${pageContext.request.contextPath}/index/admit";
            form.submit();
        }

    </script>
</head>
<body>
<%@include file="/WEB-INF/jsp/admin_head.jsp"%>
    <div class="admin">
        <div>
            <div class="u_info_box">
                <div style="width: 300px; height: 300px; border: solid 1px #F1F1F1;">
                    <img class="img_head" src="${pageContext.request.contextPath}/images/mid3.jpg">
                </div>
                <div>
                    <table style="border: none;outline: none;text-align: center;">
                        <tr style="height: 40px;">
                            <td>姓名：</td>
                            <td><%=managers.getName()%></td>
                        </tr>
                        <tr style="height: 40px;">
                            <td>等级：</td>
                            <td><%=managers.getLevel()%></td>
                        </tr>
                        <tr style="height: 40px;">
                            <td>部门：</td>
                            <td><%=managers.getDepartment()%></td>
                        </tr>
                        <tr style="height: 40px;">
                            <td>职位：</td>
                            <td><%=managers.getPosition()%></td>
                        </tr>
                        <tr style="height: 40px;">
                            <td>电子邮件：</td>
                            <td><%=managers.getEmail()%></td>
                        </tr>
                        <tr style="height: 40px;">
                            <td>联系方式：</td>
                            <td><%=managers.getPhone()%></td>
                        </tr>
                        <% if (managers.getLevel()=='0') {%>
                        <tr style="height: 40px;">
                            <td>操作</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/manage/control" method="post">
                                    <input class="submit_button" type="submit" value="添加" />
                                </form>
                            </td>
                        </tr>
                        <% } %>

                    </table>
                </div>
            </div>
            <div class="control_info_box">
                <div id="control_info_button_list">
                    <form method="post" name="actionForms">
                        <input class="info_button" type="button" v-for="(item, i) in button_list" v-model="item" @click="link(item)" />
                    </form>

                </div>
                <% if (command >= 3) {%>
                <div>
                    <form method="post" id="info" name="selectForm">
                        <select v-model="dsv" @change="change" name="command" class="info_select">
                            <option :value="option.value" v-for="option in selectLists">{{option.name}}</option>
                        </select>
                    </form>
                </div>
                <% } %>
                <div id="control_b_info" class="control_info">
                    <div v-bind:class="{control_info_button:!(index_c==1)}">
                        <% if (command==0) {%>
                        <% if (ids==6) { %>
                        <%@include file="/WEB-INF/jsp/express_info.jsp"%>
                        <% } else if (ids==7) { %>
                        <%@include file="/WEB-INF/jsp/buy_info.jsp"%>
                        <% } else if (ids == 8) {%>
                        <%@include file="/WEB-INF/jsp/storage_info.jsp"%>
                        <% } else if (ids == 3) { %>
                        <%@include file="/WEB-INF/jsp/edit_book2.jsp"%>
                        <% } else if (ids == 5) {%>
                        <%@include file="/WEB-INF/jsp/edit_buy.jsp"%>
                        <% } else if (ids == 0) {%>
                        <%@include file="/WEB-INF/jsp/manage.jsp"%>
                        <% }%>
                        <%} else if (command==1) {%>
                        <%@include file="/WEB-INF/jsp/edit_book.jsp"%>
                        <%} else {%>
                        <%@include file="/WEB-INF/jsp/product_info.jsp"%>
                        <%} %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        var one = new Vue({
            el: '#control_info_button_list',
            data: {
                button_list: ["信息列表", "待用列表", "订货单填写", "出库单填写", "入库单填写", "表单查询"],
                object: {
                    name: "后台管理系统"
                },

            },

            methods: {
                link(e) {
                    if (e==="信息列表") {
                        two.index_c = 1;
                        var form = document.actionForms;
                        form.action = "${pageContext.request.contextPath}/index/entry";
                        form.submit();
                        console.log(e);
                    } else if (e==="订货单填写") {
                        var form = document.actionForms;
                        form.action = "${pageContext.request.contextPath}/index/buy";
                        form.submit();
                    } else if (e==="入库单填写") {
                        two.index_c = 3;
                        console.log(e);
                    } else if (e==="添加商品") {
                        two.index_c = 4;
                        console.log(e);
                    }

                }
            },

        });
        var two = new Vue({
            el: '#control_b_info',
            data: {
                index_c: 1,
                pageNow:0,
                pageAll:1,
                imgName:'',
                nobox:true,
                noshow:true,
                imgUrl:'',
                ageyear:20,
                longlist:[],
                longstr:'',
                slist:[],
                cindex:0,
                clist:[],
                ndate:'',
                levellist:10,
                sl:0,
            },
            created:function () {
                this.pageAll = <%=pages%>;
                <% if (buysList == null)  {%>
                this.cindex = 0;
                <% } else { %>
                this.cindex = <%=buysList.size()%>;
                <% } %>
                let time = new Date();
                let day = ("0" + time.getDate()).slice(-2);
                let month = ("0" + (time.getMonth() + 1)).slice(-2);
                let today = time.getFullYear() + "-" + (month) + "-" + (day);
                this.ndate = today;
                console.log(this.pageAll);
            },
            methods: {
                getPage:function (e) {
                    this.pageNow = e-1;
                    console.log(e);
                },
                getImage() {
                    console.log(this.imgName);
                    this.imgUrl=this.imgName;
                },
                getBox() {
                    this.nobox=!this.nobox;
                },
                LoseBox() {
                    this.nobox=!this.nobox;
                },
                clickToControl(e, b) {
                    // console.log(e);
                    if (b === 0) {
                        e.action = "${pageContext.request.contextPath}/index/orders";
                        e.submit();
                    } else if ( b === 1) {
                        e.action = "${pageContext.request.contextPath}/index/storage";
                        e.submit();
                    }

                },
                checkInList(i, value) {
                    let tmp = [];
                    let have = 0;
                    for (let a = 0; a < this.longlist.length; a++) {
                        if (this.longlist[a].name===i) {
                            have = 1;
                        } else {
                            tmp.push({name:this.longlist[a].name, v:this.longlist[a].v})
                        }
                    }
                    if (have === 0) {
                        tmp.push({name:i, v:value})
                    }
                    this.longlist = tmp;
                    console.log(this.longlist);
                },
                checkBuy(b, p, ab, n, pr) {
                    let tmp = [];
                    let have = 0;
                    console.log(this.slist);
                    for (let a = 0; a < this.slist.length; a++) {
                        if (this.slist[a].bid===b) {
                            have = 1;
                        } else {
                            tmp.push({bid:this.slist[a].bid,
                                pid:this.slist[a].pid,
                                abid:this.slist[a].abid,
                                number:this.slist[a].number,
                                price:this.slist[a].price,
                                })
                        }
                    }
                    if (have === 0) {
                        tmp.push({bid:b, pid:p, abid:ab, number:n, price:pr})
                    }
                    this.slist = tmp;

                },
                generateName(index, name) {
                    return "buysList["+index+"]."+name;
                },
                generateName2(index, name1, name2) {
                    return name1+"["+index+"]."+name2;
                },
                checkEasy(v) {
                    let tmp = [];
                    let have = 0;
                    let count = 0;
                    for (let a = 0; a < this.clist.length; a++) {
                        if (this.clist[a].value===v) {
                            have = 1;
                        } else {
                            tmp.push({value:this.clist[a].value, i:count+this.cindex})
                            count+=1;
                        }
                    }
                    if (have === 0) {
                        tmp.push({value:v, i:tmp.length+this.cindex})
                    }
                    this.clist = tmp;
                    console.log(this.clist);
                },
                addStorage() {
                    if (this.sl === 0) {
                        this.sl = 1;
                    } else {
                        this.sl = 0;
                    }
                },
                addExpress(oid) {
                    let tmp = [];
                    let have = 0;
                    for (let a = 0; a < this.slist.length; a++) {
                        if (this.slist[a].oid===oid) {
                            have = 1;
                        } else {
                            tmp.push({
                                oid:this.slist[a].oid,
                            })
                        }
                    }
                    if (have === 0) {
                        tmp.push({oid:oid})
                    }
                    this.slist = tmp;
                    console.log(this.slist);
                },

            },
        });
        var three = new Vue({
            el: "#info",
            data: {
                selectLists: [
                    {value:3, name:"图书信息"},
                    {value:4, name:"商品信息"},
                    {value:5, name:"系列信息"},
                    {value:6, name:"销售单信息"},
                    {value:7, name:"采购单信息"},
                    {value:8, name:"入库单信息"},
                    {value:9, name:"出库单信息"},
                    {value:10, name:"图书详情"},
                    {value:11, name:"仓库信息"}
                ],
                dsv: 3,
                input_value: 3,
                id:'0'
            },
            created() {
                this.dsv = <%=command%>;
                this.id = <%=managers.getLevel()%>;
                // console.log(this.id)
                // console.log(typeof(this.id))
                if (this.id === 1) {
                    this.selectLists=[
                        {value:8, name:"入库单信息"},
                        {value:9, name:"出库单信息"},
                        {value:11, name:"仓库信息"}
                    ]
                } else if (this.id === 2) {
                    this.selectLists=[
                        {value:7, name:"采购单信息"},
                    ]
                } else if (this.id === 3) {
                    this.selectLists=[
                        {value:6, name:"销售单信息"},
                        {value:9, name:"出库单信息"},
                    ]
                } else if (this.id === 4) {
                    this.selectLists=[
                        {value:7, name:"采购单信息"},
                        {value:8, name:"入库单信息"},
                    ]
                }
            },
            methods: {
                defaultS0() {
                    var selects = document.info;
                },
                change() {
                    var form = document.selectForm;
                    form.action = "${pageContext.request.contextPath}/index/admin";
                    console.log(this.dsv);
                    if (this.dsv==3) {
                        this.input_value = 3;
                    } else if (this.dsv==4) {
                        this.input_value = 4;
                    } else if (this.dsv==5) {
                        this.input_value = 5;
                    } else if (this.dsv==6) {
                        this.input_value = 6;
                    } else if (this.dsv==7) {
                        this.input_value = 7;
                    } else if (this.dsv==8) {
                        this.input_value = 8;
                    } else if (this.dsv==9) {
                        this.input_value = 9;
                    } else if (this.dsv==10) {
                        this.input_value = 10;
                    } else if (this.dsv==11) {
                        this.input_value = 11;
                    }
                    form.submit();
                    console.log(this.dsv);
                }
            }
        });
    </script>

</body>
</html>
