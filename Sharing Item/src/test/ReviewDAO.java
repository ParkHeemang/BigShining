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
		// 1.����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.Ŀ�ؼ� / getConnection : static �޼���
		con = DriverManager.getConnection(url, user, password);
	}

	
	public void insert(Review review_i) {

		// Scanner sc = new Scanner(System.in);

		// System.out.println("�̸�");
		// String name = sc.next();
		// System.out.println("��ȣ");
		// String number = sc.next();
		// System.out.println("����");
		// int age = sc.nextInt();

		try {
			getConnection();

			String sql = "insert into reviews values(?,?,?,?,?)";
			psmt = con.prepareStatement(sql); // sql�� ��Ȱ���ϰ� ���� �� ���� ���

			psmt.setInt(1, review_i.getReviewsItemNum()); // jdbc�� ������ 1���� ������ / ���� �ε��� ��, ���� ��
			psmt.setString(2, review_i.getDate());

			psmt.setInt(3, review_i.getScore());

			psmt.setString(4, review_i.getStatement());
			
			psmt.setString(5, review_i.getUser());
		

			// �����ͺ��̽��� ������ �� ��(insert,update)

			psmt.executeUpdate();
			// �����ͺ��̽����� ���� ���� �� ��(select)

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // ������ �� �� catch�ؿ� �ڵ�� �� �ٿ�Դµ� �����ϰ� finally�κи� ������

			// ���� ���� ������ ������ �ݴ�� �ݾ��ָ� �� / �ݾ���� ���߿� �ٿ��� �ȸ���(��� ������ �ϱ� ������)
			try {
				// �ݴٰ� ������ �� �� �ֱ� ������ ����ó��
				if (psmt != null)
					psmt.close(); // pstm�� null�� ����� ����� ó��
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
