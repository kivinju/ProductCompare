package cn.edu.nju.apoc.mydb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommentDB{
	private DB db = DB.getDB();
	
	public boolean pass(ArrayList<String> comments) {
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select word from sensitives");
			
			while (rs.next()) {
				String str = rs.getString(1);
				if(comments.contains(str)){
					db.closeResultset(rs);
					db.closeStatement(stmt);
					db.closeConnection(con);
					return false;
				}
			}
			
			db.closeResultset(rs);
			db.closeStatement(stmt);
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return true;
	}
	
	public ArrayList<String> getSellers(ArrayList<String> comments) {
		
		ArrayList<String> sellers = new ArrayList<>();
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select word,seller from interest_word");
			
			while (rs.next()) {
				String word = rs.getString("word");
				if(comments.contains(word)){
					sellers.add(rs.getString("seller"));
				}
			}
			
			db.closeResultset(rs);
			db.closeStatement(stmt);
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return sellers;
	}
}
