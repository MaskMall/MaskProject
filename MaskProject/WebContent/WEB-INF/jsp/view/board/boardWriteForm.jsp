<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

<style type="text/css">
#title {
	height: 16;
	font-family: '돋움';
	font-size: 12;
	text-align: center;
}
</style>

</head>
<body>

	<br>
	<div align="center"><h1>문의 게시판!</h1></div>
	<br>

	<form method="post" action="BoardWriteAction.bo" name="boardForm" enctype="multipart/form-data">
		<input type="hidden" name="board_id" value="${sessionScope.sessionID }">
		<table border="3" align="center">
			<tr>
				<th width="300" id="title">작성자</td>
				<td>${sessionScope.sessionID }</td>
			</tr>
			<tr>
				<th width="150" id="title">제목</td>
				<td><input name="board_subject" type="text" size="100%"
					maxlength="100" value="" /></td>
			</tr>
			<tr>
				<th width="150" id="title">내용</th>
				<td><textarea name="#" rows="30" cols="100%"></textarea></td>
			</tr>
			<tr>
				<th width="150" id="title">파일첨부</td>
				<td><input type="file" name="boardFile" /></td>
			</tr>

			<tr align="center" valign="middle">
				<td colspan="5">
					<input type="reset" value="작성취소"> 
					<input type="submit" value="등록"> 
					<input type="button" value="목록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>