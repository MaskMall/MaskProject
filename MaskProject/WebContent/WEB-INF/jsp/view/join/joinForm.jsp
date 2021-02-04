<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--css start -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>마 스 크 </title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/small-business.css" rel="stylesheet">
  
<!--css end -->

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

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Our Mask</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">마스크 구매하기
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">구매내역</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">마이페이지</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">고객센터</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="joinForm.do">회원가입</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- Navigation end -->
  
  
  <!--  -->
  <div class="container">
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
 </div>
  <!-- /.container -->
	
<!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">문의처 : YD 053 - 123 -1234 </p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



</body>
</html>