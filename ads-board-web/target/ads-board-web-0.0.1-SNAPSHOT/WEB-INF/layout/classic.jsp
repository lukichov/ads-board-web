<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<tilesx:useAttribute name="current" />

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>	

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
	<div class="container">

		<%-- 	<tiles:insertAttribute name="header" /> --%>
		<tiles:insertTemplate template="header.jsp">
			<tiles:putAttribute name="current" value="${current}" />
		</tiles:insertTemplate>
		<tiles:insertAttribute name="body" />
		<br> <br>

		<div align="center">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>
</html>