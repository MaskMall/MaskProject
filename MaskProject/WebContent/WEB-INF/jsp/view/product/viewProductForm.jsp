<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#t01 {
	table-layout: fixed;
	width:70%;
	
}
#t02 {
	width:550px;
	height:400px;
	
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
#t01 img{
  width: 95%;
}
</style>
<script>
 function gotoCart(){
	 var yn = confirm("장바구니로 이동");
	 if(yn){
		 frm1.action="inputCart.do";
		 frm1.submit();
	 }else{
		 alert("계속 쇼핑");
	 }
 }
 
 function gotoNonCart(){
	 var yn = confirm("상품을 장바구니에 넣으시겠습니까?");
	 if(yn){
		 frm1.action="nonMemberCart.do";
		 frm1.submit();
	 }else{
		 alert("계속 쇼핑");
	 }
 }
 
  function buyNow(str) {
			var win = window.open("", "PopupWin", "width=680,height=800");
			frm1.target = "PopupWin";
			frm1.cartProduct.value = str;
			frm1.action = "bootPay.do";
			frm1.submit();
 } 
</script>
</head>
<body>
<div align="center">
	<h2>제품 상세 보기</h2>
	
	<table id="t01">
		<tr>
			<td>
			 	<img src="" width="250px" height="350px" >
			</td>
			<td>
				<table id="t02">
					<tr>
						<td>상품 번호</td>
						<td>${vo.productNum}</td>
					</tr>
					<tr>
						<td>상품명</td>
						<td>${vo.productName}</td>
					</tr>
					<tr>
						<td>가격</td>
						<td><fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"></fmt:formatNumber></td>
					</tr>
					<tr>
						<td colspan="2"><form name="frm1" method="post">
											<input type="hidden" name="productNum" id="productNum" value="${vo.productNum}">
											<input type="hidden" name="cartProduct" id="cartProduct" value="${vo.productNum}">
											<select name="amount">
												<c:forEach begin="1" end="10" var="i">
													<option value="${i }">${i }></option>
												</c:forEach>
											</select>&nbsp;개
											<input type="button" value="장바구니에 담기" onclick="gotoCart()">
											<input type="button" value="비회원" onclick="gotoNonCart()">
											<input type="button" value="바로 구매" onclick="buyNow(${vo.productNum})">
										</form>
					</tr>
					
				</table> 
			</td>
			
		</tr>
	
	
	</table>
	
</div>
</body>
</html>