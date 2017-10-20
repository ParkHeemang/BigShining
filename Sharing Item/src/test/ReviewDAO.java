package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class ReviewDAO {
	
	private String url = "jdbc:oracle:thin:@127.0.01:1521:XE";
	private String user = "system";
	private String password = "1234";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	
	public void getConnection() throws ClassNotFoundException, SQLException {
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.커넥션 / getConnection : static 메서드
		con = DriverManager.getConnection(url, user, password);
	}

	
	public void insert(Review review_i) {

		// Scanner sc = new Scanner(System.in);

		// System.out.println("이름");
		// String name = sc.next();
		// System.out.println("번호");
		// String number = sc.next();
		// System.out.println("나이");
		// int age = sc.nextInt();

		try {
			getConnection();

			String sql = "insert into reviews values(?,?,?,?,?)";
			psmt = con.prepareStatement(sql); // sql을 재활용하고 싶을 때 많이 사용

			psmt.setInt(1, review_i.getReviewsItemNum()); // jdbc는 순번은 1부터 시작함 / 넣을 인덱스 값, 넣을 값
			psmt.setString(2, review_i.getDate());

			psmt.setInt(3, review_i.getScore());

			psmt.setString(4, review_i.getStatement());
			
			psmt.setString(5, review_i.getUser());
		

			// 데이터베이스에 변동을 줄 때(insert,update)

			psmt.executeUpdate();
			// 데이터베이스에서 값을 꺼내 올 때(select)

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 에러가 날 시 catch밑에 코드는 다 다운먹는데 유일하게 finally부분만 실행함

			// 닫을 때는 열었던 순서의 반대로 닫아주면 됨 / 닫아줘야 나중에 다운이 안먹음(계속 연결을 하기 때문에)
			try {
				// 닫다가 에러가 날 수 있기 때문에 예외처리
				if (psmt != null)
					psmt.close(); // pstm가 null일 경우을 대비해 처리
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	public ArrayList<Review> selectReviewsByItemNum(int itemNum) {

		Review review = null;
		ArrayList<Review> list = new ArrayList<>();

		try {
			getConnection();

			String sql = "select * from reviews where itemnum=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, itemNum);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int result_itemNum = rs.getInt(1);
				String result_date = rs.getString(2);
				int result_score = rs.getInt(3);
				String result_statement = rs.getString(4);
				String result_username = rs.getString(5);
				

				review = new Review(result_itemNum, result_date, result_score,result_statement, result_username);

				list.add(review);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

}
