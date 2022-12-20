package com.koreait.dao;

import org.apache.ibatis.session.SqlSession;

import com.koreait.dto.UserDTO;
import com.koreait.mybatis.SqlMapConfig;

public class UserDAO {
	SqlSession sqlsession;
	
	public UserDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}

	public boolean join(UserDTO user) {
		return sqlsession.insert("User.join", user) == 1;
	}
}
