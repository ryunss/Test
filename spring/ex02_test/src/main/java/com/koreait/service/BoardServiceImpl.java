package com.koreait.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;
import com.koreait.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> getList(Criteria cri){
		return mapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

	@Override
	public void regist(BoardDTO board) {
		mapper.insert(board);
	}

	@Override
	public int getMaxBoardnum(String userid) {
		return mapper.getMaxBoardnum(userid);
	}

	@Override
	public BoardDTO getBoard(String boardnum) {
		return mapper.getBoard(boardnum);
	}
}
