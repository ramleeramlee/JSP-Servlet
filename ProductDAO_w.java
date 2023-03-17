package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import multi.ProductVO_w;
// 테이블 하나당 DAO하나! >> 
public class ProductDAO_w {

	public ArrayList<ProductVO_w> list() {
		ResultSet rs = null;
		ArrayList<ProductVO_w> list = new ArrayList<>();
		ProductVO_w bag = null;

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

			// 3. SQL문을 만든다.
			// URL u = new URL(url);
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
			String sql = "select * from product";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			rs = ps.executeQuery();
			System.out.println("4.SQL문 오라클로 보내기 성공");

			while (rs.next()) { //// 검색결과가 있는지 여부는 rs.next()
				
				System.out.println("검색결과 있음. 성공");
			// 각 컬럼에 있는 값들을 추출(get)
				String id = rs.getString("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String img = rs.getString("img");
				
			// 가방을 만들어서 추출한 값들 넣기(set)
				bag = new ProductVO_w();
				bag.setId(id);
				bag.setName(name);
				bag.setContent(content);
				bag.setPrice(price);
				bag.setCompany(company);
				bag.setImg(img);
				
			// 컨테이너에 가방 넣기	
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
	
	

	public ProductVO_w one(String id) {
			System.out.println(id);
			ResultSet rs = null;
			
			ProductVO_w bag = null;

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

				// 3. SQL문을 만든다.
				// URL u = new URL(url);
				// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못 함
				// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
				// SQL부품으로 만들어주어야 함 >> PreparedStatement 가 SQL부품!!
				String sql = "select * from product where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요

				System.out.println("3.SQL문 부품(객체)으로 만들어주기");

				// 4. 전송
				rs = ps.executeQuery();
				System.out.println("4.SQL문 오라클로 보내기 성공");

				if (rs.next()) { //// 검색결과가 있는지 여부는 rs.next()
					
					System.out.println("검색결과 있음. 성공");
				// 각 컬럼에 있는 값들을 추출(get)
					String id2 = rs.getString("id");
					String name = rs.getString("name");
					String content = rs.getString("content");
					int price = rs.getInt("price");
					String company = rs.getString("company");
					String img = rs.getString("img");
					System.out.println(id + " " + name + " " + content + " " + price + " " + company + " " + img);

				// 가방을 만들어서 추출한 값들 넣기(set)
					bag = new ProductVO_w();
					bag.setId(id);
					bag.setName(name);
					bag.setContent(content);
					bag.setPrice(price);
					bag.setCompany(company);
					bag.setImg(img);
				}else {
					System.out.println("검색결과 없음");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bag;
		}

	public void delete(String id) {
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
			String sql = "delete from product where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);

			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, id);

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(ProductVO_w bag) {
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
			String sql = "update product set company = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			ps.setString(1, bag.getCompany()); // 그냥 먼저 적혀있는 순서대로..
			ps.setString(2, bag.getId());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4.SQL문 오라클로 보내기 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(ProductVO_w bag) {

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
			String sql = "insert into product values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요

			// ** db는 인덱스가 1부터 시작!!!
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getName());
			ps.setString(3, bag.getContent());
			ps.setInt(4, bag.getPrice());
			ps.setString(5, bag.getCompany());
			ps.setString(6, bag.getImg());

			System.out.println("3.SQL문 부품(객체)으로 만들어주기");

			// 4. 전송
			ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
