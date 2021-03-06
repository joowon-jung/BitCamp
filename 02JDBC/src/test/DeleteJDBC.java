package test;

import java.sql.*;

public class DeleteJDBC {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		Statement stmt = con.createStatement();
		
		// DML : DELETE // 게시물 삭제시 이용 
		String sql = "DELETE FROM firstJDBC WHERE no = 3";
		
		// executeUpdate() : DELETE 전송
		int i = stmt.executeUpdate(sql);
		System.out.println("delete 된 record 의 수는 : " + i +" 행이 삭제되었습니다.");
		
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

}
