<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Product Info</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/product.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">

</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="user/search">Product Compare</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="user/search">Search</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div id="container">
		<div>
			<div class="col-10 ">
				<c:forEach var="product" items="${products}">
					<div class="item">
						<p class="product-img">
							<img class="img-thumbnail" src="${product.url}"
								data-src="holder.js/400x400/auto"
								alt="Generic placeholder image" width="250" height="250" />
						</p>

						<div class="product-info">
							<p class="title">${product.name}</p>
							<p class="price">&#65509;${product.price}</p>
							<a class="buy btn btn-primary btn-sm" target="_blank"
								href="${product.site}">去购买</a>
						</div>

						<div class="comment">
							<c:forEach var="comment" items="${product.commentses }">
								<p class="item">${comment.comments }</p>
							</c:forEach>

							<form action="user/comment" method="POST">
								<input type="hidden" name="pid" value="${product.pid}" />
								<textarea type="text" value="name" name="comment"></textarea>
								<input class="submit btn btn-primary btn-sm" type="submit" value="submit">
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div id="footer">
		<span id="author"> <span class="cn">&copy; 南京大学软件学院</span>
		</span>
	</div>
</body>
</html>
