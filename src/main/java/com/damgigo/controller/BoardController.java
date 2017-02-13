package com.damgigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.damgigo.domain.Board;
import com.damgigo.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(Board board, Model model) throws Exception {
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(Board board, RedirectAttributes redirect) throws Exception {
		service.create(board);
		//URI에 데이터를 노출하지않고 숨겨진 데이터의 형태 리다이렉팅 페이지로 전송
		//클라이언트에서 script로 출력가능, 1회만 사용되고 데이터는 없어짐
		redirect.addFlashAttribute("msg", "success");
		
		//페이지 새로고침시 데이터의 재전송 방지 - 리다이렉팅으로 해결";
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.findAll());
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes redirect) throws Exception {
		service.delete(bno);
		
		redirect.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(Board board, RedirectAttributes redirect) throws Exception {
		service.update(board);
		redirect.addFlashAttribute("msg", "success");
		
		return "redirect:/board/list";
	}
}
