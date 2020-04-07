<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	

	<script>	
	var token = "${token}"
		var k;
	<c:forEach items="${list}" var="listVar" varStatus="status">
		
		var oReq = new XMLHttpRequest();
		oReq.addEventListener("load", function() {
		    k = JSON.parse(this.responseText)
		    if(${listVar.price} === k.response.amount){
		    	console.log('1');
		    }
		   
		});
		oReq.open("GET", "https://api.iamport.kr/payments/"+"${listVar.imp}"+"?_token="+token);
		oReq.send();
		
		</c:forEach>
	
	
	
	
	
	//oReq.setRequestHeader('Content-Type', 'application/json');
	
	
	</script>
	


</body>
</html>