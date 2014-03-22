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
    
    <title>Synonym</title>
    
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
  	<table>
  		<tr>
	  		<c:forEach var="syn" items="${synlist }">
	  			<td>${syn.word }</td>
	  			<c:forEach var="word" items="${syn.synonymsIndexesForId1 }">
	  				<td>${word }</td>
	  			</c:forEach>
	  			<td><a href="manager/syn/delete">delete</a></td>
	  		</c:forEach>
  		</tr>
  	</table>
  	<form action="manager/syn/add">
  		<input type="text" name="s1"/>
  		<input type="text" name="s2"/>
  		<input type="submit" value="submit"/>
  	</form>
  </body>
</html>
