package cn.edu.nju.apoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author kivin
 *
 */
@Controller
@RequestMapping("user/")
public class UserController {
	
	/**
	 * 
	 * @author xunan
	 */
	@RequestMapping("comment")
	public String comment(){
		return null;
	}
}
