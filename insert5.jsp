
<%@page import="multi.MailDAO"%>
<%@page import="multi.MailVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="bag" class="multi.MailVO"></jsp:useBean>
    <jsp:setProperty property="*" name="bag"/>
  <%
   
    MailDAO dao = new MailDAO();
    dao.insert(bag);
   
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
메일 등록완료 
<hr color = "red">
<img src="img/완료.png" width = "100" height = "100">


</body>
</html>