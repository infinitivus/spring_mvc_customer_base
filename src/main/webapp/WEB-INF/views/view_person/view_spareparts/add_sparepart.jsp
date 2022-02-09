<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add spare part</title>
</head>
<c:url var="backToList" value="/showAllPerson"/>
<c:url var="assignSparePart" value="/assignSparePartToWork">
    <c:param name="workId" value="${repairWork.id}"/>
</c:url>
<body>
<br>
<table align="center" width="90%">
    <tr>
        <td align="left"><input type="button" value="<- Back to the list"
                                onclick="window.location.href='${backToList}'"/></td>
    </tr></table>
<form:form modelAttribute="partToWork" method="post" action="${assignSparePart}">
    <table align="center" width="90%">
        <tr>
            <td align="center">Name repair work</td>
        </tr>
        <tr>
            <td align="center"><label>
                <input type="text" align="center" value="${repairWork.nameTheWork }" disabled="true"
                       size="130"/>
            </label>
        </tr>
    </table>

    <table align="center" width="90">
        <h4 align="center">Add spare part</h4>
        <tr>
            <td align="center">
                    <form:select size="5" path="id">
                    <form:options items="${spareParts}"/>
                        </form:select>
            <td align="center"><input type="submit" value="Add parts"
                                      onclick="window.location.href='${assignSparePart}'"/>
        </tr>
    </table>
    <table align="center" width="90%" border="1">
        <h3 align="center">Information about spare parts</h3>
        <tr>
            <th>Id</th>
            <th>Name the part</th>
            <th>Article</th>
            <th>Cost</th>
            <th>Apply</th>
        </tr>
        <c:forEach var="parts" items="${repairWork.sparePartsList}">
            <form:hidden path="id"/>
            <c:url var="deleteSparePart" value="/unplugSparePartToWork">
                <c:param name="workId" value="${repairWork.id}"/>
                <c:param name="partId" value="${parts.id}"/>
            </c:url>
            <tr>
                <td align="left" width="2%">${parts.id}</td>
                <td align="left" width="80%">${parts.nameSparePart}</td>
                <td align="center" width="7%">${parts.article}</td>
                <td align="center" width="7%">${parts.costPart}</td>
                <td align="center"width="4%"> <input type="button" value="Delete"
                                                                        onclick="window.location.href='${deleteSparePart}'"/>

            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>