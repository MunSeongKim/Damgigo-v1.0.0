package com.damgigo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damgigo.domain.Board;
import com.damgigo.repository.BoardRepository;

@Service
@Transactional
public class BoardService {
	@Autowired
	BoardRepository boardRepository;
	
	public Board create(Board board){
		return boardRepository.save(board);
	}
	
	public Board read(Integer bno){
		return boardRepository.findOne(bno);
	}
	
	public Board update(Board board){
		return boardRepository.save(board);
	}
	
	public void delete(Integer bno){
		boardRepository.delete(bno);
	}
	
	public Page<Board> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	
}
