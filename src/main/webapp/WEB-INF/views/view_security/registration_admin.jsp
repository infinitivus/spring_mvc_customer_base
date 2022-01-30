<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>Admin registration</title>
</head>

<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>

<body>
<h2>Admin registration</h2>
<form:form action="registration" modelAttribute="adminForm">
    <table>
        <tr>
            <td>User:</td>
            <td><label>
                <input type='text' name='username' value=''>
            </label></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><label>
                <input type='password' name='password' />
            </label></td>
        </tr>
        <tr>
        <td>Password confirm:</td>
        <td><label>
            <input type='password' name='passwordConfirm' />
        </label></td>
        </tr>
        <tr>
            <td><input type="submit" value="Apply"
    onclick="window.location.href='${registration}'"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>