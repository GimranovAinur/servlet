<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><meta charset='UTF-8'><title>Registration</title></head>
<body>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<form action='http://localhost:8080/registration' method='POST'>
    <label>Ваш e-mail: <br>
    <input type='text' name='mail'></label><br>
    <label>Пароль: <br>
    <input type='password' name='pwd'></label><br>
    <input type='radio' name='sex' value='1'> Male <input type='radio' name='sex' value='0'> Female<br>
    <input type='checkbox' name='chb'> Подписаться на рассылку<br>
    <input type='submit' value='Регистрация'>
</form>
</body>
</html>