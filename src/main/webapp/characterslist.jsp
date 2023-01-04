<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>CharactersList</title>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>
<body>
<div class="container">
    <header>
        <h1>Spring MVC + JSP + JPA + Spring Boot 2</h1>
    </header>
    <div class="starter-template">
        <h1>Users List</h1>
        <table
                class="table table-striped table-hover table-condensed table-bordered">
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <c:forEach var="character" items="${characterslist}">
                <tr>
                    <td>${character.id}</td>
                    <td>${character.author_id}</td>
                    <td>${character.char_name}</td>
                    <td>${character.strength}</td>
                    <td>${character.dexterity}</td>
                    <td>${character.constitution}</td>
                    <td>${character.intelligence}</td>
                    <td>${character.wisdom}</td>
                    <td>${character.charisma}</td>
                    <td>${character.char_name}</td>
                    <td>${character.itemsList}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>