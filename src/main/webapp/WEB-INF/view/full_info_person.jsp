<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>
    <title>full info person</title>

<body>
<br>

<c:url var="updateButton" value="/updateInfoPerson">
    <c:param name="infoPersId" value="${pers.id}"/>
</c:url>

<c:url var="deleteButton" value="/deleteInfoPerson">
    <c:param name="infoPersId" value="${pers.id}"/>
</c:url>

<input type="button" value="Update"
       onclick="window.location.href='${updateButton}'"/>

<input type="button" value="Delete"
       onclick="window.location.href='${deleteButton}'"/>

<%--Создать кнопку возвращения к общему списку клиентов--%>

<br>
<table align="center" width="90%" border="1">
    <h3 align="center">Информация о клиенте</h3>
    <tr>
        <th>Id</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Birthday</th>
    </tr>

    <tr>
        <td align="center">${pers.id}</td>
        <td align="center">${pers.surname}</td>
        <td align="center">${pers.name}</td>
        <td align="center">${pers.phoneNumber}</td>
        <td align="center">${pers.email}</td>
        <td align="center">${pers.birthday}</td>
    </tr>
</table>

<table align="center" width="90%" border="1">
<h3 align="center">Информация о доме на колесах</h3>
<tr>
    <th>Type</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Vin</th>
    <th>Year of release</th>
    <th>Lisence plate</th>
</tr>

<tr>
    <td align="center">${home.type}</td>
    <td align="center">${home.brand}</td>
    <td align="center">${home.model}</td>
    <td align="center">${home.vin}</td>
    <td align="center">${home.yearOfRelease}</td>
    <td align="center">${home.licensePlate}</td>
</tr>
</table>

<table align="center" width="90%" border="1" >
    <h3 align="center" >Ирформация о ремонтных работах</h3>
    <tr>
        <th>Name the work</th>
        <th>Master</th>
        <th>Cost the work</th>
        <th>Date</th>
    </tr>
    <c:forEach var="repair" items="${work}">

<%--    <c:url var="fullInfoButton" value="/fullInfoPerson">--%>
<%--        <c:param name="infoPersId" value="${pers.id}"/>--%>
<%--    </c:url>--%>

    <tr>
        <td align="center">${repair.nameTheWork}</td>
        <td align="center">${repair.master}</td>
        <td align="center">${repair.costWork}</td>
        <td align="center">${repair.date}</td>


<%--        <td align="center">--%>
<%--            <input type="button" value="See"--%>
<%--                   onclick="window.location.href='${fullInfoButton}'"/>--%>


    </tr>
    </c:forEach>
</table>

</body>
</html>