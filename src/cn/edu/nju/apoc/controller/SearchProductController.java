package cn.edu.nju.apoc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.service.SearchProductService;

@Controller
@RequestMapping("user/")
public class SearchProductController {
	@Resource
	SearchProductService searchProductService;
	
	/**
	 * 
	 * @author yanning
	 * add Synonyms detector when searching!
	 * add cache for the frequent requests for search!
	 */
	@RequestMapping("search")
	public String searchProduct(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		ArrayList<String> searchKeys=(ArrayList<String>) session.getAttribute("searchKeys");
		
		List<Products> products = searchProductService.searchProduct(searchKeys);
		model.addAttribute("products", products);
		return "products/searchResult";
	}
	
	/**
	 * 
	 * @author yanning
	 * show info of a object!
	 */
	@RequestMapping("searchResult")
	public String infoProduct(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		model.addAttribute("thisProduct", (Products)session.getAttribute("thisProduct"));
		return "products/detailProduct";
	}
}
