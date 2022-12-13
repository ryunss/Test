package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.UserDTO;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	Context context;
	DataSource ds;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean join(UserDTO user) {
		
		String sql = "insert into test_user values(?,?,?)";
		int result = 0;
		try {
			context = new InitialContext(null);
			ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			String userid = user.getUserid();
			String userpw = user.getUserpw();
			String username = user.getUsername();
			
			ps.setString(1, userid);
			ps.setString(2, userpw);
			ps.setString(3, username);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
		
		return result == 1;
	}
	
	public boolean login(String userid, String userpw) {

		String sql = "select * from test_user where userid=? and userpw=?";
		int result = 0;
	
		try {
			context = new InitialContext(null);
			ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			ps.setString(2, userpw);
			
			rs = ps.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
		
		return false;
	}
	
	public boolean checkId(String userid) {
		String sql = "select * from test_user where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			return !rs.next(); // 중복된 아이디가 없어야 true
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
