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
	<h1>BBS edit 페이지 (view/bbs/edit.jsp)</h1>
	<h2>${bean.num }번째 글 - ${bean.nalja }</h2>
	<form action="updateCancel" method="post">
		<input name="num" value="${bean.num }" style="display: none;">
		<input name="nalja" value="${bean.nalja }" style="display: none;">
		<div>
			<label for="name">작성자</label>
			<input type="text" name="name" id="name" value="${bean.name }" >
		</div>
		<div>
			<label for="sub">제목</label>
			<input type="text" name="sub" id="sub" value="${bean.sub }" >
		</div>
		<div>
			<label for="content">내용</label>
			<input type="text" name="content" id="content" value="${bean.content }" >
		</div>
		<div>
			<button type="submit" name="updateCancel" value="update">수정</button>
			<button type="submit" name="updateCancel" value="cancel">취소</button>
		</div>
	</form>

</body>
</html>