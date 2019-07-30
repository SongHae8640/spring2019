<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력 페이지 (view/bbs/add2.jsp)</h1>
	<form method="POST"> <!-- action을 입력하지 않으면 default로 자기자신 -->
		<div>
			<label for="sub">제목</label>
			<input type="text" name="sub" id="sub">
		</div>
		<div>
			<label for="name">작성자</label>
			<input type="text" name="name" id="name">
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="content" id="content"></textarea>
		</div>
		<div>
			<button type="submit">입력</button>
		</div>
	</form>

</body>
</html>