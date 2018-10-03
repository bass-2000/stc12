<%--
  Created by IntelliJ IDEA.
  User: Insane
  Date: 03.10.2018
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
You autorised as <%=request.getSession().getAttribute("login")%>
<a href="/login?action=logout">Log OUT</a>
<H1>DASHBOARD</H1>

</body>
</html>
