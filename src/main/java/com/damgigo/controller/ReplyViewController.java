package com.damgigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyViewController {
	@RequestMapping(value="/reply/list", method=RequestMethod.GET)
	String redirectIndex(){
		return "reply/list";
	}
}
