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
		<c:forEach var="basesyn" items="${synonymlist}">
			<c:forEach var="syn" items="${basesyn.list}">
				<tr>
					<td>${basesyn.word}</td>
					<td>${syn.word}</td>
					<td>
					<form action="manager/syn/delete">
  						<input name="id1" type="hidden" value="${basesyn.id}" />
  						<input name="id2" type="hidden" value="${syn.id}" />
  						<input type="submit" value="delete"/>
  					</form>
  					</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	
	<form action="manager/syn/add">
  		base word:<input name="word1" type="text" />
  		synonym word:<input name="word2" type="text"/>
  		<input type="submit" value="add"/>
  	</form>
  	
  </body>
</html>
