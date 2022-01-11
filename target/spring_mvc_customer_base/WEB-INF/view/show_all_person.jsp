<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>show all person</title>


<body>
<br>
<table align="center" width="90%"  >
    <tr>
        <td><input type="button" value="Add an entry" size="30"
                   onclick="window.location.href='addNewPersonData'"/>
        </td>

        <td>
           <form method="get" action="sortPerson" >
               <input type="submit" value="Sort by:"/>
               <label>
                   <select name="select" size="1">
                       <option value="id">Default</option>
                       <option value="surname">Surname</option>
                       <option value="name">Name</option>
                   </select>
               </label>
           </form>
        </td>

        <td align="right">
            <form method="get" action="searchPerson">
                <label>
                    <input type="text" name="search" placeholder="search through the list" SIZE=40/>
                </label>
                <input type="submit" value="Search"/>
            </form>
        </td>

    </tr>
</table>

<br>

<table align="center" width="90%" border="1" >
    <h3 align="center" >Список клиентов компании</h3>
    <tr>
        <th>Surname</th>
        <th>Name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Full info</th>
    </tr>
    <c:forEach var="pers" items="${allPers}">

        <c:url var="fullInfoButton" value="/fullInfoPerson">
            <c:param name="infoPersId" value="${pers.id}"/>
        </c:url>

        <tr>
            <td align="center">${pers.surname}</td>
            <td align="center">${pers.name}</td>
            <td align="center">${pers.phoneNumber}</td>
            <td align="center">${pers.email}</td>
            <td align="center">${pers.birthday}</td>
            <td align="center">
                <input type="button" value="See"
                       onclick="window.location.href='${fullInfoButton}'"/>

            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>