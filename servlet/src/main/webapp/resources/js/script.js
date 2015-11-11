$(document).ready(function(){
    $('#post_btn').click(function(e){
        e.preventDefault();
        $(this).text("Waiting...");
        $(this).attr("disabled", true);
        var textForPost = $('textarea').val();
        if( !textForPost ){
            alert("Write down at least one symbol");
            return false;
        }
        $.post("<c:url value='/posts'/>", {"post":textForPost}, function(response){
            $('#post_btn').text("Post").attr("disabled", false);
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
            $("html,body").animate({scrollTop:$(document).height()},"fast");
        },
            'json'
        ).fail(function (){
            $('#post_btn').text("send").attr("disabled", false);
            alert("Sorry, can't send a post. Try again!");
        })
    });
});