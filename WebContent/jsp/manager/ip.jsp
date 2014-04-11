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
	<link rel="stylesheet" type="text/css" href="css/style.css">

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
        <li class="nav_button current">
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
        <li class="nav_button">
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
	<table>
		<c:forEach var="ip" items="${iplist}">
			<tr>
				<td>${ip.ip}</td>
				<td>
				<form action="manager/ip/delete">
				<input name="ip" type="hidden" value="${ip.ip}"/>
  				<input type="submit" value="delete"/>
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="manager/ip/add">
		<input name="ip" type="text" />
  		<input type="submit" value="add"/>
	</form>
	<%@include file="../footer.jsp"%>
  </body>
</html>
