package com.damgigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damgigo.domain.Reply;
import com.damgigo.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	@Autowired
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Reply reply){
		ResponseEntity<String> entity = null;
		
		try {
			service.addReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<Reply>> list(@PathVariable("bno") Integer bno){
		ResponseEntity<List<Reply>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody Reply reply){
		ResponseEntity<String> entity = null;
		
		try {
			Reply tmpReply = service.findOne(rno);

			tmpReply.setReplytext(reply.getReplytext());
			tmpReply.setUpdatedate(new java.util.Date());
			service.modifyReply(tmpReply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno){
		ResponseEntity<String> entity = null;
		
		try {
			service.removeReply(rno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Page<Reply>> listPage(@PathVariable("bno") Integer bno, 
												@PathVariable("page") Integer page){
		//@PageableDefault(sort={"rno"}, direction=Direction.DESC, size=15) Pageable pageable
		//위는 페이지 전환 방식에서의 초기화 기법, 아래는 페이지 객체를 이용한 초기화 및 사용
		//Rest Controller에서는 아래와 같이 사용해야함
		PageRequest paging = new PageRequest(page, 15, new Sort(Direction.DESC, "rno"));
		ResponseEntity<Page<Reply>> entity = null;
		
		try {
			Page<Reply> listPage = service.findAllByPage(bno, paging);
			entity = new ResponseEntity<Page<Reply>>(listPage, HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
