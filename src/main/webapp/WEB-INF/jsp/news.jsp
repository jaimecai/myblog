<%--
  Created by IntelliJ IDEA.
  User: jaimecai
  Date: 17-12-6
  Time: 下午5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:url value="http://baidu.com" var="url"></c:url>
    url:${url}
    <br>
    <a href="${url}">百度</a>
    <br>
    时间：${time}
</body>
</html>
