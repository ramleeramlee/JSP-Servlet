<%@page import="multi.MemberDAO_w"%>
<%@page import="multi.MemberVO_w"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함 >> 자바로 짜야한다-->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함 -->
    <%
    	//스크립트릿 이라고 부른다
            //자바코드 넣는 부분!!!!!!
           	//HttpServletRequest request = new HttpServletRequest();
            //tomcat은 미리 request를 만들어서 내장되어있다
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            
            //JSP안에 만들어진 변수는 서버의 RAM에 저장되는 지역변수!!
            
            //가방을 만들어서 값들을 넣고(set)
            //jsp에서 자동완성 하는 방법 >> 해당 클래스 클릭한 다음 컨트롤 + 쉬프트 + m
            MemberVO_w bag = new MemberVO_w();
            bag.setId(id);
            bag.setpw(pw);
            bag.setName(name);
            bag.setTel(tel);
            
            //dao에게 가방을 전달하자
            MemberDAO_w dao = new MemberDAO_w();
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
	background: lime;
}
</style>
</head>
<body>
회원가입 요청되었음
<hr color = "red">
가입한 id : <%= id %> <br>
가입한 pw : <%= pw %> <br>
가입한 name : <%= name %> <br>
가입한 tel : <%= tel %> <br>

</body>
</html>