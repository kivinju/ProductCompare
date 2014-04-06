package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.InterestWordDAO;
import cn.edu.nju.apoc.entity.InterestWord;

@Service
public class InterestService {
	
	@Resource
	InterestWordDAO interestWordDAO;
	
	public List<InterestWord> getAllInterestWords() {
		List<InterestWord> list = interestWordDAO.findAll();
		return list;
	}
	
	public boolean addInterestWord(InterestWord interestWord) {
		interestWordDAO.save(interestWord);
		return true;
	}
	
	public boolean deleteInterestWord(String word,String seller) {
		interestWordDAO.deleteByProperty("word", word, "seller", seller);
		return true;
	}

}
