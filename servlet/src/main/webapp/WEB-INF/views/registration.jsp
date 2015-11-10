<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/reg.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="./bootstrap.css" media="screen">

    <script type="text/javascript" language="JavaScript" src="<c:url value="/resources/js/reg_checker.js"/> "></script>
    <script type="text/javascript" language="JavaScript" src="<c:url value="/resources/js/counter.js"/> "></script>
    <title>Registration</title>

</head>

<body>
<!--NAVBAR-->
<div class="bs-docs-section clearfix">
    <div class="row">
        <div class="col-lg-12">
            <div class="bs-component">
                <nav class="navba r navbar-inverse">
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
                                <li><a href="<c:url value="/main"/>">Main <span class="sr-only">(current)</span></a></li>
                                <li><a href="<c:url value="/posts"/>">Posts</a></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <c:if test="${not empty user}">
                                    <li>
                                        <a href="<c:url value="/login"/>">Exit <span class="glyphicon glyphicon-log-out"></span></a>
                                    </li>
                                </c:if>
                                <c:if test="${empty user}">
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

    <!--FORM-->
    <div id="login_form" class="centered">
        <div class="row">
            <div class="col-lg-6">
                <div class="well bs-component">
                    <form class="form-horizontal" id="form" name="registration_form" class="reg_class" onsubmit="return formChecker()" action="<c:url value="/registration"></c:url>" method='POST'>
                        <fieldset>
                            <legend>Registration</legend>
                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="mail">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                                <div class="col-lg-10">
                                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="pwd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="about" class="col-lg-2 control-label">About:</label>
                                <div class="col-lg-10">
                                    <textarea class="form-control" rows="3" id="about" onkeyup="sym_count(value)" maxlength="50" name="about"></textarea>
                                    <span class="help-block">Symbols <b id="symbols">0</b>/<b>50</b></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Radios</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="sex" id="optionsRadios1" value="1" checked="">
                                            Male
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="sex" id="optionsRadios2" value="option2">
                                            Female
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="chb"> Subscription
                                </label>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <botton type="reset" class="btn btn-primary">Remove</botton>
                                    <input type="submit" class="btn btn-primary" value="Sign In"/>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="left_bot">
            <p>&reg; Gimranov Ainur</p>
        </div>
    </footer>
</div>

</body>

</html>