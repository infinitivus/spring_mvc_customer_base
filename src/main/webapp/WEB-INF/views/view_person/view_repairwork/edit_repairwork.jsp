<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>edit repair work, add spare parts </title>
</head>
<body>

<c:url var="saveRepairWork" value="/saveRepairWork">
    <c:param name="mobileHomeId" value="${mobileHome.id}"/>
    <c:param name="workId" value="${newRepairWork.id}"/>
</c:url>

<form:form modelAttribute="newRepairWork" method="POST" action="${saveRepairWork}">
    <form:hidden path="id"/>
    <table align="center" width="90%" border="1">
        <tr>
            <th>Name edit repair work</th>
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
            <td align="center"><input type="submit" value="Edit" size="4"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>



<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>

<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>--%>
<%--    <title>add_update data</title>--%>
<%--</head>--%>

<%--<body>--%>
<%--<form:form action="/saveRepairWork" modelAttribute="repairWork">--%>
<%--    <form:hidden path="id"/>--%>
<%--<h3 align="center">Edit repair work</h3>--%>
<%--<table align="center" width="90%" border="1">--%>
<%--    <h3 align="center"></h3>--%>

<%--    <tr>--%>
<%--        <th align="center">Name the work</th>--%>
<%--        <th align="center">Cost the work</th>--%>
<%--        <th align="center">Apply</th>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td align="center" width="80%"><form:input path="nameTheWork" size="130"/></td>--%>
<%--        <td align="center" width="10%"><form:input path="costWork" size="10"/></td>--%>
<%--        <td align="center" width="10%"> <input type="submit" value="Save" size="10"--%>
<%--                                   onclick="window.location.href='${saveRepairWork}'"/></td>--%>
<%--    </tr>--%>
<%--</table>--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>
