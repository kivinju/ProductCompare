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
	
	public List<Products> searchProduct(ArrayList<String> searchKey){
		return null;
	}
}
