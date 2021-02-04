<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<tr>
					<td width="150"><input type="number" id="productNum" name="productNum"></td>
					<td width="150"><input type="text" id="productName" name="productName"></td>
					<td width="150"><input type="number" id="productQunt" name="productQunt" min="1" max="500" ></td>
					<td width="150"><input type="number" id="productPrice" name="productPrice" ></td>
					<td width="150"><input type="text" id="ProductSeller" name="ProductSeller"></td>
				</tr>	
			</table><br/>
			<div>
				<button type="submit" >상품 등록</button>&nbsp;&nbsp;
				<input type="reset" id="cancle" name="cancle" value="취소">
			</div>
		</form>	

	</div>
</body>
</html>