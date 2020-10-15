package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example03 {

	public static void main(String[] args) throws Exception {
		
		int id = Integer.parseInt(args[0]);
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 1단계 :: login
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		// 2단계 :: SQL 쿼리 전송 
		Statement stmt = con.createStatement();
		
		// DML : DELETE
		String sql = "DELETE FROM member where no="+id+"";
		
		// executeUpdate() : DELETE 전송
		int i = stmt.executeUpdate(sql);
		System.out.println("delete 된 record 의 수는 : " + i +" 행이 삭제되었습니다.");
		
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

}
