package cn.edu.nju.apoc.service;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Ads;
import cn.edu.nju.apoc.helper.ImageIO;

@Service
public class CommentService {
	
	@Resource
	ProductsDAO productDAO;
	
}
