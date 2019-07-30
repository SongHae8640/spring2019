<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BBS add 페이지 (view/bbs/add.jsp)</h1>
	<form action="insert" method="POST">
		<div>
			<label for="name">작성자</label>
			<input type="text" name="name" id="name">
		</div>
		<div>
			<label for="sub">제목</label>
			<input type="text" name="sub" id="sub">
		</div>
		<div>
			<label for="content">내용</label>
			<input type="text" name="content" id="content">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>

</body>
</html>