package com.damgigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damgigo.domain.User_test;
import com.damgigo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User_test> findAll() {
		return userRepository.findAll();
	}
	
	public User_test findOneByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public User_test findOneByName(String name){
		return userRepository.findByName(name);
	}
	
	public User_test create(User_test user){
		return userRepository.save(user);
	}
	
	public User_test update(User_test user){
		return userRepository.save(user);
	}
	
	public void delete(Integer id){
		userRepository.delete(id);
	}
}
