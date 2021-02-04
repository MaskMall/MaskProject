<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>상품 등록</h1></div>
		<form id="frm" name="frm" action="insertExec.do" method="post">
			<table border="1">
				<tr >
					<th width="150">상품 번호</th>
				    <th width="150">상품 이름</th> 
				    <th width="150">상품 수량</th>
				    <th width="150">상품 판매가격</th>
				    <th width="150">판매자</th>
				</tr>
				<c:forEach var="vo" items="${product }">
				<tr>
					<td width="150"><input type="number" id="productNum" name="productNum" readonly="readonly"></td>
					<td width="150"><input type="text" id="productName" name="productName" value="${vo.productName }"></td>
					<td width="150"><input type="number" id="productQunt" name="productQunt" value="${vo.productQunt }" ></td>
					<td width="150"><input type="number" id="productPrice" name="productPrice" value="${vo.productPrice }" ></td>
					<td width="150"><input type="text" id="ProductSeller" name="ProductSeller" readonly="readonly"></td>
				</tr>
				</c:forEach>	
			</table><br/>
			<div>
				<button type="submit" >수정</button>&nbsp;&nbsp;
				<input type="reset" id="cancle" name="cancle" value="취소">
			</div>
		</form>	

	</div>
</body>
</html>