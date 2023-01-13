package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.db.QueryMysql;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements QueryMysql{

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			// PreparedStatement 생성
			System.out.println("INSERT");
			pstmt = conn.prepareStatement(SQL_INSERT); // <- (?, ?, ?) 세개의 ?가 있다
			pstmt.setInt(1,  10); // 첫번째 ? 에 10 넣는다.
			pstmt.setString(2, "바나나"); // 두번째 ? 에 바나나 넣는다
			pstmt.setString(3,  "2026-12-21"); // 세번째 ?에 문자열로 날짜 넣었다.
			int cnt = pstmt.executeUpdate(); // statement랑 다르게 매개변수가 없다. db01 참고
			System.out.println(cnt +"개 행(row) INSERT 성공");
			
			pstmt.close(); // 기존 PreparedStatement는 자원해제
						// 위에 INSERT는 종료하고 UPDATE 할려고 종료시킨거. 
			
			// UPDATE
			System.out.println("UPDATE");
			pstmt = conn.prepareStatement(SQL_UPDATE_NO);
			pstmt.setInt(1, 77);
			pstmt.setString(2, "바나나");
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개 행(row) UPDATE 성공");
			
			pstmt.close();
			
			// SELECT
			System.out.println("SELECT");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
			pstmt.setString(1, "바나나");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("mb_no");
				String name = rs.getString("mb_name");
				String birthDate = rs.getString("mb_birthdate");
				
				System.out.printf("%s\t|%s\t|%s\n",no,name,birthDate);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end main()

} // end class DB03Main






















