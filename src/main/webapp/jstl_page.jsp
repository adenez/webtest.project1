<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
<h1>JSP Page</h1>
<hr>
Params values:
<jsp:useBean id="personBean" class="ru.webproject.test1.model.PersonBean"/>
<jsp:setProperty name="personBean" property="*"/>
<jsp:setProperty name="personBean" property="name" param="name"/>
<jsp:setProperty name="personBean" property="age" param="age" />

<h2>Hello <jsp:getProperty name="personBean" property="result"/></h2>
<hr>
Fixed Values:
<jsp:setProperty name="personBean" property="name" value="James"/>
<jsp:setProperty name="personBean" property="age" value="35" />
<h2>Hello <jsp:getProperty name="personBean" property="result"/></h2>
<strong><a href="index.jsp">Back to main page</a></strong>
</body>
</html>
