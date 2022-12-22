package com.koreait.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.dto.BoardDTO;
import com.koreait.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSession sqlsession;
	
	public BoardDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}

	public int getBoardCnt(String keyword) {
		if(keyword == null) {
			return sqlsession.selectOne("Board.getBoardCnt");
		}else {
			return sqlsession.selectOne("Board.getBoardCntWithKey", keyword);
		}
		
//		return keyword == null ? sqlsession.selectOne("Board.getBoardCnt") : 
//			sqlsession.selectOne("Board.getBoardCntWithKey");
	}

	public List<BoardDTO> getBoardList(int startRow, int pageSize, String keyword) {
		HashMap<String, Object> datas = new HashMap<String, Object>();
		List<BoardDTO> result = null;
		
		datas.put("startRow", startRow);
		datas.put("pageSize", pageSize);
		
		if(keyword == null) {
			result = sqlsession.selectList("Board.getBoardList", datas);
		}else {
			datas.put("keyword", keyword);
			result = sqlsession.selectList("Board.getBoardListWithKey",datas);
		}
		
		return result;
	}

	public List<BoardDTO> getBoardDetail(String boardnum) {
		return sqlsession.selectList("Board.getBoardDetail", boardnum);
	}

	
}
