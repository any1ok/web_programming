<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>힘들다 개각튼거</title>
<link rel="stylesheet" type="text/css" href="main.css">
<script src="main.js"></script>
 
</head>


<body>
 
<%@ page import="java.util.*" %>
<%@ page import="kr.or.connect.project2.dto.Todo" %>
<%@ page import= "kr.or.connect.project2.dao.TodoDao" %>
<%TodoDao Dao = new TodoDao();
 Todo send = new Todo();
%>
	
<% List<Todo> list = new ArrayList<>(); %>
<% list = (List<Todo>)request.getAttribute("list"); %>

	<header>
    
    <div class="todo">나의해야할 일</div>
     <a href="http://localhost:8080/project2/TodoFormServlet">asdfafdadas</a>
  </header>
  <section id="left">dd</section>


  <section id="section-todo"><h4>TODO</h4>
   	 
   <%for(int i=0;i<list.size();i++){ 
   	if(list.get(i).getState()==0){
   	 
   	  %>
   		
  
  	
  	<section class="data" id = <%=list.get(i).getTodo_id() %>>
   
     <h5><%=list.get(i).getTodo()%></h5>
     <span>등록날짜: <%=  list.get(i).getDate()%> <%=  list.get(i).getName()%> 우선순위:<%=  list.get(i).getPriority()%></span>
      <input type="button"  name = <%=list.get(i).getTodo_id() %>  class= "t" value= ">" onclick= "todofunc(this);" />
    </section>
    
  	<%}} %>
    


    
  </section>
  <section id="section-doing"> <h4>DOING</h4>
 	 
 	 <%for(int i=0;i<list.size();i++){ 
   	if(list.get(i).getState()==1){
   %>
  	
  	<section class="data" id = <%=list.get(i).getTodo_id() %>>
   
     <h5><%=list.get(i).getTodo()%></h5>
     <span>등록날짜: <%=  list.get(i).getDate()%> <%=  list.get(i).getName()%> 우선순위:<%=  list.get(i).getPriority()%></span>
     <input type="button"  name = <%=list.get(i).getTodo_id() %>  class= "d" value= ">" onclick= "todofunc(this);" />
    </section>
    
  	<%}} %>
  	
  	
  </section>
  <section id="section-done"> <h4>DONE</h4>
  
   <%for(int i=0;i<list.size();i++){ 
   	if(list.get(i).getState()==2){
   %>
  	
  <section class="data" id = <%=list.get(i).getTodo_id() %>>
   
     <h5><%=list.get(i).getTodo()%></h5>
     <span>등록날짜: <%=  list.get(i).getDate()%> <%=  list.get(i).getName()%> 우선순위:<%=  list.get(i).getPriority()%></span>
    
    </section>
    
  	<%}} %>
  	
  
  </section>

  <script>


 
  function todofunc(id){
	 if(id.className =='t'){
		 id.className = 'd';
		 var papa = document.getElementById("section-todo"); 
		 var pa = document.getElementById(id.name);
		 var clone = pa.cloneNode(true);
		 var apapa = document.getElementById("section-doing");
	    	apapa.appendChild(clone);
	   		papa.removeChild(pa);
	   	
	  
	   	var todo_id = id.name;
	   	var xhr = new XMLHttpRequest();
	   	
	   	xhr.open("GET", "http://localhost:8080/project2/TodoUpdate?state=0&id="+todo_id);
	    xhr.send();	
	 }
		 
	 else if(id.className =='d'){
		 var papa = document.getElementById("section-doing");
		 var pa = document.getElementById(id.name);
		 var todo_id = id.name;
		 pa.removeChild(id);
		 
		 var clone = pa.cloneNode(true);
		 var apapa = document.getElementById("section-done");
		 apapa.appendChild(clone);
		 papa.removeChild(pa);
		
		 var state = "doing";
		   	
		   	var xhr = new XMLHttpRequest();
		   	
		   	xhr.open("GET", "http://localhost:8080/project2/TodoUpdate?state=1&id="+todo_id);
		    xhr.send();	
	       
	 }		 
	}

    </script>
  
</body>
</html>