package multi;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MovieDAO {

	public ArrayList<MemberVO_w> list() {
		ResultSet rs = null;

		// 가방들 넣어줄 큰 컨테이너 역할의 부품이 필요
		// ArrayList
		ArrayList<MemberVO_w> list = new ArrayList();

		MemberVO_w bag = null;

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

			String sql = "select * from movie";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();

			System.out.println("4.SQL문 오라클로 보내기 성공");
			while (rs.next()) {
				// 1. 검색결과가 있으면
				// 2. 각 컬럼에서 값들을 꺼내오자
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);

				// 3. 가방을 만들자
				bag = new MemberVO_w();
				bag.setId(id);
				bag.setpw(pw);
				bag.setName(name);
				bag.setTel(tel);

				// 4. list에 bag을 추가해주자
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

	public int delete(String id) {
		int result = 0;
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
			String sql = "delete from movie where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);

			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, id);

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

	public int update(MemberVO_w bag) {
		int result = 0;
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
			String sql = "update movie set tel = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, bag.getTel()); // 그냥 먼저 적혀있는 순서대로..
			ps.setString(2, bag.getId());

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

	public int insert(MovieVO bag) {
		int result = 0;
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
			String sql = "insert into movie values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, bag.getId()); // 그냥 먼저 적혀있는 순서대로..
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getContent());
			ps.setString(4, bag.getLocation());
			ps.setString(5, bag.getDirector());

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

	///////////// 로그인

	public int login(MemberVO_w bag) {
		int result = 0;

		try {
			// 1. 오라클 11g와 연결한 부품 설정(커넥터 설정)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.오라클과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결하자(java ---- oracle)(DB연결)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.오라클 연결 성공");

			// 3. SQL문을 만든다.
			// URL u = new URL(url);
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
			String sql = "select * from hr.MEMBER where id = ? and where pw = ? ";
			PreparedStatement ps = con.prepareStatement(sql);

			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getpw());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ResultSet rs = ps.executeQuery();

			System.out.println("4.SQL문 오라클로 보내기 성공");
			if (rs.next()) { //// 검색결과가 있는지 여부는 rs.next()
				//// true이면 있다, false이면 없다 라는 의미
				System.out.println("결과 값 있음");
				result = 1;
			}
			ps.close();
			con.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
