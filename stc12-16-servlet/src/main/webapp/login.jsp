<%--
  Created by IntelliJ IDEA.
  User: Insane
  Date: 03.10.2018
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (("wrongUser").equals(request.getParameter("action"))) {
%>
<div style="color:#AA0000">Not autorized!</div>
<%}%>
<form action="/login" method="post">
    login:<br>
    <input type="text" , name="login"><br>
    password:<br>
    <input type="password" , name="password"><br>
    <input type="submit">
</form>
</body>
</html>
