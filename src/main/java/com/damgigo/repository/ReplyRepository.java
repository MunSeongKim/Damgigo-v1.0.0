package com.damgigo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	public List<Reply> findAllByBno(Integer bno);
	public Page<Reply> findAllByBno(Integer bno, Pageable pageable);
}
