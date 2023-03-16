<%@page import="multi.ProductDAO_w"%>
<%@page import="multi.ProductVO_w"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="bag" class="multi.ProductVO_w"></jsp:useBean>
    <jsp:setProperty property="*" name="bag"/>
  <%
   // 1. 전달되는 값 받기 
   /* String id = request.getParameter("id");
    String name = request.getParameter("name");
    String content = request.getParameter("content");
    String price = request.getParameter("price");
    String company = request.getParameter("company");
    String img = request.getParameter("img"); */
    
    // 2. 가방을 만든다 
    /* ProductVO_w bag = new ProductVO_w();
    bag.setId(id);
    bag.setName(name);
    bag.setContent(content);
    bag.setPrice(Integer.parseInt(price));
    bag.setCompany(company);
    bag.setImg(img); */
    
    // 3. dao에게 가방 전달하면서 insert해 달라고 하기 
    
    ProductDAO_w dao = new ProductDAO_w();
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
상품등록 완료
<hr color = "red">

<!--  img sre=img/신발1.jpg -->
<img src="img/<%= bag.getImg() %>" width = 200 height = 200>

</body>
</html>