package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardSelectExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "c##java", "oracle");
			System.out.println("연결 성공");
			
			//DB 작업
			String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "winter");
			List<Board> boards = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfileName(rs.getString("bfilename"));
				board.setBfileData(rs.getBlob("bfiledata"));
				
				Blob blob = board.getBfileData();
				if(blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C:/Temp/" + board.getBfileName());
					
					byte[] data = new byte[1024];
					
					is.transferTo(os);
					os.flush();
					
					is.close();
					os.close();
				}
				
				boards.add(board);
			}
			rs.close();
			
			printBoard(boards);
			
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				
			//DB 연결 끊기
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("연결 끊김");
			}
		}
	}
	
	public static void printBoard(List<Board> boards) {
//		for(Board board : boards) {
//			System.out.println(board);
//		}
		
		boards.stream().forEach(b -> System.out.println(b));
	}
}
