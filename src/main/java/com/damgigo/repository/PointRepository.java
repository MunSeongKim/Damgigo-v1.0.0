package com.damgigo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.User;

public interface PointRepository extends JpaRepository<User, Integer> {
	void save(Map<String, Object> paramMap);
}
