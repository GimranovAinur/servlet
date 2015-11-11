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
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Posts</title>

    <script>
        $(document).ready(function(){
            $('#post_btn').click(function(e){
                var textForPost = $('textarea').val();
                e.preventDefault();
                if( !textForPost ){
                    alert("Type something, please" +
                            "");
                    return false;
                }
                $.post("<c:url value='/posts'/>", {"post":textForPost}, function(response){
                            $('#post_btn');
                            $('textarea#post').val('');
                            $('#postPlace').append(
                                    "<div class='panel panel-default'>"+
                                    "<div class='panel-heading'>" +
                                    "<h1 class='panel-title'>"+
                                    "<p>"+response.userName+"</p>"+
                                    "</h1>"+
                                    "</div>"+
                                    "<div class='panel-body'>"+
                                    "<p>"+ response.postText + "</p>"+
                                    "</div>"+
                                    "<div class='panel-footer' style='padding-bottom:50px;'>"+
                                    "<span class='pull-left'>"+
                                    "Published time : "+
                                    "<p>"+response.postTime+"</p>"+
                                    "</span>"+
                                    "<div id='post_id' hidden>"+response.id+"</div>"+
                                    "</div>"
                            );
                        },
                        'json'
                )
            });
        });
    </script>
    <style>
        .left_bot {
            position:fixed;
            top:95%;
            width: 200px;
            height: 0px;
        }
    </style>
</head>

<body>

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

    <div id="posts" style="padding-top:50px;">
        <div class="container">

            <div class="row">

                <div class="col-md-2"></div>

                <div class="col-md-8">

                    <div id="postPlace">

                        <c:forEach items="${posts}" var="p">

                            <div class="panel panel-default">

                                <div  class="panel-default panel-heading" >

                                    <h1 class="panel-title">
                                        <c:out value="${p.getUser_name()}"/>
                                    </h1>

                                </div>
                                <div class="panel-body">
                                    <p><c:out value="${p.getText()}"/></p>
                                </div>
                                <div class="panel-footer" style="padding-bottom:50px;">

                                    <button id="likes" class="submit pull-right btn btn-primary">
                                        <span class="glyphicon glyphicon-thumbs-up"></span>
                                        <span id="likesCount">0</span>
                                    </button>
                                        <span class="pull-left">
                                            <p>Published time :<br> <c:out value="${p.getPub_date()}"/></p>
                                        </span>

                                </div>

                            </div>

                        </c:forEach>

                    </div>

                    <br>

                    <div id="post">

                        <form class="send-message" accept-charset="UTF-8" action="<c:url value=""/>" method="POST">

                            <div class="form-group">
                                <textarea spellcheck="false" name="post" class="form-control" id="text" placeholder="Write something..."></textarea>
                            </div>
                            <c:if test="${not empty user}">
                                <button type="submit" id="post_btn" class="btn btn-primary">Post</button>
                            </c:if>
                            <c:if test="${empty user}">
                                <a href="" class="btn btn-primary disabled">Post</a><br><br>
                                <label class="well well-sm" for="text">Comments can be posted only by authorized users</label>
                            </c:if>
                        </form>

                        <br>
                        <br>

                        <c:if test="${not empty message}">
                            <p style="text-align: center">
                                <c:out value="${message}"/>
                            </p>
                        </c:if>

                    </div>

                </div>

                <div class="col-md-2"></div>

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
