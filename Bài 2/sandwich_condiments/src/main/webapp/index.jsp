<%--
  Created by IntelliJ IDEA.
  User: IDEAPAD GAMING 3
  Date: 12/25/2022
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
  <input type="checkbox" name="lettuce" value="lettuce">Lettuce
  <input type="checkbox" name="tomato" value="tomato">Tomato
  <input type="checkbox" name="mustard" value="mustard">Mustard
  <input type="checkbox" name="sprouts" value="sprouts">Spouts
  <button>Save</button>
</form>
<p>${lettuce}</p>
<p>${tomato}</p>
<p>${mustard}</p>
<p>${sprouts}</p>
</body>
</html>
