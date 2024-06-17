<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/qna.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
	var index = sessionStorage.getItem('index') ? parseInt(sessionStorage.getItem('index')) : 0;
    function loadNextQuestion() {
        $.ajax({
            type: "POST",
            url: "NextQuestionServlet",
            data: { index: index },
            dataType: "json",
            success: function(response) {
                if (response.question === "모든 질문을 완료했습니다.") {
                    $("#question").html(response.question);
                    $("#answerForm").hide();
                } else {
                    $("#question").html(response.question);
                    index = response.index;
                }
            }
        });
    }

    $("#answerForm").submit(function(event) {
        event.preventDefault();
        loadNextQuestion();
    });

    loadNextQuestion();
});
</script>
</head>
<body>
    <div class="container">
        <section id="main">
            <h3 id="question"></h3>
            <form id="answerForm">
                <input type="text" name="answer" />
                <button type="submit">다음 질문</button>
            </form>
        </section>
    </div>
</body>
</html>
