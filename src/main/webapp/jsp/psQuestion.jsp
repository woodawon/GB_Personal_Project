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
        var answer = $("#answerForm input[name='answer']:checked").val();
        if (!answer) {
            alert("답변을 선택해주세요.");
            return;
        }
        console.log("Submitting answer: " + answer + " with index: " + index);  // 로그 추가
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/PTQuestionServlet",
            data: { index: index, answer: answer },
            dataType: "json",
            success: function(response) {
                if (response.question === "모든 질문을 완료했습니다.") {
                    $("#question").html(response.question);
                    $("#answerForm").hide();
                    var nbtn = $('<button/>', {
                        text: '결과 확인하러 가기', 
                        id: 'nbtn',
                        click: function() { 
                            window.location.href = "${pageContext.request.contextPath}/PTResult";
                        }
                    });
                    $('#answerForm').append(nbtn);
                } else {
                    $("#question").html(response.question);
                    index = response.index;
                    sessionStorage.setItem('index', index);  // index 값을 세션 스토리지에 저장합니다.
                }
                $("#answerForm input[name='answer']").prop('checked', false);  // 폼 초기화
            },
            error: function(xhr, status, error) {
                console.error("AJAX error: " + status + " - " + error);  // 에러 로그 추가
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
                <input type="radio" name="answer" value="1" />전혀 그렇지 않다
                <input type="radio" name="answer" value="2" />그렇지 않다
                <input type="radio" name="answer" value="8" />그렇다
                <input type="radio" name="answer" value="9" />매우 그렇다
                <button type="submit">다음 질문</button>
            </form>
        </section>
    </div>
</body>
</html>
