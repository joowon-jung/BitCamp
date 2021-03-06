package test;

import java.sql.*;
import java.util.*;

//==> 아래의 import 주석 처리한 이유 이해
//import oracle.jdbc.driver.*;

/*
*	FileName : ConnectionTest02.java
*
*	1. JDBC Programming 절차 이해
	==> DBMS 접근 ( LOGIN 과정 )	: Connection 객체로 Object Modeling
	==> SQL Prompt & SQL 전송		: Statement 객체로 Object Modeling
	==> SQL 문의 결과				: ResultSet 객체로 Object Modeling
*/
public class ConnectionTest02{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB에 로그인 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="scott";
		String pwd = "tiger";

/* =============== DBMS 종속적인 아래의 부분을 주석처리한 이유 이해 ===========
		//1.단계  connection :: login 과정
		//1.1 OracleDriver  instance 생성
		OracleDriver od = new OracleDriver();

		//1.2 oracle에 접속 정보를 갖는  properties instance 생성 
		Properties info = new Properties();
		info.put("user",user);
		info.put("password",pwd);

		//1.3OracleDriver intance를 사용  Connection instance 생성
		Connection con = od.connect(url,info);
====================================================== */

		// Interface 기반 Programming : java.sql.* 이용 DBMS 비종속적인 DB
		// 1단계 connection :: login 과정
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, pwd);

		//2단계 QUERY (SELECT * FROM product) 전송단계 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM product");  // executeQuery : select 에 사용 

		//3단계 결과 확인

		while (rs.next()) // rs.next() != false
		{
			String productName = rs.getString("p_name");
			//String productName = rs.getString(1); ==> database 는 인덱스가 1부터 시작!
			int productPrice = rs.getInt("p_price");
			//int productPrice = rs.getInt(2);

			System.out.println("상품명 : "+productName);
			System.out.println("가   격 : "+productPrice);
		}

		//각각의 객체를 close한다.
		rs.close();
		stmt.close();
		con.close();

	}//end of main

}//end of class