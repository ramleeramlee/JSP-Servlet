<%@page import="multi.ProductVO_w"%>
<%@page import="multi.ProductDAO_w"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    ProductDAO_w dao = new ProductDAO_w();
    //5,6번 >> dao가 리턴한 BbsVO_w가 들어간 ArrayList를 받는다
    ArrayList<ProductVO_w>list = dao.list();
   
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
 	<td>id</td>
 	<td>name</td>
 	<td>content</td>
 	<td>price</td>
 	<td>company</td>
 	<td>img</td>
 	
 </tr>
<%
	for(ProductVO_w bag: list){
%>
<tr>
 	<td><%= bag.getId() %></td>
 	<td>
 		<a href="one3.jsp?id=<%= bag.getId() %>">
			<%=bag.getName() %>
		</a>
 		
 	</td>
 	<td><%=bag.getContent() %></td>
 	<td><%=bag.getPrice() %>원</td>
 	<td><%=bag.getCompany() %></td>
 	<td><%=bag.getImg() %></td>
 </tr>

<% } %>
</table>
</body>
</html>