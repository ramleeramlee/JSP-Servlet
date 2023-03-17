<%@page import="multi.MailVO"%>
<%@page import="multi.MailDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String no = request.getParameter("no"); 
    
    MailDAO dao = new MailDAO();
    MailVO bag = dao.one(Integer.parseInt(no));
   
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

검색한 메일번호 <%= no %>
<hr color = "red">
 <table class="table table-striped">
 	<tr>
 		<td>메일번호</td>
 		<td><%=bag.getNo() %></td>
 	</tr>
 	<tr>
 		<td>받는사람</td>
 		<td><%=bag.getSend() %></td>
 	</tr>
 	<tr>
 		<td>메일제목</td>
 		<td><%=bag.getTitle() %></td>
 	</tr>
 	<tr>
 		<td>메일내용</td>
 		<td><%=bag.getContent() %></td>
 	</tr>
 	<tr>
 		<td>보낸날짜</td>
 		<td><%=bag.getDate() %></td>
 	</tr>
 	
 </table>	

</body>
</html>