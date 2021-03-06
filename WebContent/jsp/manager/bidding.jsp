<%@ page language="java" import="java.util.*,cn.edu.nju.apoc.entity.Products" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
  	<div id="header">
    <a href="index.html">
        <img id="logo" src="images/logo.png" />
    </a>

    <ul>
        <li class="nav_button">
            <a href="manager/synonymmanage">
                <span class="cn">同义词</span>
                <span class="en">SYNONYM</span>
            </a>
        </li>
        <li class="nav_button">
            <a href="manager/ipmanage">
                <span class="cn">IP 管理</span>
                <span class="en">IP MANAGE</span>
            </a>
        </li>
        <li class="nav_button">
            <a href="manager/sensmanage">
                <span class="cn">敏感词</span>
                <span class="en">SENSITIVE WORLD</span>
            </a>
        </li>
        <li class="nav_button current">
            <a href="manager/biddingmanage">
                <span class="cn">竞价排名</span>
                <span class="en">BIDDING RANK</span>
            </a>
        </li>
        <li class="nav_button">
            <a href="manager/armymanage">
                <span class="cn">水军管理</span>
                <span class="en">WATER ARMY</span>
            </a>
        </li>
        <li class="nav_button">
            <a href="manager/interestmanage">
                <span class="cn">兴趣词汇</span>
                <span class="en">INTERESTED WORD</span>
            </a>
        </li>
        <li class="nav_button">
            <a href="jsp/manager/upload.jsp">
                <span class="cn">广告上传</span>
                <span class="en">ADS UPLOAD</span>
            </a>
        </li>
    </ul>
</div>
<div id="container">
	<table>
		<c:forEach var="bidding" items="${biddinglist}">
			<tr>
				<td>${bidding.products.pid}</td>
				<td>${bidding.money}</td>
				<td>
				<form action="manager/bidding/delete">
				<input name="pid" type="hidden" value="${bidding.products.pid}"/>
				<input name="money" type="hidden" value="${bidding.money}"/>
  				<input type="submit" value="delete"/>
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="manager/bidding/add">
		pid:<input name="pid" type="text" />
		money:<input name="money" type="text" />
  		<input type="submit" value="add"/>
	</form>
	</div>
	<%@include file="../footer.jsp"%>
  </body>
</html>
