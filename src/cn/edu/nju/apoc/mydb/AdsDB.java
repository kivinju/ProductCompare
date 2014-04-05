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
import cn.edu.nju.apoc.helper.ImageIO;

public class AdsDB{
	private DB db = DB.getDB();
	
	public ArrayList<Ads> getURLs(String address) {
		File file = new File(address);
        File[] files = file.listFiles();
		if(files.length > 10){
			for(File f:files)
				f.delete();
		}
        
		ArrayList<Ads> list = new ArrayList<Ads>();
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(*) FROM commercial_ads");
			
			if (rs.next()) {
				int size = rs.getInt(1);
				db.closeResultset(rs);
				db.closeStatement(stmt);
				while(list.size() < 2){
					Statement s = con.createStatement();
					ResultSet r = s.executeQuery("SELECT * FROM commercial_ads where adid =" + ((int)(Math.random()*size))+1);
					if(r.next()){
						String url = r.getString("url");
						byte[] image = r.getBytes("content");
						String name = new BigInteger(130, new SecureRandom()).toString(32) + ".jpg";
						String uri = address + "/" + name;
						new ImageIO().imwrite(uri, image);
						list.add(new Ads(url, "img/news/"+name));
					}
					db.closeResultset(r);
					db.closeStatement(s);
				}
			}else{
				db.closeResultset(rs);
				db.closeStatement(stmt);
			}
			
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}
}
