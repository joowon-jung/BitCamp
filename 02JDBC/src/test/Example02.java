package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example02 {

	public static void main(String[] args) throws Exception {
		
		int no = Integer.parseInt(args[0]);
		String id = args[1];
		int pwd = Integer.parseInt(args[2]);
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 1단계 :: login
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		// 2단계 :: SQL 쿼리 전송 
		Statement stmt = con.createStatement();
		
		String sql = "INSERT INTO member VALUES("+no+",'"+id+"',"+pwd+")";
		
		//executeUpdate(): DML 전송
		int i = stmt.executeUpdate(sql);
		System.out.println("1번 insert 유무 : "+i+" 개의 행이 만들어졌습니다.");
		
		if (stmt !=null)
			stmt.close();
		if (con !=null)
			con.close();
	}

}
