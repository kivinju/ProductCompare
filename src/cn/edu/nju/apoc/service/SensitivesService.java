package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.SensitivesDAO;
import cn.edu.nju.apoc.entity.Bidding;
import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.entity.Sensitives;

@Service
public class SensitivesService {
	
	@Resource
	SensitivesDAO sensitivesDAO;
	
	public List<Sensitives> getAllSensitives() {
		List<Sensitives> list = sensitivesDAO.findAll();
		return list;
	}
	
	public boolean addSensitives(Sensitives sensitives) {
		sensitivesDAO.save(sensitives);
		return true;
	}
	
	public boolean deleteSensitives(String word) {
		sensitivesDAO.deleteByProperty("word", word);
		return true;
	}

}
