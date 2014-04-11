package cn.edu.nju.apoc.mydb;

import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.edu.nju.apoc.entity.Ads;
import cn.edu.nju.apoc.helper.ImageIO;

public class AdsDB {
	private DB db = DB.getDB();

	public ArrayList<Ads> getURLs(String address) {
		File file = new File(address);
		File[] files = file.listFiles();
		if (files.length > 10) {
			for (File f : files)
				f.delete();
		}

		ArrayList<Ads> list = new ArrayList<Ads>();
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT max(adid) FROM commercial_ads");

			if (rs.next()) {
				int size = rs.getInt(1);
				db.closeResultset(rs);
				db.closeStatement(stmt);
				while (list.size() < 2) {
					Statement s = con.createStatement();
					int id = ((int) (Math.random() * size)) + 1;
					ResultSet r = s.executeQuery("SELECT * FROM commercial_ads where adid ="
									+ id);
					if (r.next()) {
						String url = r.getString("url");
						byte[] image = r.getBytes("content");
						String name = new BigInteger(130, new SecureRandom())
								.toString(32) + ".jpg";
						String uri = address + "/" + name;
						new ImageIO().imwrite(uri, image);
						list.add(new Ads(url, "img/news/" + name));
					}
					db.closeResultset(r);
					db.closeStatement(s);
				}
			} else {
				db.closeResultset(rs);
				db.closeStatement(stmt);
			}

			db.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void store(byte[] bytes, double money, String url) {
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into commercial_ads(money,url,content) values(?,?,?)");
			stmt.setDouble(1, money);
			stmt.setString(2, url);
			stmt.setBytes(3, bytes);
			stmt.execute();
			db.closeStatement(stmt);
			db.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
