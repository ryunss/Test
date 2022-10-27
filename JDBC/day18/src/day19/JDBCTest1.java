package day19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) {
		Connection conn;
		PreparedStatement ps;
		
		try {
		// 재료 준비 - 드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver"); // 클래스를 작동하도록 준비시킨다.
		 
		// 목적지
		//127.0.0.1
		String url = "jdbc:mysql://localhost:3306/gb";
		String user = "root";
		String password = "1234";
		
		conn = DriverManager.getConnection(url, user, password);
		// 전달할 택배물
		String sql = "INSERT INTO test (strdata) VALUES('JDBC Test1')";
		// 택배물을 전달해줄 콜트럭 잡기
		ps = conn.prepareStatement(sql);
		
		// 진행시키고 결과는 1, 0 (성공이냐 실패냐)로 들고옴
		int result = ps.executeUpdate();
		
		if(result == 1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
