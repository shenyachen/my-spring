package com.buge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yachen.shen
 * @Date 2020/3/22 12:10
 */
@Controller
@RequestMapping
public class TestController {

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		return "123";
	}
}
