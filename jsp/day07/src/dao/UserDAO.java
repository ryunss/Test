package dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import dto.UserDTO;
import mybatis.SqlMapConfig;

public class UserDAO {
	
	SqlSession sqlsession;
	
	public UserDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);	//true시 오토커밋
	}
	
	public boolean join(UserDTO user) {
		return sqlsession.insert("User.join",user) == 1;
	}
	public UserDTO login(String userid, String userpw) {
//		넘기려는 여러개의 값들이 한 클래스의 필드로 존재할 수 있다면 객체로 포장
//		UserDTO user = new UserDTO();
//		user.setUserid(userid);
//		user.setUserpw(userpw);
//		sqlsession.selectOne("User.login",user);
		
//		아니라면 해쉬맵에 세팅해서 넘겨주기
		HashMap<String, String> datas = new HashMap<>();
		datas.put("userid", userid);
		datas.put("userpw", userpw);
		
		return sqlsession.selectOne("User.login",datas);
	}
	
	public boolean checkId(String userid) {
//		return (Integer)sqlsession.selectOne("User.checkId",userid) == 0;
		int result = 0;
		result = sqlsession.selectOne("User.checkId",userid);
		return result == 0;
	}
}










