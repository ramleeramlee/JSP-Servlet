<%@page import="multi.MailVO"%>
<%@page import="multi.MailDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%
    String no = request.getParameter("no"); 
    String content = request.getParameter("content"); 
    
    MailVO bag = new MailVO();
    bag.setNo(Integer.parseInt(no));
    bag.setContent(content);
    
    MailDAO dao = new MailDAO();
    dao.update(bag);
   
    %>
    <!-- 브라우저에게 결과를 알려주기 위한 html코드가 미리 들어가 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background: #d2edf7;
}
</style>
</head>
<body>
메일 수정완료
<hr color = "red">
수정한 메일 번호 : <%= no %> <br>
수정된 메일 내용 : <%= content %><br>
<br>
<img src="img/완료.png" width = "100" height = "100">



</body>
</html>