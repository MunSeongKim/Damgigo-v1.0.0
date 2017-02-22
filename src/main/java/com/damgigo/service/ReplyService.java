package com.damgigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damgigo.domain.Reply;
import com.damgigo.repository.ReplyRepository;

@Service
@Transactional
public class ReplyService {
	@Autowired
	ReplyRepository replyRepository;
	
	public void addReply(Reply reply) throws Exception{
		replyRepository.save(reply);
	}
	
	public List<Reply> listReply(Integer bno) throws Exception{
		
		return replyRepository.findAllByBno(bno);
	}
	
	public void modifyReply(Reply reply) throws Exception{
		replyRepository.save(reply);
	}
	
	public void removeReply(Integer rno) throws Exception{
		replyRepository.delete(rno);
	}

	public Reply findOne(Integer rno) {
		// TODO Auto-generated method stub
		return replyRepository.findOne(rno);
	}
	
	public Page<Reply> findAllByPage(Pageable pageable){
		return replyRepository.findAll(pageable);
	}
}
