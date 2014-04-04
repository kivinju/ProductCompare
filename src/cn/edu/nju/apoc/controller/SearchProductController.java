package cn.edu.nju.apoc.controller;

import java.io.IOException;
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
	SearchProductService productService;
	
	/**
	 * 
	 * @author yanning + ss
	 * add Synonyms detector when searching!
	 * add cache for the frequent requests for search!
	 */
	@RequestMapping("search")
	public String searchProduct(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		
		String searchString = (String)request.getAttribute("searchString");
		
		String[] searchList = null;
		List<Products> plist = productService.searchProduct();
		if(searchString!=null&&!searchString.equals("")){
			searchList = searchString.split(";");
			plist = productService.searchProduct(searchList);
		}
		model.addAttribute("products", plist);
		return "user/searchResult";
	}
	
	/**
	 * 
	 * @author yanning
	 * show info of a object!
	 * @throws IOException 
	 */
	@RequestMapping("productInfo")
	public String infoProduct(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) throws IOException {
		String pid = request.getParameter("pid");
		List<Products> products;
		if(pid!=null){
			products = productService.getSameNameProduct(Integer.parseInt(request.getParameter("pid")));
			model.addAttribute("products", products);
			return "products/productInfo";
		}
		else{
			response.sendRedirect("search");
			return null;
		}
		
	}
}
