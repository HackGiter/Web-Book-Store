<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="generalClass.Books" %>
<%
String path = request.getContextPath();
String names = request.getParameter("name");
String title = request.getParameter("title");
String z_index = request.getParameter("z-index");
String top = request.getParameter("top");
List<Books> booksList = (List<Books>) session.getAttribute(title);
//System.out.println(booksList);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int listLen =  booksList.size() / 6 + 1;
int remainLen = booksList.size() % 6;

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Library Body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="BookLibrary">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/body.css" type="text/css">
	<script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
  </head>
  
  <body>
  <div class='body' style=<%="z-index:"+z_index+";top:"+top+";"%> name=<%=names+"_class" %>>
	  <div class='title' name=<%=names%>>
		  <%=title %>
	  </div>
<%--	  <div class='bookshelf_h'></div>--%>
	  <div class='bookshelf_b' name=<%=names+"_body"%>>
		  <div class="content_table">
			  <table style="margin: 0 5px;">
				  <tbody>
				  <% for (int i = 0 ; i < listLen; i++) {
				  	int remains = 6;
					  if (i == listLen-1) {
						  remains = remainLen;
					  }
				  %>

				  <tr>
					  <% for (int a = 0; a < remains; a++) {%>
					  <td>
						  <form action="${pageContext.request.contextPath}/books/detailBook" method="post">
						  <div class="book_info_box">
							  <input style="display: none" name="bid" value="<%=booksList.get(i*6+a).getBid()%>" />
							  <input style="display: none" name="location" value="book_info"/>
							  <input type="image" src="${pageContext.request.contextPath}/images/<%=booksList.get(i*6+a).getBid()%>.jpg" class="book_info_img"/>
<%--							  <img class="book_info_img" src="${pageContext.request.contextPath}/images/<%=booksList.get(i*5+a).getBid()%>.jpg"/>--%>
							  <div class="table_text" title="<%=booksList.get(i*6+a).getName()%>"> <%=booksList.get(i*6+a).getName()%> </div>
							  <div class="table_text" title="<%=booksList.get(i*6+a).getAuthor()%>"> [<%=booksList.get(i*6+a).getCountry()%>] <%=booksList.get(i*6+a).getAuthor()%> </div>
						  </div>
						  </form>
					  </td>
					  <% } %>
					  <% for (int a = 0; a < 6-remains; a++) {%>
					  <td class="empty_info_box">
					  </td>
					  <% }%>
				  </tr>

				  <% } %>
				  </tbody>
			  </table>
		  </div>
	  </div>
	  <div class="bookshelf_h"></div>
  </div>
  </body>
</html>
