<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><meta charset='UTF-8'>
    <title>Registration</title>
    <script type="text/javascript" language="javascript">
        function formChecker(){
            if (!checkEmail(document.registration_form.mail.value)) {
                alert("Invalid E-mail address!!!");
            }
            var inp = document.getElementsByName('sex');
            if (!inp[0].checked && !inp[1].checked) {
                alert("Выберите свой пол!!!");
            }
        }
        function checkEmail(email){
            var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
            return pattern.test(email);
        }
        function sym_count(text){
            document.getElementById('symbols').innerHTML=text.length;
        }
    </script>
</head>
<body>
<div id="form_div">
    <form id="form" name="registration_form" class="reg_class" onsubmit="return formChecker()" action='http://localhost:8080/registration' method='POST'>
        <div id="email_pwd_div">
            <label>Ваш e-mail: <br>
                <input type='text' name='mail'></label><br>
            <label>Пароль: <br>
                <input type='password' name='pwd'></label><br>
        </div>

        <div id="sex_div">
            <input type='radio' name='sex' value='1'> Male <input type='radio' name='sex' value='0'> Female<br>
        </div>

        <div id="info_div">
            <p>
                <label><p>Напишите про себя:</p>
                    <textarea id="about" onkeyup="sym_count(value)" maxlength="50" name="about"></textarea>
                </label>
            </p>
            <p>символов <b id="symbols">0</b>/<b>50</b></p>
        </div>

        <div id="checkbox_div">
            <input type='checkbox' name='chb'> Подписаться на рассылку<br>
        </div>

        <div id="submit_div">
            <input type='submit' value='Регистрация'>
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