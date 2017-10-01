<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles_for_login.css" />"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
</head>
<body>
	<a class="log_button" href="./">Log out </a>
	<p id="welcome">
		Welcome,
		<c:out value="${name}" />
	</p>
</body>
</html>