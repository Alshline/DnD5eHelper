<%--
  Created by IntelliJ IDEA.
  User: Spurius
  Date: 22.12.2022
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Person List</h1>

<br/><br/>
<div>
    <table width="750" cellpadding="5" cellspacing="0">
        <tr>
            <th> Searching by the JSOAP</th>
            <th> Inventory </th>
            <td width="150">??????? 1</td>
            <td width="400">??????? 2</td>
        </tr>
    </table>

    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach  items="${persons}" var ="person">
            <tr>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>