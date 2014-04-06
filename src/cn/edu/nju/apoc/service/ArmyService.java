package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.WaterArmyDAO;
import cn.edu.nju.apoc.entity.BlackIps;
import cn.edu.nju.apoc.entity.WaterArmy;

@Service
public class ArmyService {
	
	@Resource
	WaterArmyDAO waterArmyDAO;
	
	public List<WaterArmy> getAllArmys() {
		List<WaterArmy> list = waterArmyDAO.findAll();
		return list;
	}
	
	public boolean addArmy(WaterArmy waterArmy) {
		waterArmyDAO.save(waterArmy);
		return true;
	}
	
	public boolean deleteArmy(String ip) {
		waterArmyDAO.deleteByProperty("ip", ip);
		return true;
	}


}
