<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="phone" items="${phones}">
        <TR>
            <TD>${phone.id}</TD>
            <TD>${phone.model}</TD>
            <TD>${phone.cost}</TD>
        </TR>
    </c:forEach>
</table>
</body>
</html>