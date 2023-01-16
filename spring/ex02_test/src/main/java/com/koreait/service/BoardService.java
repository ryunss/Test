package com.koreait.service;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

public interface BoardService {
	List<BoardDTO> getList(Criteria cri);

	int getTotal(Criteria cri);

	void regist(BoardDTO board);

	int getMaxBoardnum(String userid);

	BoardDTO getBoard(String boardnum);
}
