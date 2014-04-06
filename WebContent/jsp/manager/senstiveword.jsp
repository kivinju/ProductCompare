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
    
    <title>My JSP 'ip.jsp' starting page</title>
    
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
		<c:forEach var="sens" items="${sensitiveslist}">
			<tr>
				<td>${sens.word}</td>
				<td>
				<form action="manager/sens/delete">
				<input name="word" type="hidden" value="${sens.word}"/>
  				<input type="submit" value="delete"/>
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="manager/sens/add">
		<input name="word" type="text" />
  		<input type="submit" value="add"/>
	</form>
  </body>
</html>
