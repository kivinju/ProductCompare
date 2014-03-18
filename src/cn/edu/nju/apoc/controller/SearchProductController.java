package cn.edu.nju.apoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/")
public class SearchProductController {
	/**
	 * 
	 * @author yanning
	 * add Synonyms detector when searching!
	 * add cache for the frequent requests for search!
	 */
	@RequestMapping("search")
	public String searchProduct() {
		return null;
	}
	
	/**
	 * 
	 * @author yanning
	 * show info of a object!
	 */
	@RequestMapping("info")
	public String infoProduct() {
		return null;
	}
}
