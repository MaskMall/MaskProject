<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원 수정</h1>
		</div>
		<c:forEach var="vo" items="${list }">
			<form id="frm" name="frm"
				action="myPageUpdate.do?memberId=${vo.memberId }" method="post">
				<table border="1" class="row">
					<tr>
						<th>회원 아이디</th>
						<td align="center">${vo.memberId }</td>
					</tr>
					<tr>
						<th>회원 이름</th>
						<td align="center"><input type="text" id="memberName"
							name="memberName" value="${vo.memberName }"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td align="center"><input type="text" id="memberPassword"
							name="memberPassword" value="${vo.memberPassword }"></td>
					</tr>
					<tr>
						<th>전화 번호</th>
						<td align="center"><input type="text" id="memberPhone"
							name="memberPhone" value="${vo.memberPhone }"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td align="center"><input type="text" id="memberAddress"
							name="memberAddress" value="${vo.memberAddress }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td align="center"><input type="text" id="memberEmail"
							name="memberEmail" value="${vo.memberEmail }"></td>
					</tr>
					<tr>
						<th>권한</th>
						<td align="center"><input type="text" id="memberAuth"
							name="memberAuth" value="${vo.memberAuth }"></td>
					</tr>
				</table>
				<br />
				<button type="submit">수정</button>
				&nbsp;
				<button type="reset">취소</button>
				&nbsp;
				<button type="button" onclick="location.href='myPageForm.do'">마이페이지</button>
			</form>
		</c:forEach>

	</div>
</body>
</html>