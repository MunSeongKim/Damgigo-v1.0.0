package com.damgigo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damgigo.repository.PointRepository;

@Service
@Transactional
public class PointService {
	@Autowired
	PointRepository pointRepository;
	
	public void updatePoint(String uid, int point) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);
		
		pointRepository.save(paramMap);
	}
}
