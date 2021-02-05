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
			<h1>거래처 수정</h1>
		</div>
		<form id="frm" name="frm" action="sellerUpdate.do?memberId=${vo.memberId }" method="post">
			<table border="1">
				<tr style="background-color: silver">
					<th width="100">회원 아이디</th>
					<th width="100">회원명</th>
					<th width="200">전화번호</th>
					<th width="100">주소</th>
					<th width="200">이메일</th>
					<th width="100">권한</th>
				</tr>
				<tr class="row">
					<td align="center">${vo.memberId }</td>
					<td align="center"><input type="text" id="memberName" name="memberName" value="${vo.memberName }"></td>
					<td align="center"><input type="text" id="memberPhone" name="memberPhone" value="${vo.memberPhone }"></td>
					<td align="center"><input type="text" id="memberAddress" name="memberAddress" value="${vo.memberAddress }"></td>
					<td align="center"><input type="text" id="memberEmail" name="memberEmail" value="${vo.memberEmail }"></td>
					<td align="center">${vo.memberAuth }</td>
				</tr>
			</table>
			<br />
			<button type="submit">수정</button>
			&nbsp;&nbsp;&nbsp;
			<button type="reset">취소</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='adminSellerForm.do'">목록</button>
		</form>
	</div>
</body>
</html>