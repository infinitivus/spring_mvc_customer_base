<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>
    <title>add_update data</title>
</head>
<c:url var="backToList" value="/showAllPerson"/>
<body>
<br>
<table align="center" width="90%">
    <tr>
        <td align="left"><input type="button" value="<- Back to the list"
                                onclick="window.location.href='${backToList}'"/></td>
    </tr>
</table>
<form:form action="savePersonData" modelAttribute="person">
    <form:hidden path="id"/>
    <h3 align="center">Add or edit information</h3>
    <table align="center" width="90%">
        <h4 align="center">Personal information</h4>
        <tr>
            <td align="center">Last name from 3 to 15 letters</td>
            <td align="center">First name from 3 to 30 letters</td>
            <td align="center">phone number-sample:89011234567</td>
            <td align="center">email-sample:abc@mail.com</td>
            <td align="center">birthday-sample:01.02.1999</td>
        </tr>
        <tr>
            <td align="center"><form:input path="surname" placeholder="Surname:required"/></td>
            <td align="center"><form:input path="name" placeholder="Name:required"/></td>
            <td align="center"><form:input path="phoneNumber" placeholder="Phone number:required"/></td>
            <td align="center"><form:input path="email" placeholder="Email:optional"/></td>
            <td align="center"><form:input path="birthday" placeholder="Birthday:optional"/></td>
        </tr>
        <tr>
            <td align="center"><form:errors cssStyle="color: red" path="surname"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="name"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="phoneNumber"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="email"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="birthday"/></td>
        </tr>
    </table>
<%--    <form:form modelAttribute="mobileHome">--%>

        <table align="center" width="90%">
            <h4 align="center">Motorhome information</h4>
            <form:hidden path="id"/>
            <tr>
                <td align="center">Type from 3 to 15 letters</td>
                <td align="center">Brand from 3 to 15 letters</td>
                <td align="center">Model from 3 to 15 letters</td>
                <td align="center">Vin from 3 to 30 characters</td>
                <td align="center">Year of release: 1999</td>
                <td align="center">Lisense plate from 3 to 11 characters</td>
            </tr>
            <tr>
                <td align="center"><form:input path="mobileHome.type" placeholder="Type:optional"/></td>
                <td align="center"><form:input path="mobileHome.brand" placeholder="Brand:optional"/></td>
                <td align="center"><form:input path="mobileHome.model" placeholder="Model:optional"/></td>
                <td align="center"><form:input path="mobileHome.vin" placeholder="Vin:optional"/></td>
                <td align="center"><form:input path="mobileHome.yearOfRelease" placeholder="Year of release:optional"/></td>
                <td align="center"><form:input path="mobileHome.licensePlate" placeholder="Lisense plate:optional"/></td>
            </tr>
            <tr>
                <td align="center"><form:errors path="mobileHome.type"/></td>
                <td align="center"><form:errors path="mobileHome.brand"/></td>
                <td align="center"><form:errors path="mobileHome.model"/></td>
                <td align="center"><form:errors path="mobileHome.vin"/></td>
                <td align="center"><form:errors path="mobileHome.yearOfRelease"/></td>
                <td align="center"><form:errors path="mobileHome.licensePlate"/></td>
            </tr>
        </table>
        <br>
        <table align="center" width="90%">
            <tr>
                <td align="left"><input type="submit" value="Save"
                                        onclick="window.location.href='${savePersonData}'"/></td>
            </tr>
        </table>
    </form:form>
<%--</form:form>--%>
</body>
</html>