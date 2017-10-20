package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {

	private String url = "jdbc:oracle:thin:@127.0.01:1521:XE";
	private String user = "system";
	private String password = "1234";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	
	
	
	
	
	
	public void insert(Users user_i) {

		// Scanner sc = new Scanner(System.in);

		// System.out.println("�̸�");
		// String name = sc.next();
		// System.out.println("��ȣ");
		// String number = sc.next();
		// System.out.println("����");
		// int age = sc.nextInt();

		try {
			getConnection();

			String sql = "insert into users values(?,?,?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql); // sql�� ��Ȱ���ϰ� ���� �� ���� ���

			psmt.setString(1, user_i.getId()); // jdbc�� ������ 1���� ������ / ���� �ε��� ��, ���� ��
			psmt.setString(2, "asd");

			psmt.setString(3, user_i.getName());

			psmt.setString(4, user_i.getAddress());
			psmt.setString(5, user_i.getSex());
			psmt.setString(6, user_i.getPassword());
			psmt.setInt(7, user_i.getAge());
			psmt.setString(8, null);
			psmt.setString(9, null);
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

	public void getConnection() throws ClassNotFoundException, SQLException {
		// 1.����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.Ŀ�ؼ� / getConnection : static �޼���
		con = DriverManager.getConnection(url, user, password);
	}

	public Users selectOneByName(String name) { // �̸����� �ҷ�����

		Users m = null;

		try {
			getConnection();

			String sql = "select * from users where name= ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);

			rs = psmt.executeQuery(); // ��ȯ��(Resultset) Ŭ����Ÿ������ �Ǿ� �ִٰ� ����

			while (rs.next()) { // Ŀ���� ������(���� ó�� Ŀ���� ���� ���� ����Ű�� ���� next�� ������ ������(��)�� Ŀ���� ��ġ��Ŵ / booleanŸ�� ��ȯ
				String result_id = rs.getString(1); // ������̺� ������ ���� ��ȣ�� ����(�������)
				String result_userImglUrl = rs.getString(2); // ���� �̸��� ���̸� �������� sql���̿��ٸ� �̸��� 1�� ���̰� 2���� ��
				String result_name = rs.getString(3);
				String result_adress = rs.getString(4);
				String result_sex = rs.getString(5);
				String result_password = rs.getString(6);
				int result_age = rs.getInt(7);
				String result_phoneaddress = rs.getString(8);
				String result_usercomment = rs.getString(9);
		

				m = new Users(result_id, result_userImglUrl, result_name, result_adress, result_sex, result_password, result_age, result_phoneaddress, result_usercomment);

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
		return m;
	}

	
	
}
