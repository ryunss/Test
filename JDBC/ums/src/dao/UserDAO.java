package dao;

import java.util.HashSet;

import dto.UserDTO;

public class UserDAO {

	DBConnection conn;
	
	public UserDAO() {
		conn = new DBConnection("UserTable.txt");
	}
	
	public boolean join(UserDTO user) {
		return conn.insert(user.toString());
	}
	
	public boolean checkId(String userid) {
		HashSet<String> rs = conn.select(0,userid);
		return rs.size() == 0;
	}

	public boolean login(String userid, String userpw) {
		//{"apple	abcd1234	김사과	..."}
		HashSet<String> rs = conn.select(0,userid);
		
		for(String line : rs) {
			//line : "apple	abcd1234	김사과	..."
			//datas : {"apple","abcd1234","김사과",..}
			String[] datas = line.split("\t");
			if(datas[1].equals(userpw)) {
				//로그인 성공
				UserDTO loginUser = new UserDTO(datas);
				Session.setData("loginUser", loginUser);
				return true;
			}
		}
		//로그인 실패
		return false;
	}

	public boolean modifyUser(String userid, int choice, String newData) {
		//choice : 1(비밀번호 수정 - 1) / 2(핸드폰 번호 수정 - 4) / 3(주소 수정 - 5)
		boolean check = false;
		if(choice == 1) {
			check = conn.update(userid, 1, newData);
		}
		else if(choice == 2) {
			check = conn.update(userid, 4, newData);
		}
		else if(choice == 3) {
			check = conn.update(userid, 5, newData);
		}
		if(check) {
			HashSet<String> rs = conn.select(0,userid);
			for(String line : rs) {
				UserDTO loginUser = new UserDTO(line.split("\t"));
				Session.setData("loginUser", loginUser);
			}
		}
		return check;
	}

	public boolean leaveId(String userid) {
		boolean check = conn.delete(userid);
		if(check) {
			Session.setData("loginUser", null);
		}
		return check;
	}
}







