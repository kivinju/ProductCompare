package cn.edu.nju.apoc.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.CommentsDAO;
import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.Ads;
import cn.edu.nju.apoc.entity.Comments;
import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.helper.ImageIO;

@Service
public class CommentService {
	
	@Resource
	CommentsDAO commentsDAO;
	
	@Resource
	ProductsDAO productsDAO;
	
	public void addComment(int pid,String ip, String comment){
		Products p = productsDAO.findById(pid);
		Timestamp time = new Timestamp(new Date().getTime());
		Comments c = new Comments(p,ip,time,comment);
		commentsDAO.save(c);
System.out.println("comments saved");
	}
	
	public void notifyCompany(ArrayList<String> interest){
		
	}
	
	
}
