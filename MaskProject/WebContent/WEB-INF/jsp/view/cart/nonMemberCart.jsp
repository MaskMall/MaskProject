<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jsp -->
<jsp:include page="../main/menu.jsp"></jsp:include>


<style type="text/css">
input{
 border: none;
}
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
<script type="text/javascript">
	function buyProduct(str) {
		var win = window.open("", "PopupWin", "width=680,height=800");
		frm.productNum.value = str;
		frm.action = "nonMemberBootPay.do";
		frm.submit();
	}
	function DeleteProduct(str) {
		var yn = confirm("삭제하시겠습니까?")
		if(yn) {
			frm.productNum.value = str;
			frm.action = "nonMemberCartDel.do";
			frm.submit();
		}
	}
</script>
</head>
<body>
	<div align="center">
		<h1>비회원 장바구니</h1>
		<div>
			<form action="" id="frm" name="frm" method="post" target="PopupWin">
			<input type="hidden" name="productNum" id="productNum">
				<table border="1">
					<tr>
						<th>상품 번호</th>
						<th>상 품 명</th>
						<th>가 격</th>
						<th>구매 수량</th>
						<th>판 매 자</th>
						<th>구 매</th>
						<th>삭 제</th>
					</tr>
					<c:if test="${empty NonMemberList }">
						<tr align="center" >
							<th colspan="7">장바구니에 등록된 상품이 없습니다.</th>
						</tr>
					</c:if>
					<c:if test="${not empty NonMemberList }">
						<c:forEach var="vo" items="${NonMemberList }">
							<tr>
								<td>${vo.productNum }</td>
								<td>${vo.productName }</td>
								<td>${vo.productPrice }</td>
								<td>${vo.amount }</td>
								<td>${vo.productSeller }</td>
								<td>
									<button type="button" onclick="buyProduct(${vo.productNum})">구 매</button>
									<input type="hidden" name="amount" id="amount" value="${vo.amount }">
								</td>
								<td>
									<button type="button" onclick="DeleteProduct(${vo.productNum})">삭 제</button>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table><br/>
				<button type="button" onclick="location.href = 'main.do'">홈으로</button>
			</form>
		</div>
	</div>
</body>
</html>