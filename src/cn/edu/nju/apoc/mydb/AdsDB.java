package cn.edu.nju.apoc.mydb;

import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.edu.nju.apoc.entity.Ads;
import cn.edu.nju.apoc.entity.CommercialAds;
import cn.edu.nju.apoc.helper.ImageIO;

public class AdsDB{
	private DB db = new DB();
	
	public void addAds(){
		byte[] img = new ImageIO().imread("/home/sky/1.jpg");
		 
        CommercialAds ad = new CommercialAds(); 
        ad.setAdid(1);
        ad.setContent(img);
        ad.setMoney(100);
        ad.setUrl("test");
        
	}
	
	public ArrayList<Ads> getURLs(String address) {
		File file = new File(address);
        File[] files = file.listFiles();
		if(files.length > 10000){
			for(File f:files)
				f.delete();
		}
        
		ArrayList<Ads> list = new ArrayList<>();
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(*) FROM commercial_ads");
			
			if (rs.next()) {
				int size = rs.getInt(1);
				db.closeResultset(rs);
				db.closeStatement(stmt);
				for(int i = 0;i < 2;i ++){
					Statement s = con.createStatement();
					ResultSet r = s.executeQuery("SELECT * FROM commercial_ads where adid =" + ((int)(Math.random()*size))+1);
					if(r.next()){
						String url = r.getString("url");
						byte[] image = r.getBytes("content");
						String name = new BigInteger(130, new SecureRandom()).toString(32) + ".jpg";
						String uri = address + "/" + name;
						new ImageIO().imwrite(uri, image);
						list.add(new Ads(url, "img/news/"+name));
						db.closeResultset(r);
						db.closeStatement(s);
					}
				}
			}
			
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}
}