package cn.edu.nju.apoc.mydb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SynonymDB{
	private DB db = new DB();
	
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
}
