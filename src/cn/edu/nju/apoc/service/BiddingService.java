package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.BiddingDAO;
import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Bidding;
import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.mydb.BiddingDB;

@Service
public class BiddingService {
	
	@Resource
	BiddingDAO biddingDAO;
	@Resource
	ProductsDAO productsDAO;
	
	public List<Bidding> getAllBiddings() {
		List<Bidding> list = biddingDAO.findAll();
		return list;
	}
	
	public Bidding addBidding(int pid,int money) {
		BiddingDB db = new BiddingDB();
		return db.addBidding(pid,money);
	}
	
	public boolean deleteBidding(int pid,int money) {
		BiddingDB db = new BiddingDB();
		db.deleteBidding(pid,money);
		return true;
	}

}
