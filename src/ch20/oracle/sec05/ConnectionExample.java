package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		
//		Connection conn = null;
//		
//		try {
//			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			
//			//DB와 연결
//			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "c##java", "oracle");
//			System.out.println("연결 성공");
//			
//			//DB 작업
//			
//			
//
//
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) {
//				
//			//DB 연결 끊기
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			System.out.println("연결 끊김");
//			}
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "c##java", "oracle")) {
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "c##java", "oracle");
				System.out.println("연결 성공");
				
				//DB 작업
				//~
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("연결 끊김");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
