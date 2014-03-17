package cn.edu.nju.apoc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.service.TestService;

@Controller
public class TestController {
	@Resource
	TestService testService;
	
	@RequestMapping("test")
	public String test(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		Products products=testService.getProduct();
		model.addAttribute("aa", products.getName());
		return "test";
	}
}
