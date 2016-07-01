<%@ page import="models.User" %>
<%@ page import="store.UserCache" %>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>UserView</title>
</head>
<body style="background-image: url(../images/fon2.png);>

<div style="height: 300px">
<p align="center"><img src="../images/header1.png" width="1000px" height="300px" style="margin:0 auto"></p>
</div>
<table>
    <tr>
        <td>
<a href="${pageContext.servletContext.contextPath}/views/user/UserCreate.jsp"><font color="#ff8c00">
    <input type="image" src="../images/register.png" width="93" height="40">
</font></a></br>
<table border="2" style="color: #2e67ff;border-style: hidden" >
    <tr>
        <td style="font-family: Andalus,Arial">Login</td>
        <td style="font-family: Andalus,Arial">Email</td>
        <td style="font-family: Andalus, Arial">Action</td>
    </tr>
    <%
        UserCache USER_CACHE = UserCache.getInstance();
        for (User user : USER_CACHE.users.values()) {
    %>


    <tr valign="top">
        <td style="font-family: Andalus,Arial"><%=user.getLogin()%></td>
        <td style="font-family: Andalus,Arial"><%=user.getEmail()%></td>
        <td>

            <a href="${pageContext.servletContext.contextPath}/user/edit?id=<%=user.getId()%>">
                <input type="image" src="../images/edit.png" width="70" height="30"/>
            </a>
            <a href="${pageContext.servletContext.contextPath}/user/delete?id=<%=user.getId()%>">
                <input type="image" src="../images/delete.png" width="70" height="30"/>
            </a>
        </td>
    </tr>
    <%}%>

</table>
        </td>
</br>
        <td>

<div align="center" style="border: dashed">
    <tr>
        <td>
    <h2 style="font-family: Andalus; color:#2e67ff ">Search User : </h2>
    <form action="${pageContext.servletContext.contextPath}/user/search" method="get">
        <input type="text" name="searchUser">
        <input type="image" src="../images/search.png" width="70" height="30">
    </form>
        </td>
        <td style="font-family: Andalus,Arial; font-size: 30px; color: #2e67ff">${search.login}</td>
        <td style="font-family: Andalus,Arial; font-size: 30px; color: #2e67ff">${search.email}</td>
    </tr>
</div>

</table>

</body>
</html>
