<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add/edit repair work and spare parts</title>
</head>
<c:url var="backToList" value="/showAllPerson"/>
<c:url var="saveRepairWork" value="/saveRepairWork">
    <c:param name="mobileHomeId" value="${mobileHome.id}"/>
</c:url>
<body>
<br>
<table align="center" width="90%">
    <tr>
        <td align="left"><input type="button" value="<- Back to the list"
                                onclick="window.location.href='${backToList}'"/></td>
    </tr>
</table>
<form:form modelAttribute="newRepairWork" method="POST" action="${saveRepairWork}">
    <table bgcolor="white" align="center" width="90%" border="1">
        <h3 align="center">Add repair work</h3>
        <tr>
            <td>Mobile home: Brand:<label>
                <input type="text" value="${mobileHome.brand }" disabled="true"/>
            </label>
            <td> Model:<label>
                <input type="text" value="${mobileHome.model }" disabled="true"/>
            </label>
            <td>Vin:<label>
                <input type="text" value="${mobileHome.vin }" disabled="true"/>
            </label>
            <td> Year:<label>
                <input type="text" value="${mobileHome.yearOfRelease }" disabled="true"/>
            </label>
        </tr>
    </table>
    <table bgcolor="white" align="center" width="90%" border="1">
        <tr>
            <th>Name new repair work</th>
            <th>Master</th>
            <th>Cost</th>
            <th>Date</th>
            <th>Apply</th>
        </tr>
        <tr>
            <td align="left"><form:input path="nameTheWork" placeholder="100 letters max" size="120"/></td>
            <td align="center"><form:input path="master" placeholder="10 letter max" size="10"/></td>
            <td align="center"><form:input path="costWork" placeholder="9 dig max" size="6"/></td>
            <td align="center"><form:input path="date" placeholder="01.01.1999" size="10"/></td>
            <td align="center"><input type="submit" value="Add" size="4"/></td>
        </tr>
        <tr>
            <td align="center"><form:errors cssStyle="color: red" path="nameTheWork"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="master"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="costWork"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="date"/></td>
        </tr>
    </table>
</form:form>
<h3 align="center">Information about repair work and spare parts</h3>
<c:forEach var="repair" items="${mobileHome.repairWorkList}">
    <c:url var="deleteWork" value="/deleteRepairWork">
        <c:param name="workId" value="${repair.id}"/>
        <c:param name="mobileHomeId" value="${mobileHome.id}"/>
    </c:url>
    <c:url var="addPart" value="/showAllSpareParts/addSparePartToWork">
        <c:param name="workId" value="${repair.id}"/>
    </c:url>
    <table bgcolor="white" align="center" width="90%" border="1">
        <tr>
            <th>Name the work</th>
            <th>Master</th>
            <th>Cost</th>
            <th>Date</th>
            <th>Apply</th>
        </tr>
        <tr>
            <td align="left" width="63%">${repair.nameTheWork}</td>
            <td align="center" width="7%">${repair.master}</td>
            <td align="center" width="7%">${repair.costWork}</td>
            <td align="center" width="7%">${repair.date}</td>
            <td align="center" width="16%">
                <input type="submit" value="Delete"
                       onclick="window.location.href='${deleteWork}'"/>
                <input type="submit" value="Add part"
                       onclick="window.location.href='${addPart}'"/>
            </td>
        </tr>
    </table>
    <table bgcolor="white" align="center" width="90%" border="1">
        <tr>
            <th align="left" width="84%">Name spare parts</th>
            <th align="center" width="8%">Article</th>
            <th align="center" width="8%">Cost</th>
        </tr>
        <c:forEach var="parts" items="${repair.sparePartsList}">
            <tr>
                <td align="left" width="84%">${parts.nameSparePart}</td>
                <td align="left" width="8%">${parts.article}</td>
                <td align="left" width="8%">${parts.costPart}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
</c:forEach>
</body>
</html>