<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>MainPage</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="../css/default.css" />
<link rel="stylesheet" href="../css/animation.css" />
<link rel="stylesheet" href="../css/main.css" />
</head>
<body>
	<div class="container">
		<section id="main">
			<h1>Welcome!</h1>
			<div id="box">
				<form action="itQuestion.jsp" method="post" id="btn">
					<button type="submit" class="btn-outline-danger">IT 인지도
						체크하기</button>
				</form>
				<form action="psQuestion.jsp" method="post" id="btn">
					<button type="submit" class="btn-outline-danger">성격 테스트
						하러가기</button>
				</form>
			</div>
			<form action="DeleteDB.do" method="post" id="btn">
				<button type="button" class="btn-outline-danger">
				DB 초기화
				</button>
			</form>
		</section>
	</div>
</body>
</html>