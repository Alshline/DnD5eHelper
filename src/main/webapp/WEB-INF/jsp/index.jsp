<%--
  Created by IntelliJ IDEA.
  User: Spurius
  Date: 22.12.2022
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Welcome</h1>
<h2>${message}</h2>



<a href="${pageContext.request.contextPath}/personList">Person List</a>

</body>

</html>