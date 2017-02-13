package com.damgigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	
}
