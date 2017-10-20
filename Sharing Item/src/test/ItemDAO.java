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
		// 1.����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.Ŀ�ؼ� / getConnection : static �޼���
		con = DriverManager.getConnection(url, user, password);
	}

	public void insert(Item item_i) {

		// Scanner sc = new Scanner(System.in);

		// System.out.println("�̸�");
		// String name = sc.next();
		// System.out.println("��ȣ");
		// String number = sc.next();
		// System.out.println("����");
		// int age = sc.nextInt();

		try {
			getConnection();

			String sql = "insert into items values(?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql); // sql�� ��Ȱ���ϰ� ���� �� ���� ���

			psmt.setInt(1, item_i.getItemNum()); // jdbc�� ������ 1���� ������ / ���� �ε��� ��, ���� ��
			psmt.setString(2, item_i.getOwner());

			psmt.setString(3, item_i.getType());

			psmt.setInt(4, item_i.getFee());
			psmt.setInt(5, item_i.getAvailable());
			psmt.setString(6, item_i.getBrand());

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

	public Item selectOneByType(String itemType) { // �̸����� �ҷ�����

		Item item = null;

		try {
			getConnection();

			String sql = "select * from items where type= ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, itemType);

			rs = psmt.executeQuery(); // ��ȯ��(Resultset) Ŭ����Ÿ������ �Ǿ� �ִٰ� ����

			while (rs.next()) { // Ŀ���� ������(���� ó�� Ŀ���� ���� ���� ����Ű�� ���� next�� ������ ������(��)�� Ŀ���� ��ġ��Ŵ / booleanŸ�� ��ȯ
				
				
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
		} finally { // ������ �� �� catch�ؿ� �ڵ�� �� �ٿ�Դµ� �����ϰ� finally�κи� ������

			// ���� ���� ������ ������ �ݴ�� �ݾ��ָ� �� / �ݾ���� ���߿� �ٿ��� �ȸ���(��� ������ �ϱ� ������)
			try {
				// �ݴٰ� ������ �� �� �ֱ� ������ ����ó��

				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close(); // pstm�� null�� ����� ����� ó��
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	
	
	
	
//	public Item selectOneByItemNum(int itemNum) { // �̸����� �ҷ�����
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
//			rs = psmt.executeQuery(); // ��ȯ��(Resultset) Ŭ����Ÿ������ �Ǿ� �ִٰ� ����
//
//			while (rs.next()) { // Ŀ���� ������(���� ó�� Ŀ���� ���� ���� ����Ű�� ���� next�� ������ ������(��)�� Ŀ���� ��ġ��Ŵ / booleanŸ�� ��ȯ
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
//		} finally { // ������ �� �� catch�ؿ� �ڵ�� �� �ٿ�Դµ� �����ϰ� finally�κи� ������
//
//			// ���� ���� ������ ������ �ݴ�� �ݾ��ָ� �� / �ݾ���� ���߿� �ٿ��� �ȸ���(��� ������ �ϱ� ������)
//			try {
//				// �ݴٰ� ������ �� �� �ֱ� ������ ����ó��
//
//				if (rs != null)
//					rs.close();
//				if (psmt != null)
//					psmt.close(); // pstm�� null�� ����� ����� ó��
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
