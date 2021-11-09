<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL Page</title>
</head>
<body>
<h1>JSTL Page</h1>
<hr>
<jsp:useBean id="personBean" class="ru.webproject.test1.model.PersonBean"/>
<jsp:setProperty name="personBean" property="*"/>
<jsp:setProperty name="personBean" property="name" param="name"/>
<jsp:setProperty name="personBean" property="age" param="age" />

<h2>Hello <jsp:getProperty name="personBean" property="result"/></h2>
</body>
</html>
