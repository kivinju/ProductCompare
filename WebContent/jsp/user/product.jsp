<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	同名：
  	<table>
  		<tr>
		  	<c:forEach var="product" items="${productlist }">
		  		<td>
		  			${product.name }
		  		</td>
		  	</c:forEach>
	  	</tr>
  	</table>
  	<form action="user/comment">
  		comment:<input type="text" value="name">
  		<input type="submit" value="submit">
  	</form>
  	<ul>
  	<c:forEach var="comment" items="comments">
  		<li>${comment.comments }</li>
  	</c:forEach>
  	</ul>
  </body>
</html>
