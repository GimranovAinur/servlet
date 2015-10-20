<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><meta charset='UTF-8'><title>LogIn</title></head>
<body>

<div id="form_div">

  <form id="form" action='' method='POST'>

    <div id="email_pwd_div">
      <label>Логин: <br>
        <input type='text' name='login'></label><br>
      <label>Пароль: <br>
        <input type='password' name='pass'></label><br>
    </div>

    <div id="chb_dev">
      <input type='checkbox' name='chb'> Запомнить меня<br>
    </div>

    <div id="enter_div">

    </div>
  </form>
</div>

<div id="message">
  <c:if test="${not empty message}">
    <h3>${message}</h3>
  </c:if>
</div>
</body>
</html>