<%@page import="multi.MovieVO"%>
<%@page import="multi.MovieDAO"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    MovieDAO dao = new MovieDAO();
    //5,6번 >> dao가 리턴한 BbsVO_w가 들어간 ArrayList를 받는다
    ArrayList<MovieVO>list = dao.list();
   
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
	  color: white;
	}
</style>
</head>
<body>
<h3>게시판 글의 갯수: <%=list.size() %>개</h3>
<% if(list.size() == 0) {%>
<h3>등록된 영화가 없습니다</h3>
<img src="img/oops.jpg" width = "400" height = "400">
<% }else{ %>
 <table class="table table-dark table-hover">
 <tr>
 	<td>id</td>
 	<td>title</td>
 	<td>content</td>
 	<td>location</td>
 	<td>director</td>
 </tr>
<%
	for(MovieVO bag: list){
%>
<tr>
 	<td><%= bag.getId() %></td>
 	<td>
 		<a href="one4.jsp?id=<%= bag.getId() %>">
			<%=bag.getTitle() %>
		</a>
 		
 	</td>
 	<td><%=bag.getContent() %></td>
 	<td><%=bag.getLocation() %></td>
 	<td><%=bag.getDirector() %></td>
 	
 </tr>

<% } %>
</table>
<% } %>
</body>
</html>