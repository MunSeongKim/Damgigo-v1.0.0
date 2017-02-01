package com.damgigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damgigo.domain.User;
import com.damgigo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findOneByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public User findOneByName(String name){
		return userRepository.findByName(name);
	}
	
	public User create(User user){
		return userRepository.save(user);
	}
	
	public User update(User user){
		return userRepository.save(user);
	}
	
	public void delete(Integer id){
		userRepository.delete(id);
	}
}
