<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>
    <title>add_update data</title>
</head>

<body>
<form:form action="savePersonData" modelAttribute="person">
    <form:hidden path="id"/>
    <h3 align="center">Добавить\Редактировать информацию</h3>
    <table align="center" width="90%">
        <h3 align="center">Персональная информация</h3>
        <tr>
            <td align="center">Last name from 3 to 15 characters</td>
            <td align="center">First name from 3 to 30 characters</td>
            <td align="center">phone number-sample:89011234567</td>
            <td align="center">email-sample:abc@mail.com</td>
            <td align="center">birthday-sample:01.02.1999</td>
        </tr>
        <tr>
            <th align="center">Surname*</th>
            <th align="center">Name*</th>
            <th align="center">Phone number*</th>
            <th align="center">Email</th>
            <th align="center">Birthday</th>
        </tr>
        <tr>
            <td align="center"><form:input path="surname"/></td>
                <%--            <form:errors path="person.surname"/>--%>

            <td align="center"><form:input path="name"/></td>
                <%--            <form:errors path="person.name"/>--%>

            <td align="center"><form:input path="phoneNumber"/></td>
                <%--            <form:errors path="person.phoneNumber"/>--%>

            <td align="center"><form:input path="email"/></td>
                <%--            <form:errors path="person.email"/>--%>

            <td align="center"><form:input path="birthday"/></td>
                <%--            <form:errors path="person.birthday"/>--%>
        </tr>
    </table>

<table align="center" width="90%">
    <h3 align="center">Информация о транспортном средстве</h3>
    <tr>
        <td align="center">1</td>
        <td align="center">2</td>
        <td align="center">3</td>
        <td align="center">4</td>
        <td align="center">5</td>
        <td align="center">6</td>
    </tr>
    <tr>
        <th align="center">Type</th>
        <th align="center">Brand</th>
        <th align="center">Model</th>
        <th align="center">Vin</th>
        <th align="center">Year of release</th>
        <th align="center">Lisece plate</th>
    </tr>
    <tr>
        <td align="center"><form:input path="mobileHome.type"/></td>

        <td align="center"><form:input path="mobileHome.brand"/></td>

        <td align="center"><form:input path="mobileHome.model"/></td>

        <td align="center"><form:input path="mobileHome.vin"/></td>

        <td align="center"><form:input path="mobileHome.yearOfRelease"/></td>

        <td align="center"><form:input path="mobileHome.licensePlate"/></td>
    </tr>
</table>

<table align="center" width="90%">
    <h3 align="center">Ирформация о ремонтных работах</h3>
    <tr>
        <th>Name the work</th>
        <th>Master</th>
        <th>Cost the work</th>
        <th>Date</th>
    </tr>

    <c:forEach var="work" items="${mobileHome.repairWorkList}">
    <tr>
        <td align="center"><p>${work.nameTheWork}</p></td>
<%--        <td align="center"><form:input ${w}/></td>--%>
<%--        <td align="center"><form:input path="repairWork.master"/></td>--%>
<%--        <td align="center"><form:input path="repairWork.costWork"/></td>--%>
<%--        <td align="center"><form:input path="repairWork.date"/></td>--%>

    </tr>
</c:forEach>
</table>


<br>

<input type="submit" value="Save"
       onclick="window.location.href='${savePersonData}'"/>

</form:form>
</body>
</html>