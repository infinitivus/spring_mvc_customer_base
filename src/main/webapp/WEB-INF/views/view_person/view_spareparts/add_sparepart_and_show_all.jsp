<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Add and list spare parts</title>
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
<form:form action="saveSpareParts" modelAttribute="spareParts">
    <form:hidden path="id"/>
    <table align="center" width="90%" border="1">
        <h3 align="center">New spare part</h3>
        <tr>
            <th align="center" width="80%">Name spare part</th>
            <th align="center" width="10%">Article</th>
            <th align="center" width="10%">Cost</th>
            <th align="center" width="10%">Apply</th>
        </tr>
        <tr>
            <td align="center"><form:input path="nameSparePart" size="130"/></td>
            <td align="center"><form:input path="article" size="10"/></td>
            <td align="center"><form:input path="costPart" size="10"/></td>
            <td align="center"><input type="submit" value="Save" size="10"
                                      onclick="window.location.href='${saveSpareParts}'"/></td>
        </tr>
        <tr>
            <td align="center"><form:errors cssStyle="color: red" path="nameSparePart"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="article"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="costPart"/></td>
        </tr>
    </table>
</form:form>
<br>
<table align="center" width="90%" border="1">
    <h3 align="center">List spare parts</h3>
    <tr>
        <th>Name spare part</th>
        <th>Article</th>
        <th>Cost</th>
        <th>Apply</th>
    </tr>
    <c:forEach var="parts" items="${allParts}">
        <c:url var="editPart" value="/editSpareParts">
            <c:param name="partsId" value="${parts.id}"/>
        </c:url>
        <c:url var="deletePart" value="/deleteSpareParts">
            <c:param name="partsId" value="${parts.id}"/>
        </c:url>
        <tr>
            <td align="left" width="70%">${parts.nameSparePart}</td>
            <td align="center" width="10%">${parts.article}</td>
            <td align="center" width="10%">${parts.costPart}</td>
            <td align="center" width="10%">
                <input type="submit" value="Edit"
                       onclick="window.location.href='${editPart}'"/>
                <input type="submit" value="Delete"
                       onclick="window.location.href='${deletePart}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>