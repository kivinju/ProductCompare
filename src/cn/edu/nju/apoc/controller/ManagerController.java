package cn.edu.nju.apoc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.nju.apoc.entity.Bidding;
import cn.edu.nju.apoc.entity.BlackIps;
import cn.edu.nju.apoc.entity.Sensitives;
import cn.edu.nju.apoc.service.BiddingService;
import cn.edu.nju.apoc.service.IpService;
import cn.edu.nju.apoc.service.SensitivesService;

/**
 * 
 * @author kivin
 *
 */

@Controller
@RequestMapping("manager/")
public class ManagerController {
	
	@Resource
	IpService ipService;
	@Resource
	BiddingService biddingService;
	@Resource
	SensitivesService sensitivesService;
	
	@RequestMapping("ipmanage")
	public String ipManage(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		List<BlackIps> iplist = ipService.getAllIps();
		session.setAttribute("iplist", iplist);
		model.addAttribute("iplist", iplist);
		return "manager/ip";
	}
	
	@RequestMapping("ip/add")
	public String ipAdd(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		String ip = request.getParameter("ip");
		BlackIps blackIps = new BlackIps(ip);
		ipService.addIp(blackIps);
		List<BlackIps> iplist = (List<BlackIps>)session.getAttribute("iplist");
		iplist.add(blackIps);
		model.addAttribute("iplist", iplist);
		return "manager/ip";
	}
	
	@RequestMapping("ip/delete")
	public String ipDelete(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		String ip = request.getParameter("ip");
		ipService.deleteIp(ip);
		List<BlackIps> iplist = (List<BlackIps>)session.getAttribute("iplist");
		for (int i=0;i<iplist.size();i++) {
			if (iplist.get(i).getIp().equals(ip)) {
				iplist.remove(i);
				break;
			}
		}
		model.addAttribute("iplist", iplist);
		return "manager/ip";
	}
	
	
	
	
	
	
	@RequestMapping("sensmanage")
	public String sensitiveWordManage(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		List<Sensitives> sensitiveslist = sensitivesService.getAllSensitives();
		session.setAttribute("sensitiveslist", sensitiveslist);
		model.addAttribute("sensitiveslist", sensitiveslist);
		return "manager/senstiveword";
	}
	
	@RequestMapping("sens/add")
	public String sensitiveWordAdd(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		String word = request.getParameter("word");
		Sensitives sensitives = new Sensitives(word);
		sensitivesService.addSensitives(sensitives);
		List<Sensitives> sensitiveslist = (List<Sensitives>)session.getAttribute("sensitiveslist");
		sensitiveslist.add(sensitives);
		model.addAttribute("sensitiveslist", sensitiveslist);
		return "manager/senstiveword";
	}
	
	@RequestMapping("sens/delete")
	public String sensitiveWordDelete(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		String word = request.getParameter("word");
		sensitivesService.deleteSensitives(word);
		List<Sensitives> sensitiveslist = (List<Sensitives>)session.getAttribute("sensitiveslist");
		for (int i=0;i<sensitiveslist.size();i++) {
			if (sensitiveslist.get(i).getWord().equals(word)) {
				sensitiveslist.remove(i);
				break;
			}
		}
		model.addAttribute("sensitiveslist", sensitiveslist);
		return "manager/senstiveword";
	}
	
	
	
	
	
	@RequestMapping("biddingmanage")
	public String biddingManage(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		List<Bidding> biddinglist = biddingService.getAllBiddings();
		session.setAttribute("biddinglist", biddinglist);
		model.addAttribute("biddinglist", biddinglist);
		return "manager/bidding";
	}
	
	@RequestMapping("bidding/add")
	public String biddingAdd(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int money = Integer.parseInt(request.getParameter("money"));
		Bidding bidding = biddingService.addBidding(pid, money);
		List<Bidding> biddinglist = (List<Bidding>)session.getAttribute("biddinglist");
		biddinglist.add(bidding);
		model.addAttribute("biddinglist", biddinglist);
		return "manager/bidding";
	}
	
	@RequestMapping("bidding/delete")
	public String biddingDelete(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int money = Integer.parseInt(request.getParameter("money"));
		biddingService.deleteBidding(pid, money);
		List<Bidding> biddinglist = (List<Bidding>)session.getAttribute("biddinglist");
		for (int i=0;i<biddinglist.size();i++) {
			if ((biddinglist.get(i).getProducts().getPid() == pid) && (biddinglist.get(i).getMoney() == money)) {
				biddinglist.remove(i);
				break;
			}
		}
		model.addAttribute("biddinglist", biddinglist);
		return "manager/bidding";
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
	 * @author zhouhaibing
	 */
	@RequestMapping("crawlermanage")
	public String crawlerManage() {
		return null;
	}
}
