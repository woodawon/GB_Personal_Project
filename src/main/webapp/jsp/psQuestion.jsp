<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/qna.css" />
</head>
<body>
	<div class="container">
		<section id="main">
			<c:choose>
                <c:when test="${not empty sessionScope.psDB and sessionScope.currentIndex < sessionScope.psDB.size()}">
                    <c:set var="vo" value="${sessionScope.psDB[sessionScope.currentIndex]}" />
                    <h3>${vo.question}</h3>
                    <form action="NextQuestion.do" method="post">
                        <input type="text" name="answer" />
                        <button type="submit">다음 질문</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <h3>모든 질문을 완료했습니다.</h3>
                </c:otherwise>
            </c:choose>
		</section>
	</div>
</body>
</html>