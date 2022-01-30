<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<title>Log in with your account</title>
<html>
<body>


<form method="POST" action="${contextPath}/login" class="form-signin">
    <table align="center" width="90%">
        <h2 align="center" class="form-heading">Log in</h2>
        <span>${message}</span>
        <tr>
            <td align="center">
                <label>
                    <input name="username" type="text" class="form-control" placeholder="Username"
                           autofocus="true"/>
                </label>
            </td>
        </tr>
        <br><br>
        <tr>
            <td align="center">
                <label>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                </label>

            </td>
        </tr>
        <br><br>
        <tr>
            <td align="center">
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </td>
        </tr>
    <br><br>
        <tr>
            <td align="center">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>