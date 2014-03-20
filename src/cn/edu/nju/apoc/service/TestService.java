package cn.edu.nju.apoc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.nju.apoc.dao.BlackIpsDAO;
import cn.edu.nju.apoc.dao.CommercialAdsDAO;
import cn.edu.nju.apoc.dao.ProductsDAO;
import cn.edu.nju.apoc.entity.BlackIps;
import cn.edu.nju.apoc.entity.CommercialAds;
import cn.edu.nju.apoc.entity.Products;
import cn.edu.nju.apoc.helper.ImageIO;

@Service
public class TestService {
	@Resource
	ProductsDAO productsDAO;
	@Resource
	BlackIpsDAO blackIpsDAO;
	@Resource
	CommercialAdsDAO adsDAO;
	
	public Products getProduct() {
		return (Products) productsDAO.findAll().get(0);
	}
	public List<BlackIps> getAllIps() {
		List<BlackIps> list=new ArrayList<BlackIps>();
		list.add(new BlackIps("hsdkfhsdkjfhskjf"));
		list.add(new BlackIps("hsdkfhsdkjfhskjfdsfasufhksahf"));
		return list;
	}
	public void addAds(){
		byte[] img = new ImageIO().imread("/home/sky/1.jpg");
		 
        CommercialAds ad = new CommercialAds(); 
        ad.setAdid(1);
        ad.setContent(img);
        ad.setMoney(100);
        ad.setUrl("test");
        
        adsDAO.save(ad);
	}
	
	public void loadAds() {
		CommercialAds ads = (CommercialAds) adsDAO.findAll().get(0);
		new ImageIO().imwrite("/home/sky/2.jpg", ads.getContent());
	}
}
