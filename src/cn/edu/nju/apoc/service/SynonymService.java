package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.SynonymsIndexDAO;
import cn.edu.nju.apoc.entity.Synonym;
import cn.edu.nju.apoc.mydb.SynonymDB;

@Service
public class SynonymService {
	
	@Resource
	SynonymsIndexDAO synonymsIndexDAO;
	
	public List<Synonym> getAllSynonyms() {
		SynonymDB db = new SynonymDB();
		List<Synonym> list = db.findAll();
		return list;
	}
	
	public boolean addSynonym(String word1,String word2) {
		SynonymDB db = new SynonymDB();
		db.addSynonym(word1, word2);
		return true;
	}
	
	public boolean deleteSynonym(int id1,int id2) {
		SynonymDB db = new SynonymDB();
		db.deleteSynonym(id1, id2);
		return true;
	}

}
