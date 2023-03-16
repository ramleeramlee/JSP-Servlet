<%@page import="multi.BbsVO_w"%>
<%@page import="multi.BbsDAO_w"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String no = request.getParameter("no"); 
    
    BbsDAO_w dao = new BbsDAO_w();
    BbsVO_w bag = dao.one(Integer.parseInt(no));
   
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
검색을 원하는 번호 : <%= no %>
<hr color = "red">
 <table class="table table-dark table-striped">
 	<tr>
 		<td>검색한 제목</td>
 		<td><%=bag.getTitle() %></td>
 	</tr>
 	<tr>
 		<td>검색한 내용</td>
 		<td><%=bag.getContent() %></td>
 	</tr>
 	<tr>
 		<td>검색한 글쓴이</td>
 		<td><%=bag.getWriter() %></td>
 	</tr>
 </table>	

</body>
</html>