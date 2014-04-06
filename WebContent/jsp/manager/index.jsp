<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>manager's home</title>
    
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
  	<ul>
		<li><a href="manager/synonym">同义词管理</a></li>
		<li><a href="manager/ipmanage">IP管理</a></li>
		<li><a href="manager/sensmanage">敏感词管理</a></li>
		<li><a href="manager/watermanage">水军管理</a></li>
		<li><a href="manager/interestmanage">商家感兴趣词管理</a></li>
		<li><a href="manager/biddingmanage">竞价排名管理</a></li>
  	</ul>
  </body>
</html>
