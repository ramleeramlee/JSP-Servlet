<%@page import="multi.meetingDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bag" class="multi.meetingVO"></jsp:useBean>
<jsp:setProperty property="*" name="bag"/>
<%
	meetingDAO dao = new meetingDAO();
	dao.insert(bag);
%>