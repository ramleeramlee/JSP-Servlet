<%@page import="java.util.ArrayList"%>
<%@page import="multi.MailVO"%>
<%@page import="multi.MailDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String content = request.getParameter("content"); 
    
    MailDAO dao = new MailDAO();
    ArrayList<MailVO>list = dao.list3(content);
   
    %>
    <!-- 브라우저에게 결과를 알려주기 위한 html코드가 미리 들어가 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
	a{text-decoration: none;
	  color: black;
	}
</style>
</head>
<body>
<h3>검색 된 메일 총 갯수: <%=list.size() %>개</h3>
<br>
<% if(list.size() == 0) {%>
<h3>등록된 메일이 없습니다</h3>
<img src="img/oops.jpg" width = "400" height = "400">
<% }else{ %>
 <table class="table">
 <thead class="table-active">
 <tr>
 	<td>no</td>
 	<td>send</td>
 	<td>title</td>
 	<td>content</td>
 	<td>date</td>
 </tr>
</thead>
<%
	for(MailVO bag: list){
%>
<tr>
 	<td><%= bag.getNo() %></td>
 	<td><%=bag.getSend() %></td>
 	<td><%=bag.getTitle() %></td>
 	<td>
 	<a href="one5.jsp?no=<%= bag.getNo() %>">
 		<%=bag.getContent() %></a>
 	</td>
 	<td><%=bag.getDate() %></td>
 	
 </tr>

<% } %>
</table>
<% } %>
</body>
</html>