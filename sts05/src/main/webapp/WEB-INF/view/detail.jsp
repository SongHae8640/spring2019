<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>"${bean.num }" 번째 글 - "${bean.nalja }"</h1>
	<form action="insert.bit" method="post">
		<div>
			<label for="sub">제목</label>
			<input type="text" name="sub" id="sub" value="${bean.sub }" placeholder="sub">
		</div>
		<div>
			<label for="name">글쓴이</label>
			<input type="text" name="name" id="name" value="${bean.name }" placeholder="name">
		</div>
		<div>
			<textarea  name="content" id="content" value="${bean.content }" placeholder="content"></textarea>
		</div>
		<div>
			<button type="submit">입력</button>
			<button type="reset">취소</button>
		</div>
	</form>

</body>
</html>