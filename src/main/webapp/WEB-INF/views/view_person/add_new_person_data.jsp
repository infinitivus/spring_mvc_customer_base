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
    <h3 align="center">Add or edit information</h3>
    <table align="center" width="90%">
        <h3 align="center">Personal information</h3>
        <tr>
            <td align="center">Last name from 3 to 15 characters</td>
            <td align="center">First name from 3 to 30 characters</td>
            <td align="center">phone number-sample:89011234567</td>
            <td align="center">email-sample:abc@mail.com</td>
            <td align="center">birthday-sample:01.02.1999</td>
        </tr>
        <tr>
            <td align="center"><form:input path="surname" placeholder="Surname*"/></td>
<%--            <form:errors path="surname"/>--%>
            <td align="center"><form:input path="name" placeholder="Name*"/></td>
<%--            <form:errors path="name"/>--%>
            <td align="center"><form:input path="phoneNumber" placeholder="Phone number*"/></td>
<%--            <form:errors path="phoneNumber"/>--%>
            <td align="center"><form:input path="email" placeholder="Email"/></td>
<%--            <form:errors path="email"/>--%>
            <td align="center"><form:input path="birthday" placeholder="Birthday"/></td>
<%--            <form:errors path="birthday"/>--%>
        </tr>
    </table>
    <table align="center" width="90%">
        <h3 align="center">Motorhome information</h3>
        <form:hidden path="mobileHome.id"/>
        <tr>
            <td align="center">1</td>
            <td align="center">2</td>
            <td align="center">3</td>
            <td align="center">4</td>
            <td align="center">5</td>
            <td align="center">6</td>
        </tr>
        <tr>
            <td align="center"><form:input path="mobileHome.type" placeholder="Type"/></td>
<%--            <form:errors path="mobileHome.type"/>--%>
            <td align="center"><form:input path="mobileHome.brand" placeholder="Brand"/></td>
<%--            <form:errors path="mobileHome.brand"/>--%>
            <td align="center"><form:input path="mobileHome.model" placeholder="Model"/></td>
<%--            <form:errors path="mobileHome.model"/>--%>
            <td align="center"><form:input path="mobileHome.vin" placeholder="Vin"/></td>
<%--            <form:errors path="mobileHome.vin"/>--%>
            <td align="center"><form:input path="mobileHome.yearOfRelease" placeholder="Year of release"/></td>
<%--            <form:errors path="mobileHome.yearOfRelease"/>--%>
            <td align="center"><form:input path="mobileHome.licensePlate" placeholder="Lisense plate"/></td>
<%--            <form:errors path="mobileHome.licensePlate"/>--%>
        </tr>
    </table>
    <br>
    <input type="submit" value="Save"
           onclick="window.location.href='${savePersonData}'"/>
</form:form>
</body>
</html>