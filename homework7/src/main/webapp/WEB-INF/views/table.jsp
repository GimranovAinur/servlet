
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="info.kpfu.ru.utils.DB" %>
<html>
<head>
    <title>database</title>
    <style>
      table{
        border-collapse: collapse;
        border:3px solid black;
      }
      tr{
        border-collapse: collapse;
        border: 3px solid black;
      }
      td{
        border-collapse: collapse;
        border: 3px solid black;
      }
    </style>
</head>
<body>
  <table cellpadding="10" style="margin: 20px">
    <tr style="text-align: center">
      <th>Почта</th>
      <th>Пароль</th>
      <th>Пол</th>
      <th>Подписка</th>
    </tr>

    <tr>
      <td><%=users.get(i)[0]%></td>
      <td><%=users.get(i)[1]%></td>
      <td><%=users.get(i)[2]%></td>
      <td><%=users.get(i)[3]%></td>
    </tr>
    <%
        i++;
      }
    %>
  </table>
</body>
</html>
