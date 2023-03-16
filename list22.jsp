<%@page import="java.util.ArrayList"%>
<%@page import="multi.BbsVO_w"%>
<%@page import="multi.BbsDAO_w"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    BbsDAO_w dao = new BbsDAO_w();
    //5,6번 >> dao가 리턴한 BbsVO_w가 들어간 ArrayList를 받는다
    ArrayList<BbsVO_w>list = dao.list();
   
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
 <table class="table table-dark table-hover">
 <tr>
 	<td>no</td>
 	<td>title</td>
 	<td>content</td>
 	<td>writer</td>
 </tr>
<%
	for(BbsVO_w bag: list){
%>
<tr>
 	<td><%= bag.getNo() %></td>
 	<td>
 		<a href="http://localhost:8888/web00/one2.jsp?no=<%= bag.getNo() %>">
			<%=bag.getTitle() %>
		</a>
 		
 	</td>
 	<td><%=bag.getContent() %></td>
 	<td><%=bag.getWriter() %></td>
 </tr>

<% } %>
</table>
</body>
</html>