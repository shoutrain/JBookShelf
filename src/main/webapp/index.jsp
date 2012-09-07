<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBookStore</title>
</head>

<body>
    <s:if test="#session.logined">
        Welcome, you have logined. <a href="<%= request.getContextPath() %>/logout.action">Logout</a>
    </s:if>
    <s:else>
        <p>User: test/test</p>
        <s:form action="login">
            <s:textfield key="username" label="Username" />
            <s:password key="password" label="Password" />
            <s:submit value="Login" />
        </s:form>
    </s:else>
</body>
</html>