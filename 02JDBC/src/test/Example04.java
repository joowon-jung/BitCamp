package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
데이터 검색하는 JDBC 실습 4)

:: 입력된 Record 수와 무관하게 아래와 같이 출력

회원정보 ==> 번호 : 1, id : angel, pwd : 1004 
...등등 
*/

public class Example04 {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 1단계 :: login
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		// 2단계 :: SQL 쿼리 전송 
		Statement stmt = con.createStatement();
		
		String sql = ("SELECT * from member");
				
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			int no = rs.getInt(1);
			//String productName = rs.getString(1); ==> database 는 인덱스가 1부터 시작!
			String id = rs.getString(2);
			//int productPrice = rs.getInt(2);
			int pwd = rs.getInt(3);

			System.out.print("회원정보 => ");
			System.out.print(" 번호 : "+ no);
			System.out.print(", id : "+ id);
			System.out.println(", pwd : " + pwd);
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}