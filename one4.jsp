<%@page import="javax.swing.JOptionPane"%>
<%@page import="multi.MovieVO"%>
<%@page import="multi.MovieDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String id = request.getParameter("id"); 
    
    MovieDAO dao = new MovieDAO();
    MovieVO bag = dao.one(id);
   
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

</head>
<body>
검색을 원하는 아이디는 <%= id %>
<hr color = "red">
 <table class="table table-dark table-striped">
 	<tr>
 		<td>영화아이디</td>
 		<td><%=bag.getId() %></td>
 	</tr>
 	<tr>
 		<td>영화제목</td>
 		<td><%=bag.getTitle() %></td>
 	</tr>
 	<tr>
 		<td>영화내용</td>
 		<td><%=bag.getContent() %></td>
 	</tr>
 	<tr>
 		<td>영화상영관</td>
 		<td><%=bag.getLocation() %></td>
 	</tr>
 	<tr>
 		<td>영화감독</td>
 		<td><%=bag.getDirector() %></td>
 	</tr>
 	
 </table>	

</body>
</html>