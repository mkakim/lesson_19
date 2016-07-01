<%--
  Created by IntelliJ IDEA.
  User: Merei
  Date: 22.06.2016
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserEdit</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/edit" method="post">
    Login : <input type="text" name="login" value="${user.login}"></br>
    Email : <input type="text" name="email" value="${user.email}"></br>
    <input type="submit" value="query">
</form>
</body>
</html>
