<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: m.biryukov
  Date: 01.10.2018
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Integer> list = (List<Integer>) request.getAttribute("list");
    for (Integer i : list) {
%>
<%=i%><BR>
<%
    }
%>
</body>
</html>