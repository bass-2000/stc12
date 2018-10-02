<%@ page import="ru.innopolis.stc12.servlets.pojo.City" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 16691270
  Date: 02.10.2018
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список городов:</title>
</head>
<body>
<%
    List<City> list = (List<City>) request.getAttribute("list");
    for (City city : list) {
%>
<%=city.getId()%> <%=city.getName()%> <%=city.getPopulation()%><BR>
<%
    }
%>
</body>
</html>
