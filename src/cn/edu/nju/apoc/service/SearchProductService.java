package cn.edu.nju.apoc.service;

import java.util.ArrayList;
import java.util.List;

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
		stub.add(new Products("Nike", 798, "www.taobao.com", null));
		stub.add(new Products("Eland", 1290, "www.amazon.com", null));
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
		stub.add(new Products("Nike", 798, "www.taobao.com", null));
		stub.add(new Products("Eland", 1290, "www.amazon.com", null));
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
	
}
