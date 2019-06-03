package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * method 단독 매핑
 */

@Controller
public class BoardController {
	
	
	@RequestMapping("/board/update")
	@ResponseBody
	public String update(
	// String name
	// @RequestParam String name
	/* 추천 */@RequestParam("name") String name
	) {
		System.out.println("---" + name + "---");
		return "BoardController:update()";
	}
	
	@RequestMapping("/board/write")
	@ResponseBody
	public String write(
	@RequestParam(value="n", required=true, defaultValue="") String name,
	@RequestParam(value="age", required=true, defaultValue="0") int age
	) {
		System.out.println(name);
		System.out.println(age);
		return "BoardController:write()";
	}
	
	@RequestMapping("/board/view/{no}")
	@ResponseBody
	public String view(@PathVariable("no") Long no) {
		return "BoardController:view(" + no + ")";
	}
}
