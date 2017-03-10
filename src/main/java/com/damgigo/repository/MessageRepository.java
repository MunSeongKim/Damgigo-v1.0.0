package com.damgigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damgigo.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
