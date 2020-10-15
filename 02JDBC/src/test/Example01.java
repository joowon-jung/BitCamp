package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.Exception;

public class Example01 {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 1단계 :: login
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		// 2단계 :: SQL 쿼리 전송 
		Statement stmt = con.createStatement();
			
		// Create Query 만들기
		String createSql = 
					"CREATE TABLE member" +
						"(no 		NUMBER," +
						"id 		VARCHAR2(10)," +
						"pwd 		VARCHAR2(10) )";
		
		// 3단계 : 결과 확인 
		stmt.executeUpdate(createSql);
		System.out.println("number TABLE 생성완료");
		
		// 사용했으면 닫아서 반환해주기 
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}

}
