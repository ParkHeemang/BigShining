package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {

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

	public void insert(Item item_i) {

		// Scanner sc = new Scanner(System.in);

		// System.out.println("이름");
		// String name = sc.next();
		// System.out.println("번호");
		// String number = sc.next();
		// System.out.println("나이");
		// int age = sc.nextInt();

		try {
			getConnection();

			String sql = "insert into items values(?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql); // sql을 재활용하고 싶을 때 많이 사용

			psmt.setInt(1, item_i.getItemNum()); // jdbc는 순번은 1부터 시작함 / 넣을 인덱스 값, 넣을 값
			psmt.setString(2, item_i.getOwner());

			psmt.setString(3, item_i.getType());

			psmt.setInt(4, item_i.getFee());
			psmt.setInt(5, item_i.getAvailable());
			psmt.setString(6, item_i.getBrand());

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

	
	
	public ArrayList<Item> selectOwners(String owner) {

		Item item = null;
		ArrayList<Item> list = new ArrayList<>();

		try {
			getConnection();

			String sql = "select * from items where owner=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, owner);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int result_itemNum = rs.getInt(1);
				String result_owner = rs.getString(2);
				String result_type = rs.getString(3);
				int result_fee = rs.getInt(4);
				int result_available = rs.getInt(5);
				String result_brand = rs.getString(6);
				

				item = new Item(result_owner, result_type, result_fee, result_available, result_brand);

				list.add(item);
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

	public Item selectOneByType(String itemType) { // 이름으로 불러오기

		Item item = null;

		try {
			getConnection();

			String sql = "select * from items where type= ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, itemType);

			rs = psmt.executeQuery(); // 반환값(Resultset) 클래스타입으로 되어 있다고 생각

			while (rs.next()) { // 커서를 움직임(제일 처음 커서는 제일 위를 가리키고 있음 next할 때마다 다음줄(밑)로 커서를 위치시킴 / boolean타입 반환
				
				
				int result_itemNum = rs.getInt(1);
				String result_owner = rs.getString(2);
				String result_type = rs.getString(3);
				int result_fee = rs.getInt(4);
				int result_available = rs.getInt(5);
				String result_brand = rs.getString(6);
				

				item = new Item(result_owner, result_type, result_fee, result_available, result_brand);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 에러가 날 시 catch밑에 코드는 다 다운먹는데 유일하게 finally부분만 실행함

			// 닫을 때는 열었던 순서의 반대로 닫아주면 됨 / 닫아줘야 나중에 다운이 안먹음(계속 연결을 하기 때문에)
			try {
				// 닫다가 에러가 날 수 있기 때문에 예외처리

				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close(); // pstm가 null일 경우을 대비해 처리
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	
	
	
	
//	public Item selectOneByItemNum(int itemNum) { // 이름으로 불러오기
//
//		Item item = null;
//
//		try {
//			getConnection();
//
//			String sql = "select * from items where itemnum= ?";
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, itemNum);
//
//			rs = psmt.executeQuery(); // 반환값(Resultset) 클래스타입으로 되어 있다고 생각
//
//			while (rs.next()) { // 커서를 움직임(제일 처음 커서는 제일 위를 가리키고 있음 next할 때마다 다음줄(밑)로 커서를 위치시킴 / boolean타입 반환
//				
//				
//				int result_itemNum = rs.getInt(1);
//				String result_owner = rs.getString(2);
//				String result_type = rs.getString(3);
//				int result_fee = rs.getInt(4);
//				int result_available = rs.getInt(5);
//				
//
//				item = new Item(result_owner, result_type, result_fee, result_available);
//
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally { // 에러가 날 시 catch밑에 코드는 다 다운먹는데 유일하게 finally부분만 실행함
//
//			// 닫을 때는 열었던 순서의 반대로 닫아주면 됨 / 닫아줘야 나중에 다운이 안먹음(계속 연결을 하기 때문에)
//			try {
//				// 닫다가 에러가 날 수 있기 때문에 예외처리
//
//				if (rs != null)
//					rs.close();
//				if (psmt != null)
//					psmt.close(); // pstm가 null일 경우을 대비해 처리
//				if (con != null)
//					con.close();
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return item;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
