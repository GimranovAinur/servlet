<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><meta charset='UTF-8'><title>LogIn</title></head>
<body>
<c:if test="${not empty message}">
  <h3>${message}</h3>
</c:if>
<form action='http://localhost:8080/login' method='POST'>
  <label>Логин: <br>
    <input type='text' name='login'></label><br>
  <label>Пароль: <br>
    <input type='password' name='pass'></label><br>
  <input type='checkbox' name='chb'> Запомнить меня<br>
  <input type='submit' value='Войти'>
</form>
</body>
</html>