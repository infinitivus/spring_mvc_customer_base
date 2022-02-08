<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Edit user form</title>
</head>

<c:url var="backToList" value="/adminPanel"/>
<%--     delete user         --%>
<body>
<form:form action="saveNewUser" modelAttribute="userForm">
    <h3 align="center">Добавить информацию о пользователе</h3>
    <br>
    <td align="left"><input type="button" value="<- Back to the list"
                            onclick="window.location.href='${backToList}'"/></td>
    <br>
    <table align="center" width="90%">
        <h3 align="center">Информация о авторизации</h3>
        <tr>
            <th align="center">User name</th>
            <th align="center">Password</th>
            <th align="center">Password confirm</th>
            <th align="center">Roles</th>
        </tr>
        <tr>
            <td align="center"><form:input path="username" /></td>
            <td align="center"><form:input path="password"/></td>
            <td align="center"><form:input path="passwordConfirm"/></td>
            <td align="center">
<%--                <form:checkboxes path="roles" items="${listRoles}" />--%>

                ADMIN<form:checkbox path="roles" value="ROLE_ADMIN" id="1" />
                MANAGER<form:checkbox path="roles" value="ROLE_MANAGER" id="2"/>
                MASTER<form:checkbox path="roles" value="ROLE_MASTER" id="3"/>

            </td>
            <td align="center">
                <input type="submit" value="Edit"
                       onclick="window.location.href='${saveNewUser}'"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

