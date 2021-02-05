<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
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
</style>
</head>
<body>

<jsp:include page="../main/menu.jsp"></jsp:include>
 <div class="container">
  <div align="center">
	<table border="1">
		  <tr>
		    <th width="150">상품 번호</th>
		    <th width="150">상품 이름</th> 
		    <th width="150">상품 수량</th>
		    <th width="150">상품 판매가격</th>
		    <th width="150">해당 판매자</th>
		  </tr>
			  <c:forEach var="vo" items="${Product }">
				  <tr class="row">
				    <td>${vo.productNum}</td>
				    <td>${vo.productName}</td>
				    <td>${vo.productQunt}</td>
				    <td>${vo.productPrice}</td>
				    <td>${vo.ProductSeller}</td>
				  </tr>
			  </c:forEach>
			  <c:if test="${vo.MEMBERAUTH eq 'SELLER'}">
			  <button type="button" onclick="location.href = 'toInsertProduct.do'">상품 등록</button>&nbsp;&nbsp;
			  <button type="button" onclick="location.href='toUpdateProduct.do'">상품 수정</button>&nbsp;&nbsp;
			  <button type="button" onclick="location.href='deleteExec.do'">상품 삭제</button>&nbsp;&nbsp;
		  	  </c:if>
	</table>
</div>
  </div>
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>