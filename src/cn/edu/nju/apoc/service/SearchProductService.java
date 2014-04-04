package cn.edu.nju.apoc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Products;

@Service
public class SearchProductService {
	@Resource
	ProductsDAO productsDao;
	
	public List<Products> searchProduct(String[] searchKey){
//		stub
		List<Products> stub=new ArrayList<Products>();
		Set bidding = new HashSet();
		bidding.add("100");
		Set comments = new HashSet();
		comments.add("Good~");
		Products p1 = new Products("Nike", 798, "www.taobao.com", "my image",comments,bidding);
		Products p2 = new Products("Lining", 928, "www.taobao.com", "my image",comments,bidding);
		p1.setPid(1);
		p2.setPid(2);
		stub.add(p1);
		stub.add(p2);
		return stub;
		
//		List<Products> result=new ArrayList<Products>();
//		for(String key:searchKey){
//			List<Products> tmp=productsDao.findByName(key);
//			if(tmp!=null){
//				for(Products p:tmp)
//					result.add(p);
//			}
//			
//		}
//		return result;
	}
	
	public List<Products> searchProduct(){
//		stub
		List<Products> stub=new ArrayList<Products>();
		Set bidding = new HashSet();
		bidding.add("100");
		Set comments = new HashSet();
		comments.add("Good~");
		Products p1 = new Products("Nike", 798, "www.taobao.com", "my image",comments,bidding);
		Products p2 = new Products("Lining", 928, "www.taobao.com", "my image",comments,bidding);
		p1.setPid(1);
		p2.setPid(2);
		stub.add(p1);
		stub.add(p2);
		
		return stub;
		
//		List<Products> result=new ArrayList<Products>();
//		for(String key:searchKey){
//			List<Products> tmp=productsDao.findByName(key);
//			if(tmp!=null){
//				for(Products p:tmp)
//					result.add(p);
//			}
//			
//		}
//		return result;
	}
	
	public List<Products> getSameNameProduct(int id){
		Products p= productsDao.findById(id);
		List<Products> plist = productsDao.findByName(p.getName());
		return plist;
	}
	
	public void addComment(int pid,String comment){
		Products p= productsDao.findById(pid);
		Set comments = p.getCommentses();
		comments.add(comment);
		productsDao.save(p);
	}
	
}
