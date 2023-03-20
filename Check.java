package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check.do")
public class Check extends HttpServlet {//12개
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Check 서블릿 객체가 하나 만들어진다");
	} //코드 변경이 생기지 않으면 한번 불러온 뒤 변경이 되기전 까지 종료되지않는다(싱글톤 객체생성)
	
	@Override
	public void destroy() {
		System.out.println("Check서블릿 소멸됨");
	} // 코드 변경이 생기면 종료됬다가 다시 실행하면 서블릿 객체가 만들어짐
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String today = request.getParameter("today");
		String result = "그냥있자";
		if (today.equals("맑음")) {
			result = "나가자";
		}else if (today.equals("흐림")) {
			result = "코딩";
		}else if (today.equals("비옴")) {
			result = "쇼핑";
		}
		out.print(result);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String pass = request.getParameter("pass");
		String result = "들어올 수 없습니다<img src='oops.jpg' height='300' width='300'>";
		// 만약 img파일에 넣어다면>>> "<img src='img/oops.jpg'>"; 로 표시해야한다!!
		if (pass.equals("나는왕이다")) {
			result ="들어오세요<img src='완료.png' height='300' width='300'>";
		}
		out.print(result);
		out.close();
	}

}
