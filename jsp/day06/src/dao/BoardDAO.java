package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.BoardDTO;
import mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSession sqlsession;
	
	public BoardDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}
	
	public boolean writeBoard(BoardDTO board) {
		return sqlsession.insert("Board.write",board) == 1;
	}
	
	public List<BoardDTO> getList(int page) {
		int startrow = (page-1)*10;
		List<BoardDTO> list = sqlsession.selectList("Board.getList",startrow);
		return list;
	}
	
	public int getCnt() {
		return sqlsession.selectOne("Board.getCnt");
	}
	
	public BoardDTO getDetail(int boardnum) {
		return sqlsession.selectOne("Board.getDetail",boardnum);
	}
	
	public boolean remove(int boardnum) {
		return sqlsession.delete("Board.remove",boardnum) == 1;
	}
	public boolean updateBoard(int boardnum,String boardtitle,String boardcontents) {
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("boardnum", boardnum);
		datas.put("boardtitle", boardtitle);
		datas.put("boardcontents", boardcontents);
		return sqlsession.update("Board.updateBoard",datas) == 1;
	}
}









