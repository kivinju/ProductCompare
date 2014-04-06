package cn.edu.nju.apoc.mydb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.apoc.entity.Synonym;

public class SynonymDB{
	private DB db = DB.getDB();
	
	public String getSynonym(String str) {
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select i.word from synonyms s,synonyms_index i,synonyms_index ii where ii.word = '"
						+ str +"' and s.id1 = ii.synoid and s.id2 = i.synoid");
			
			if (rs.next()) {
				str = rs.getString(1);
			}
			
			db.closeResultset(rs);
			db.closeStatement(stmt);
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return str;
	}
	
	public List<Synonym> findAll() {
		ArrayList<Synonym> list = new ArrayList<Synonym>();
		
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct id1,word from synonyms,synonyms_index where id1=synoid");
			
			while (rs.next()) {
				int id = rs.getInt("id1");
				String word = rs.getString("word");
				list.add(new Synonym(id,word));
			}
			
			for (int i=0;i<list.size();i++) {
				Synonym synonym = list.get(i);
				int baseid = synonym.getId();
				stmt = con.createStatement();
				rs = stmt.executeQuery("select distinct id2,word from synonyms,synonyms_index where id2=synoid and id1=" + String.valueOf(baseid));
				while (rs.next()) {
					int id = rs.getInt("id2");
					String word = rs.getString("word");
					synonym.getList().add(new Synonym(id,word));
				}
			}
			
			db.closeResultset(rs);
			db.closeStatement(stmt);
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean addSynonym(String word1,String word2) {
		
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			stmt = con.prepareStatement("select synoid from synonyms_index where word=?");
			stmt.setString(1, word1);
			result = stmt.executeQuery();
			int id1= -1;
			if(result.next()){
				id1 = result.getInt("synoid");
			}
			if (id1 == -1) {
				stmt = con.prepareStatement("insert into synonyms_index (word) values(?)",Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, word1);
				stmt.executeUpdate();
				result = stmt.getGeneratedKeys(); 
				if(result.next()){
					id1 = result.getInt(1);
				}
			}
			
			stmt = con.prepareStatement("select synoid from synonyms_index where word=?");
			stmt.setString(1, word2);
			result = stmt.executeQuery();
			int id2= -1;
			if(result.next()){
				id2 = result.getInt("synoid");
			}
			if (id2 == -1) {
				stmt = con.prepareStatement("insert into synonyms_index (word) values(?)",Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, word2);
				stmt.executeUpdate();
				result = stmt.getGeneratedKeys(); 
				if(result.next()){
					id2 = result.getInt(1);
				}
			}
			
			stmt = con.prepareStatement("insert into synonyms (id1,id2) values(?,?)");
			stmt.setInt(1, id1);
			stmt.setInt(2, id2);
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
	
	public boolean deleteSynonym(int id1,int id2) {
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = null;
			
			stmt = con.prepareStatement("delete from synonyms where id1=? and id2=?");
			stmt.setInt(1, id1);
			stmt.setInt(2, id2);
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
