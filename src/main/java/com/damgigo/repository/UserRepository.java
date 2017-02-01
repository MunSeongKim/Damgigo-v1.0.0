package com.damgigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
	User findByEmail(String email);
}
