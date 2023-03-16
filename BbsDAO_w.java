package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import multi.BbsVO_w;

// 테이블 하나당 DAO하나! >> 
public class BbsDAO_w {

	public BbsVO_w one(int no) {
		ResultSet rs = null;
		BbsVO_w bag = null;

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

			// 3. SQL문을 만든다.
			// URL u = new URL(url);
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
			String sql = "select * from bbs where NO = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요

			ps.setInt(1, no); // ** db는 인덱스가 1부터 시작!!!

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();
			System.out.println("4.SQL문 오라클로 보내기 성공");

			if (rs.next()) { //// 검색결과가 있는지 여부는 rs.next()
				//// true이면 있다, false이면 없다 라는 의미
				System.out.println("검색결과 있음. 성공");
				int no2 = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				System.out.println(no2 + " " + title + " " + title + " " + writer);

				//// 검색결과를 검색화면 UI부분을 주어야 함(DAO는 JOptionPane가 안됨)
				bag = new BbsVO_w();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
			} else {
				System.out.println("검색결과 없음");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}

	public void delete(int no) {
		try {
			// 1. 오라클 11g와 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			// 3. SQL문을 만든다.
			// URL u = new URL(url);
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
			String sql = "delete from bbs where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql);

			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setInt(1, no);

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(BbsVO_w bag) {
		try {
			// 1. 오라클 11g와 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			// 3. SQL문을 만든다.
			// URL u = new URL(url);
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
			String sql = "update bbs set content = ? where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, bag.getContent()); // 그냥 먼저 적혀있는 순서대로..
			ps.setInt(2, bag.getNo());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4.SQL문 오라클로 보내기 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(BbsVO_w bag) {

		try {
			// 1. 오라클 11g와 연결한 부품 설정(커넥터 설정)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:mysql://localhost:3306/multi";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.mySQL 연결 성공");

			// 3. SQL문을 만든다.
			// URL u = new URL(url);
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
			String sql = "insert into bbs (title, content, writer) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요

			// ** db는 인덱스가 1부터 시작!!!
			ps.setString(1, bag.getTitle());
			ps.setString(2, bag.getContent());
			ps.setString(3, bag.getWriter());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public ArrayList<BbsVO_w> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		// ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미
		ArrayList<BbsVO_w> list = new ArrayList<>();

		BbsVO_w bag = null;
		try {
			// 1.연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공.");
			

			// 2.연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. mySQL 연결 성공.");
			
			
			String sql = "select * from bbs";
			PreparedStatement ps = con.prepareStatement(sql); 
		
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			while (rs.next()) { 
				int no = rs.getInt(1);
				String title = rs.getString(2); 
				String content = rs.getString(3); 
				String writer = rs.getString(4); 
				System.out.println(no + " " + title + " " + content + " " + writer);
				
				// 3. 가방을 만들고 값들을 넣는다
				bag = new BbsVO_w();
				bag.setNo(no);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);

				// 4. list에 bag을 추가해주자.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}

}
