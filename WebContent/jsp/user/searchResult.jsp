<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8" contentType="text/html"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Search Results</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

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
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">

		<div class="row">
		
		<form  name="searchform" action="user/search" >
			<div class="col-md-8"></div>
			<div class="col-md-2">
				<input type="text" name="searchString" class="form-control" placeholder="Search"
					autofocus>
			</div>
			<div class="col-md-1">
				<button type="submit" class="btn btn-primary btn-sm">Search</button>
			</div>

		</form>>
		</div>
		<div class="row">
		<c:forEach var="product" items="${products}">
			<div class="col-6 col-sm-6 col-lg-4">
              <h2><a href="user/productInfo?pid=${product.pid}">${product.name}</a></h2>
              <img class="img-thumbnail" src="${product.url}" data-src="holder.js/400x400/auto" alt="Generic placeholder image"width="250" height="250">
              <p><a class="btn btn-default" href="user/productInfo?pid=${product.pid}">${product.name }</a></p>
           	  <p>Price:${product.price}</p>
		      <p>From site:${product.site}	</p>
            </div><!--/span-->
           </c:forEach>
		</div>
		<!--/row-->
	</div>
	<!-- /.container -->
	

</body>
</html>