package cn.edu.nju.apoc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author kivin
 *
 */

@Controller
@RequestMapping("manager/")
public class ManagerController {

	
	/**
	 * @author zongyanqi
	 */
	@RequestMapping("ipmanage")
	public String ipManage(HttpServletRequest request,HttpServletResponse response) {
		
		return null;
	}
	/**
	 * 
	 * @author yanning
	 * manage synonyms in database
	 */
	@RequestMapping("synmanage")
	public String synonymManage() {
		return null;
	}
	/**
	 * 
	 * @author xunan
	 */
	@RequestMapping("sensmanage")
	public String sensitiveWordManage() {
		return null;
	}
	/**
	 * 
	 * @author xunan
	 */
	@RequestMapping("watermanage")
	public String waterArmyManage() {
		return null;
	}
	/**
	 * 
	 * @author xunan
	 */
	@RequestMapping("interestmanage")
	public String interestWordManage() {
		return null;
	}
	/**
	 * 
	 * @author songshuo
	 */
	@RequestMapping("rankmanage")
	public String rankManage() {
		return null;
	}
	/**
	 * 
	 * @author kivin
	 */
	@RequestMapping("advermanage")
	public String adverManage() {
		return null;
	}
}
