package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.service.GuestBook2Service;
import com.ict.model.vo.GuestBook2VO;

@Controller
public class GuestBook2Controller {
	// 일처리가 있으면 서비스로 가자
	@Autowired
	private GuestBook2Service guestBook2Service;

	@GetMapping("/guestbook2_list.do")
	public ModelAndView getguestbookList() {
		ModelAndView mv = new ModelAndView("guestbook2/list");
		List<GuestBook2VO> glist2 = guestBook2Service.getGuestBookList();
		mv.addObject("glist2", glist2);
		return mv;
	}
	
	@GetMapping("/guestbook2AddForm.do")
	public ModelAndView getGuestBookAddForm(){
		return new ModelAndView("guestbook2/write");
	}
	
	@PostMapping("/guestbook2_writeOK.do")
	public ModelAndView getGuestBookInsert(GuestBook2VO gvo2) {
		ModelAndView mv = new ModelAndView("redirect:/guestbook2_list.do");
		int result = guestBook2Service.getGuestBookInsert(gvo2);
		return mv;
	}
	
	// idx는 onelist.jsp에도 사용하기 때문에 넘겨야한다.
	@GetMapping("/guestbook2_oneList.do")
	public ModelAndView getGuestBookOneList(@ModelAttribute("idx") String idx) {
		System.out.println(idx);
		ModelAndView mv = new ModelAndView("guestbook2/onelist");
		GuestBook2VO gvo = guestBook2Service.getGuestBookOneList(idx);
		mv.addObject("gvo",gvo);
		return mv;
	}
	@PostMapping("/guestbook2_delete_Form.do")
	public ModelAndView getGuestBookDeleteForm(@ModelAttribute("idx") String idx) {
		ModelAndView mv = new ModelAndView("guestbook2/delete");
		// jsp 실제 삭제할때 비밀번호를 검사하기 위해서 getGuestBookOneList()를 실행하자
		GuestBook2VO gvo = guestBook2Service.getGuestBookOneList(idx);
		mv.addObject("gvo",gvo);
		return mv;
	}
	@PostMapping("/guestbook2_delete.do")
	public ModelAndView getGuestBookDeleteOK(String idx) {
		ModelAndView mv = new ModelAndView("redirect:/guestbook2_list.do");
		int result = guestBook2Service.getGuestBookDelete(idx);
		return mv;
	}
	@PostMapping("/guestbook2_edit_Form.do")
	public ModelAndView getGuestBookEditForm(String idx) {
		ModelAndView mv = new ModelAndView("guestbook2/update");
		GuestBook2VO gvo = guestBook2Service.getGuestBookOneList(idx);
		mv.addObject("gvo",gvo);
		return mv;
	}
	@PostMapping("/guestbook2_edit.do")
	public ModelAndView getGuestBookEditOK(GuestBook2VO gvo2) {
		ModelAndView mv = new ModelAndView("redirect:/guestbook2_oneList.do?idx="+gvo2.getIdx());
		int result = guestBook2Service.getGuestBookUpdate(gvo2);
		return mv;
	}
}
