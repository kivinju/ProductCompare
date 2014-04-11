<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<base href="<%=basePath%>">
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
        <li class="nav_button current">
            <a href="jsp/manager/upload.jsp">
                <span class="cn">广告上传</span>
                <span class="en">ADS UPLOAD</span>
            </a>
        </li>
    </ul>
	</div>
	<div id="container">
	<form action="manager/fileUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="fileUpload" label="广告"/>
		money:<input type="text" name="money"/>
		url:<input type="text" name="url"/>
		<input type="submit" value="上传" />
	</form>
	</div>
	<div id="footer">
    <span id="author">
        <span class="cn">&copy; 南京大学软件学院</span>
    </span>
    
</div>
</body>
</html>