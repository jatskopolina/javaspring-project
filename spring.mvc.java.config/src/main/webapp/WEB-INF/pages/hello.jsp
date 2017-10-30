<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="cubearticle.examples.springmvc.helpful.CookieUtils"%>

<%@ page import="cubearticle.examples.springmvc.helpful.SoapPrinter"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" />
<link href="<c:url value="/resources/styles_for_login.css" />"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
</head>
<body>
	<a class="log_button" style="text-decoration: none" href="./">Log
		out </a>
	<!-- Used Bootstrap for cute table and he decided to change the style of p. 
	"Welcome, ..." is right on the top of the screen now. Dont wanna create another text style for it, but i am angry!-->
	<p id="welcome">
		Welcome,
		<c:out value="${name}" />
	</p>
	<%
		CookieUtils.demoUserCookie(request, response, out);
		//i couldn`t get my list of valutes here.. so i use special class))
		SoapPrinter.print(out);
	%>

</body>
</html>