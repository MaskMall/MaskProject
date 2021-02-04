<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formCheck() {
		if (frm.memberPassword.value != frm.memberPassword1.value) {
			alert("패스워드가 일치하지 않습니다.");
			frm.memberPassword1.value = null;
			frm.memberPassword1.focus();
			return false;
		}
		return true;
	}

	function idCheck(str) {
		var url = "idCheck.do?memberId=" + str;
		if (str == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
		} else {
			window.open(url, "아이디 중복확인",
					"width=600, height=200, top=100, left=100");
		}
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원가입</h1>
		</div>
		<form id="frm" name="frm" onsubmit="return formCheck()"
			action="join.do" method="post">
			<div>
				<table border="1">
				
					<tr>
						<th>아이디</th>
						<td><input type="text" id="memberId" name="memberId"
							required="required">&nbsp;
							<button type="button" onclick="idCheck(memberId.value)">중복체크</button></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="memberPassword" name="memberPassword"
							required="required"></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" id="memberPassword1" name="memberPassword1"
							required="required"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="memberName" name="memberName"
							required="required"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" id="memberPhone" name="memberPhone"
							required="required"></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type="text" id="memberAddress" name="memberAddress"
							required="required"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" id="memberEmail" name="memberEmail"
							required="required"></td>
					</tr>
					<tr>
						<th>회원구분</th>
						<td><input type="radio" id="memberAuth" name="memberAuth"  value="USER" checked="checked">개인회원
							<input type="radio" id="memberAuth" name="memberAuth"  value="SELLER">판매자</td>
					</tr>
				</table>
			</div>
			<br /> <input type="submit" value="회원가입">&nbsp; <input
				type="reset" value="취소">
		</form>
	</div>
</body>
</html>