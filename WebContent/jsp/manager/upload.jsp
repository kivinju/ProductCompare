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
</head>
<body>
	<form action="manager/fileUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="fileUpload" label="广告"/>
		money:<input type="text" name="money"/>
		url:<input type="text" name="url"/>
		<input type="submit" value="上传" />
	</form>
</body>
</html>