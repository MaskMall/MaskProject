<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 내용 보기</title>
<style type="text/css">
 	.controller{
 		padding: 25px 0;
 		margin: auto;
 		width: 840px;
 		text-align: center;
 	}
 	table {
 	width: 840px;
 	padding: 10px 0;
 	border-collapse: collapse;
 	}
 	th {
 		background-color: black;
 		color: white;
 	}
 	
 	a{
 	text-decoration:none;
 	color: black;
 	}
 	a:hover{
 		text-decration-line: underline;
 	}
 </style>
<script type="text/javascript">
function deleteBoard(str){
	var yn = confirm("정말 삭제합니까");
	if(yn){
		frm.action="boardDelete.do?row="+str;
		frm.submit();
	}
}
function updateBoard(str){
	frm.action = "boardUpdateForm.do?row="+str;
	frm.submit();
}



</script>
<jsp:include page="../main/menu.jsp" />

</head>
<body>
	<div align="center">
		<div>
			<h1>문의글 내용보기</h1>
		</div>
		<form id="frm" name="frm" method="post">
		<table  border="1">
			<tr>
				<th>게시글번호</th>
				<th>글쓴이</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<tr>
				<td align="center">${vo.boardNumber }</td>
				<td align="center">${vo.boardWriter }</td>
				<td align="center">${vo.boardTitle }</td>
				<td align="center">${vo.boardContent }</td>
				<td align="center">${vo.boardDate }</td>
				<td align="center">${vo.boardHit }</td>
			</tr>
		</table>
		</form>
		<br/><button type="button" onclick="updateBoard('${vo.boardNumber}')">수정</button>&nbsp;&nbsp;&nbsp; 
		<button type="submit" onclick="deleteBoard('${vo.boardNumber}')">삭제</button>&nbsp;&nbsp;&nbsp; 
		<input type="button" onclick="location.href = 'boardListForm.do'" value="목록">
	</div>
</body>
</html>