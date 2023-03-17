<%@page import="multi.MailDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. 전달된 값 받기(request이용)-->
    <!-- 2. dao에게 값 전달(DAO이용) 생략 -->
    <!-- 3. 전달된 값을 출력하는 결과를 브라우저에 Html로 보내기 -->
    <% 
    String no = request.getParameter("no"); 
   
    MailDAO dao = new MailDAO();
    dao.delete(Integer.parseInt(no));
   
    
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
메일 삭제완료
<hr color = "red">
삭제 한 번호 : <%= no %> <br>
<br>
<img src="img/완료.png" width = "100" height = "100">

</body>
</html>