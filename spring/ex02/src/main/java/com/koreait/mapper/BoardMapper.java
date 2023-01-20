package com.koreait.mapper;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

public interface BoardMapper {
	List<BoardDTO> getList(Criteria cri);

	int getTotal(Criteria cri);

	void insert(BoardDTO board);

	Long getMaxBoardnum(String userid);

	BoardDTO getDetail(Long boardnum);

	void remove(Long boardnum);

	int modify(BoardDTO board);
}