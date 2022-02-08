<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin registration</title>
</head>
<body>
<br>
<br>
<h2 align="center">Admin registration</h2>
<form:form action="registration" modelAttribute="adminForm">
    <table align="center">
        <tr>
            <td align="center">Admin login:</td>
        </tr>
        <tr>
            <td align="center"><label>
                <input type='text' name='username' value=''>
            </label></td>
        </tr>
        <tr>
            <td align="center">Password:</td>
        </tr>
        <tr>
            <td align="center"><label>
                <input type='password' name='password'/>
            </label></td>
        </tr>
        <tr>
            <td align="center">Password confirm:</td>
        </tr>
        <tr>
            <td align="center"><label>
                <input type='password' name='passwordConfirm'/>
            </label></td>
        </tr>
        <tr></tr>
        <tr>
            <td align="center"><input type="submit" value="Save admin"
                                      onclick="window.location.href='${registration}'"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>