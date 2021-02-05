<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../main/menu.jsp"></jsp:include>
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="main-container">
		<div class="main-wrap">
	<div align="center">
	<header>
	<div class="logo-wrap">
				<img src="#">
			</div>
		</header>

		<div>
			<form id="frm" name="frm" action="login.do" method="post">
				<section class="login-input-section-wrap">

							<div class="login-input-wrap">	
							<input type="text" id="memberId" name="memberId"
								size="30">
							</div>	

						<div class="login-input-wrap password-wrap">
							<input type="password" id="memberPassword" name="memberPassword" size="30"></td>
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
				
				</div>
				<br /> &nbsp;&nbsp;&nbsp;
			</form>
		</div>
	</div>

</body>
</html>