package cn.edu.nju.apoc.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.entity.RealProduct;
import cn.edu.nju.apoc.helper.ImageIO;

@Service
public class SearchProductService {
	@Resource
	ProductsDAO productsDao;
	
	public List<RealProduct> searchProduct(String[] searchKey,String address){
//		stub
		
	//	return stub(address);
		
		List<RealProduct> result=new ArrayList<RealProduct>();
		for(String key:searchKey){
			List<Products> tmp = productsDao.findByLikeName(key);
			//stub
//			tmp.add(productsDao.findById(2));
			
			
			if(tmp!=null){
				Collections.sort(tmp);
				for(Products p:tmp){
					RealProduct rp = parseProduct(p,address);
					result.add(rp);
				}
			}
			
		}
		return result;
	}
	
	public List<RealProduct> getProducts(int num,String address){
//		stub
		
	//	return stub(address);
		List<RealProduct> result=new ArrayList<RealProduct>();
		
		List<Products> temp=new ArrayList<Products>();
		temp=productsDao.findSome(num);
		for (Products p : temp) {
			RealProduct rp = parseProduct(p,address);
			result.add(rp);
		}
		return result;
	}
	
	public List<RealProduct> searchProduct(String address){
//		stub
		
//		return stub(address);
		
		List<RealProduct> result=new ArrayList<RealProduct>();
		List<Products> tmp= new ArrayList<Products>();//productsDao.findByName(key);
		
		/*
		for(int i = 0;i<20;i++){
			tmp.addAll((List<Products>) productsDao.findById(i));
			
		}
		if(tmp!=null){
			for(Products p:tmp){
				RealProduct rp = parseProduct(p,address);
				result.add(rp);
			}
		}
		*/
		return result;
	}
	
	public List<RealProduct> getSameNameProduct(int id,String address){
		Products p= productsDao.findById(id);
		List<RealProduct> result=new ArrayList<RealProduct>();
		List<Products> plist = productsDao.findByName(p.getName());
		
		
		
		if(plist!=null){
			Collections.sort(plist);
			for(Products product:plist){
				RealProduct rp = parseProduct(product,address);
				result.add(rp);
			}
		}
		
		return result;
	}
	
	
	
	private RealProduct parseProduct(Products p,String address){
		
		byte[] image =p.getImg();
		String name = p.getPid()+ ".jpg";
		String uri = address + "/" + name;
		new ImageIO().imwrite(uri, image);
		uri = "img/"+name;
		RealProduct rp = new RealProduct(p,uri);
		return rp;
	}
	
	private List<RealProduct> stub(String address){
		List<RealProduct> stub=new ArrayList<RealProduct>();
		Set bidding = new HashSet();
		bidding.add("100");
		Set comments = new HashSet();
		comments.add("Good~");
		Products p1 = new Products("Nike", 798, "www.taobao.com", null,comments,bidding);
		Products p2 = new Products("Lining", 928, "www.taobao.com",null,comments,bidding);
		p1.setPid(1);
		p2.setPid(2);
		stub.add(parseProduct(p1,address));
		stub.add(parseProduct(p2,address));
		return stub;
	}
}
