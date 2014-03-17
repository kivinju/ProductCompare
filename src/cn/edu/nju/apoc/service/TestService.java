package cn.edu.nju.apoc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Products;

@Service
public class TestService {
	@Resource
	ProductsDAO productsDAO;
	
	public Products getProduct() {
		return (Products) productsDAO.findAll().get(0);
	}
}
