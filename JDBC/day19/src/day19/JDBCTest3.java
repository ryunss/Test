package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest3 {

	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("검색하실 데이터의 번호 : ");
//		int input = sc.nextInt();
//		String sql = "SELECT * FROM test WHERE num = "+input;

		System.out.print("검색하실 데이터의 strdata : ");
		String input = sc.nextLine();
		String sql = "SELECT * FROM test WHERE strdata = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// ps.set~~~(n, data) : n번째 물음표 자리에 data를 ~~~타입으로 세팅
			ps.setString(1, input);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int num = rs.getInt("num");
				String strdata = rs.getString("strdata");
				String timedata = rs.getString("timedata");
				
				System.out.println(num + " / " + strdata + " / " + timedata);
			}else {
				System.out.println("검색된 결과가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
