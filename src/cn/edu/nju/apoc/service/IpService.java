package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.BlackIpsDAO;
import cn.edu.nju.apoc.entity.BlackIps;

@Service
public class IpService {
	
	@Resource
	BlackIpsDAO blackIpsDAO;
	
	public List<BlackIps> getAllIps() {
		List<BlackIps> list = blackIpsDAO.findAll();
		return list;
	}
	
	public boolean addIp(BlackIps blackIps) {
		blackIpsDAO.save(blackIps);
		return true;
	}
	
	public boolean deleteIp(String ip) {
		blackIpsDAO.deleteByProperty("ip", ip);
		return true;
	}

}
