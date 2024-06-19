<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/qna.css" />
<style>
#newButton {
  background-color: silver; 
  border: 15px;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
#newButton:hover {
  background-color: gray;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    var index = sessionStorage.getItem('index') ? parseInt(sessionStorage.getItem('index')) : 0;

    function loadNextQuestion() {
        var answer = $("#answerForm input[name='answer']").val();
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/ITQuestionServlet",
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
                        	window.location.href = "${pageContext.request.contextPath}/ITResult";
                        }
                    });
                    $('#answerForm').append(nbtn);
                } else {
                    $("#question").html(response.question);
                    index = response.index;
                    sessionStorage.setItem('index', index);  // index 값을 세션 스토리지에 저장합니다.
                }
                $("#answerForm input[name='answer']").val('');  // 폼 초기화
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
