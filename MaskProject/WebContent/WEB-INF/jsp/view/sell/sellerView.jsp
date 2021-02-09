<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>
table {
  width:70%;
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
.updateBtn{
  border: none;
  font-size: 16px;
  cursor: pointer;
  color: black;
  justify-content: center;
  display: flex;
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
		
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Sell List'],
        <c:forEach var="ct" items="${chartList }">
       		['${ct.chartProduct}', ${ct.chartProductQunt}],
        </c:forEach>
        ]);

        var options = {
          title: '판매 순위'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
</script>
</head>
<body>
<jsp:include page="../main/menu.jsp"></jsp:include>
	<div align="center">
		<h1>판매 내역 페이지</h1>
		<div>
			<form action="" id="frm" name="frm" method="post">
				<table border="1">
					<tr>
						<th>판매 번호</th>
						<th>상품 번호</th>
						<th>상 품 명</th>
						<th>상품 가격</th>
						<th>구매 갯수</th>
						<th>구 매 자</th>
						<th>구 매 일</th>
					</tr>
					<c:if test="${empty list}">
						<tr><td colspan="7" align="center">판매 내역이 없습니다.</td></tr>
					</c:if>
					<c:if test="${not empty list}">
						<c:forEach var="vo" items="${list }">
							<tr>
								<td>${vo.sellNumber }</td>
								<td>${vo.sellProductNumber }</td>
								<td>${vo.productName }</td>
								<td>${vo.productPrice }</td>
								<td>${vo.sellQunt }</td>
								<td>${vo.sellUser }</td>
								<td>${vo.sellDate }</td>
							</tr>
						</c:forEach>
					</c:if>
				</table><br/>
				<div id="piechart" style="width: 900px; height: 500px;"></div>
				<button type="button" onclick="location.href = 'main.do'">홈으로</button>
			</form>
		</div>
	</div>
</body>
</html>