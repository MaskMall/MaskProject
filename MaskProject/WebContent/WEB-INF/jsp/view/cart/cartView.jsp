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
							<td><input type="text" readonly="readonly" id="cartNumber" name="cartNumber" value="${vo.cartNumber }"></td>
							<td><input type="text" readonly="readonly" id="cartUser" name="cartUser" value="${vo.cartUser }"></td>
							<td><input type="text" readonly="readonly" id="cartProduct" name="cartProduct" value="${vo.cartProduct }"></td>
							<td><input type="text" readonly="readonly" id="cartSelect" name="cartSelect" value="${vo.cartSelect}"></td>
							<td><button type="button" onclick="buyProduct(${vo.cartProduct})"></button></td>
							<td><button type="button" onclick="DeleteProduct(${vo.cartNumber})"></button></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>