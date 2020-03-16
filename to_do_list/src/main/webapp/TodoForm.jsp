<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="TodoFormc.css">
</head>
<body>
<h1>할일 등록</h1>
  <form action="TodoAdd" method="POST">
  <section>
    어떤일 인가요?<br>
    <input type="text" name="todo" placeholder="24자" style="width:400px"><br><br>
    
    누가할일인가요?<br>
    <input type="text" name="whodo" placeholder="누가할일?" style="width:400px">
    <input type="submit" value="전송">


   </section>
   
  <section>
   
      우선순위를 선택하세요.<br>
      <input type="checkbox" name="priority" value =1>1순위
       <input type="checkbox" name="priority" value =2>2순위
       <input type="checkbox" name="priority" value =3>3순위
    
    <br>
   
  </section>
  
  <section>
    
    
    <a href="Main" class="back"> 이전 </a>
    <input type="submit" value="제출하기">
    <a href="http://localhost:8080/project2/TodoFormServlet" class="redo">다시하기</a>
    
   
  </section>
   </form>
</body>
</html>