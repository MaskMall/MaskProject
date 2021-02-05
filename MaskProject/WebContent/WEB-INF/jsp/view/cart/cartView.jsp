<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input{
		border: none;
	}
</style>
<script type="text/javascript">
	function buyProduct(str) {
		frm.cartProduct.value = str;
		frm.action = "bootPay.do";
		frm.submit();
	}
	function DeleteProduct(str) {
		frm.cartNumber.value = str;
		frm.action = "cartDelete.do";
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>cartView 페이지</h1>
		<div>
			<form action="" id="frm" name="frm" method="post">
			<input type="hidden" name="cartProduct" id="cartProduct">
			<input type="hidden" name="cartNumber" id="cartNumber">
				<table border="1">
					<tr>
						<th>장바구니 번호</th>
						<th>구 매 자</th>
						<th>상품 번호</th>
						<th>구매 수량</th>
						<th>구 매</th>
						<th>삭 제</th>
					</tr>
					<c:forEach var="vo" items="${cartList }">
						<tr>
							<td>${vo.cartNumber }</td>
							<td>${vo.cartUser }</td>
							<td>${vo.cartProduct }</td>
							<td>${vo.cartSelect }</td>
							<td><button type="button" onclick="buyProduct(${vo.cartProduct})">구 매</button></td>
							<td>
								<button type="button" onclick="DeleteProduct(${vo.cartNumber})">삭 제</button>
								<input type="hidden" name="cartUser" id="cartUser" value=${vo.cartUser }>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>