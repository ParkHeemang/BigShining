package SourceOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	   
	   

	   
	   public Users selectOneByName(String itemName) {        //�̸����� �ҷ�����

	      Users m = null;

	      try {
	         getConnection();

	         String sql = "select * from member where name= ?";
	         psmt = con.prepareStatement(sql);
	         psmt.setString(1, itemName);

	         rs = psmt.executeQuery(); // ��ȯ��(Resultset) Ŭ����Ÿ������ �Ǿ� �ִٰ� ����

	         while (rs.next()) { // Ŀ���� ������(���� ó�� Ŀ���� ���� ���� ����Ű�� ���� next�� ������ ������(��)�� Ŀ���� ��ġ��Ŵ / booleanŸ�� ��ȯ
	            String result_owner = rs.getString(1); // ������̺� ������ ���� ��ȣ�� ����(�������)
	            String result_type = rs.getString(3); // ���� �̸��� ���̸� �������� sql���̿��ٸ� �̸��� 1�� ���̰� 2���� ��
	            int result_fee = rs.getInt(4);
	            String item_comment = rs.getString(5);
	            int result_available = rs.getInt(6);
	            int usersscore = rs.getInt(7);
	           
	            
	            m = new Users();
	       
	         
	         
	         
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
