<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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