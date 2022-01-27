<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>
    <title>full info person</title>

<body>
<br>

<c:url var="updateButtonPerson" value="/updateInfoPerson">
    <c:param name="infoPersId" value="${pers.id}"/>
</c:url>

<c:url var="updateButtonRepair" value="/updateInfoRepair">
    <c:param name="infoPersId" value="${pers.id}"/>
</c:url>

<c:url var="deleteButton" value="/deleteInfoPerson">
    <c:param name="infoPersId" value="${pers.id}"/>
</c:url>

<c:url var="backToList" value="/"/>

<table align="center" width="90%">
    <tr>
        <td align="left"><input type="button" value="<- Back to the list"
                                onclick="window.location.href='${backToList}'"/></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>

        <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
            <td align="right"><input type="button" value="Update information person"
                                     onclick="window.location.href='${updateButtonPerson}'"/></td>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MASTER')">
            <td align="right"><input type="button" value="Update repair information"
                                     onclick="window.location.href='${updateButtonRepair}'"/></td>
        </security:authorize>

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <td align="right"><input type="button" value="Delete full information"
                                     onclick="window.location.href='${deleteButton}'"/></td>
        </security:authorize>

    </tr>
</table>
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
        <td align="center">${pers.mobileHome.type}</td>
        <td align="center">${pers.mobileHome.brand}</td>
        <td align="center">${pers.mobileHome.model}</td>
        <td align="center">${pers.mobileHome.vin}</td>
        <td align="center">${pers.mobileHome.yearOfRelease}</td>
        <td align="center">${pers.mobileHome.licensePlate}</td>
    </tr>
</table>

<table align="center" width="90%" border="1">
    <h3 align="center">Ирформация о ремонтных работах</h3>
    <tr>
        <th>Name the work</th>
        <th>Master</th>
        <th>Cost the work</th>
        <th>Date</th>
    </tr>
    <c:forEach var="repair" items="${pers.mobileHome.repairWorkList}">
        <tr>
            <td align="center">${repair.nameTheWork}</td>
            <td align="center">${repair.master}</td>
            <td align="center">${repair.costWork}</td>
            <td align="center">${repair.date}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>