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


</style>
<script>
function updateproduct(str4,str5,str6) {
	 var msg = confirm("정말 수정하시겠습니까?");
	 if(msg){
		 if(str6 != str5){
			 alert("수정권한이 없습니다.");
		 }else{
			 frm.action="toUpdateProduct.do?row="+str4;
			 frm.submit();	 
		 }
		 
	 }else{
		 alert("취소 하였습니다.");
	 }
	 
	 
}

function PdDelete(str,str2,str3){
	var deletee = confirm("정말 삭제하시겠습니까?");
	//console.log(str, str2);
	if(deletee){
		if(str3 != str2){
			alert("삭제권한이 없습니다.")
		}else{
			frm.action="deleteExec.do?row="+str;
			frm.submit();
		}
		
	}else{
		alert("취소 하였습니다.");
	}
	
}
	

</script>

</head>
<body>
<%-- <jsp:include page="../main/menu.jsp"></jsp:include> --%>
  <div align="center">
  	<div><h2>상품 목록</h2></div>
  	<form id="frm" name="frm" method="post">
	<table border="1" id="t01">

		  <tr>
		    <th width="70" >상품 번호</th>
		    <th width="100">상품 이름</th> 
		    <th width="70">상품 수량</th>
		    <th width="70">상품 판매가격</th>
		    <th width="70">해당 판매자</th>
		    <c:if test="${memberAuth eq 'SELLER'}">
		    <th width="70">상품 수정</th>
		    <th width="70">상품 삭제</th>
		    </c:if>
		  </tr>
			  <c:forEach var="vo" items="${list }">
				 <tr >
				 
				    <td width="70">${vo.productNum}</td>
				    <td width="70">${vo.productName}</td>
				    <td width="70">${vo.productQunt}</td>
				    <td width="100">${vo.productPrice}</td>
				    <td width="70">${vo.productSeller}</td>
				    <c:if test="${memberAuth eq 'SELLER'}">
			        <td>
						<button type="button" onclick = "updateproduct('${vo.productNum}','${vo.productSeller }','${memberId }')" >수  정</button></td>
			  	 	<td>
						<button type="button" onclick="PdDelete(${vo.productNum},'${vo.productSeller }','${memberId }')" >삭  제</button></td>
			  	 	 </c:if>
		  	  </tr>
		  	  </c:forEach>

		  	  
	</table>
	<br/>
	</form>
</div>

			<div align="center">
		  	  <button type="button" onclick="location.href = 'main.do'">홈으로</button>&nbsp;&nbsp;
		  	  <button type="button" onclick="location.href = 'showProduct.do'">상품목록 가기</button>&nbsp;&nbsp;
			  <button type="button" onclick="location.href ='toInsertProduct.do'" >상품 등록</button>
		    </div>  
		    
</body>

</html>