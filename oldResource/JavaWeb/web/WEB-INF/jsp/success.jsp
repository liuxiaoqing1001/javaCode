<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:if test="${empty username}">
    注册成功！
</c:if>

<c:if test="${!empty username}">
    登陆成功！欢迎 ${username} !
</c:if>
</body>
</html>
