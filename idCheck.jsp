<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //입력한 값 받아오기
   String id =request.getParameter("id"); //root
    
    //입력한 id가 배열에 있는지 확인
   String[] list = {"root", "admin", "hong"};
   String result = "사용가능";
    
    //결과 응답하기
   for (String s : list) {
    if(s.equals(id)){
    	result = "중복된 id, 사용불가능";
    	break;
    }
   }
%><%= result %> 
   

    
  