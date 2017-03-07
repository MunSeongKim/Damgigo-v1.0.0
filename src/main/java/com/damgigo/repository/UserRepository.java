package com.damgigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.User_test;

public interface UserRepository extends JpaRepository<User_test, Integer> {
	User_test findByName(String name);
	User_test findByEmail(String email);
}
