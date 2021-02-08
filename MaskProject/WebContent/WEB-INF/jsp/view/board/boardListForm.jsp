
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시글</title>

<!-- jsp -->
<jsp:include page="../main/menu.jsp"></jsp:include>


<style type="text/css">
#wrap {
	width: 800px;
	margin: 0 auto 0 auto;
}

#topForm {
	text-align: right;
}

#board, #pageForm, #searchForm {
	text-align: center;
}

#bList {
	text-align: center;
}
</style>


<script type="text/javascript">
	function writeForm() {
		location.href = "BoardWriteForm.bo";
	}
</script>
</head>
<body>
	<div id="wrap">
		<br>
		<div id="topForm">
			<c:if test="${sessionScope.sessionID!=null }">
				<input type="button" value="글쓰기" onclick="writeForm()">
			</c:if>
		</div>
		<br>
		<form id="frm" name="frm" method="post">
			<div id="board">
				<table id="bList" width="800" border="1">
					<tr height="30">
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:forEach var="vo" items="${list }">
						<tr class="row"
							onclick="location.href='boardView.do?row='+${vo.boardNumber }">
							<td align="center">${vo.boardNumber }</td>
							<td align="center">${vo.boardTitle }</td>
							<td align="center">${vo.boardWriter }</td>
							<td align="center">${vo.boardDate }</td>
							<td align="center">${vo.boardHit }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<br>
		<div id="pageForm">페이지번호</div>
		<br>
		<div id="searchForm">
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