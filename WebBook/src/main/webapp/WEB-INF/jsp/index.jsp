<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String[] titles = {"文学", "流行", "文化", "生活", "经管", "科技"};
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Book Index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Index">
	<script src="${pageContext.request.contextPath}/script/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/script/vue.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<script type="text/javascript">
		$(document).ready(function(){
			$(".title").click(function(e){
	  	//console.log(e);
	  	//console.log(e.attr("name"));
	  	//console.log(e);
	  	//console.log(e.currentTarget.attributes.name.value);
	    //$(".bookshelf_b").slideDown("slow");
	    //$("div[name='name_1_1']").slideDown("slow");
	    //console.log($("div[name='name_1_1']").find(".bookshelf_b"));
	    //document.getElementsByName("name_1_1")[0].getElementsByClassName("bookshelf_b")[0].slideDown("slow");
	    //console.log(document.getElementsByName("name_1_1")[0].getElementsByClassName("bookshelf_b")[0]);
		//   console.log($("div[name='"+e.currentTarget.attributes.name.value+"_class']"))
		//   $("div[name='"+e.currentTarget.attributes.name.value+"_class']").find(".bookshelf_b").slideToggle("slow");
		  // console.log($("div[name='"+e.currentTarget.attributes.name.value+"_class']").width());
			// 	console.log("['"+e.currentTarget.attributes.name.value+"_body']")
		  if ($("div[name='"+e.currentTarget.attributes.name.value+"_body']").height()==340) {
			  $("div[name='"+e.currentTarget.attributes.name.value+"_body']").css({
				  "height": "680px"
			  });
		  } else {
			  $("div[name='"+e.currentTarget.attributes.name.value+"_body']").css({
				  "height": "340px"
			  });
		  }
		  if ($("div[name='"+e.currentTarget.attributes.name.value+"_class']").width()==1125) {
		  	$("div[name='"+e.currentTarget.attributes.name.value+"_class']").css({
	    	"width": "1345px"
		  	});
		  } else {
		  	$("div[name='"+e.currentTarget.attributes.name.value+"_class']").css({
				"width": "1125px"
		  	});
		  }
	  });
	});
	</script>
  </head>
  <body>
  	<jsp:include page="/WEB-INF/jsp/head.jsp"/>

	<div class='base_line'>
	  	<%
	  		for (int i = 0; i < titles.length; i++) {
	  		String names = "name_1_"+String.valueOf(i);
	  		System.out.println(titles[i]);
	  	 %>
<%--			<div class='layer' name=<%=names %> style=<%="z-index:"+String.valueOf(i)+";top:"+String.valueOf(50-100*i)+";"%>>--%>
<%--				<jsp:include page="/WEB-INF/jsp/body.jsp">--%>
<%--				<jsp:param name="name" value="<%=names %>"/>--%>
<%--				<jsp:param name="title" value="<%=titles[i] %>"/>--%>
<%--				</jsp:include>--%>
<%--			</div>--%>
			<jsp:include page="/WEB-INF/jsp/body.jsp">
				<jsp:param name="name" value="<%=names %>"/>
				<jsp:param name="title" value="<%=titles[i] %>"/>
				<jsp:param name="z-index" value="<%=String.valueOf(i)%>"/>
				<jsp:param name="top" value="<%=String.valueOf(50-100*i)%>"/>
				<jsp:param name="booksList" value="<%=request.getAttribute(titles[i])%>"/>
			</jsp:include>
	  	 <%
	  	 	}
	  	  %>
	</div>
  </body>

</html>
