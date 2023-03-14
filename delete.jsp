<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. 전달된 값 받기(request이용)-->
    <!-- 2. dao에게 값 전달(DAO이용) 생략 -->
    <!-- 3. 전달된 값을 출력하는 결과를 브라우저에 Html로 보내기 -->
    <% //스크립트릿 이라고 부른다
    //자바코드 넣는 부분!!!!!!
   	//HttpServletRequest request = new HttpServletRequest();
    //tomcat은 미리 request를 만들어서 내장되어있다
    String id = request.getParameter("id");
   
   
    
    %>
    <!-- 브라우저에게 결과를 알려주기 위한 html코드가 미리 들어가 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background: lime;
}
</style>
</head>
<body>
회원탈퇴 완료
<hr color = "red">
회원 id : <%= id %> <br>




</body>
</html>