<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin panel</title>
</head>

<c:url var="backToList" value="/showAllPerson"/>

<c:url var="newUser" value="/adminPanel/addUser"/>

<body>
<table align="center" width="90%">
    <tr>
        <td align="left"><input type="button" value="<- Back to the list"
                                onclick="window.location.href='${backToList}'"/></td>
        <td align="right"><input type="button" value="Create new user"
                                 onclick="window.location.href='${newUser}'"/></td>
    </tr>
</table>
<table align="center" width="90%" border="1">
    <h3 align="center">List of users and access rights</h3>
    <tr>
        <th>User id</th>
        <th>User name</th>
        <th>Role</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="user" items="${listUsers}">
        <c:url var="editInfoUser" value="/adminPanel/editUser">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td align="center">${user.id}</td>
            <td align="center">${user.username}</td>
            <td align="center">${user.roles}</td>
            <td align="center"><input type="button" value="Edit user"
                                      onclick="window.location.href='${editInfoUser}'"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
