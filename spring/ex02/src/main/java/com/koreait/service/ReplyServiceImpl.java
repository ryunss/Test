package com.koreait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyDTO;
import com.koreait.domain.ReplyPageDTO;
import com.koreait.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Override
	public boolean regist(ReplyDTO reply) {
		return mapper.insert(reply) == 1;
	}

	@Override
	public boolean remove(Long replynum) {
		return mapper.delete(replynum) == 1;
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		return mapper.update(reply) == 1;
	}

	@Override
	public ReplyPageDTO getList(Criteria cri, Long boardnum) {
		return new ReplyPageDTO(mapper.getTotal(boardnum), mapper.getList(cri,boardnum));
	}

	@Override
	public Long getMaxReplyNum(String userid) {
		return mapper.getNum(userid);
	}

}













