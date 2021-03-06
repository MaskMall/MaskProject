	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head> 
<meta charset="UTF-8">
<title>전체 게시글</title>

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
 	button {
 	margin: 4px 0;
 	padding: 10px 0;
 	width: 840px;
 	background-color: black;
 	color:white;
 	border: none;
 	}
 	a{
 	text-decoration:none;
 	color: black;
 	}
 	a:hover{
 		text-decration-line: underline;
 	}
 </style>
</head>
<body>
<jsp:include page="../main/menu.jsp" />
<div align="center"><h1>문의 게시판</h1></div>
	<div class="controller">
		<form id="frm" name="frm" method="post">
			<table class="table table-hover">
				<tr align="center">
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:if test="${empty list }">
					<tr><td colspan="5" align="center">문의 내역이 없습니다.</td></tr>
				</c:if>	
				<c:if test="${not empty list }">
				<c:forEach var="vo" items="${list }">
				<tr onclick="location.href='boardView.do?row='+${vo.boardNumber }">
				<td align="center">${vo.boardNumber }</td>
				<td align="center">${vo.boardWriter }</td>
				<td align="center">${vo.boardTitle }</td>
				<td align="center">${vo.boardDate }</td>
				<td align="center">${vo.boardHit }</td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</form>
		<br>
		<div id="pageForm">
			페이지번호
		</div>
		<br>
		<div>
			<form>
				<select name="opt">
					<option value="0">제목</option>
					<option value="1">내용</option>
					<option value="2">제목+내용</option>
					<option value="3">글쓴이</option>
				</select>
				<input type="text" size="20" name="condition" />&nbsp;
				<input type="submit" value="검색"/>&nbsp;&nbsp;<br/>
				<button type="button" title="글쓰기" onclick="location.href='boardWriteForm.do'">글쓰기</button>
				
			</form>
		</div>
	</div>	
</body>
</html>