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
<body>
<td align="left"><input type="button" value="<- Back to the list"
                        onclick="window.location.href='${backToList}'"/></td>
<form:form action="saveEditedUser" modelAttribute="userForm">
    <c:url var="deleteUser" value="/adminPanel/deleteUser">
        <c:param name="userId" value="${userForm.id}"/>
    </c:url>
    <form:hidden path="id"/>
    <form:hidden path="password"/>
    <h3 align="center">Редактировать информацию о пользователе</h3>
    <br>
    <table align="center" width="90%">
        <h3 align="center">Информация о авторизации</h3>
        <tr>
            <th align="center">User name</th>
            <th align="center">Roles</th>
            <th align="center">Action</th>
        </tr>
        <tr>
            <td align="center"><form:input path="username"/></td>
            <td align="center">

                <form:form modelAttribute="userRole">
                    ADMIN<form:radiobutton path="role" value="ROLE_ADMIN" id="1"/>
                    MASTER<form:radiobutton path="role" value="ROLE_MASTER" id="2"/>
                    MANAGER<form:radiobutton path="role" value="ROLE_MANAGER" id="3"/>
                </form:form>
            </td>
            <td align="center">
                <input type="submit" value="Edit user"
                       onclick="window.location.href='${saveEditedUser}'"/>
                <input type="button" value="Delete user"
                       onclick="window.location.href='${deleteUser}'"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
