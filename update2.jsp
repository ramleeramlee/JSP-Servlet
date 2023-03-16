<%@page import="multi.BbsVO_w"%>
<%@page import="multi.BbsDAO_w"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. 전달된 값 받기(request이용)-->
    <!-- 2. dao에게 값 전달(DAO이용) 생략 -->
    <!-- 3. 전달된 값을 출력하는 결과를 브라우저에 Html로 보내기 -->
    <% //스크립트릿 이라고 부른다
    //자바코드 넣는 부분!!!!!!
   	//HttpServletRequest request = new HttpServletRequest();
    //tomcat은 미리 request를 만들어서 내장되어있다
    String no = request.getParameter("no"); 
    String content = request.getParameter("content"); 
    //외부에서 손으로 치는 것들은 전부 String
   
    BbsVO_w bag = new BbsVO_w();
    bag.setNo(Integer.parseInt(no));
    bag.setContent(content);
    
    BbsDAO_w dao = new BbsDAO_w();
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
	background: gray;
}
</style>
</head>
<body>
게시글 수정
<hr color = "red">
수정을 원하는 게시글 번호 : <%= no %> <br>
수정을 원하는 게시글 내용 : <%= content %>



</body>
</html>