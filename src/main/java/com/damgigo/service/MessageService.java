package com.damgigo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damgigo.domain.Message;
import com.damgigo.repository.MessageRepository;

@Service
@Transactional
public class MessageService {
	@Autowired
	MessageRepository msgRepository;
	
	public void addMessage(Message msg) throws Exception {
		msgRepository.save(msg);
	}
	
	public Message read(Integer mid) throws Exception {
		return msgRepository.findOne(mid);
	}
	
	public void updateState(Integer mid) throws Exception {
		Message msg = msgRepository.findOne(mid);
		msg.setOpendate(new Date());
		msgRepository.save(msg);
	}
}
