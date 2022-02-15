<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>
    <title>edit spareparts</title>
</head>
<body>
<form:form action="saveSpareParts" modelAttribute="spareParts">
    <form:hidden path="id"/>
    <h3 align="center">Edit spare part</h3>
    <table align="center" width="90%" border="1">
        <h3 align="center"></h3>
        <tr>
            <th align="center" width="70%">Name spare part</th>
            <th align="center" width="10%">Article</th>
            <th align="center" width="10%">Cost</th>
            <th align="center" width="10%">Apply</th>
        </tr>
        <tr>
            <td align="center" width="80%"><form:input path="nameSparePart" size="130" placeholder="100 letters max"/></td>
            <td align="center" width="10%"><form:input path="article" size="10" placeholder="10 letter max"/></td>
            <td align="center" width="10%"><form:input path="costPart" size="10" placeholder="9 dig max"/></td>
            <td align="center" width="10%"> <input type="submit" value="Edit" size="10"
                                                   onclick="window.location.href='${saveSpareParts}'"/></td>
        </tr>
        <tr>
            <td align="center"><form:errors cssStyle="color: red" path="nameSparePart"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="article"/></td>
            <td align="center"><form:errors cssStyle="color: red" path="costPart"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
