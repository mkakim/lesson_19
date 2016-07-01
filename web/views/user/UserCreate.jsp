<%--
  Created by IntelliJ IDEA.
  User: Merei
  Date: 22.06.2016
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="http://localhost:8080/cpw/css/style.css">
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>UserCreate</title>
</head>
<body <%--style="background-image: url(http://localhost:8080/cpw/images/fon2.png)"--%>>
<div style="height: 300px">
   <p align="center"> <img src="http://localhost:8080/cpw/images/fon3.jpg" height="420" width="1000" style="margin: 0 auto;"></p>
</div>
</br>
    <h2 style="font-family: Andalus; color: #2e67ff;">Add User : </h2>
    <form action="${pageContext.servletContext.contextPath}/user/create" method="get">
        Login : <input type="text" name="login"></br></br>
        Email : <input type="text" name="email"></br></br>
        <input type="image" src="http://localhost:8080/cpw/images/add.png" width="80" height="35">
    </form>
</body>
</html>
