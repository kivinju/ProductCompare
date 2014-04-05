package cn.edu.nju.apoc.mydb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IPDB{
	private DB db = DB.getDB();
	
	public boolean pass(String ip) {
		boolean result = true;
		try{
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM black_ips where ip = '" + ip.trim() + "'");
			
			if (rs.next()) {
				result = false;
			}
			
			db.closeResultset(rs);
			db.closeStatement(stmt);
			db.closeConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
}
