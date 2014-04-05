package cn.edu.nju.apoc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.BiddingDAO;
import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Bidding;
import cn.edu.nju.apoc.entity.Products;

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
		Products products = productsDAO.findById(pid);
		Bidding bidding = new Bidding(products,money);
		biddingDAO.save(bidding);
		return bidding;
	}
	
	public boolean deleteBidding(int pid,int money) {
		Products products = productsDAO.findById(pid);
		biddingDAO.deleteByProperty("products", products, "money", new Integer(money));
		return true;
	}

}
