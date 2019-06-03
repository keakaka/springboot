package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hellow2() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("email", "k@k.net");
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hellow3(Model model) {
		model.addAttribute("email", "둘리@.net");
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello4")
	public String hellow4(
			Model model, 
			@RequestParam("email") String email, 
			@RequestParam String name /* 어노테이션에 value 생략 시 변수 이름으로 request parameter name의 대체*/) {
		
		model.addAttribute("email", email);
		model.addAttribute("name", name);
		System.out.println(email+":"+name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	/*  기술이 침투했기 때문에 비추천.
	@RequestMapping("/hello5")
	public String hellow5 (Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		System.out.println(name);
		System.out.println(email);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "/WEB-INF/views/hello.jsp";
	}
	*/
}
