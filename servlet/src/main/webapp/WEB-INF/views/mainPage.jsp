<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

  <meta content="text/html" charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
  <link href="<c:url value="/resources/css/bootstrap-theme.css"/>" rel="stylesheet">
  <link rel="stylesheet" href="./bootstrap.css" media="screen">
  <title>Main</title>

  <style>
    .centered {
      position: absolute;
      top: 37%;
      left: 31.6%;
      width: 200px;
      height:100px;
    }
    .left_bot {
      position:fixed;
      top:95%;
      width: 200px;
      height: 0px;
    }
    h1{
      font-size:120px;
    }
  </style>
</head>

<body>

<div class="bs-docs-section clearfix">
  <div class="row">
    <div class="col-lg-12">
      <div class="bs-component">
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="<c:url value="/main"/>">Welcome</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
              <ul class="nav navbar-nav">
                <li><a href="<c:url value="/posts"/>">Posts</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty user}">
                  <li>
                    <a name="exit" value="exit" href="<c:url value="/login?status=1"/>">Exit <span class="glyphicon glyphicon-log-out"></span></a>
                  </li>
                </c:if>
                <c:if test="${empty user}">
                  <li>
                    <a href="<c:url value="/registration"/>">Registration <span class="glyphicon glyphicon-check"></span></a>
                  </li>
                  <li>
                    <a href="<c:url value="/login"/>">LogIn <span class="glyphicon glyphicon-log-in"></span></a>
                  </li>
                </c:if>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </div>
  </div>

  <div class="centered">
    <h1>Welcome</h1>
  </div>
  <footer>
    <div class="left_bot">
      <p>&reg; Gimranov Ainur</p>
    </div>
  </footer>
</div>

</body>

</html>