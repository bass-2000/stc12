<%@ page import="ru.innopolis.stc12.servlets.controllers.HelloServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String Request = request.getParameter("testText");
    String Status = "Failed";
    if (Request.equals(HelloServlet.getTestString())) Status = "Success";
%>
<%=Status%>
<BR>
<button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>
