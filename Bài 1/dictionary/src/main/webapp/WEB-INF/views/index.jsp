<%--
  Created by IntelliJ IDEA.
  User: IDEAPAD GAMING 3
  Date: 12/25/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="${pageContext.request.contextPath}/translate" method="post">
  <label for="vni">Enter VNI word: </label>
  <input id="vni" type="text" name="vni">
  <button type="reset">Reset</button>
  <button type="submit">Submit</button>
</form>
<span>Result: </span>
<c:if test="${mess != null}">
  <span><c:out value="${mess}"/></span>
</c:if>
</body>
</html>
