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
	
	@RequestMapping("add_img")
	public String testAddImg(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		testService.addAds();
		System.out.println("Add");
		return "test";
	}
	
	@RequestMapping("load_img")
	public String testLoadImg(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		testService.loadAds();
		System.out.println("Load");
		return "test";
	}
	
	@RequestMapping("zongyanqi/haha")
	public String test2(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session){
		int ai=request.getContentLength();
		model.addAttribute("temp", ai);
		model.addAttribute("iplist", testService.getAllIps());
		return "zongyanqi/test";
	}
	
}
