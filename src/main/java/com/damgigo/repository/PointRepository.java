package com.damgigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.User;

public interface PointRepository extends JpaRepository<User, Integer> {

}
