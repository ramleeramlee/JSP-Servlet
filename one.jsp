<%@page import="multi.MemberVO_w"%>
<%@page import="multi.MemberDAO_w"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String id = request.getParameter("id"); 
    
    MemberDAO_w dao = new MemberDAO_w();
    MemberVO_w bag = dao.one(id);
   
    %>
    <!-- 브라우저에게 결과를 알려주기 위한 html코드가 미리 들어가 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background: gray;
}
</style>
</head>
<body>
검색을 원하는 id: <%= id %>
<hr color = "red">
검색된 비번: <%= bag.getpw() %> <br>
검색된 이름: <%= bag.getName() %> <br>
검색된 전화번호: <%= bag.getTel() %>




</body>
</html>