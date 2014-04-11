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

//import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.entity.RealProduct;
import cn.edu.nju.apoc.service.SearchProductService;

@Controller
@RequestMapping("user/")
public class UserController {
	@Resource
	SearchProductService productService;
	@RequestMapping("index")
	public String index(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		return "user/index";
	}
	
	/**
	 * 
	 * @author yanning + ss
	 * add Synonyms detector when searching!
	 * add cache for the frequent requests for search!
	 */
	@RequestMapping("search")
	public String searchProduct(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) {
		
		String searchString = (String)request.getAttribute("searchString");
		String address = request.getRealPath("img/product");
		String[] searchList = null;
		
		List<RealProduct> plist = productService.searchProduct(address);
		if(searchString!=null&&!searchString.equals("")){
			searchList = searchString.split(";");
			plist = productService.searchProduct(searchList,address);
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
		String address = request.getRealPath("img/product");
		List<RealProduct> products;
		if(pid!=null){
			products = productService.getSameNameProduct(Integer.parseInt(request.getParameter("pid")),address);
			model.addAttribute("products", products);
			return "user/productInfo";
		}
		else{
			response.sendRedirect("search");
			return null;
		}
		
	}
	
	@RequestMapping("comment")
	public String comment(HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) throws IOException{
		int pid = Integer.parseInt(request.getParameter("pid"));
		String comment = request.getParameter("comment");
		productService.addComment(pid, comment);
		response.sendRedirect("productInfo");
		return null;
	}
}
