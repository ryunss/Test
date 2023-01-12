package com.koreait.mapper;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

public interface BoardMapper {
	List<BoardDTO> getList(Criteria cri);
}
