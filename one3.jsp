<%@page import="multi.ProductVO_w"%>
<%@page import="multi.ProductDAO_w"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String id = request.getParameter("id"); 
    
    ProductDAO_w dao = new ProductDAO_w();
    ProductVO_w bag = dao.one(id);
   
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
 		<td>상품아이디</td>
 		<td><%=bag.getId() %></td>
 	</tr>
 	<tr>
 		<td>상품명</td>
 		<td><%=bag.getName() %></td>
 	</tr>
 	<tr>
 		<td>상품내용</td>
 		<td><%=bag.getContent() %></td>
 	</tr>
 	<tr>
 		<td>상품가격</td>
 		<td><%=bag.getPrice() %></td>
 	</tr>
 	<tr>
 		<td>제조회사</td>
 		<td><%=bag.getCompany() %></td>
 	</tr>
 	<tr>
 		<td>상품사진</td>
 		<td><img src="img/<%=bag.getImg() %>" width = "150" height = "150"></td>
 	</tr>
 	
 </table>	

</body>
</html>