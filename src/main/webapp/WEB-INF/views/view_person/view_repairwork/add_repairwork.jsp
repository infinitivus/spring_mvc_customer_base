<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add/edit repair work</title>
</head>
<body>

<c:url var="saveRepairWork" value="/saveRepairWork">
    <c:param name="mobileHomeId" value="${mobileHome.id}"/>
</c:url>

<form:form modelAttribute="newRepairWork" method="POST" action="${saveRepairWork}">
    <table align="center" width="90%">
        <h3 align="center">Add repair work</h3>
        <tr>
            <td>Mobile home: Brand:<input type="text" value="${mobileHome.brand }" disabled="true"/>

            <td> Model:<input type="text" value="${mobileHome.model }" disabled="true"/>

            <td>Vin:<input type="text" value="${mobileHome.vin }" disabled="true"/>

            <td> Year:<input type="text" value="${mobileHome.yearOfRelease }" disabled="true"/>
        </tr>
    </table>
    <table align="center" width="90%" border="1">
        <tr>
            <th>Name new repair work</th>
            <th>Master</th>
            <th>Cost</th>
            <th>Date</th>
            <th>Apply</th>
        </tr>
        <tr>
            <td align="left"><form:input path="nameTheWork" size="120"/></td>
            <td align="center"><form:input path="master" size="10"/></td>
            <td align="center"><form:input path="costWork" size="6"/></td>
            <td align="center"><form:input path="date" size="10"/></td>
            <td align="center"><input type="submit" value="Add" size="4"/></td>
        </tr>
    </table>
</form:form>
<table align="center" width="90%" border="1">
    <h3 align="center">Information about repair work</h3>
    <tr>
        <th>Name the work</th>
        <th>Master</th>
        <th>Cost</th>
        <th>Date</th>
        <th>Apply</th>
    </tr>
    <c:forEach var="repair" items="${mobileHome.repairWorkList}">

        <c:url var="deleteWork" value="/deleteRepairWork">
            <c:param name="workId" value="${repair.id}"/>
            <c:param name="mobileHomeId" value="${mobileHome.id}"/>
        </c:url>

        <c:url var="addPart" value="/addSparePartToWork">
            <c:param name="workId" value="${repair.id}"/>
        </c:url>

        <tr>
            <td align="left" width="65%">${repair.nameTheWork}</td>
            <td align="center" width="5%">${repair.master}</td>
            <td align="center" width="5%">${repair.costWork}</td>
            <td align="center" width="5%">${repair.date}</td>
            <td align="center" width="20%">
                <input type="submit" value="Delete"
                       onclick="window.location.href='${deleteWork}'"/>
                <input type="submit" value="Add part"
                       onclick="window.location.href='${addPart}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>