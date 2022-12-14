package dao;

import org.apache.ibatis.session.SqlSession;

import dto.BoardDTO;
import mybatis.SqlMapConfig;

public class BoardDAO {

	SqlSession sqlsession;
	
	public BoardDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}
	
	public boolean write(BoardDTO board) {
		return sqlsession.insert("Board.write", board) == 1;
	}
}
