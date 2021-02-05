<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>메인 페이지</title>

</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
 
<!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="img/mask1.jpg" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5">
        <h1 class="font-weight-light">당신이 원하는 마스크</h1>
        <p>이 마스크야 말로 가격과 디자인을 모두 챙긴..</p>
        <a class="btn btn-primary" href="#">구매하세요!</a>
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

    <div class="card text-white bg-secondary my-5 py-4 text-center">
    <!-- Call to Action Well -->
      <div class="card-body">
        <p class="text-white m-0"> 코로나 바이러스를 효과적으료 예방할수있는 마스크 저희와 함께 하세요. 
      </div>
    </div>

    <!-- Content Row -->
    <div class="row">
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">아동용 마스크</h2>
            <p class="card-text">8세 미만 아동용이 쓰기 좋은 마스크입니다.</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">구매하기</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">미세먼지 마스크</h2>
            <p class="card-text">미세먼지를 막을 정도의 강력한 보호력을 가진 마스크.</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">구매하기</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">비말 마스크</h2>
            <p class="card-text"> 비말차단마스크 / 새부리형 / KF-AD / 멜트블로운필터 / 3중구조 / 넓은귀끈 / 중형 / 묶음포장 / 식약처인증 / 접이식(세로2단)</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">구매하기</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
 
 <jsp:include page="footer.jsp"></jsp:include>
 
   <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  

</body>
</html>