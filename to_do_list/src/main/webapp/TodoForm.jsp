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
<h1>���� ���</h1>
  <form action="TodoAdd" method="POST">
  <section>
    ��� �ΰ���?<br>
    <input type="text" name="todo" placeholder="24��" style="width:400px"><br><br>
    
    ���������ΰ���?<br>
    <input type="text" name="whodo" placeholder="��������?" style="width:400px">
    <input type="submit" value="����">


   </section>
   
  <section>
   
      �켱������ �����ϼ���.<br>
      <input type="checkbox" name="priority" value =1>1����
       <input type="checkbox" name="priority" value =2>2����
       <input type="checkbox" name="priority" value =3>3����
    
    <br>
   
  </section>
  
  <section>
    
    
    <a href="Main" class="back"> ���� </a>
    <input type="submit" value="�����ϱ�">
    <a href="http://localhost:8080/project2/TodoFormServlet" class="redo">�ٽ��ϱ�</a>
    
   
  </section>
   </form>
</body>
</html>