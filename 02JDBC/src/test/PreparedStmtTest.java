package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
 * PreparedStatement 의 장점
 * 1. 반복적 같은 SQL 수행 시 효율적
 * 2. 가독성, 사용 편의성 유용
 * 3. Binary Data 입력 시 유용
 */
public class PreparedStmtTest {

	public static void main(String[] args) throws Exception {
		
		int no = Integer.parseInt(args[0]);
		String id = args[1];
		String pwd = (args[2]);
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 1단계 :: login
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		// Statement / PreparedState 비교 이해
		/* ============= Statement 사용 ================ 
		Statement stmt = con.createStatement();
		String sql = "INSERT INTO member VALUES("+no+",'"+id+"',"+pwd+")";
		
		int i = stmt.executeUpdate(sql);
		System.out.println("1번 insert 유무 : "+i+" 개의 행이 만들어졌습니다."); */
		
		// ============= PreparedStatement 사용 ================ //
		// PreparedStatement 인스턴스 생성시 SQL 구성
		PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?)");
		
		// PreparedStatement method 사용해서 데이터 세팅 (' ' 불필요!)
		pstmt.setInt(1,  no);
		pstmt.setString(2,  id);
		pstmt.setString(3, pwd);
		int confirm = pstmt.executeUpdate();
		
		if (confirm == 1) {
			System.out.println("number Table data Insert 완료!");
		}else {
			System.out.println("number Table data Insert 실패!");
		}

		if (pstmt !=null)
			pstmt.close();
		if (con !=null)
			con.close();
	}

}