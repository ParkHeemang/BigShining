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
	      // 1.드라이버 로딩
	      Class.forName("oracle.jdbc.driver.OracleDriver");

	      // 2.커넥션 / getConnection : static 메서드
	      con = DriverManager.getConnection(url, user, password);
	   }
	   
	   

	   
	   public Users selectOneByName(String itemName) {        //이름으로 불러오기

	      Users m = null;

	      try {
	         getConnection();

	         String sql = "select * from member where name= ?";
	         psmt = con.prepareStatement(sql);
	         psmt.setString(1, itemName);

	         rs = psmt.executeQuery(); // 반환값(Resultset) 클래스타입으로 되어 있다고 생각

	         while (rs.next()) { // 커서를 움직임(제일 처음 커서는 제일 위를 가리키고 있음 next할 때마다 다음줄(밑)로 커서를 위치시킴 / boolean타입 반환
	            String result_owner = rs.getString(1); // 결과테이블 구조에 따라 번호가 붙음(순서대로)
	            String result_type = rs.getString(3); // 만약 이름과 나이만 가져오는 sql문이였다면 이름이 1번 나이가 2번이 됨
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
	      return m;
	   }

	   
	
	
	

}
