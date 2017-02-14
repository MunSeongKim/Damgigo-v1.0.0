package com.damgigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
	public void registerGET(Board board, int page, Model model) throws Exception {
		model.addAttribute("page", page);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(Board board, int page, RedirectAttributes redirect) throws Exception {
		board = service.create(board);
		//URI에 데이터를 노출하지않고 숨겨진 데이터의 형태 리다이렉팅 페이지로 전송
		//클라이언트에서 script로 출력가능, 1회만 사용되고 데이터는 없어짐
		redirect.addFlashAttribute("msg", "success");
		redirect.addAttribute("bno", board.getBno());
		redirect.addAttribute("page", page);
		//페이지 새로고침시 데이터의 재전송 방지 - 리다이렉팅으로 해결";
		return "redirect:/board/read";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model,
			//정령은 { "val1", "val2" } 로 다중컬럼에 대한 정렬가능
			@PageableDefault(sort={"bno"}, direction=Direction.DESC, size=12) Pageable pageable) 
			throws Exception {
		Page<Board> listPage = service.findAll(pageable);
		model.addAttribute("list", listPage);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, int page, Model model) throws Exception {
		Board tmpBoard = service.read(bno);
		/* ViewCnt 처리 - 작성자가 작성후 바로 read로 넘어와서 카운트가 무조건 +1 되는 현상
		int tmpCnt = tmpBoard.getViewcnt() + 1;
		tmpBoard.setViewcnt(tmpCnt);
		service.update(tmpBoard);
		*/
		model.addAttribute(tmpBoard);
		model.addAttribute("page", page);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, int page, RedirectAttributes redirect) throws Exception {
		service.delete(bno);
		redirect.addFlashAttribute("msg", "success");
		redirect.addAttribute("page", page);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, int page, Model model) throws Exception {
		model.addAttribute(service.read(bno));
		model.addAttribute("page", page);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(Board board, int page, RedirectAttributes redirect) throws Exception {
		service.update(board);
		redirect.addFlashAttribute("msg", "success");
		redirect.addAttribute("bno", board.getBno());
		redirect.addAttribute("page", page);
		return "redirect:/board/read";
	}
}
