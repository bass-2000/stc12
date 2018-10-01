<%@ page import="ru.innopolis.stc12.servlets.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: m.biryukov
  Date: 01.10.2018
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентов:</title>
</head>
<body>
<%
    List<Student> list = (List<Student>) request.getAttribute("list");
    for (Student student : list) {
%>
<%=student.getFamilyName()%> <%=student.getName()%> <%=student.getCity()%><BR>
<%
    }
%>
</body>
</html>