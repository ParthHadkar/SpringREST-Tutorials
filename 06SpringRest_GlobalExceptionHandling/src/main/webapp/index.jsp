<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h2>Spring Rest Demo</h2>
<hr/>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<hr/>
<a href="${pageContext.request.contextPath}/api/students">View Students</a>
</body>
</html>