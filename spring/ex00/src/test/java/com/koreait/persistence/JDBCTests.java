package com.koreait.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void connectionTest() {
		// try(Statement) : 소괄호 안에 close를 필요로 하는 인스턴스를 작성하게 되면
		// try문이 끝났을 때 자동으로 close()를 실행해준다.
		try(
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/gb",
						"root",
						"1234"
				);
			) {
			log.info(conn);
		} catch(Exception e) {
			
		}
	}
}
