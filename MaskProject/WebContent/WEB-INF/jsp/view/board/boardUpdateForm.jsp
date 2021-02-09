<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<div>
	<h1>${vo.boardNumber } 게시글 수정</h1>
</div>
	<form id="frm" name="frm" action="boardUpdate.do?row=${vo.boardNumber }" method="post">
		<table border="1" class="row">
			<tr>
				<th>글쓴이</th>
				<td align="center">${vo.boardWriter }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td align="center"><input type="text" name="boardContent" value="${vo.boardTitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="center"><input type="text" name="boardTitle" value="${vo.boardContent }"></td>
			</tr>
		</table><br/>
		<button type="submit">수정</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button>&nbsp;&nbsp;
		<button type="button" onclick="location.href='boardListForm.do'">목록</button>
	</form>
</div>
</body>
</html>