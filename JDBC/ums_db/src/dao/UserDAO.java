package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;


public class UserDAO {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean join(UserDTO user) {
		try {
			String sql = "insert into user (userid,userpw,username,userage,userphone,useraddr) "
					+ "values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.userid);
			ps.setString(2, user.userpw);
			ps.setString(3, user.username);
			ps.setInt(4, user.userage);
			ps.setString(5, user.userphone);
			ps.setString(6, user.useraddr);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
		}
		return false;
	}
	
	public boolean checkId(String userid) {
		try {
			String sql = "select * from user where userid=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			return !rs.next();
			
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean login(String userid, String userpw) {
		try {
			String sql = "select * from user where userid=? and userpw=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			ps.setString(2, userpw);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				UserDTO loginUser = new UserDTO();
				loginUser.userid = rs.getString("userid");
				loginUser.userpw = rs.getString("userpw");
				loginUser.username = rs.getString("username");
				loginUser.userage = rs.getInt("userage");
				loginUser.userphone = rs.getString("userphone");
				loginUser.useraddr = rs.getString("useraddr");
				
				Session.setData("loginUser", loginUser);
				
				return true;
			}
		} catch (SQLException e) {
		}
		//로그인 실패
		return false;
	}

	public boolean modifyUser(String userid, int choice, String newData) {
		//choice : 1(비밀번호 수정 - 1) / 2(핸드폰 번호 수정 - 4) / 3(주소 수정 - 5)
		String[] cols = {"","userpw","userphone","useraddr"};
		try {
			String sql = "update user set "+cols[choice]+"=? where userid=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newData);
			
			if(ps.executeUpdate() == 1) {
				sql = "select * from user where userid=?";
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, userid);
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					UserDTO loginUser = new UserDTO();
					loginUser.userid = rs.getString("userid");
					loginUser.userpw = rs.getString("userpw");
					loginUser.username = rs.getString("username");
					loginUser.userage = rs.getInt("userage");
					loginUser.userphone = rs.getString("userphone");
					loginUser.useraddr = rs.getString("useraddr");
					
					Session.setData("loginUser", loginUser);
					
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean leaveId(String userid) {
		try {
			String sql = "delete from user where userid=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			
			return 1 == ps.executeUpdate();
		} catch (SQLException e) {
		}
		return false;
	}
}







