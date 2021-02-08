<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<style>
table {
	width: 70%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	padding: 15px;
	text-align: left;
}

th {
	padding: 15px;
	text-align: center;
}

#t01 tr:nth-child(even) {
	background-color: #eee;
}

#t01 tr:nth-child(odd) {
	background-color: #fff;
}

#t01 th {
	background-color: black;
	color: white;
}

.insertBtn {
	border: none;
	font-size: 16px;
	cursor: pointer;
	color: black;
	justify-content: center;
	display: flex;
}

.updateBtn {
	border: none;
	font-size: 16px;
	cursor: pointer;
	color: black;
	justify-content: center;
	display: flex;
}
</style>
</head>
<body>

	<jsp:include page="../main/menu.jsp" />
	<div class="container">
		<div align="center">
			<div>
				<h2>문의 게시판</h2>
			</div>
			<table border="1" id="t01">
				<tr>
					<th width="100">게시글 번호</th>
					<th width="100">글쓴이</th>
					<th width="70">제목</th>
					<th width="70">내용</th>
					<th width="70">날짜</th>
				</tr>
				<c:forEach var="vo" items="${list }">

					<tr>

						<td width="70">${vo.boardNumber}</td>
						<td width="70">${vo.boardWriter}</td>
						<td width="70">${vo.boardTitle}</td>
						<td width="70">${vo.boardContent}</td>
						<td width="70">${vo.boardDate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>
	<!-- <div id="pageForm">페이지번호</div>  -->	
		<br>
		<div align="center"  id="searchForm">
			<form>
				<select name="opt">
					<option value="0">제목</option>
					<option value="1">내용</option>
					<option value="2">제목+내용</option>
					<option value="3">글쓴이</option>
				</select> <input type="text" size="20" name="condition" />&nbsp; <input
					type="submit" value="검색" />&nbsp;&nbsp;
				<button type="button" title="글쓰기"
					onclick="location.href='boardWirteForm.do'">글쓰기</button>
			</form>
		</div>
	</div>
</body>
</html>