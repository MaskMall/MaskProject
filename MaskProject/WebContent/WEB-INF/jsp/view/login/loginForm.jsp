<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!--css start -->

<meta charset="UTF-8">

<title>로 그 인</title>

<!-- Custom styles for this template -->
<link rel="stylesheet" href="css/style.css">

<!--css end -->

<!-- jsp -->
<jsp:include page="../main/menu.jsp"></jsp:include>

<!-- script -->
<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>


</head>
<body>
	<div class="main-container">
		<div class="main-wrap">
		
				<header>
					<div class="logo-wrap">
						<img src="#">
					</div>
				</header>


			<form id="frm" name="frm" action="login.do" method="post">
				<section class="login-input-section-wrap">
					<div class="login-input-wrap">	
						<input type="text" id="memberId" name="memberId" placeholder="아이디" size="30">
					</div>	
					<div class="login-input-wrap password-wrap">
						<input type="password" id="memberPassword" name="memberPassword" placeholder="비밀번호" size="30">
					</div>
					<div class="login-button-wrap">
						<button type="submit" onclick="location.href='joinForm.do'">sign in</button>
					</div>
					<div class="login-button-wrap">
						<button type="button" onclick="location.href='joinForm.do'">sign up</button>
					</div>
					<div class="login-stay-sign-in">
						<i class="far fa-check-circle"></i>
						<span>Stay Signed in</span>
					</div>
				</section>
			</form>
			
			
			<br /> &nbsp;&nbsp;&nbsp;
			
		</div>
	</div>

</body>
</html>