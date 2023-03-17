package multi;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MailDAO {

	public ArrayList<MailVO> list() {
		ResultSet rs = null;

		// 가방들 넣어줄 큰 컨테이너 역할의 부품이 필요
		// ArrayList
		ArrayList<MailVO> list = new ArrayList();

		MailVO bag = null;

		try {
			// 1. 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "select * from mail";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();

			System.out.println("4.SQL문 오라클로 보내기 성공");
			while (rs.next()) {

				//한번에 작성하기
				bag = new MailVO();
				bag.setNo(rs.getInt("no"));
				bag.setSend(rs.getString("send"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setDate(rs.getString("date"));
				
				//  list에 bag을 추가해주자
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		//// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함

	}
	
	
public MailVO one(int no) {
		System.out.println(no);
		ResultSet rs = null;

		// 가방들 넣어줄 큰 컨테이너 역할의 부품이 필요
		// ArrayList
		MailVO bag = null;

		try {
			// 1. 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "select * from mail where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();

			System.out.println("4.SQL문 오라클로 보내기 성공");
			if (rs.next()) {
				bag = new MailVO();
				bag.setNo(rs.getInt("no"));
				bag.setSend(rs.getString("send"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setDate(rs.getString("date"));
			
			} else {
				System.out.println("검색결과없음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
	

	public int delete(int no) {
		int result = 0;
		try {
			// 1.연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 연결하자(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "delete from mail where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql);

			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setInt(1, no);

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			result = ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공");
			if (result >= 1) {
				System.out.println("탈퇴 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(MailVO bag) {
		int result = 0;
		try {
			// 1. 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 연결하자(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "update mail set content = ? where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, bag.getContent()); // 그냥 먼저 적혀있는 순서대로..
			ps.setInt(2, bag.getNo());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4.SQL문 오라클로 보내기 성공");
			if (result >= 1) {
				System.out.println("업데이트 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insert(MailVO bag) {
		int result = 0;
		try {
			// 1. 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2.  연결하자(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "insert into mail (send, title, content, date) values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			
			ps.setString(1, bag.getSend());
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getContent());
			ps.setString(4, bag.getDate());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4.SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("회원가입 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	
	public ArrayList<MailVO> list2(String send) {
		ResultSet rs = null;

		// 가방들 넣어줄 큰 컨테이너 역할의 부품이 필요
		// ArrayList
		ArrayList<MailVO> list = new ArrayList();

		MailVO bag = null;

		try {
			// 1. 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "select * from mail where send = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, send);
			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();

			System.out.println("4.SQL문 오라클로 보내기 성공");
			while (rs.next()) {

				//한번에 작성하기
				bag = new MailVO();
				bag.setNo(rs.getInt("no"));
				bag.setSend(rs.getString("send"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setDate(rs.getString("date"));
				
				//  list에 bag을 추가해주자
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		//// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함

	}
	
	
	public ArrayList<MailVO> list3(String content) {
		ResultSet rs = null;

		// 가방들 넣어줄 큰 컨테이너 역할의 부품이 필요
		// ArrayList
		ArrayList<MailVO> list = new ArrayList();

		MailVO bag = null;

		try {
			// 1. 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			String sql = "select * from mail where content like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + content + "%");
			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();

			System.out.println("4.SQL문 오라클로 보내기 성공");
			while (rs.next()) {

				//한번에 작성하기
				bag = new MailVO();
				bag.setNo(rs.getInt("no"));
				bag.setSend(rs.getString("send"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setDate(rs.getString("date"));
				
				//  list에 bag을 추가해주자
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		//// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함

	}
	
	
	
}
