<%@ page import="ru.innopolis.stc12.servlets.pojo.City" %>
<%@ page import="java.util.List" %>
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
