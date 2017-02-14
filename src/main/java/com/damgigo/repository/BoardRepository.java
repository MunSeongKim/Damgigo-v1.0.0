package com.damgigo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	public Page<Board> findAll(Pageable pageable);
}
