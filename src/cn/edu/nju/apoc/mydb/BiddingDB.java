package cn.edu.nju.apoc.mydb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.nju.apoc.entity.Bidding;
import cn.edu.nju.apoc.entity.Products;

public class BiddingDB {
	private DB db = DB.getDB();
	
	public Bidding addBidding(int pid,int money) {
		Bidding bidding = new Bidding();
		bidding.setMoney(money);
		bidding.setProducts(null);
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			stmt = con.prepareStatement("select pid,name,price,site,img from products where pid=?");
			stmt.setInt(1, pid);
			result = stmt.executeQuery();
			if(result.next()){
				Products products = new Products();
				products.setPid(result.getInt("pid"));
				products.setName(result.getString("pid"));
				products.setPrice(result.getDouble("price"));
				products.setSite(result.getString("site"));
				products.setImg(result.getBytes("img"));
				bidding.setProducts(products);
			}
			
			if (bidding.getProducts() != null) {
				stmt = con.prepareStatement("insert into bidding (pid,money) values(?,?)",Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, pid);
				stmt.setInt(2, money);
				stmt.executeUpdate();
				result = stmt.getGeneratedKeys(); 
				if(result.next()){
					bidding.setBidid(result.getInt(1));
				}
			} else {
				return null;
			}
			
			db.closeConnection(con);
			db.closeStatement(stmt);
			db.closeConnection(con);
			
			return bidding;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean deleteBidding(int pid,int money) {
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = null;
			
			stmt = con.prepareStatement("delete from bidding where pid=? and money=?");
			stmt.setInt(1, pid);
			stmt.setInt(2, money);
			stmt.executeUpdate();
			
			db.closeConnection(con);
			db.closeStatement(stmt);
			db.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
