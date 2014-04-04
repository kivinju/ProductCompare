package cn.edu.nju.apoc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.service.SearchProductService;
/**
 * 
 * @author kivin 
 *
 */
@Controller
@RequestMapping("user/")
public class UserController {
	@Resource 
	SearchProductService productService;
	
	@RequestMapping("comment")
	public String comment(){
		return null;
	}
	
}
