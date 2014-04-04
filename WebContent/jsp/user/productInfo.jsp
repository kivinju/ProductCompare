<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
  	同名商品：
  	<div>
  		<div class="col-10 ">
		  	<c:forEach var="product" items="${products}">
		  		<p>
		  			${product.name}
		  		</p>
		  		<p>
		  			${product.price }
		  		</p>
		  		<p>
		  			${product.site }
		  		</p>
		  		<p>
		  			${product.img }
		  		</p>
		  		<c:forEach var="comment" items="${product.comments }">
		  			<p>${comment }</p>
		  		</c:forEach>
		  		
		  		<form action="user/comment?pid=${product.pid}">
  					Comment:<textarea type="text" value="name"></textarea>
  					<input type="submit" value="submit">
  				</form>
		  	</c:forEach>
	  	</div>
  	</div>
  	
  </body>
</html>
